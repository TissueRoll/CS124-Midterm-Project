package inputfields;
import annotations.*;

@InputFields
public class StudentHealthFields {
	
	@ModelAnnotation(fieldName = "Student Health Assessment")
	private String studentHealthAssessment;
	@FieldAnnotation(fieldName = "SHINE ID", type = "STRING:text", misc = "UNMAPPED")
	private String shineId;

	// Page1
	@FragmentAnnotation(fieldName = "Page 1")
	private String page1;
	@LabelAnnotation(fieldName = "Immunization Status")
	private String immunizationStatus;
	@FieldAnnotation(fieldName = "Vaccines Administered", type = "MULTI:{BCG,DPT,OPV,PCV,MR,JE,TD,Others(specify)}", misc = "FIELDNAME:vaccines")
	private String vaccines;
	
	@LabelAnnotation(fieldName = "Vital Signs")
	private String vitalSigns;
	@FieldAnnotation(fieldName = "Temperature(F)", type = "STRING:numberDecimal", misc = "FIELDNAME:temperature")
	private Double temperature;
	
	@LabelAnnotation(fieldName = "Blood Pressure")
	private String bloodPressure;
	@FieldAnnotation(fieldName = "Systolic", type = "STRING:number", misc = "FIELDNAME:systolic")
	private Integer systolic;
	@FieldAnnotation(fieldName = "Diastolic", type = "STRING:number", misc = "FIELDNAME:diastolic")
	private Integer diastolic;
	
	@FieldAnnotation(fieldName = "Height in Centimeter", type = "STRING:numberDecimal", misc = "FIELDNAME:heightCm")
	private Double heightCm;
	@FieldAnnotation(fieldName = "Weight in KG", type = "STRING:numberDecimal", misc = "FIELDNAME:weightKg")
	private Double weightKg;
	@FieldAnnotation(fieldName = "BMI", type = "SINGLE:{Underweight,Normal,Overweight,Obese}", misc = "FIELDNAME:bmi")
	private Integer bmi;
	@FieldAnnotation(fieldName = "BMI computed", type = "STRING:numberDecimal", misc = "FIELDNAME:bmiComputed")
	private Double bmiComputed;
	
	@LabelAnnotation(fieldName = "Infectuous Disease")
	private String infectuousDisease;
	@FieldAnnotation(fieldName = "Acute Respiratory Infection", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:acuteRespiratoryInfection")
	private Integer acuteRespiratoryInfection;
	@FieldAnnotation(fieldName = "Acute Watery Diarrhea", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:acuteWateryDiarrhea")
	private Integer acuteWateryDiarrhea;
	@FieldAnnotation(fieldName = "Acute Bloody Diarrhea", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:acuteBloodyDiarrhea")
	private Integer acuteBloodyDiarrhea;
	@FieldAnnotation(fieldName = "Acute Jaundice Infection", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:acuteJaundiceInfection")
	private Integer acuteJaundiceInfection;
	@FieldAnnotation(fieldName = "Suspected Meningitis", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:suspectedMeningitis")
	private Integer suspectedMeningitis;
	@FieldAnnotation(fieldName = "Suspected Tetanus", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:suspectedTetanus")
	private Integer suspectedTetanus;
	@FieldAnnotation(fieldName = "Acute Flaccid Paralysis", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:acuteFlaccidParalysis")
	private Integer acuteFlaccidParalysis;
	@FieldAnnotation(fieldName = "Acute Hemorrhagic Fever", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:acuteHemorraphicFever")
	private Integer acuteHemorraphicFever;
	@FieldAnnotation(fieldName = "Fever", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:fever")
	private Integer fever;

	// Page2
	@FragmentAnnotation(fieldName = "Page 2")
	private String page2;
	@FieldAnnotation(fieldName = "Any Major Head Injury/Trauma", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:traumaMajorHead")
	private Integer traumaMajorHead;
	@FieldAnnotation(fieldName = "Any Major Spinal Injury", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:traumaMajorSpinal")
	private Integer traumaMajorSpinal;
	@FieldAnnotation(fieldName = "Any Major Torso Injury", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:traumaMajorTorso")
	private Integer traumaMajorTorso;
	@FieldAnnotation(fieldName = "Any Left Leg Injury", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:traumaLeftLeg")
	private Integer traumaLeftLeg;
	@FieldAnnotation(fieldName = "Any Right Leg Injury", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:traumaRightLeg")
	private Integer traumaRightLeg;
	@FieldAnnotation(fieldName = "Any Left Arm Injury", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:traumaLeftArm")
	private Integer traumaLeftArm;
	@FieldAnnotation(fieldName = "Any Right Arm Injury", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:traumaRightArm")
	private Integer traumaRightArm;
	
	@LabelAnnotation(fieldName = "Medical Condition")
	private String medicalCondition;
	@FieldAnnotation(fieldName = "Skin diseases?", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:skinDiseases")
	private Integer skinDiseases;
	@FieldAnnotation(fieldName = "Any Allergies?", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:allegies")
	private Integer allegies;
	@FieldAnnotation(fieldName = "Respiratory Disease", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:respiratoryDisease")
	private Integer respiratoryDisease;
	@FieldAnnotation(fieldName = "Cardiovascular Disease", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:cardiovascularDisease")
	private Integer cardiovascularDisease;
	@FieldAnnotation(fieldName = "Endocrine Disease", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:endocrineDisease")
	private Integer endocrineDisease;
	@FieldAnnotation(fieldName = "Urinary System Disease", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:urinarySystemDisease")
	private Integer urinarySystemDisease;
	@FieldAnnotation(fieldName = "Reproductive System Disease", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:reproductivSystemDisease")
	private Integer reproductivSystemDisease;
	@FieldAnnotation(fieldName = "Communication and Hearing Problem", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:communicationHearingProblem")
	private Integer communicationHearingProblem;
	@FieldAnnotation(fieldName = "Vision Problem", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:visionProblem")
	private Integer visionProblem;
	@FieldAnnotation(fieldName = "Oral and Dental Health Problem", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:oralDentalHealthProblem")
	private Integer oralDentalHealthProblem;
	@FieldAnnotation(fieldName = "Psychological and Behavioral Problem", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:psychologicalProblem")
	private Integer psychologicalProblem;
	@FieldAnnotation(fieldName = "Physical Functioning and Structural Problem", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:physicalStructuralProblems")
	private Integer physicalStructuralProblems;
	@FieldAnnotation(fieldName = "Cognitive Patterns", type = "SINGLE:{Normal,Abnormal(specify)}", misc = "FIELDNAME:cognativePatterns")
	private Integer cognativePatterns;
	@FieldAnnotation(fieldName = "Bowel Habit", type = "SINGLE:{Normal,Abnormal(specify)}", misc = "FIELDNAME:bowelHabit")
	private Integer bowelHabit;
	@FieldAnnotation(fieldName = "Bladder Habit", type = "SINGLE:{Normal,Abnormal(specify)}", misc = "FIELDNAME:bladderHabit")
	private Integer bladderHabit;
	
	@FieldAnnotation(fieldName = "Is under any medications", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:underMedication")
	private Integer underMedication;
	
	@FieldAnnotation(fieldName = "Received any recent treatment", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:recentTreatment")
	private Integer recentTreatment;
	@FieldAnnotation(fieldName = "Received any recent procedure", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:recentProcedure")
	private Integer recentProcedure;
	@FieldAnnotation(fieldName = "Received any recent counseling", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:recentCounseling")
	private Integer recentCounseling;

	@FragmentAnnotation(fieldName = "Page 3")
	private String page3;
	@LabelAnnotation(fieldName = "Behavioral Health")
	private String behavioralHealth;
	@FieldAnnotation(fieldName = "Suspension from school", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:bhSuspension")
	private Integer bhSuspension;
	@FieldAnnotation(fieldName = "Anti-social behavior", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:bhAntiSocialBehavior")
	private Integer bhAntiSocialBehavior;
	@FieldAnnotation(fieldName = "Delinquency", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:bhDelinquency")
	private Integer bhDelinquency;
	@FieldAnnotation(fieldName = "Violence", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:bhViolence")
	private Integer bhViolence;
	@FieldAnnotation(fieldName = "Smoking", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:bhSmoking")
	private Integer bhSmoking;
	@FieldAnnotation(fieldName = "Alcohol", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:bhAlcohol")
	private Integer bhAlcohol;
	@FieldAnnotation(fieldName = "Substance Abuse", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:bhSubstanceAbuse")
	private Integer bhSubstanceAbuse;
	@FieldAnnotation(fieldName = "Suicidal Thoughts", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:bhSuicidalThoughts")
	private Integer bhSuicidalThoughts;
	@FieldAnnotation(fieldName = "Suicidal Attempts", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:bhSuicidalAttempts")
	private Integer bhSuicidalAttempts;
	
	@LabelAnnotation(fieldName = "Food Intake")
	private String foodIntake;
	@LabelAnnotation(fieldName = "Breakfast")
	private String breakfast;
	@FieldAnnotation(fieldName = "Place", type = "STRING:text", misc = "FIELDNAME:breakfastPlace")
	private String breakfastPlace;
	@FieldAnnotation(fieldName = "Time", type = "STRING:text", misc = "FIELDNAME:breakfastTime")
	private String breakfastTime;
	@FieldAnnotation(fieldName = "Type of food", type = "STRING:text", misc = "FIELDNAME:breakfastTypeOfFood")
	private String breakfastTypeOfFood;
	
	@LabelAnnotation(fieldName = "Lunch")
	private String lunch;
	@FieldAnnotation(fieldName = "Place", type = "STRING:text", misc = "FIELDNAME:lunchPlace")
	private String lunchPlace;
	@FieldAnnotation(fieldName = "Time", type = "STRING:text", misc = "FIELDNAME:lunchTime")
	private String lunchTime;
	@FieldAnnotation(fieldName = "Type of food", type = "STRING:text", misc = "FIELDNAME:lunchTypeOfFood")
	private String lunchTypeOfFood;
	
	@LabelAnnotation(fieldName = "Snack")
	private String snack;
	@FieldAnnotation(fieldName = "Place", type = "STRING:text", misc = "FIELDNAME:snackPlace")
	private String snackPlace;
	@FieldAnnotation(fieldName = "Time", type = "STRING:text", misc = "FIELDNAME:snackTime")
	private String snackTime;
	@FieldAnnotation(fieldName = "Type of food", type = "STRING:text", misc = "FIELDNAME:snackTypeOfFood")
	private String snackTypeOfFood;
	
	@LabelAnnotation(fieldName = "Dinner")
	private String dinner;
	@FieldAnnotation(fieldName = "Place", type = "STRING:text", misc = "FIELDNAME:dinnerPlace")
	private String dinnerPlace;
	@FieldAnnotation(fieldName = "Time", type = "STRING:text", misc = "FIELDNAME:dinnerTime")
	private String dinnerTime;
	@FieldAnnotation(fieldName = "Type of food", type = "STRING:text", misc = "FIELDNAME:dinnerTypeOfFood")
	private String dinnerTypeOfFood;
	
	@FieldAnnotation(fieldName = "Malnutrition", type = "SINGLE:{No,Yes(specify)}", misc = "FIELDNAME:malnutrition")
	private Integer malnutrition;
	
	@LabelAnnotation(fieldName = "Activities")
	private String activities;
	@FieldAnnotation(fieldName = "Idle Hours", type = "STRING:text", misc = "FIELDNAME:idleHours")
	private String idleHours;
	@FieldAnnotation(fieldName = "Active Hours", type = "STRING:text", misc = "FIELDNAME:activeHours")
	private String activeHours;
	
	@LabelAnnotation(fieldName = "Menstrual Health")
	private String menstrualHealth;
	@FieldAnnotation(fieldName = "Age of Menarche", type = "STRING:number", misc = "FIELDNAME:ageOfMenarche|OPTIONAL")
	private Integer ageOfMenarche;
	@FieldAnnotation(fieldName = "Type of materials used during menstruation", type = "STRING:text", misc = "FIELDNAME:menstruationMaterials|OPTIONAL")
	private String menstruationMaterials;
	
	@LabelAnnotation(fieldName = "Family Involvement")
	private String familyInvolvement;
	@FieldAnnotation(fieldName = "Family Interaction/Engagement", type = "SINGLE:{No(specify),Yes}:If no, what is the reason", misc = "FIELDNAME:familyInteraction")
	private Integer familyInteraction;
	@FieldAnnotation(fieldName = "Community involvement", type = "SINGLE:{No(specify),Yes}:If no, what is the reason", misc = "FIELDNAME:communityInvolvement")
	private Integer communityInvolvement;
	@FieldAnnotation(fieldName = "Does the child have DRR knowledge?", type = "SINGLE:{No,Yes}", misc = "FIELDNAME:childDrrKnowledge")
	private Integer childDrrKnowledge;
	@FieldAnnotation(fieldName = "Any chief complaint from student", type = "STRING:text", misc = "FIELDNAME:childComplaint")
	private String childComplaint;
}
