package processors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.charset.Charset;
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
public class PojoProcessor implements ModelListener, FragmentListener, FieldListener {

	String modelName;
	StringBuilder fieldBuffer = new StringBuilder();
	StringBuilder toStringBuffer = new StringBuilder();
	StringBuilder getSetBuffer = new StringBuilder();
	
	
	public PojoProcessor()
	{
		
	}
	
	@Override
	public void fieldCreated(String fieldName, String type, String misc) throws Exception {
		// TODO Auto-generated method stub
		ReusableMethods rm = new ReusableMethods();
		ProcessorsImplement thing = (ProcessorsImplement) rm.getMethodForThisClass(fieldName, type, misc, this);
		thing.passInfo(fieldName, type, misc, this);
		thing.PojoProcessorCommand();	
	}
	
	public void addUnmappedField(String javaFieldName, String javaType, String init) {
		addTabs();
		
		fieldBuffer.append("private ");
		fieldBuffer.append(javaType);
		fieldBuffer.append(" ");
		fieldBuffer.append(javaFieldName);
		
		if (init!=null)
		{
			fieldBuffer.append(" = ");
			fieldBuffer.append(init);
		}
		
		fieldBuffer.append(";\n");
				
		addAccessors(javaFieldName, javaType);
		addToString(javaFieldName, javaType);
	}
	
	public void addUnmappedRealmList(String javaFieldName, String javaType, String containedType, String init) {
		fieldBuffer.append("\n");
		addTabs();		

		fieldBuffer.append("@AutoMigration.MigratedList(listType = "+containedType+".class)\n");

		addTabs();		
		fieldBuffer.append("private ");
		fieldBuffer.append(javaType);
		fieldBuffer.append(" ");
		fieldBuffer.append(javaFieldName);
		
		if (init!=null)
		{
			fieldBuffer.append(" = ");
			fieldBuffer.append(init);
		}
		
		fieldBuffer.append(";\n");
				
		addAccessors(javaFieldName, javaType);
		addToString(javaFieldName, javaType);
	}

	public void addField(String javaFieldName, String javaType) {
		addTabs();
		fieldBuffer.append("private ");
		fieldBuffer.append(javaType);
		fieldBuffer.append(" ");
		fieldBuffer.append(javaFieldName);
		fieldBuffer.append(";\n");
				
		addAccessors(javaFieldName, javaType);
		addToString(javaFieldName, javaType);
	}
	
	public void addAccessors(String javaFieldName, String javaType)
	{
		try
		{
			File getsetTemplate = new File("templates/getset.txt");
			String content = FileUtils.readFileToString(getsetTemplate, Charset.defaultCharset());
		
			content = content.replaceAll("\\{\\$FIELD_NAME_CC\\}", NameUtils.upcaseFirst(javaFieldName));
			content = content.replaceAll("\\{\\$FIELD_NAME\\}", javaFieldName);
			content = content.replaceAll("\\{\\$TYPE\\}", javaType);

			getSetBuffer.append(content);		
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	public void addToString(String javaFieldName, String javaType)
	{
		try
		{
			File getsetTemplate = new File("templates/tostring.txt");
			String content = FileUtils.readFileToString(getsetTemplate, Charset.defaultCharset());
		
			content = content.replaceAll("\\{\\$FIELD_NAME\\}", javaFieldName);

			toStringBuffer.append(content);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public void fieldDone() {
		// TODO Auto-generated method stub
	}

	@Override
	public void fragmentCreated(String fragmentName) {
		// TODO Auto-generated method stub
		fieldBuffer.append("\n");
		addTabs();
		fieldBuffer.append("// ");
		fieldBuffer.append(fragmentName);
		fieldBuffer.append("\n");
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
			File pojoTemplate = new File("templates/pojo.txt");
			String content = FileUtils.readFileToString(pojoTemplate, Charset.defaultCharset());
			
			content = content.replaceAll("\\{\\$MODEL_PACKAGE\\}", NameUtils.toPackageName(modelName));
				
			content = content.replaceAll("\\{\\$MODEL_NAME\\}", NameUtils.toClassName(modelName));
				
			content = content.replaceAll("\\{\\$FIELDS\\}", fieldBuffer.toString());
			
			content = content.replaceAll("\\{\\$GETSET\\}", getSetBuffer.toString());

			content = content.replaceAll("\\{\\$TOSTRING\\}", toStringBuffer.toString());

			File dir = new File("output/"+NameUtils.toPackageName(modelName)+"/gen");
			dir.mkdirs();
			
			File output = new File(dir, NameUtils.toClassName(modelName)+".java");
			FileWriter fw = new FileWriter(output);
			fw.write(content, 0, content.length());
			fw.close();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void addTabs()
	{
		fieldBuffer.append("\t");
	}

}
