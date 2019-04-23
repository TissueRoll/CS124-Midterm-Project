package inputfields;
import annotations.*;

@InputFields
public class NurseRegFields {
	
	@ModelAnnotation(fieldName = "Nurse Registration")
	private String nurseRegistration;
	@FieldAnnotation(fieldName = "SHINE ID", type = "STRING:text", misc = "UNMAPPED")
	private String shineId;

	// Registration
	@FragmentAnnotation(fieldName = "Registration")
	private String registration;
	@LabelAnnotation(fieldName = "NAN Registration")
	private String nanRegistration;
	@FieldAnnotation(fieldName = "NAN Registration No", type = "STRING:text", misc = "FIELDNAME:nanNumber")
	private String nanNumber;
	@FieldAnnotation(fieldName = "First Name", type = "STRING:textPersonName", misc = "FIELDNAME:firstName")
	private String firstName;
	@FieldAnnotation(fieldName = "Middle Name", type = "STRING:textPersonName", misc = "FIELDNAME:middleName|OPTIONAL")
	private String middleName;
	@FieldAnnotation(fieldName = "Last Name", type = "STRING:textPersonName", misc = "FIELDNAME:lastName")
	private String lastName;
	@FieldAnnotation(fieldName = "Sex", type = "SINGLE:{Male, Female}", misc = "FIELDNAME:sex")
	private Integer sex;
	@FieldAnnotation(fieldName = "Citizenship No", type = "STRING:text", misc = "FIELDNAME:citizenshipNumber")
	private String citizenshipNumber;

	@LabelAnnotation(fieldName = "Birth Information (MM/DD/YYYY)")
	private String birthInformation;
	@FieldAnnotation(fieldName = "Date of Birth in AD", type = "DATE", misc = "FIELDNAME:dateOfBirthInAd")
	private String dateOfBirthInAd;
	@FieldAnnotation(fieldName = "Date of Birth in BS", type = "DATE", misc = "FIELDNAME:dateOfBirthInBs")
	private String dateOfBirthInBs;
	@FieldAnnotation(fieldName = "Age", type = "STRING:number", misc = "FIELDNAME:age")
	private Integer age;
	
	// Temporary Address
	@FragmentAnnotation(fieldName = "Temporary Address")
	@LabelAnnotation(fieldName = "Temporary Address")
	private String tempAddress;
	@FieldAnnotation(fieldName = "House Number", type = "STRING:textPostalAddress", misc = "FIELDNAME:tempHouseNumber")
	private String tempHouseNumber;
	@FieldAnnotation(fieldName = "Ward Number", type = "STRING:textPostalAddress", misc = "FIELDNAME:tempWardNumber")
	private String tempWardNumber;
	@FieldAnnotation(fieldName = "Municipality", type = "STRING:textPostalAddress", misc = "FIELDNAME:tempMunicipality")
	private String tempMunicipality;
	@FieldAnnotation(fieldName = "District", type = "STRING:textPostalAddress", misc = "FIELDNAME:tempDistrict")
	private String tempDistrict;
	@FieldAnnotation(fieldName = "Country", type = "STRING:textPostalAddress", misc = "FIELDNAME:tempCountry")
	private String tempCountry;
	@FieldAnnotation(fieldName = "ZipCode", type = "STRING:textPostalAddress", misc = "FIELDNAME:tempZipcode")
	private String tempZipcode;

	// Permanent Address
	@FragmentAnnotation(fieldName = "Permanent Address")
	@LabelAnnotation(fieldName = "Permanent Address")
	private String permanentAddress;
	@FieldAnnotation(fieldName = "House Number", type = "STRING:textPostalAddress", misc = "FIELDNAME:permanentHouseNumber")
	private String permanentHouseNumber;
	@FieldAnnotation(fieldName = "Ward Number", type = "STRING:textPostalAddress", misc = "FIELDNAME:permanentWardNumber")
	private String permanentWardNumber;
	@FieldAnnotation(fieldName = "Municipality", type = "STRING:textPostalAddress", misc = "FIELDNAME:permanentMunicipality")
	private String permanentMunicipality;
	@FieldAnnotation(fieldName = "District", type = "STRING:textPostalAddress", misc = "FIELDNAME:permanentDistrict")
	private String permanentDistrict;
	@FieldAnnotation(fieldName = "Country", type = "STRING:textPostalAddress", misc = "FIELDNAME:permanentCountry")
	private String permanentCountry;
	@FieldAnnotation(fieldName = "ZipCode", type = "STRING:textPostalAddress", misc = "FIELDNAME:permanentZipcode")
	private String permanentZipcode;

	// Professional Information
	@FragmentAnnotation(fieldName = "Professional Information")
	private String professionalInformation;
	@FieldAnnotation(fieldName = "Professional Status", type = "STRING:text", misc = "FIELDNAME:professionalStatus")
	private String professionalStatus;
	@FieldAnnotation(fieldName = "Designation", type = "STRING:text", misc = "FIELDNAME:designation")
	private String designation;
	@FieldAnnotation(fieldName = "Office", type = "STRING:text", misc = "FIELDNAME:office")
	private String office;
	
	@FieldAnnotation(fieldName = "qualifications", type = "LIST:com.ajwcc.epinurse.nurseregistration.ui.QualificationEntry", misc = "UNMAPPED")
	private String qualifications;
	@FieldAnnotation(fieldName = "trainings", type = "LIST:com.ajwcc.epinurse.nurseregistration.ui.TrainingEntry", misc = "UNMAPPED")
	private String trainings;
   
}
