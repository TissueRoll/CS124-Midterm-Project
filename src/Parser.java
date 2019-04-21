import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import annotations.Processor;
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
	
	/*
	 * constructor
	 * calls add listener and passes each .*Processor class
	 * -- maybe use fastclasspathscanner? idk
	 */
	public Parser(String file) throws Exception
	{
		dataFile = file;
		ScanResult processors = new FastClasspathScanner("processors").scan();
		List<String> allProcessors = processors.getNamesOfClassesWithAnnotation("annotations.Processor");
		for (String s : allProcessors) {
			addListener(Class.forName(s).newInstance());
		}
	}
	
	/*
	 * if the object is an instance of a listener, add it with its corresponding add function
	 * > actually just adds it to an arraylist
	 * -- maybe possible to use fastclasspathscanner but maybe need something a bit more complicated (something like an interceptor)
	 */
	public void addListener(Object o)
	{
		// add<TYPE>Listener(<TYPE> o);
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
	
	/*
	 * parses the input file according to label
	 * calls corresponding method for label
	 * each method call is similar but has something different each time; might be optimizable
	 */
	public void parse() throws Exception
	{
		// read line
		//	read MODEL:name
			// generate POJO file (no getter/setter, no toString)
			// generate Activity class
		//  read FRAGMENT:name
			// generate new fragment layout (save previous if any)
			// generate fragment class (save previous if any)
		
		//  FIELD no prefix == FIELD
			// name
				// generate javaFieldName unless FIELDNAME present
			// type
				// STRING: input
				// SINGLE: {values}
				// CHECKBOX
				// DATE
					// DATE: needs adding code to trigger the date processing
			// misc
				// FIELDNAME:javaFieldName
		
			// add to POJO, add to fragment, add to fragment layout, 			
			// add Fragment init to Activity class


		//	prefix LABEL:name
			// adds a TextView/Spacer to the fragment layout
		
		Scanner scanner = new Scanner(new File(dataFile));
		
		while(scanner.hasNextLine())
		{
			String line = scanner.nextLine().trim();
			try {
				if (line.trim().isEmpty()) // keep
				{
					continue;
				}
				
				if (line.startsWith("#")) // keep
				{
					// comment, ignore
					continue;
				}
				
				// basically replace this if else chain with some mechanism to determine new<type>Created();
				// we can probably use reflection to find stuff with method names as new.*Created
				// everything is just new<TYPE>Created(line) so maybe theres a way to do this
				if (line.startsWith("MODEL"))
				{
					newModelCreated(line);
				}
				else if (line.startsWith("FRAGMENT"))
				{
					newFragmentCreated(line);
				}
				else if (line.startsWith("LABEL"))
				{
					newLabelCreated(line);
				}
				else
				{
					// field
					newFieldCreated(line);
				}
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				System.out.println("ERROR in line: "+line);
				e.printStackTrace();
				throw e;			
			}
		}
		
		// trigger done to commit all files
		for (ModelListener ml : modelListeners)
		{
			ml.modelDone();
		}
	}
	
	// slightly different from the others
	private List<FieldListener> fieldListeners = new ArrayList<>();
	
	public void addFieldListener(FieldListener fl)
	{
		fieldListeners.add(fl);
	}
	
	public void newFieldCreated(String line) throws Exception
	{
		String[] data = line.split(";");
		
		if (data.length<2)
		{
			throw new RuntimeException("not enough data for FIELD: "+line);
		}
		
		for (FieldListener fl : fieldListeners)
		{
			fl.fieldCreated(data[0].trim(), data[1].trim(), data.length>2 ? data[2].trim() : null);
		}
	}
	
	// fragment, model, label are all the same functions
	private List<FragmentListener> fragmentListeners = new ArrayList<>();
	
	public void addFragmentListener(FragmentListener fl)
	{
		fragmentListeners.add(fl);
	}
	
	public void newFragmentCreated(String line)
	{
		String[] data = line.split(";");
		
		if (data.length<2)
		{
			throw new RuntimeException("not enough data for FRAGMENT");
		}

		for (FragmentListener fl : fragmentListeners)
		{
			fl.fragmentCreated(data[1].trim());
		}
	}

	private List<ModelListener> modelListeners = new ArrayList<>();
	
	public void addModelListener(ModelListener fl)
	{
		modelListeners.add(fl);
	}
	
	public void newModelCreated(String line)
	{
		String[] data = line.split(";");
		
		if (data.length<2)
		{
			throw new RuntimeException("not enough data for MODEL");
		}

		for (ModelListener fl : modelListeners)
		{
			fl.modelCreated(data[1].trim());
		}
	}	
	
	private List<LabelListener> labelListeners = new ArrayList<>();
	
	public void addLabelListener(LabelListener fl)
	{
		labelListeners.add(fl);
	}
	
	public void newLabelCreated(String line)
	{
		String[] data = line.split(";");
		
		if (data.length<2)
		{
			throw new RuntimeException("not enough data for LABEL");
		}

		for (LabelListener fl : labelListeners)
		{
			fl.labelCreated(data[1].trim());
		}
	}	
}
