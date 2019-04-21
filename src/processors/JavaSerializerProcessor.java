package processors;

import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;

import annotations.FieldCreatedIdentifier;
import annotations.RefersTo;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;
import listeners.FieldListener;
import listeners.FragmentListener;
import listeners.LabelListener;
import listeners.ModelListener;
import processors.fieldCreatedExtension.ProcessorsImplement;
import processors.fieldCreatedExtension.ReusableMethods;

@RefersTo(target= {ModelListener.class,FragmentListener.class,FieldListener.class,LabelListener.class})
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
		ReusableMethods rm = new ReusableMethods();
		ProcessorsImplement thing = (ProcessorsImplement) rm.getMethodForThisClass(fieldName, type, misc, this);
		thing.passInfo(fieldName, type, misc, this);
		thing.JavaSerializerProcessorCommand();	
	}


	public void addSerialization(String name)
	{
		addSerializeCall(name);
		addSerializeMethod(name);
	}
	
	public void addSerializeCall(String name)
	{
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
