package processors.fieldCreatedExtension;

import processors.ParseUtils;

public class GenericUtil {
	protected String javaFieldName;
	protected String[] options;
	protected String fieldName;
	protected String type;
	protected String misc;
	protected Object original;
	
	public GenericUtil() {
		
	}
	public void passInfo(String fieldName, String type, String misc, Object o) {
		this.fieldName = fieldName;
		this.type = type;
		this.misc = misc;
		javaFieldName = ParseUtils.extractJavaFieldName(fieldName, misc);
		String[] data = type.split(":");
		if (data.length > 1) {
			String optionString = data[1].substring(1, data[1].length()-1);
			options = optionString.split(",");	
		} else {
			options = data;
		}
		
		original = o;
	}
	
}
