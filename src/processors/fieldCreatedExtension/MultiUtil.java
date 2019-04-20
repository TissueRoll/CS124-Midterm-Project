package processors.fieldCreatedExtension;

import processors.*;

public class MultiUtil extends GenericUtil implements ProcessorsImplement {
	
	private String type;
	private String misc;
	private Object original;
	
	public MultiUtil(String fieldName, String type, String misc, Object obj) {
		super(fieldName, type, misc);
		this.type = type;
		this.misc = misc;
		this.original = obj;
	}

	@Override
	public void JavaSerializerProcessorCommand() {
		// TODO Auto-generated method stub
		JavaSerializerProcessor obj = (JavaSerializerProcessor) original;
		for (int i=0; i<options.length; i++)
		{
			String name = (String) options[i];

			if (name.toLowerCase().contains("(specify)"))
			{
				obj.addSerialization(javaFieldName+"Others");
				obj.addSerialization(javaFieldName+"Specify");				
			}
			else
			{
				obj.addSerialization(javaFieldName+NameUtils.toJavaFieldNameAppender(name.trim()));
			}
		}
	}

	@Override
	public void JavaValidatorProcessorCommand() {
		// TODO Auto-generated method stub
		JavaValidatorProcessor obj = (JavaValidatorProcessor) original;
		String dependencyCheck = obj.createDependencyCheck(javaFieldName, type, misc);
		for (int i=0; i<options.length; i++)
		{
			String name = (String) options[i];


			if (name.toLowerCase().contains("(specify)"))
			{
				obj.addValidation(javaFieldName+"Others", dependencyCheck, NameUtils.stripRadioAlias(name));
				obj.addSpecifyValidation(javaFieldName+"Specify", javaFieldName+"Others", 1, NameUtils.stripRadioAlias(name), dependencyCheck);				
			}
			else
			{
				obj.addValidation(javaFieldName+NameUtils.toJavaFieldNameAppender(name.trim()), dependencyCheck, NameUtils.stripRadioAlias(name));
			}
		}
	}

	@Override
	public void JsonTemplateProcessorCommand() {
		// TODO Auto-generated method stub
		JsonTemplateProcessor obj = (JsonTemplateProcessor) original;
		/* has an error, since addSimpleField is private
		for (String name : options)
		{
			if (name.toLowerCase().contains("(specify)"))
			{
				obj.addSimpleField(javaFieldName+"Others", "CHECKBOX");
				obj.addSimpleField(javaFieldName+"Specify", "STRING");				
			}
			else
			{
				obj.addSimpleField(javaFieldName+NameUtils.toJavaFieldNameAppender(name.trim()), "CHECKBOX");
			}
		}
		*/
	}

	@Override
	public void PojoProcessorCommand() {
		// TODO Auto-generated method stub
		PojoProcessor obj = (PojoProcessor) original;
		/* has an error, since addField is private
		for (int i=0; i<options.length; i++)
		{
			String name = (String) options[i];
			String javaType = "Integer";
			
			if (name.contains("(specify)".toLowerCase()))
			{
				obj.addField(javaFieldName+"Others", javaType);
				obj.addField(javaFieldName+"Specify", "String");
			}
			else
			{
				obj.addField(javaFieldName+NameUtils.toJavaFieldNameAppender(name.trim()), javaType);
			}
		}
		*/
	}

}
