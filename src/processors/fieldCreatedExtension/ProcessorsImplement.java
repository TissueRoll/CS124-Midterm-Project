package processors.fieldCreatedExtension;

public interface ProcessorsImplement {
	public void passInfo(String fieldName, String type, String misc, Object o);
	public void JavaSerializerProcessorCommand();
	public void JavaValidatorProcessorCommand();
	public void JsonTemplateProcessorCommand();
	public void PojoProcessorCommand();
}
