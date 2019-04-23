package inputfields;
import annotations.*;

@InputFields
public class BasicInfoFields {

	@ModelAnnotation(fieldName = "Basic Information")
	private String basicInformation;
	@FieldAnnotation(fieldName = "Patient ID", type = "STRING:text", misc = "UNMAPPED")
	private String patientId;
	
	// Personal Information
	@FragmentAnnotation(fieldName = "Personal Information")
	@LabelAnnotation(fieldName = "Personal Information")
	private String personalInformation;
	@FieldAnnotation(fieldName = "First Name", type = "STRING:textPersonName", misc = "FIELDNAME:firstName")
	private String firstName;
	@FieldAnnotation(fieldName = "Middle Name", type = "STRING:textPersonName", misc = "FIELDNAME:middleName|OPTIONAL")
	private String middleName;
	@FieldAnnotation(fieldName = "Last Name", type = "STRING:textPersonName", misc = "FIELDNAME:lastName")
	private String lastName;
	@FieldAnnotation(fieldName = "Sex", type = "SINGLE:{Male, Female}", misc = "FIELDNAME:sex")
	private Integer sex;
	@FieldAnnotation(fieldName = "Marital Status", type = "SINGLE:{Unmarried, Married, Divorced, Widowed/Widower, Broken/Separated}", misc = "FIELDNAME:maritalStatus")
	private Integer maritalStatus;
	
	@LabelAnnotation(fieldName = "Birth Information (MM/DD/YYYY)")
	private String birthInformation;
	@FieldAnnotation(fieldName = "Date of Birth in AD", type = "DATE", misc = "FIELDNAME:dateOfBirthInAd")
	private String dateOfBirthInAd;
	@FieldAnnotation(fieldName = "Date of Birth in BS", type = "DATE", misc = "FIELDNAME:dateOfBirthInBs")
	private String dateOfBirthInBs;
	@FieldAnnotation(fieldName = "Age", type = "STRING:number", misc = "FIELDNAME:age")
	private Integer age;

	// Household Information
	@FragmentAnnotation(fieldName = "Household Information")
	private String householdInformation;
	@LabelAnnotation(fieldName = "Family Information")
	private String familyInformation;
	@FieldAnnotation(fieldName = "Family ID", type = "STRING:text", misc = "FIELDNAME:familyID")
	private String familyID;
	@FieldAnnotation(fieldName = "Type of Family", type = "SINGLE:{Nuclear,Joint,Extended}", misc = "FIELDNAME:typeOfFamily")
	private Integer typeOfFamily;
	
	@LabelAnnotation(fieldName = "Address")
	private String address;
	@FieldAnnotation(fieldName = "House Number", type = "STRING:textPostalAddress", misc = "FIELDNAME:houseNumber")
	private String houseNumber;
	@FieldAnnotation(fieldName = "Ward Number", type = "STRING:textPostalAddress", misc = "FIELDNAME:wardNumber")
	private String wardNumber;
	@FieldAnnotation(fieldName = "Municipality", type = "STRING:textPostalAddress", misc = "FIELDNAME:municipality")
	private String municipality;
	@FieldAnnotation(fieldName = "District", type = "STRING:textPostalAddress", misc = "FIELDNAME:district")
	private String district;
	@FieldAnnotation(fieldName = "Country", type = "STRING:textPostalAddress", misc = "FIELDNAME:country")
	private String country;
	@FieldAnnotation(fieldName = "ZipCode", type = "STRING:textPostalAddress", misc = "FIELDNAME:zipcode")
	private String zipcode;
	
	@LabelAnnotation(fieldName = "Household Information")
	private String familyInformationLabel; //FIX THIS OR MAKE EVERYTHING SAME
	@FieldAnnotation(fieldName = "Father's Name", type = "STRING:textPersonName", misc = "FIELDNAME:fathersName|OPTIONAL")
	private String fathersName;
	@FieldAnnotation(fieldName = "Father Late?", type = "CHECKBOX", misc = "FIELDNAME:fatherLate")
	private Integer fatherLate;
	@FieldAnnotation(fieldName = "Mother's Name", type = "STRING:textPersonName", misc = "FIELDNAME:mothersName|OPTIONAL")
	private String mothersName;
	@FieldAnnotation(fieldName = "Mother Late?", type = "CHECKBOX", misc = "FIELDNAME:motherLate")
	private Integer motherLate;
	@FieldAnnotation(fieldName = "Local Guardian's Name", type = "STRING:textPersonName", misc = "FIELDNAME:localGuardiansName|OPTIONAL")
	private String localGuardiansName;
	@FieldAnnotation(fieldName = "Contact of Parent/Guardian", type = "STRING:text", misc = "FIELDNAME:contactOfParentGuardian|OPTIONAL")
	private String contactOfParentGuardian;
	
	@LabelAnnotation(fieldName = "Family Details in Number")
	private String detailsInNumber;
	@FieldAnnotation(fieldName = "Male", type = "STRING:number", misc = "FIELDNAME:numberMale")
	private Integer numberMale;
	@FieldAnnotation(fieldName = "Female", type = "STRING:number", misc = "FIELDNAME:numberFemale")
	private Integer numberFemale;
	@FieldAnnotation(fieldName = "Others", type = "STRING:number", misc = "FIELDNAME:numberOthers")
	private Integer numberOthers;
	@FieldAnnotation(fieldName = "Under 5 years Male", type = "STRING:number", misc = "FIELDNAME:numberMaleUnder5")
	private Integer numberMaleUnder5;
	@FieldAnnotation(fieldName = "Under 5 years Female", type = "STRING:number", misc = "FIELDNAME:numberFemaleUnder5")
	private Integer numberFemaleUnder5;
	@FieldAnnotation(fieldName = "Above 60 years Male", type = "STRING:number", misc = "FIELDNAME:numberMaleAbove60")
	private Integer numberMaleAbove60;
	@FieldAnnotation(fieldName = "Above 60 years Female", type = "STRING:number", misc = "FIELDNAME:numberFemaleAbove60")
	private Integer numberFemaleAbove60;
	@FieldAnnotation(fieldName = "Disabled", type = "STRING:number", misc = "FIELDNAME:numberDisabled")
	private Integer numberDisabled;
	@FieldAnnotation(fieldName = "Pregnant", type = "STRING:number", misc = "FIELDNAME:numberPregnant")
	private Integer numberPregnant;
	@FieldAnnotation(fieldName = "Lactating Mothers", type = "STRING:number", misc = "FIELDNAME:numberLactatingMothers")
	private Integer numberLactatingMothers;

	// Socio-Economic Information
	@FragmentAnnotation(fieldName = "Socio-Economic Information")
	@LabelAnnotation(fieldName = "Socio-Economic Information")
	private String socioEconomicInformation;
	@FieldAnnotation(fieldName = "Ethnicity", type = "STRING:text", misc = "FIELDNAME:ethnicity")
	private String ethnicity;
	@FieldAnnotation(fieldName = "Religion", type = "STRING:text", misc = "FIELDNAME:religion")
	private String religion;
	@FieldAnnotation(fieldName = "Educational Status", type = "SINGLE:{Illiterate, Literate, Primary Level(1-5), Secondary Level(6-10), Higher Secondary(11-12), Bachelor and above}", misc = "FIELDNAME:educationalStatus")
	private Integer educationalStatus;
	@FieldAnnotation(fieldName = "Occupation", type = "SINGLE:{House Maker, Agriculture, Business, Services, Labor, Others(specify)}", misc = "FIELDNAME:occupation")
	private Integer occupation;
	@FieldAnnotation(fieldName = "Main source of family income", type = "MULTI:{Agriculture,Business,Service, Labor, Remittance, Others(specify)}", misc = "FIELDNAME:income")
	private String income;
	@FieldAnnotation(fieldName = "Food sufficiency of your family from the main source of income", type = "SINGLE:{Sufficient for less than 3 months, Sufficient for 3-5 months, Sufficient for 6-11 months, Sufficient for 12 months and with surplus}", misc = "FIELDNAME:foodSufficiency")
	private Integer foodSufficiency;
	
}
