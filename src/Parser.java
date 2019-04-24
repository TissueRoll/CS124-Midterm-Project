import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import annotations.*;
import inputfields.BasicInfoFields;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;
import listeners.FieldListener;
import listeners.FragmentListener;
import listeners.LabelListener;
import listeners.ModelListener;
import processors.JavaSerializerProcessor;
import processors.JavaValidatorProcessor;
import processors.JsonTemplateProcessor;
import processors.PojoProcessor;

public class Parser 
{
	private String dataFile;

	public Parser(String file) throws Exception
	{
		dataFile = file;
		ScanResult processors = new FastClasspathScanner("processors").scan();
		List<String> allProcessors = processors.getNamesOfClassesWithAnnotation("annotations.RefersTo");
		for (String s : allProcessors) {
			addListener(Class.forName(s).newInstance());
		}
	}
	
	public void addListener(Object o)
	{
		if (o instanceof ModelListener)
		{
			addModelListener((ModelListener) o);
		}
		if (o instanceof FragmentListener)
		{
			addFragmentListener((FragmentListener) o);		
		}
		if (o instanceof FieldListener)
		{
			addFieldListener((FieldListener) o);			
		}
		if (o instanceof LabelListener)
		{
			addLabelListener((LabelListener) o);
		}
	}
	
	public void parse() throws Exception
	{
		ScanResult results = new FastClasspathScanner("inputfields").scan();
		List<String> allResults = results.getNamesOfClassesWithAnnotation(InputFields.class);
		for (String s : allResults)
		{
			Class c = Class.forName(s);
			for (Field f : c.getDeclaredFields())
			{
				if(f.isAnnotationPresent(ModelAnnotation.class))
				{
					ModelAnnotation fa = (ModelAnnotation) f.getAnnotation(ModelAnnotation.class);
					newModelCreated(fa.fieldName());
				}
				else if(f.isAnnotationPresent(FragmentAnnotation.class))
				{
					FragmentAnnotation fa = (FragmentAnnotation) f.getAnnotation(FragmentAnnotation.class);
					newFragmentCreated(fa.fieldName());
				}
				else if(f.isAnnotationPresent(LabelAnnotation.class))
				{
					LabelAnnotation fa = (LabelAnnotation) f.getAnnotation(LabelAnnotation.class);
					newLabelCreated(fa.fieldName());
				}
				else if(f.isAnnotationPresent(FieldAnnotation.class))
				{
					FieldAnnotation fa = (FieldAnnotation) f.getAnnotation(FieldAnnotation.class);
					newFieldCreated(fa.fieldName(), fa.type(), fa.misc());
				}
			}
		}
		
		for (ModelListener ml : modelListeners)
		{
			ml.modelDone();
		}
	}
	
	//FIELD
	private List<FieldListener> fieldListeners = new ArrayList<>();
	
	public void addFieldListener(FieldListener fl)
	{
		fieldListeners.add(fl);
	}
	
	public void newFieldCreated(String fN, String t, String m) throws Exception
	{		
		for (FieldListener fl : fieldListeners)
		{
			fl.fieldCreated(fN, t, m);
		}
	}
	
	//FRAGMENT
	private List<FragmentListener> fragmentListeners = new ArrayList<>();
	
	public void addFragmentListener(FragmentListener fl)
	{
		fragmentListeners.add(fl);
	}
	
	public void newFragmentCreated(String line)
	{
		for (FragmentListener fl : fragmentListeners)
		{
			fl.fragmentCreated(line);
		}
	}

	//MODEL
	private List<ModelListener> modelListeners = new ArrayList<>();
	
	public void addModelListener(ModelListener fl)
	{
		modelListeners.add(fl);
	}
	
	public void newModelCreated(String line)
	{
		for (ModelListener fl : modelListeners)
		{
			fl.modelCreated(line);
		}
	}	
	
	//LABEL
	private List<LabelListener> labelListeners = new ArrayList<>();
	
	public void addLabelListener(LabelListener fl)
	{
		labelListeners.add(fl);
	}
	
	public void newLabelCreated(String line)
	{
		for (LabelListener fl : labelListeners)
		{
			fl.labelCreated(line);
		}
	}	
}
