package processors.fieldCreatedExtension;

import annotations.FieldCreatedIdentifier;
import annotations.RefersTo;
import processors.*;

@FieldCreatedIdentifier(identifier="OTHER")
@RefersTo(target = {JavaSerializerProcessor.class,JavaValidatorProcessor.class,JsonTemplateProcessor.class,PojoProcessor.class})
public class OtherUtil extends GenericUtil implements ProcessorsImplement {
	
	
	public OtherUtil() {
		
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
		boolean addSpecifyField = false;
		if (type.equals("CHECKBOX:SPECIFY"))
		{
			addSpecifyField = true;
		}
		
		obj.addSerialization(javaFieldName);
		
		if (addSpecifyField)
		{
			obj.addSerialization(javaFieldName+"Specify");				
		}
	}

	@Override
	public void JavaValidatorProcessorCommand() {
		// TODO Auto-generated method stub
		JavaValidatorProcessor obj = (JavaValidatorProcessor) original;
		String dependencyCheck = obj.createDependencyCheck(javaFieldName, type, misc);
		boolean addSpecifyField = false;
		if (type.equals("CHECKBOX:SPECIFY"))
		{
			addSpecifyField = true;
		}
				
		obj.addValidation(javaFieldName, dependencyCheck, fieldName);
		
		if (addSpecifyField)
		{
			obj.addSpecifyValidation(javaFieldName+"Specify", javaFieldName, 1, fieldName+" Specify", dependencyCheck);				
		}
	}

	@Override
	public void JsonTemplateProcessorCommand() {
		// TODO Auto-generated method stub
		JsonTemplateProcessor obj = (JsonTemplateProcessor) original;
		boolean addSpecifyField = false;
		/* CHANGE */
		// wont work if methods needed below are protected/private
		if (type.equals("CHECKBOX:SPECIFY"))
		{
			addSpecifyField = true;
		}
				
		obj.addSimpleField(javaFieldName, type);
		
		if (addSpecifyField)
		{
			obj.addSimpleField(javaFieldName+"Specify", "STRING");				
		}
		
	}

	@Override
	public void PojoProcessorCommand() {
		// TODO Auto-generated method stub
		PojoProcessor obj = (PojoProcessor) original;
		/* CHANGE */
		// wont work if methods needed below are protected/private
		String javaType = TypeUtils.getPojoType(type);
			
		boolean addSpecifyField = false;
		if (type.equals("CHECKBOX:SPECIFY"))
		{
			addSpecifyField = true;
		}
				
		obj.addField(javaFieldName, javaType);
		
		if (addSpecifyField)
		{
			obj.addField(javaFieldName+"Specify", "String");
		}	
		
	}

}
