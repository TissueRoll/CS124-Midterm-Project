package processors.fieldCreatedExtension;

import processors.*;

public class OtherUtil extends GenericUtil implements ProcessorsImplement {
	
	private String fieldName;
	private String type;
	private String misc;
	private Object original;
	
	public OtherUtil(String fieldName, String type, String misc, Object obj) {
		super(fieldName, type, misc);
		this.fieldName = fieldName;
		this.type = type;
		this.misc = misc;
		this.original = obj;
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
		/* has an error, since addSimpleField is private
		boolean addSpecifyField = false;
		if (type.equals("CHECKBOX:SPECIFY"))
		{
			addSpecifyField = true;
		}
				
		addSimpleField(javaFieldName, type);
		
		if (addSpecifyField)
		{
			addSimpleField(javaFieldName+"Specify", "STRING");				
		}
		*/
	}

	@Override
	public void PojoProcessorCommand() {
		// TODO Auto-generated method stub
		PojoProcessor obj = (PojoProcessor) original;
		/* has an error, since addField is private
		String javaType = TypeUtils.getPojoType(type);
			
		boolean addSpecifyField = false;
		if (type.equals("CHECKBOX:SPECIFY"))
		{
			addSpecifyField = true;
		}
				
		addField(javaFieldName, javaType);
		
		if (addSpecifyField)
		{
			addField(javaFieldName+"Specify", "String");
		}	
		*/
	}

}
