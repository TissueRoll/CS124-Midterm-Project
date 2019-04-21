package processors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import listeners.FieldListener;
import listeners.FragmentListener;
import listeners.LabelListener;
import listeners.ModelListener;
import processors.fieldCreatedExtension.MultiUtil;
import processors.fieldCreatedExtension.ProcessorsImplement;
import annotations.FieldCreatedIdentifier;
import annotations.Processor;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;

@Processor(target= {ModelListener.class,FragmentListener.class,FieldListener.class,LabelListener.class})
public class JavaSerializerProcessor implements ModelListener, FragmentListener, FieldListener , LabelListener{

	String modelName;
	String fragmentName;

	StringBuilder methodBuffer = new StringBuilder();
	StringBuilder callBuffer = new StringBuilder();

	
	public JavaSerializerProcessor()
	{
		
	}


	@Override
	public void fieldCreated(String fieldName, String type, String misc) throws Exception {
		// TODO Auto-generated method stub
		ScanResult results = new FastClasspathScanner("processors.fieldCreatedExtension").scan();
		List<String> allResults = results.getNamesOfClassesWithAnnotation(FieldCreatedIdentifier.class);
		boolean matched = false;
		for (String s : allResults) {
			Class c = Class.forName(s);
			FieldCreatedIdentifier fci = (FieldCreatedIdentifier) c.getAnnotation(FieldCreatedIdentifier.class);
			if (type.startsWith(fci.identifier())) {
				matched = true;
				ProcessorsImplement thing = (ProcessorsImplement) c.newInstance();
				thing.passInfo(fieldName, type, misc, this);
				thing.JavaSerializerProcessorCommand();
			}
		}
		if (!matched) {
			ProcessorsImplement thing = (ProcessorsImplement) Class.forName("processors.fieldCreatedExtension.OtherUtil").newInstance();
			thing.passInfo(fieldName, type, misc, this);
			thing.JavaSerializerProcessorCommand();
		}
		
		
//		String javaFieldName = ParseUtils.extractJavaFieldName(fieldName, misc);
//
//		if (type.startsWith("MULTI:"))
//		{
//			String[] multiData = type.split(":");
//			String optionString = multiData[1].substring(1, multiData[1].length()-1);
//			String[] options = optionString.split(",");			
//
//			for (int i=0; i<options.length; i++)
//			{
//				String name = (String) options[i];
//
//				if (name.toLowerCase().contains("(specify)"))
//				{
//					addSerialization(javaFieldName+"Others");
//					addSerialization(javaFieldName+"Specify");				
//				}
//				else
//				{
//					addSerialization(javaFieldName+NameUtils.toJavaFieldNameAppender(name.trim()));
//				}
//			}
//
//		}
//		else if (type.startsWith("SINGLE:"))
//		{
//			addSerialization(javaFieldName);
//			
//			// NEED TO LOOP ENTRIES to tie the specify
//			String[] singleData = type.split(":");
//			String optionString = singleData[1].substring(1, singleData[1].length()-1);
//			String[] options = optionString.split(",");
//			for (int i=0; i< options.length; i++)
//			{
//				String option = options[i];
//				if (option.toLowerCase().contains("(specify"))
//				{
//					addSerialization(javaFieldName+"Specify");				
//					break;  // assume only one Specify field per group
//				}					
//			}
//			
//		}
//		else
//		{
//			boolean addSpecifyField = false;
//			if (type.equals("CHECKBOX:SPECIFY"))
//			{
//				addSpecifyField = true;
//			}
//					
//			addSerialization(javaFieldName);
//			
//			if (addSpecifyField)
//			{
//				addSerialization(javaFieldName+"Specify");				
//			}		
//		}		
		
	}


	public void addSerialization(String name)
	{
		addSerializeCall(name);
		addSerializeMethod(name);
	}
	
	public void addSerializeCall(String name)
	{
//		System.out.println("\t\tserialize"+NameUtils.upcaseFirst(name)+"(model, object, context); // "+NameUtils.javaFieldNameToJson(name));
		callBuffer.append("\t\tserialize"+NameUtils.upcaseFirst(name)+"(model, object, context); // "+NameUtils.javaFieldNameToJson(name)+"\n");
	}
	
	public void addSerializeMethod(String name)
	{
		try
		{
			File template = new File("templates/serializeMethod.txt");
			String content = FileUtils.readFileToString(template, Charset.defaultCharset());
			
			content = content.replaceAll("\\{\\$METHOD_NAME\\}", NameUtils.upcaseFirst(name));
			content = content.replaceAll("\\{\\$FIELD_NAME\\}", NameUtils.javaFieldNameToJson(name));
			content = content.replaceAll("\\{\\$MODEL_CLASS\\}", NameUtils.toClassName(modelName));
			
			methodBuffer.append(content);
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
		
		// TODO Auto-generated method stub
		callBuffer.append("\n\t\t// "+fragmentName+"\n");

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
		
		// save file

		try
		{
			File template = new File("templates/serializer.txt");
			String content = FileUtils.readFileToString(template, Charset.defaultCharset());
			
			
			// update info
			content = content.replaceAll("\\{\\$MODEL_PACKAGE\\}", NameUtils.toPackageName(modelName));
			
			content = content.replaceAll("\\{\\$MODEL_CLASS\\}", NameUtils.toClassName(modelName));

			content = content.replaceAll("\\{\\$METHOD_CALL\\}", callBuffer.toString());
			content = content.replaceAll("\\{\\$METHODS\\}", methodBuffer.toString());
			
	
			
			File dir = new File("output/"+NameUtils.toPackageName(modelName)+"/gen");
			dir.mkdirs();
			
			File output = new File(dir, NameUtils.toClassName(modelName)+"JsonSerializer.java");
			FileWriter fw = new FileWriter(output);
			fw.write(content, 0, content.length());
			fw.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
		
	}


	@Override
	public void labelCreated(String label) {

	}
	
	
	
}
