package processors.fieldCreatedExtension;

import java.util.List;

import annotations.FieldCreatedIdentifier;
import annotations.RefersTo;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;

public class ReusableMethods {
	public ReusableMethods() {
		
	}
	
	public Object getMethodForThisClass (String fieldName, String type, String misc, Object o) throws Exception {
		Object returnedObject = null;
		ScanResult results = new FastClasspathScanner("processors.fieldCreatedExtension").scan();
		List<String> allResults = results.getNamesOfClassesWithAnnotation(FieldCreatedIdentifier.class);
		boolean matched = false;
		for (String s : allResults) {
			Class c = Class.forName(s);
			RefersTo rt = (RefersTo) c.getAnnotation(RefersTo.class);
			boolean isReferred = false;
			for (Class referredClass : rt.target()) {
				if (o.getClass().equals(referredClass)) {
					isReferred = true;
				}
			}
			if (!isReferred) {
				continue;
			}
			FieldCreatedIdentifier fci = (FieldCreatedIdentifier) c.getAnnotation(FieldCreatedIdentifier.class);
			if (type.startsWith(fci.identifier())) {
				matched = true;
				returnedObject = c.newInstance();
			}
		}
		if (!matched) {
			returnedObject = Class.forName("processors.fieldCreatedExtension.OtherUtil").newInstance();
		}
		return returnedObject;
	}
}
