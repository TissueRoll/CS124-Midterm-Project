package processors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
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
public class JsonTemplateProcessor implements ModelListener, FragmentListener, FieldListener {

	boolean useSampleValues = true;
	
	String modelName;

	StringBuilder fieldBuffer = new StringBuilder();
	
	public JsonTemplateProcessor()
	{
		
	}
	
	public String getSampleValue(String type)
	{

		String[] data = type.split(":");
		
		
		switch (data[0].trim().toLowerCase())
		{
			case "string":
				if (data.length>1)
				{
					switch (data[1].toLowerCase())
					{
						case "number": 
							return "0";
						case "numberdecimal": 
							return "0.0";
						default:
							return "\"text\"";						
					}
				}
				else
				{
					return "\"text\"";
				}
				
			case "date":
				return "\"mm/dd/yyyy\"";
		
			case "list":
				return "[]";
				
			case "seekbar":
			case "seekbar2":
			case "single":
			case "single_img":
			case "checkbox":
			case "checkbox_img":
				return "0";
		}
		
		throw new RuntimeException("Unknown type: "+type);
	}
	
	
	@Override
	public void fieldCreated(String fieldName, String type, String misc) throws Exception {
		// TODO Auto-generated method stub

		if (ParseUtils.hasMisc("JSONCUSTOM", misc))
		{
			return;
		}
		
		ScanResult results = new FastClasspathScanner("processors.fieldCreatedExtension").scan();
		ReusableMethods rm = new ReusableMethods();
		ProcessorsImplement thing = (ProcessorsImplement) rm.getMethodForThisClass(fieldName, type, misc, this);
		thing.passInfo(fieldName, type, misc, this);
		thing.JsonTemplateProcessorCommand();	
	}
	
	public void addSimpleField(String javaFieldName, String type) {
		
		String jsonKey = NameUtils.javaFieldNameToJson(javaFieldName);		
		StringBuilder sb = fieldBuffer;

		addTabs(sb);
		sb.append(",\""); 
		sb.append(jsonKey);	
		sb.append("\":");

		sb.append(getSampleValue(type));
		sb.append("\n");
		
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
			File pojoTemplate = new File("templates/json.txt");
			String content = FileUtils.readFileToString(pojoTemplate, Charset.defaultCharset());
			
			
			content = content.replaceAll("\\{\\$MODEL_NAME\\}", NameUtils.toClassName(modelName));

			content = content.replaceAll("\\{\\$FIELDS\\}", fieldBuffer.toString());

			File dir = new File("output/json");
			dir.mkdirs();
			
			File output = new File(dir, NameUtils.toClassName(modelName)+".json");
			FileWriter fw = new FileWriter(output);
			fw.write(content, 0, content.length());
			fw.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void addTabs(StringBuilder sb)
	{
		sb.append("\t\t");
	}




	@Override
	public void fieldDone() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fragmentCreated(String fragmentName) {
		// TODO Auto-generated method stub
		fieldBuffer.append("\n\n");
	}

	@Override
	public void fragmentDone() {
		// TODO Auto-generated method stub
		
	}

	
	
}
