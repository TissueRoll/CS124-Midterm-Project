package processors.fieldCreatedExtension;

import processors.*;

public class LineUtil extends GenericUtil implements ProcessorsImplement {
	
	private String fieldName;
	private String type;
	private String misc;
	private Object original;
	
	public LineUtil(String fieldName, String type, String misc, Object obj) {
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
		
	}

	@Override
	public void JavaValidatorProcessorCommand() {
		// TODO Auto-generated method stub
		JavaValidatorProcessor obj = (JavaValidatorProcessor) original;
		
	}

	@Override
	public void JsonTemplateProcessorCommand() {
		// TODO Auto-generated method stub
		JsonTemplateProcessor obj = (JsonTemplateProcessor) original;

	}

	@Override
	public void PojoProcessorCommand() {
		// TODO Auto-generated method stub
		PojoProcessor obj = (PojoProcessor) original;
//		String[] listData = type.split(":");
//		obj.getClass()
//		.getDeclaredMethod("addUnmappedRealmList", new Class[]{String.class, String.class, String.class})
//		.invoke(javaFieldName, "io.realm.RealmList<"+listData[1]+">",listData[1], "new io.realm.RealmList<"+listData[1]+">()");
//		obj.addUnmappedRealmList(javaFieldName, "io.realm.RealmList<"+listData[1]+">",listData[1], "new io.realm.RealmList<"+listData[1]+">()");
		/* has an error, since addField is private
		String[] listData = type.split(":");
		addUnmappedRealmList(javaFieldName, "io.realm.RealmList<"+listData[1]+">",listData[1], "new io.realm.RealmList<"+listData[1]+">()");
		*/
	}

}
