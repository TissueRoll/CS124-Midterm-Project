package processors.fieldCreatedExtension;

import annotations.FieldCreatedIdentifier;
import annotations.RefersTo;
import processors.*;

@FieldCreatedIdentifier(identifier="SINGLE:")
@RefersTo(target = {JavaSerializerProcessor.class,JavaValidatorProcessor.class,JsonTemplateProcessor.class,PojoProcessor.class})
public class SingleUtil extends GenericUtil implements ProcessorsImplement {
	
	public SingleUtil() {
		
	}
	
	@Override
	public void passInfo(String fieldName, String type, String misc, Object o) {
		// TODO Auto-generated method stub
		super.passInfo(fieldName, type, misc, o);
	}

	@Override
	public void JavaSerializerProcessorCommand() {
		// TODO Auto-generated method stub
		JavaSerializerProcessor obj = (JavaSerializerProcessor) original;
		obj.addSerialization(javaFieldName);
		for (int i=0; i< options.length; i++)
		{
			String option = options[i];
			if (option.toLowerCase().contains("(specify"))
			{
				obj.addSerialization(javaFieldName+"Specify");				
				break;  
			}					
		}
	}

	@Override
	public void JavaValidatorProcessorCommand() {
		// TODO Auto-generated method stub
		JavaValidatorProcessor obj = (JavaValidatorProcessor) original;
		String dependencyCheck = obj.createDependencyCheck(javaFieldName, type, misc);
		obj.addValidation(javaFieldName, dependencyCheck, fieldName);
		for (int i=0; i< options.length; i++)
		{
			String option = options[i];
			if (option.toLowerCase().contains("(specify"))
			{
				obj.addSpecifyValidation(javaFieldName+"Specify", javaFieldName, i, fieldName+" "+option, dependencyCheck);				
				break;  
			}					
		}
	}

	@Override
	public void JsonTemplateProcessorCommand() {
		// TODO Auto-generated method stub
		JsonTemplateProcessor obj = (JsonTemplateProcessor) original;

		obj.addSimpleField(javaFieldName, type);
		for (int i=0; i< options.length; i++)
		{
			String option = options[i];
			if (option.toLowerCase().contains("(specify"))
			{
				obj.addSimpleField(javaFieldName+"Specify", "STRING");				
				break; 
			}					
		}
	}

	@Override
	public void PojoProcessorCommand() {
		// TODO Auto-generated method stub
		PojoProcessor obj = (PojoProcessor) original;

		String javaType = TypeUtils.getPojoType(type);
		obj.addField(javaFieldName, javaType);
		if (type.contains("(Specify".toLowerCase()))
		{
			obj.addField(javaFieldName+"Specify", "String");
		}
		
	}

}
