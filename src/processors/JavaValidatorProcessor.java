package processors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

import listeners.FieldListener;
import listeners.FragmentListener;
import listeners.LabelListener;
import listeners.ModelListener;
import processors.fieldCreatedExtension.ProcessorsImplement;
import processors.fieldCreatedExtension.ReusableMethods;
import annotations.FieldCreatedIdentifier;
import annotations.RefersTo;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;

@RefersTo(target= {ModelListener.class,FragmentListener.class,FieldListener.class})
public class JavaValidatorProcessor implements ModelListener, FragmentListener, FieldListener {

	String modelName;
	String fragmentName;

	StringBuilder validationMethodBuffer = new StringBuilder();
	StringBuilder validationCallBuffer = new StringBuilder();

	
	public JavaValidatorProcessor()
	{
		
	}


	public String createDependencyCheck(String fieldName, String type, String misc)
	{
		if (ParseUtils.hasMisc("DEPEND", misc))
		{
			String variable = ParseUtils.getMiscValue("DEPEND", misc);
			String[] valuesForcingValidation = ParseUtils.getMiscParams("DEPEND", misc);
			
			try
			{
				File template = new File("templates/validationDependencyCheck.txt");
				String content = FileUtils.readFileToString(template, Charset.defaultCharset());
				
				ArrayList<String> conditions = new ArrayList<>();
				for (String value : valuesForcingValidation)
				{
					try
					{
						conditions.add("model.get"+NameUtils.upcaseFirst(variable)+"()=="+Integer.parseInt(value));
					}
					catch(Exception e)
					{
						conditions.add("model.get"+NameUtils.upcaseFirst(variable)+"()"+value);
					}
				}
				
				StringBuilder sb = new StringBuilder();
				sb.append("(model.get"+NameUtils.upcaseFirst(variable)+"()==null || !(");
				
				for (Iterator<String> i = conditions.iterator(); i.hasNext(); )
				{
					String condition = i.next();
					sb.append(condition);
					if (i.hasNext())
					{
						sb.append(" || ");
					}
				}
				
				sb.append("))");
				
				content = content.replaceAll("\\{\\$CONDITIONS\\}", sb.toString());
				
				return content;

			}
			catch(Exception e)
			{
				throw new RuntimeException(e);
			}			
		}
		else
		{
			return "";
		}
	}
	
	
	@Override
	public void fieldCreated(String fieldName, String type, String misc) throws Exception {
		// TODO Auto-generated method stub
		
		if (ParseUtils.hasMisc("OPTIONAL", misc))
		{
			validationCallBuffer.append("\t\t//  ");
			validationCallBuffer.append(ParseUtils.extractJavaFieldName(fieldName, misc)+" optional");
			validationCallBuffer.append("\n");
			return;
		}
		
		ReusableMethods rm = new ReusableMethods();
		ProcessorsImplement thing = (ProcessorsImplement) rm.getMethodForThisClass(fieldName, type, misc, this);
		thing.passInfo(fieldName, type, misc, this);
		thing.JavaValidatorProcessorCommand();	
			
	}


	public void addValidation(String name, String dependencyCheck, String originalField)
	{
		if (fragmentName!=null)
		{
			addValidationCall(name);			
			addValidationMethod(name, dependencyCheck, originalField);
		}
	}
	
	public void addSpecifyValidation(String name, String checkableName, int position, String origName, String dependencyCheck)
	{
		if (fragmentName!=null)
		{
			addValidationCall(name);
			addSpecifyValidationMethod(name, checkableName, position, origName, dependencyCheck);
		}
	}
	
	public void addValidationCall(String name)
	{
		validationCallBuffer.append("\t\tvalidate"+NameUtils.upcaseFirst(name)+"();\n");
	}
	
	public void addValidationMethod(String javaFieldName, String dependencyCheck, String originalField)
	{
		try
		{
			File template = new File("templates/validatorMethod.txt");
			String content = FileUtils.readFileToString(template, Charset.defaultCharset());
								
			content = content.replaceAll("\\{\\$DEPENDENCY_CHECK\\}", dependencyCheck);
			
			
			content = content.replaceAll("\\{\\$METHOD_NAME\\}", NameUtils.upcaseFirst(javaFieldName));
			content = content.replaceAll("\\{\\$FIELD_NAME\\}", javaFieldName);
			content = content.replaceAll("\\{\\$FRAGMENT_NAME\\}", fragmentName);
			content = content.replaceAll("\\{\\$ORIG_FIELD\\}", asResourceString(javaFieldName, originalField));  // TODO: USE RES
			
			validationMethodBuffer.append(content);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void addSpecifyValidationMethod(String name, String checkableName, int position, String originalField, String dependencyCheck)
	{
		try
		{
			File template = new File("templates/validatorSpecifyMethod.txt");
			String content = FileUtils.readFileToString(template, Charset.defaultCharset());
			
			content = content.replaceAll("\\{\\$DEPENDENCY_CHECK\\}", dependencyCheck);

			content = content.replaceAll("\\{\\$METHOD_NAME\\}", NameUtils.upcaseFirst(name));
			content = content.replaceAll("\\{\\$FIELD_NAME\\}", name);
			content = content.replaceAll("\\{\\$FRAGMENT_NAME\\}", fragmentName);

			content = content.replaceAll("\\{\\$METHOD_SELECTABLE_NAME\\}", NameUtils.upcaseFirst(checkableName));
			content = content.replaceAll("\\{\\$POSITION\\}", String.valueOf(position));
			content = content.replaceAll("\\{\\$ORIG_FIELD\\}", asResourceString(name, originalField));		// TODO: USE RES


			validationMethodBuffer.append(content);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void fieldDone() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void fragmentCreated(String fragmentName) {
		// TODO Auto-generated method stub
		this.fragmentName = fragmentName;
		
	}


	@Override
	public void fragmentDone() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modelCreated(String modelName) {
		// TODO Auto-generated method stub
		this.modelName = modelName;
	}


	@Override
	public void modelDone() {
		// TODO Auto-generated method stub

		try
		{
			File template = new File("templates/validator.txt");
			String content = FileUtils.readFileToString(template, Charset.defaultCharset());
			

			content = content.replaceAll("\\{\\$MODEL_PACKAGE\\}", NameUtils.toPackageName(modelName));
			
			content = content.replaceAll("\\{\\$MODEL_CLASS\\}", NameUtils.toClassName(modelName));

			content = content.replaceAll("\\{\\$MODEL_VALIDATION\\}", validationCallBuffer.toString());
			content = content.replaceAll("\\{\\$VALIDATION_METHODS\\}", validationMethodBuffer.toString());
			
	
			
			File dir = new File("output/"+NameUtils.toPackageName(modelName)+"/gen");
			dir.mkdirs();
			
			File output = new File(dir, NameUtils.toClassName(modelName)+"Validator.java");
			FileWriter fw = new FileWriter(output);
			fw.write(content, 0, content.length());
			fw.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
		
		
		
	}
	
	boolean useResourceStrings = true;
	
	public String asResourceString(String key, String s)
	{
		if (useResourceStrings)
		{
			if (s.startsWith("@drawable"))
			{
				return "\""+s+"\"";
			}
			
			String value = "context.getResources().getString(R.string."+NameUtils.toLayoutName(modelName)+"_"+key+")";
			return value;
		}
		return s;
	}
	
}
