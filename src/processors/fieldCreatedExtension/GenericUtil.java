package processors.fieldCreatedExtension;

import processors.ParseUtils;

public class GenericUtil {
	protected String javaFieldName;
	protected String[] options;
	public GenericUtil(String fieldName, String type, String misc) {
		javaFieldName = ParseUtils.extractJavaFieldName(fieldName, misc);
		String[] data = type.split(":");
		String optionString = data[1].substring(1, data[1].length()-1);
		options = optionString.split(",");	
	}
}
