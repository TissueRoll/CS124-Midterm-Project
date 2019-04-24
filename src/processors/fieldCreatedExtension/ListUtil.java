package processors.fieldCreatedExtension;

import annotations.FieldCreatedIdentifier;
import annotations.RefersTo;
import processors.*;

@FieldCreatedIdentifier(identifier="LIST:")
@RefersTo(target= {PojoProcessor.class})
public class ListUtil extends GenericUtil implements ProcessorsImplement {
	
	public ListUtil() {
		
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
		String[] listData = type.split(":");
		obj.addUnmappedRealmList(javaFieldName, "io.realm.RealmList<"+listData[1]+">",listData[1], "new io.realm.RealmList<"+listData[1]+">()");
		
	}

}
