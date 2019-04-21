package listeners;

public interface FieldListener 
{
	public void fieldCreated(String fieldName, String type, String misc) throws Exception;
	public void fieldDone();
}
