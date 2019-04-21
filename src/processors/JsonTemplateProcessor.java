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
	
	/* CHANGE */
	// used to be private
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
		
		// check if the field is a meant for custom runtime serialization
			// if it is, nothing is added at this point, just skip
		if (ParseUtils.hasMisc("JSONCUSTOM", misc))
		{
			return;
		}
		
		ScanResult results = new FastClasspathScanner("processors.fieldCreatedExtension").scan();
		List<String> allResults = results.getNamesOfClassesWithAnnotation(FieldCreatedIdentifier.class);
		boolean matched = false;
		for (String s : allResults) {
			Class c = Class.forName(s);
			RefersTo rt = (RefersTo) c.getAnnotation(RefersTo.class);
			boolean isReferred = false;
			for (Class referredClass : rt.target()) {
				if (this.getClass().equals(referredClass)) {
					isReferred = true;
				}
			}
			if (!isReferred) {
				continue;
			}
			FieldCreatedIdentifier fci = (FieldCreatedIdentifier) c.getAnnotation(FieldCreatedIdentifier.class);
			if (type.startsWith(fci.identifier())) {
				matched = true;
				ProcessorsImplement thing = (ProcessorsImplement) c.newInstance();
				thing.passInfo(fieldName, type, misc, this);
				thing.JsonTemplateProcessorCommand();
			}
		}
		if (!matched) {
			ProcessorsImplement thing = (ProcessorsImplement) Class.forName("processors.fieldCreatedExtension.OtherUtil").newInstance();
			thing.passInfo(fieldName, type, misc, this);
			thing.JsonTemplateProcessorCommand();
		}
	}
	
	/* CHANGE */
	// used to be private
	public void addSimpleField(String javaFieldName, String type) {
		// javaType just determines if value will have a ""
		
//		,"src_maternity_info": 0
//		,"child_name": "Name of child"
		
		String jsonKey = NameUtils.javaFieldNameToJson(javaFieldName);		
		StringBuilder sb = fieldBuffer;

		addTabs(sb);
		// add key only if fresh
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
			
			
			// update info
			content = content.replaceAll("\\{\\$MODEL_NAME\\}", NameUtils.toClassName(modelName));
				// {$FIELDS}
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
	
	/* CHANGE */
	// used to be private
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
