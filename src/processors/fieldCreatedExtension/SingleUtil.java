package processors.fieldCreatedExtension;

import processors.*;

public class SingleUtil extends GenericUtil implements ProcessorsImplement {
	
	private String fieldName;
	private String type;
	private String misc;
	private Object original;
	
	public SingleUtil(String fieldName, String type, String misc, Object obj) {
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
		obj.addSerialization(javaFieldName);
		for (int i=0; i< options.length; i++)
		{
			String option = options[i];
			if (option.toLowerCase().contains("(specify"))
			{
				obj.addSerialization(javaFieldName+"Specify");				
				break;  // assume only one Specify field per group
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
				break;  // assume only one Specify field per group
			}					
		}
	}

	@Override
	public void JsonTemplateProcessorCommand() {
		// TODO Auto-generated method stub
		JsonTemplateProcessor obj = (JsonTemplateProcessor) original;
		/* has an error, since addSimpleField is private
		addSimpleField(javaFieldName, type);
		for (int i=0; i< options.length; i++)
		{
			String option = options[i];
			if (option.toLowerCase().contains("(specify"))
			{
				addSimpleField(javaFieldName+"Specify", "STRING");				
				break;  // assume only one Specify field per group
			}					
		}
		*/
	}

	@Override
	public void PojoProcessorCommand() {
		// TODO Auto-generated method stub
		PojoProcessor obj = (PojoProcessor) original;
		/* has an error, since addField is private
		String javaType = TypeUtils.getPojoType(type);
		addField(javaFieldName, javaType);
		if (type.contains("(Specify".toLowerCase()))
		{
			addField(javaFieldName+"Specify", "String");
		}
		*/
	}

}
