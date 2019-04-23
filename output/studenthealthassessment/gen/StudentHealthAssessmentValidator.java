package com.ajwcc.epinurse.StudentHealthAssessment.gen;

import com.ajwcc.epinurse.common.BaseValidator;
import com.ajwcc.util.ui.validation.ValidationHandler;
import com.ajwcc.epinurse.R;

public class StudentHealthAssessmentValidator extends BaseValidator implements ValidationHandler<StudentHealthAssessment>
{
    protected StudentHealthAssessment model;
    protected StudentHealthAssessmentActivity activity;


    public StudentHealthAssessmentValidator(StudentHealthAssessmentActivity a)
    {
    	super(a);
        activity = a;
    }

    @Override
    public void setModel(StudentHealthAssessment model)
    {
        this.model = model;
    }

    @Override
    public void validateModel()
    {
		validateFirstName();
		//  middleName optional
		validateLastName();
		validateSex();
		validateMaritalStatus();
		validateDateOfBirthInAd();
		validateDateOfBirthInBs();
		validateAge();
		validateFamilyID();
		validateTypeOfFamily();
		validateHouseNumber();
		validateWardNumber();
		validateMunicipality();
		validateDistrict();
		validateCountry();
		validateZipcode();
		//  fathersName optional
		validateFatherLate();
		//  mothersName optional
		validateMotherLate();
		//  localGuardiansName optional
		//  contactOfParentGuardian optional
		validateNumberMale();
		validateNumberFemale();
		validateNumberOthers();
		validateNumberMaleUnder5();
		validateNumberFemaleUnder5();
		validateNumberMaleAbove60();
		validateNumberFemaleAbove60();
		validateNumberDisabled();
		validateNumberPregnant();
		validateNumberLactatingMothers();
		validateEthnicity();
		validateReligion();
		validateEducationalStatus();
		validateOccupation();
		validateOccupationSpecify();
		validateIncomeAgriculture();
		validateIncomeBusiness();
		validateIncomeService();
		validateIncomeLabor();
		validateIncomeRemittance();
		validateIncomeOthers();
		validateIncomeSpecify();
		validateFoodSufficiency();
		validateShineId();
		validateNanNumber();
		validateFirstName();
		//  middleName optional
		validateLastName();
		validateSex();
		validateCitizenshipNumber();
		validateDateOfBirthInAd();
		validateDateOfBirthInBs();
		validateAge();
		validateTempHouseNumber();
		validateTempWardNumber();
		validateTempMunicipality();
		validateTempDistrict();
		validateTempCountry();
		validateTempZipcode();
		validatePermanentHouseNumber();
		validatePermanentWardNumber();
		validatePermanentMunicipality();
		validatePermanentDistrict();
		validatePermanentCountry();
		validatePermanentZipcode();
		validateProfessionalStatus();
		validateDesignation();
		validateOffice();
		validateQualifications();
		validateTrainings();
		validateShineId();
		validateVaccinesBcg();
		validateVaccinesDpt();
		validateVaccinesOpv();
		validateVaccinesPcv();
		validateVaccinesMr();
		validateVaccinesJe();
		validateVaccinesTd();
		validateVaccinesOthers();
		validateVaccinesSpecify();
		validateTemperature();
		validateSystolic();
		validateDiastolic();
		validateHeightCm();
		validateWeightKg();
		validateBmi();
		validateBmiComputed();
		validateAcuteRespiratoryInfection();
		validateAcuteWateryDiarrhea();
		validateAcuteBloodyDiarrhea();
		validateAcuteJaundiceInfection();
		validateSuspectedMeningitis();
		validateSuspectedTetanus();
		validateAcuteFlaccidParalysis();
		validateAcuteHemorraphicFever();
		validateFever();
		validateTraumaMajorHead();
		validateTraumaMajorHeadSpecify();
		validateTraumaMajorSpinal();
		validateTraumaMajorSpinalSpecify();
		validateTraumaMajorTorso();
		validateTraumaMajorTorsoSpecify();
		validateTraumaLeftLeg();
		validateTraumaLeftLegSpecify();
		validateTraumaRightLeg();
		validateTraumaRightLegSpecify();
		validateTraumaLeftArm();
		validateTraumaLeftArmSpecify();
		validateTraumaRightArm();
		validateTraumaRightArmSpecify();
		validateSkinDiseases();
		validateSkinDiseasesSpecify();
		validateAllegies();
		validateAllegiesSpecify();
		validateRespiratoryDisease();
		validateRespiratoryDiseaseSpecify();
		validateCardiovascularDisease();
		validateCardiovascularDiseaseSpecify();
		validateEndocrineDisease();
		validateEndocrineDiseaseSpecify();
		validateUrinarySystemDisease();
		validateUrinarySystemDiseaseSpecify();
		validateReproductivSystemDisease();
		validateReproductivSystemDiseaseSpecify();
		validateCommunicationHearingProblem();
		validateCommunicationHearingProblemSpecify();
		validateVisionProblem();
		validateVisionProblemSpecify();
		validateOralDentalHealthProblem();
		validateOralDentalHealthProblemSpecify();
		validatePsychologicalProblem();
		validatePsychologicalProblemSpecify();
		validatePhysicalStructuralProblems();
		validatePhysicalStructuralProblemsSpecify();
		validateCognativePatterns();
		validateCognativePatternsSpecify();
		validateBowelHabit();
		validateBowelHabitSpecify();
		validateBladderHabit();
		validateBladderHabitSpecify();
		validateUnderMedication();
		validateUnderMedicationSpecify();
		validateRecentTreatment();
		validateRecentTreatmentSpecify();
		validateRecentProcedure();
		validateRecentProcedureSpecify();
		validateRecentCounseling();
		validateRecentCounselingSpecify();
		validateBhSuspension();
		validateBhAntiSocialBehavior();
		validateBhDelinquency();
		validateBhViolence();
		validateBhSmoking();
		validateBhAlcohol();
		validateBhSubstanceAbuse();
		validateBhSuicidalThoughts();
		validateBhSuicidalAttempts();
		validateBreakfastPlace();
		validateBreakfastTime();
		validateBreakfastTypeOfFood();
		validateLunchPlace();
		validateLunchTime();
		validateLunchTypeOfFood();
		validateSnackPlace();
		validateSnackTime();
		validateSnackTypeOfFood();
		validateDinnerPlace();
		validateDinnerTime();
		validateDinnerTypeOfFood();
		validateMalnutrition();
		validateMalnutritionSpecify();
		validateIdleHours();
		validateActiveHours();
		//  ageOfMenarche optional
		//  menstruationMaterials optional
		validateFamilyInteraction();
		validateFamilyInteractionSpecify();
		validateCommunityInvolvement();
		validateCommunityInvolvementSpecify();
		validateChildDrrKnowledge();
		validateChildComplaint();

    }


    public void validateFirstName()
    {
    
        validateNonNullField(model.getFirstName(), activity.getPage("Personal Information"), R.id.firstNameContainer, context.getResources().getString(R.string.basic_information_firstName));
    }

    public void validateLastName()
    {
    
        validateNonNullField(model.getLastName(), activity.getPage("Personal Information"), R.id.lastNameContainer, context.getResources().getString(R.string.basic_information_lastName));
    }

    public void validateSex()
    {
    
        validateNonNullField(model.getSex(), activity.getPage("Personal Information"), R.id.sexContainer, context.getResources().getString(R.string.basic_information_sex));
    }

    public void validateMaritalStatus()
    {
    
        validateNonNullField(model.getMaritalStatus(), activity.getPage("Personal Information"), R.id.maritalStatusContainer, context.getResources().getString(R.string.basic_information_maritalStatus));
    }

    public void validateDateOfBirthInAd()
    {
    
        validateNonNullField(model.getDateOfBirthInAd(), activity.getPage("Personal Information"), R.id.dateOfBirthInAdContainer, context.getResources().getString(R.string.basic_information_dateOfBirthInAd));
    }

    public void validateDateOfBirthInBs()
    {
    
        validateNonNullField(model.getDateOfBirthInBs(), activity.getPage("Personal Information"), R.id.dateOfBirthInBsContainer, context.getResources().getString(R.string.basic_information_dateOfBirthInBs));
    }

    public void validateAge()
    {
    
        validateNonNullField(model.getAge(), activity.getPage("Personal Information"), R.id.ageContainer, context.getResources().getString(R.string.basic_information_age));
    }

    public void validateFamilyID()
    {
    
        validateNonNullField(model.getFamilyID(), activity.getPage("Household Information"), R.id.familyIDContainer, context.getResources().getString(R.string.basic_information_familyID));
    }

    public void validateTypeOfFamily()
    {
    
        validateNonNullField(model.getTypeOfFamily(), activity.getPage("Household Information"), R.id.typeOfFamilyContainer, context.getResources().getString(R.string.basic_information_typeOfFamily));
    }

    public void validateHouseNumber()
    {
    
        validateNonNullField(model.getHouseNumber(), activity.getPage("Household Information"), R.id.houseNumberContainer, context.getResources().getString(R.string.basic_information_houseNumber));
    }

    public void validateWardNumber()
    {
    
        validateNonNullField(model.getWardNumber(), activity.getPage("Household Information"), R.id.wardNumberContainer, context.getResources().getString(R.string.basic_information_wardNumber));
    }

    public void validateMunicipality()
    {
    
        validateNonNullField(model.getMunicipality(), activity.getPage("Household Information"), R.id.municipalityContainer, context.getResources().getString(R.string.basic_information_municipality));
    }

    public void validateDistrict()
    {
    
        validateNonNullField(model.getDistrict(), activity.getPage("Household Information"), R.id.districtContainer, context.getResources().getString(R.string.basic_information_district));
    }

    public void validateCountry()
    {
    
        validateNonNullField(model.getCountry(), activity.getPage("Household Information"), R.id.countryContainer, context.getResources().getString(R.string.basic_information_country));
    }

    public void validateZipcode()
    {
    
        validateNonNullField(model.getZipcode(), activity.getPage("Household Information"), R.id.zipcodeContainer, context.getResources().getString(R.string.basic_information_zipcode));
    }

    public void validateFatherLate()
    {
    
        validateNonNullField(model.getFatherLate(), activity.getPage("Household Information"), R.id.fatherLateContainer, context.getResources().getString(R.string.basic_information_fatherLate));
    }

    public void validateMotherLate()
    {
    
        validateNonNullField(model.getMotherLate(), activity.getPage("Household Information"), R.id.motherLateContainer, context.getResources().getString(R.string.basic_information_motherLate));
    }

    public void validateNumberMale()
    {
    
        validateNonNullField(model.getNumberMale(), activity.getPage("Household Information"), R.id.numberMaleContainer, context.getResources().getString(R.string.basic_information_numberMale));
    }

    public void validateNumberFemale()
    {
    
        validateNonNullField(model.getNumberFemale(), activity.getPage("Household Information"), R.id.numberFemaleContainer, context.getResources().getString(R.string.basic_information_numberFemale));
    }

    public void validateNumberOthers()
    {
    
        validateNonNullField(model.getNumberOthers(), activity.getPage("Household Information"), R.id.numberOthersContainer, context.getResources().getString(R.string.basic_information_numberOthers));
    }

    public void validateNumberMaleUnder5()
    {
    
        validateNonNullField(model.getNumberMaleUnder5(), activity.getPage("Household Information"), R.id.numberMaleUnder5Container, context.getResources().getString(R.string.basic_information_numberMaleUnder5));
    }

    public void validateNumberFemaleUnder5()
    {
    
        validateNonNullField(model.getNumberFemaleUnder5(), activity.getPage("Household Information"), R.id.numberFemaleUnder5Container, context.getResources().getString(R.string.basic_information_numberFemaleUnder5));
    }

    public void validateNumberMaleAbove60()
    {
    
        validateNonNullField(model.getNumberMaleAbove60(), activity.getPage("Household Information"), R.id.numberMaleAbove60Container, context.getResources().getString(R.string.basic_information_numberMaleAbove60));
    }

    public void validateNumberFemaleAbove60()
    {
    
        validateNonNullField(model.getNumberFemaleAbove60(), activity.getPage("Household Information"), R.id.numberFemaleAbove60Container, context.getResources().getString(R.string.basic_information_numberFemaleAbove60));
    }

    public void validateNumberDisabled()
    {
    
        validateNonNullField(model.getNumberDisabled(), activity.getPage("Household Information"), R.id.numberDisabledContainer, context.getResources().getString(R.string.basic_information_numberDisabled));
    }

    public void validateNumberPregnant()
    {
    
        validateNonNullField(model.getNumberPregnant(), activity.getPage("Household Information"), R.id.numberPregnantContainer, context.getResources().getString(R.string.basic_information_numberPregnant));
    }

    public void validateNumberLactatingMothers()
    {
    
        validateNonNullField(model.getNumberLactatingMothers(), activity.getPage("Household Information"), R.id.numberLactatingMothersContainer, context.getResources().getString(R.string.basic_information_numberLactatingMothers));
    }

    public void validateEthnicity()
    {
    
        validateNonNullField(model.getEthnicity(), activity.getPage("Socio-Economic Information"), R.id.ethnicityContainer, context.getResources().getString(R.string.basic_information_ethnicity));
    }

    public void validateReligion()
    {
    
        validateNonNullField(model.getReligion(), activity.getPage("Socio-Economic Information"), R.id.religionContainer, context.getResources().getString(R.string.basic_information_religion));
    }

    public void validateEducationalStatus()
    {
    
        validateNonNullField(model.getEducationalStatus(), activity.getPage("Socio-Economic Information"), R.id.educationalStatusContainer, context.getResources().getString(R.string.basic_information_educationalStatus));
    }

    public void validateOccupation()
    {
    
        validateNonNullField(model.getOccupation(), activity.getPage("Socio-Economic Information"), R.id.occupationContainer, context.getResources().getString(R.string.basic_information_occupation));
    }

    public void validateOccupationSpecify()
    {
  
        validateNonNullSpecifyField(model.getOccupation(),5,model.getOccupationSpecify(), activity.getPage("Socio-Economic Information"), R.id.occupationSpecifyContainer, context.getResources().getString(R.string.basic_information_occupationSpecify));   
    }

    public void validateIncomeAgriculture()
    {
    
        validateNonNullField(model.getIncomeAgriculture(), activity.getPage("Socio-Economic Information"), R.id.incomeAgricultureContainer, context.getResources().getString(R.string.basic_information_incomeAgriculture));
    }

    public void validateIncomeBusiness()
    {
    
        validateNonNullField(model.getIncomeBusiness(), activity.getPage("Socio-Economic Information"), R.id.incomeBusinessContainer, context.getResources().getString(R.string.basic_information_incomeBusiness));
    }

    public void validateIncomeService()
    {
    
        validateNonNullField(model.getIncomeService(), activity.getPage("Socio-Economic Information"), R.id.incomeServiceContainer, context.getResources().getString(R.string.basic_information_incomeService));
    }

    public void validateIncomeLabor()
    {
    
        validateNonNullField(model.getIncomeLabor(), activity.getPage("Socio-Economic Information"), R.id.incomeLaborContainer, context.getResources().getString(R.string.basic_information_incomeLabor));
    }

    public void validateIncomeRemittance()
    {
    
        validateNonNullField(model.getIncomeRemittance(), activity.getPage("Socio-Economic Information"), R.id.incomeRemittanceContainer, context.getResources().getString(R.string.basic_information_incomeRemittance));
    }

    public void validateIncomeOthers()
    {
    
        validateNonNullField(model.getIncomeOthers(), activity.getPage("Socio-Economic Information"), R.id.incomeOthersContainer, context.getResources().getString(R.string.basic_information_incomeOthers));
    }

    public void validateIncomeSpecify()
    {
  
        validateNonNullSpecifyField(model.getIncomeOthers(),1,model.getIncomeSpecify(), activity.getPage("Socio-Economic Information"), R.id.incomeSpecifyContainer, context.getResources().getString(R.string.basic_information_incomeSpecify));   
    }

    public void validateFoodSufficiency()
    {
    
        validateNonNullField(model.getFoodSufficiency(), activity.getPage("Socio-Economic Information"), R.id.foodSufficiencyContainer, context.getResources().getString(R.string.basic_information_foodSufficiency));
    }

    public void validateShineId()
    {
    
        validateNonNullField(model.getShineId(), activity.getPage("Socio-Economic Information"), R.id.shineIdContainer, context.getResources().getString(R.string.nurse_registration_shineId));
    }

    public void validateNanNumber()
    {
    
        validateNonNullField(model.getNanNumber(), activity.getPage("Registration"), R.id.nanNumberContainer, context.getResources().getString(R.string.nurse_registration_nanNumber));
    }

    public void validateFirstName()
    {
    
        validateNonNullField(model.getFirstName(), activity.getPage("Registration"), R.id.firstNameContainer, context.getResources().getString(R.string.nurse_registration_firstName));
    }

    public void validateLastName()
    {
    
        validateNonNullField(model.getLastName(), activity.getPage("Registration"), R.id.lastNameContainer, context.getResources().getString(R.string.nurse_registration_lastName));
    }

    public void validateSex()
    {
    
        validateNonNullField(model.getSex(), activity.getPage("Registration"), R.id.sexContainer, context.getResources().getString(R.string.nurse_registration_sex));
    }

    public void validateCitizenshipNumber()
    {
    
        validateNonNullField(model.getCitizenshipNumber(), activity.getPage("Registration"), R.id.citizenshipNumberContainer, context.getResources().getString(R.string.nurse_registration_citizenshipNumber));
    }

    public void validateDateOfBirthInAd()
    {
    
        validateNonNullField(model.getDateOfBirthInAd(), activity.getPage("Registration"), R.id.dateOfBirthInAdContainer, context.getResources().getString(R.string.nurse_registration_dateOfBirthInAd));
    }

    public void validateDateOfBirthInBs()
    {
    
        validateNonNullField(model.getDateOfBirthInBs(), activity.getPage("Registration"), R.id.dateOfBirthInBsContainer, context.getResources().getString(R.string.nurse_registration_dateOfBirthInBs));
    }

    public void validateAge()
    {
    
        validateNonNullField(model.getAge(), activity.getPage("Registration"), R.id.ageContainer, context.getResources().getString(R.string.nurse_registration_age));
    }

    public void validateTempHouseNumber()
    {
    
        validateNonNullField(model.getTempHouseNumber(), activity.getPage("Temporary Address"), R.id.tempHouseNumberContainer, context.getResources().getString(R.string.nurse_registration_tempHouseNumber));
    }

    public void validateTempWardNumber()
    {
    
        validateNonNullField(model.getTempWardNumber(), activity.getPage("Temporary Address"), R.id.tempWardNumberContainer, context.getResources().getString(R.string.nurse_registration_tempWardNumber));
    }

    public void validateTempMunicipality()
    {
    
        validateNonNullField(model.getTempMunicipality(), activity.getPage("Temporary Address"), R.id.tempMunicipalityContainer, context.getResources().getString(R.string.nurse_registration_tempMunicipality));
    }

    public void validateTempDistrict()
    {
    
        validateNonNullField(model.getTempDistrict(), activity.getPage("Temporary Address"), R.id.tempDistrictContainer, context.getResources().getString(R.string.nurse_registration_tempDistrict));
    }

    public void validateTempCountry()
    {
    
        validateNonNullField(model.getTempCountry(), activity.getPage("Temporary Address"), R.id.tempCountryContainer, context.getResources().getString(R.string.nurse_registration_tempCountry));
    }

    public void validateTempZipcode()
    {
    
        validateNonNullField(model.getTempZipcode(), activity.getPage("Temporary Address"), R.id.tempZipcodeContainer, context.getResources().getString(R.string.nurse_registration_tempZipcode));
    }

    public void validatePermanentHouseNumber()
    {
    
        validateNonNullField(model.getPermanentHouseNumber(), activity.getPage("Permanent Address"), R.id.permanentHouseNumberContainer, context.getResources().getString(R.string.nurse_registration_permanentHouseNumber));
    }

    public void validatePermanentWardNumber()
    {
    
        validateNonNullField(model.getPermanentWardNumber(), activity.getPage("Permanent Address"), R.id.permanentWardNumberContainer, context.getResources().getString(R.string.nurse_registration_permanentWardNumber));
    }

    public void validatePermanentMunicipality()
    {
    
        validateNonNullField(model.getPermanentMunicipality(), activity.getPage("Permanent Address"), R.id.permanentMunicipalityContainer, context.getResources().getString(R.string.nurse_registration_permanentMunicipality));
    }

    public void validatePermanentDistrict()
    {
    
        validateNonNullField(model.getPermanentDistrict(), activity.getPage("Permanent Address"), R.id.permanentDistrictContainer, context.getResources().getString(R.string.nurse_registration_permanentDistrict));
    }

    public void validatePermanentCountry()
    {
    
        validateNonNullField(model.getPermanentCountry(), activity.getPage("Permanent Address"), R.id.permanentCountryContainer, context.getResources().getString(R.string.nurse_registration_permanentCountry));
    }

    public void validatePermanentZipcode()
    {
    
        validateNonNullField(model.getPermanentZipcode(), activity.getPage("Permanent Address"), R.id.permanentZipcodeContainer, context.getResources().getString(R.string.nurse_registration_permanentZipcode));
    }

    public void validateProfessionalStatus()
    {
    
        validateNonNullField(model.getProfessionalStatus(), activity.getPage("Professional Information"), R.id.professionalStatusContainer, context.getResources().getString(R.string.nurse_registration_professionalStatus));
    }

    public void validateDesignation()
    {
    
        validateNonNullField(model.getDesignation(), activity.getPage("Professional Information"), R.id.designationContainer, context.getResources().getString(R.string.nurse_registration_designation));
    }

    public void validateOffice()
    {
    
        validateNonNullField(model.getOffice(), activity.getPage("Professional Information"), R.id.officeContainer, context.getResources().getString(R.string.nurse_registration_office));
    }

    public void validateQualifications()
    {
    
        validateNonNullField(model.getQualifications(), activity.getPage("Professional Information"), R.id.qualificationsContainer, context.getResources().getString(R.string.nurse_registration_qualifications));
    }

    public void validateTrainings()
    {
    
        validateNonNullField(model.getTrainings(), activity.getPage("Professional Information"), R.id.trainingsContainer, context.getResources().getString(R.string.nurse_registration_trainings));
    }

    public void validateShineId()
    {
    
        validateNonNullField(model.getShineId(), activity.getPage("Professional Information"), R.id.shineIdContainer, context.getResources().getString(R.string.student_health_assessment_shineId));
    }

    public void validateVaccinesBcg()
    {
    
        validateNonNullField(model.getVaccinesBcg(), activity.getPage("Page 1"), R.id.vaccinesBcgContainer, context.getResources().getString(R.string.student_health_assessment_vaccinesBcg));
    }

    public void validateVaccinesDpt()
    {
    
        validateNonNullField(model.getVaccinesDpt(), activity.getPage("Page 1"), R.id.vaccinesDptContainer, context.getResources().getString(R.string.student_health_assessment_vaccinesDpt));
    }

    public void validateVaccinesOpv()
    {
    
        validateNonNullField(model.getVaccinesOpv(), activity.getPage("Page 1"), R.id.vaccinesOpvContainer, context.getResources().getString(R.string.student_health_assessment_vaccinesOpv));
    }

    public void validateVaccinesPcv()
    {
    
        validateNonNullField(model.getVaccinesPcv(), activity.getPage("Page 1"), R.id.vaccinesPcvContainer, context.getResources().getString(R.string.student_health_assessment_vaccinesPcv));
    }

    public void validateVaccinesMr()
    {
    
        validateNonNullField(model.getVaccinesMr(), activity.getPage("Page 1"), R.id.vaccinesMrContainer, context.getResources().getString(R.string.student_health_assessment_vaccinesMr));
    }

    public void validateVaccinesJe()
    {
    
        validateNonNullField(model.getVaccinesJe(), activity.getPage("Page 1"), R.id.vaccinesJeContainer, context.getResources().getString(R.string.student_health_assessment_vaccinesJe));
    }

    public void validateVaccinesTd()
    {
    
        validateNonNullField(model.getVaccinesTd(), activity.getPage("Page 1"), R.id.vaccinesTdContainer, context.getResources().getString(R.string.student_health_assessment_vaccinesTd));
    }

    public void validateVaccinesOthers()
    {
    
        validateNonNullField(model.getVaccinesOthers(), activity.getPage("Page 1"), R.id.vaccinesOthersContainer, context.getResources().getString(R.string.student_health_assessment_vaccinesOthers));
    }

    public void validateVaccinesSpecify()
    {
  
        validateNonNullSpecifyField(model.getVaccinesOthers(),1,model.getVaccinesSpecify(), activity.getPage("Page 1"), R.id.vaccinesSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_vaccinesSpecify));   
    }

    public void validateTemperature()
    {
    
        validateNonNullField(model.getTemperature(), activity.getPage("Page 1"), R.id.temperatureContainer, context.getResources().getString(R.string.student_health_assessment_temperature));
    }

    public void validateSystolic()
    {
    
        validateNonNullField(model.getSystolic(), activity.getPage("Page 1"), R.id.systolicContainer, context.getResources().getString(R.string.student_health_assessment_systolic));
    }

    public void validateDiastolic()
    {
    
        validateNonNullField(model.getDiastolic(), activity.getPage("Page 1"), R.id.diastolicContainer, context.getResources().getString(R.string.student_health_assessment_diastolic));
    }

    public void validateHeightCm()
    {
    
        validateNonNullField(model.getHeightCm(), activity.getPage("Page 1"), R.id.heightCmContainer, context.getResources().getString(R.string.student_health_assessment_heightCm));
    }

    public void validateWeightKg()
    {
    
        validateNonNullField(model.getWeightKg(), activity.getPage("Page 1"), R.id.weightKgContainer, context.getResources().getString(R.string.student_health_assessment_weightKg));
    }

    public void validateBmi()
    {
    
        validateNonNullField(model.getBmi(), activity.getPage("Page 1"), R.id.bmiContainer, context.getResources().getString(R.string.student_health_assessment_bmi));
    }

    public void validateBmiComputed()
    {
    
        validateNonNullField(model.getBmiComputed(), activity.getPage("Page 1"), R.id.bmiComputedContainer, context.getResources().getString(R.string.student_health_assessment_bmiComputed));
    }

    public void validateAcuteRespiratoryInfection()
    {
    
        validateNonNullField(model.getAcuteRespiratoryInfection(), activity.getPage("Page 1"), R.id.acuteRespiratoryInfectionContainer, context.getResources().getString(R.string.student_health_assessment_acuteRespiratoryInfection));
    }

    public void validateAcuteWateryDiarrhea()
    {
    
        validateNonNullField(model.getAcuteWateryDiarrhea(), activity.getPage("Page 1"), R.id.acuteWateryDiarrheaContainer, context.getResources().getString(R.string.student_health_assessment_acuteWateryDiarrhea));
    }

    public void validateAcuteBloodyDiarrhea()
    {
    
        validateNonNullField(model.getAcuteBloodyDiarrhea(), activity.getPage("Page 1"), R.id.acuteBloodyDiarrheaContainer, context.getResources().getString(R.string.student_health_assessment_acuteBloodyDiarrhea));
    }

    public void validateAcuteJaundiceInfection()
    {
    
        validateNonNullField(model.getAcuteJaundiceInfection(), activity.getPage("Page 1"), R.id.acuteJaundiceInfectionContainer, context.getResources().getString(R.string.student_health_assessment_acuteJaundiceInfection));
    }

    public void validateSuspectedMeningitis()
    {
    
        validateNonNullField(model.getSuspectedMeningitis(), activity.getPage("Page 1"), R.id.suspectedMeningitisContainer, context.getResources().getString(R.string.student_health_assessment_suspectedMeningitis));
    }

    public void validateSuspectedTetanus()
    {
    
        validateNonNullField(model.getSuspectedTetanus(), activity.getPage("Page 1"), R.id.suspectedTetanusContainer, context.getResources().getString(R.string.student_health_assessment_suspectedTetanus));
    }

    public void validateAcuteFlaccidParalysis()
    {
    
        validateNonNullField(model.getAcuteFlaccidParalysis(), activity.getPage("Page 1"), R.id.acuteFlaccidParalysisContainer, context.getResources().getString(R.string.student_health_assessment_acuteFlaccidParalysis));
    }

    public void validateAcuteHemorraphicFever()
    {
    
        validateNonNullField(model.getAcuteHemorraphicFever(), activity.getPage("Page 1"), R.id.acuteHemorraphicFeverContainer, context.getResources().getString(R.string.student_health_assessment_acuteHemorraphicFever));
    }

    public void validateFever()
    {
    
        validateNonNullField(model.getFever(), activity.getPage("Page 1"), R.id.feverContainer, context.getResources().getString(R.string.student_health_assessment_fever));
    }

    public void validateTraumaMajorHead()
    {
    
        validateNonNullField(model.getTraumaMajorHead(), activity.getPage("Page 2"), R.id.traumaMajorHeadContainer, context.getResources().getString(R.string.student_health_assessment_traumaMajorHead));
    }

    public void validateTraumaMajorHeadSpecify()
    {
  
        validateNonNullSpecifyField(model.getTraumaMajorHead(),1,model.getTraumaMajorHeadSpecify(), activity.getPage("Page 2"), R.id.traumaMajorHeadSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_traumaMajorHeadSpecify));   
    }

    public void validateTraumaMajorSpinal()
    {
    
        validateNonNullField(model.getTraumaMajorSpinal(), activity.getPage("Page 2"), R.id.traumaMajorSpinalContainer, context.getResources().getString(R.string.student_health_assessment_traumaMajorSpinal));
    }

    public void validateTraumaMajorSpinalSpecify()
    {
  
        validateNonNullSpecifyField(model.getTraumaMajorSpinal(),1,model.getTraumaMajorSpinalSpecify(), activity.getPage("Page 2"), R.id.traumaMajorSpinalSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_traumaMajorSpinalSpecify));   
    }

    public void validateTraumaMajorTorso()
    {
    
        validateNonNullField(model.getTraumaMajorTorso(), activity.getPage("Page 2"), R.id.traumaMajorTorsoContainer, context.getResources().getString(R.string.student_health_assessment_traumaMajorTorso));
    }

    public void validateTraumaMajorTorsoSpecify()
    {
  
        validateNonNullSpecifyField(model.getTraumaMajorTorso(),1,model.getTraumaMajorTorsoSpecify(), activity.getPage("Page 2"), R.id.traumaMajorTorsoSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_traumaMajorTorsoSpecify));   
    }

    public void validateTraumaLeftLeg()
    {
    
        validateNonNullField(model.getTraumaLeftLeg(), activity.getPage("Page 2"), R.id.traumaLeftLegContainer, context.getResources().getString(R.string.student_health_assessment_traumaLeftLeg));
    }

    public void validateTraumaLeftLegSpecify()
    {
  
        validateNonNullSpecifyField(model.getTraumaLeftLeg(),1,model.getTraumaLeftLegSpecify(), activity.getPage("Page 2"), R.id.traumaLeftLegSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_traumaLeftLegSpecify));   
    }

    public void validateTraumaRightLeg()
    {
    
        validateNonNullField(model.getTraumaRightLeg(), activity.getPage("Page 2"), R.id.traumaRightLegContainer, context.getResources().getString(R.string.student_health_assessment_traumaRightLeg));
    }

    public void validateTraumaRightLegSpecify()
    {
  
        validateNonNullSpecifyField(model.getTraumaRightLeg(),1,model.getTraumaRightLegSpecify(), activity.getPage("Page 2"), R.id.traumaRightLegSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_traumaRightLegSpecify));   
    }

    public void validateTraumaLeftArm()
    {
    
        validateNonNullField(model.getTraumaLeftArm(), activity.getPage("Page 2"), R.id.traumaLeftArmContainer, context.getResources().getString(R.string.student_health_assessment_traumaLeftArm));
    }

    public void validateTraumaLeftArmSpecify()
    {
  
        validateNonNullSpecifyField(model.getTraumaLeftArm(),1,model.getTraumaLeftArmSpecify(), activity.getPage("Page 2"), R.id.traumaLeftArmSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_traumaLeftArmSpecify));   
    }

    public void validateTraumaRightArm()
    {
    
        validateNonNullField(model.getTraumaRightArm(), activity.getPage("Page 2"), R.id.traumaRightArmContainer, context.getResources().getString(R.string.student_health_assessment_traumaRightArm));
    }

    public void validateTraumaRightArmSpecify()
    {
  
        validateNonNullSpecifyField(model.getTraumaRightArm(),1,model.getTraumaRightArmSpecify(), activity.getPage("Page 2"), R.id.traumaRightArmSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_traumaRightArmSpecify));   
    }

    public void validateSkinDiseases()
    {
    
        validateNonNullField(model.getSkinDiseases(), activity.getPage("Page 2"), R.id.skinDiseasesContainer, context.getResources().getString(R.string.student_health_assessment_skinDiseases));
    }

    public void validateSkinDiseasesSpecify()
    {
  
        validateNonNullSpecifyField(model.getSkinDiseases(),1,model.getSkinDiseasesSpecify(), activity.getPage("Page 2"), R.id.skinDiseasesSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_skinDiseasesSpecify));   
    }

    public void validateAllegies()
    {
    
        validateNonNullField(model.getAllegies(), activity.getPage("Page 2"), R.id.allegiesContainer, context.getResources().getString(R.string.student_health_assessment_allegies));
    }

    public void validateAllegiesSpecify()
    {
  
        validateNonNullSpecifyField(model.getAllegies(),1,model.getAllegiesSpecify(), activity.getPage("Page 2"), R.id.allegiesSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_allegiesSpecify));   
    }

    public void validateRespiratoryDisease()
    {
    
        validateNonNullField(model.getRespiratoryDisease(), activity.getPage("Page 2"), R.id.respiratoryDiseaseContainer, context.getResources().getString(R.string.student_health_assessment_respiratoryDisease));
    }

    public void validateRespiratoryDiseaseSpecify()
    {
  
        validateNonNullSpecifyField(model.getRespiratoryDisease(),1,model.getRespiratoryDiseaseSpecify(), activity.getPage("Page 2"), R.id.respiratoryDiseaseSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_respiratoryDiseaseSpecify));   
    }

    public void validateCardiovascularDisease()
    {
    
        validateNonNullField(model.getCardiovascularDisease(), activity.getPage("Page 2"), R.id.cardiovascularDiseaseContainer, context.getResources().getString(R.string.student_health_assessment_cardiovascularDisease));
    }

    public void validateCardiovascularDiseaseSpecify()
    {
  
        validateNonNullSpecifyField(model.getCardiovascularDisease(),1,model.getCardiovascularDiseaseSpecify(), activity.getPage("Page 2"), R.id.cardiovascularDiseaseSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_cardiovascularDiseaseSpecify));   
    }

    public void validateEndocrineDisease()
    {
    
        validateNonNullField(model.getEndocrineDisease(), activity.getPage("Page 2"), R.id.endocrineDiseaseContainer, context.getResources().getString(R.string.student_health_assessment_endocrineDisease));
    }

    public void validateEndocrineDiseaseSpecify()
    {
  
        validateNonNullSpecifyField(model.getEndocrineDisease(),1,model.getEndocrineDiseaseSpecify(), activity.getPage("Page 2"), R.id.endocrineDiseaseSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_endocrineDiseaseSpecify));   
    }

    public void validateUrinarySystemDisease()
    {
    
        validateNonNullField(model.getUrinarySystemDisease(), activity.getPage("Page 2"), R.id.urinarySystemDiseaseContainer, context.getResources().getString(R.string.student_health_assessment_urinarySystemDisease));
    }

    public void validateUrinarySystemDiseaseSpecify()
    {
  
        validateNonNullSpecifyField(model.getUrinarySystemDisease(),1,model.getUrinarySystemDiseaseSpecify(), activity.getPage("Page 2"), R.id.urinarySystemDiseaseSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_urinarySystemDiseaseSpecify));   
    }

    public void validateReproductivSystemDisease()
    {
    
        validateNonNullField(model.getReproductivSystemDisease(), activity.getPage("Page 2"), R.id.reproductivSystemDiseaseContainer, context.getResources().getString(R.string.student_health_assessment_reproductivSystemDisease));
    }

    public void validateReproductivSystemDiseaseSpecify()
    {
  
        validateNonNullSpecifyField(model.getReproductivSystemDisease(),1,model.getReproductivSystemDiseaseSpecify(), activity.getPage("Page 2"), R.id.reproductivSystemDiseaseSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_reproductivSystemDiseaseSpecify));   
    }

    public void validateCommunicationHearingProblem()
    {
    
        validateNonNullField(model.getCommunicationHearingProblem(), activity.getPage("Page 2"), R.id.communicationHearingProblemContainer, context.getResources().getString(R.string.student_health_assessment_communicationHearingProblem));
    }

    public void validateCommunicationHearingProblemSpecify()
    {
  
        validateNonNullSpecifyField(model.getCommunicationHearingProblem(),1,model.getCommunicationHearingProblemSpecify(), activity.getPage("Page 2"), R.id.communicationHearingProblemSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_communicationHearingProblemSpecify));   
    }

    public void validateVisionProblem()
    {
    
        validateNonNullField(model.getVisionProblem(), activity.getPage("Page 2"), R.id.visionProblemContainer, context.getResources().getString(R.string.student_health_assessment_visionProblem));
    }

    public void validateVisionProblemSpecify()
    {
  
        validateNonNullSpecifyField(model.getVisionProblem(),1,model.getVisionProblemSpecify(), activity.getPage("Page 2"), R.id.visionProblemSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_visionProblemSpecify));   
    }

    public void validateOralDentalHealthProblem()
    {
    
        validateNonNullField(model.getOralDentalHealthProblem(), activity.getPage("Page 2"), R.id.oralDentalHealthProblemContainer, context.getResources().getString(R.string.student_health_assessment_oralDentalHealthProblem));
    }

    public void validateOralDentalHealthProblemSpecify()
    {
  
        validateNonNullSpecifyField(model.getOralDentalHealthProblem(),1,model.getOralDentalHealthProblemSpecify(), activity.getPage("Page 2"), R.id.oralDentalHealthProblemSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_oralDentalHealthProblemSpecify));   
    }

    public void validatePsychologicalProblem()
    {
    
        validateNonNullField(model.getPsychologicalProblem(), activity.getPage("Page 2"), R.id.psychologicalProblemContainer, context.getResources().getString(R.string.student_health_assessment_psychologicalProblem));
    }

    public void validatePsychologicalProblemSpecify()
    {
  
        validateNonNullSpecifyField(model.getPsychologicalProblem(),1,model.getPsychologicalProblemSpecify(), activity.getPage("Page 2"), R.id.psychologicalProblemSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_psychologicalProblemSpecify));   
    }

    public void validatePhysicalStructuralProblems()
    {
    
        validateNonNullField(model.getPhysicalStructuralProblems(), activity.getPage("Page 2"), R.id.physicalStructuralProblemsContainer, context.getResources().getString(R.string.student_health_assessment_physicalStructuralProblems));
    }

    public void validatePhysicalStructuralProblemsSpecify()
    {
  
        validateNonNullSpecifyField(model.getPhysicalStructuralProblems(),1,model.getPhysicalStructuralProblemsSpecify(), activity.getPage("Page 2"), R.id.physicalStructuralProblemsSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_physicalStructuralProblemsSpecify));   
    }

    public void validateCognativePatterns()
    {
    
        validateNonNullField(model.getCognativePatterns(), activity.getPage("Page 2"), R.id.cognativePatternsContainer, context.getResources().getString(R.string.student_health_assessment_cognativePatterns));
    }

    public void validateCognativePatternsSpecify()
    {
  
        validateNonNullSpecifyField(model.getCognativePatterns(),1,model.getCognativePatternsSpecify(), activity.getPage("Page 2"), R.id.cognativePatternsSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_cognativePatternsSpecify));   
    }

    public void validateBowelHabit()
    {
    
        validateNonNullField(model.getBowelHabit(), activity.getPage("Page 2"), R.id.bowelHabitContainer, context.getResources().getString(R.string.student_health_assessment_bowelHabit));
    }

    public void validateBowelHabitSpecify()
    {
  
        validateNonNullSpecifyField(model.getBowelHabit(),1,model.getBowelHabitSpecify(), activity.getPage("Page 2"), R.id.bowelHabitSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_bowelHabitSpecify));   
    }

    public void validateBladderHabit()
    {
    
        validateNonNullField(model.getBladderHabit(), activity.getPage("Page 2"), R.id.bladderHabitContainer, context.getResources().getString(R.string.student_health_assessment_bladderHabit));
    }

    public void validateBladderHabitSpecify()
    {
  
        validateNonNullSpecifyField(model.getBladderHabit(),1,model.getBladderHabitSpecify(), activity.getPage("Page 2"), R.id.bladderHabitSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_bladderHabitSpecify));   
    }

    public void validateUnderMedication()
    {
    
        validateNonNullField(model.getUnderMedication(), activity.getPage("Page 2"), R.id.underMedicationContainer, context.getResources().getString(R.string.student_health_assessment_underMedication));
    }

    public void validateUnderMedicationSpecify()
    {
  
        validateNonNullSpecifyField(model.getUnderMedication(),1,model.getUnderMedicationSpecify(), activity.getPage("Page 2"), R.id.underMedicationSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_underMedicationSpecify));   
    }

    public void validateRecentTreatment()
    {
    
        validateNonNullField(model.getRecentTreatment(), activity.getPage("Page 2"), R.id.recentTreatmentContainer, context.getResources().getString(R.string.student_health_assessment_recentTreatment));
    }

    public void validateRecentTreatmentSpecify()
    {
  
        validateNonNullSpecifyField(model.getRecentTreatment(),1,model.getRecentTreatmentSpecify(), activity.getPage("Page 2"), R.id.recentTreatmentSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_recentTreatmentSpecify));   
    }

    public void validateRecentProcedure()
    {
    
        validateNonNullField(model.getRecentProcedure(), activity.getPage("Page 2"), R.id.recentProcedureContainer, context.getResources().getString(R.string.student_health_assessment_recentProcedure));
    }

    public void validateRecentProcedureSpecify()
    {
  
        validateNonNullSpecifyField(model.getRecentProcedure(),1,model.getRecentProcedureSpecify(), activity.getPage("Page 2"), R.id.recentProcedureSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_recentProcedureSpecify));   
    }

    public void validateRecentCounseling()
    {
    
        validateNonNullField(model.getRecentCounseling(), activity.getPage("Page 2"), R.id.recentCounselingContainer, context.getResources().getString(R.string.student_health_assessment_recentCounseling));
    }

    public void validateRecentCounselingSpecify()
    {
  
        validateNonNullSpecifyField(model.getRecentCounseling(),1,model.getRecentCounselingSpecify(), activity.getPage("Page 2"), R.id.recentCounselingSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_recentCounselingSpecify));   
    }

    public void validateBhSuspension()
    {
    
        validateNonNullField(model.getBhSuspension(), activity.getPage("Page 3"), R.id.bhSuspensionContainer, context.getResources().getString(R.string.student_health_assessment_bhSuspension));
    }

    public void validateBhAntiSocialBehavior()
    {
    
        validateNonNullField(model.getBhAntiSocialBehavior(), activity.getPage("Page 3"), R.id.bhAntiSocialBehaviorContainer, context.getResources().getString(R.string.student_health_assessment_bhAntiSocialBehavior));
    }

    public void validateBhDelinquency()
    {
    
        validateNonNullField(model.getBhDelinquency(), activity.getPage("Page 3"), R.id.bhDelinquencyContainer, context.getResources().getString(R.string.student_health_assessment_bhDelinquency));
    }

    public void validateBhViolence()
    {
    
        validateNonNullField(model.getBhViolence(), activity.getPage("Page 3"), R.id.bhViolenceContainer, context.getResources().getString(R.string.student_health_assessment_bhViolence));
    }

    public void validateBhSmoking()
    {
    
        validateNonNullField(model.getBhSmoking(), activity.getPage("Page 3"), R.id.bhSmokingContainer, context.getResources().getString(R.string.student_health_assessment_bhSmoking));
    }

    public void validateBhAlcohol()
    {
    
        validateNonNullField(model.getBhAlcohol(), activity.getPage("Page 3"), R.id.bhAlcoholContainer, context.getResources().getString(R.string.student_health_assessment_bhAlcohol));
    }

    public void validateBhSubstanceAbuse()
    {
    
        validateNonNullField(model.getBhSubstanceAbuse(), activity.getPage("Page 3"), R.id.bhSubstanceAbuseContainer, context.getResources().getString(R.string.student_health_assessment_bhSubstanceAbuse));
    }

    public void validateBhSuicidalThoughts()
    {
    
        validateNonNullField(model.getBhSuicidalThoughts(), activity.getPage("Page 3"), R.id.bhSuicidalThoughtsContainer, context.getResources().getString(R.string.student_health_assessment_bhSuicidalThoughts));
    }

    public void validateBhSuicidalAttempts()
    {
    
        validateNonNullField(model.getBhSuicidalAttempts(), activity.getPage("Page 3"), R.id.bhSuicidalAttemptsContainer, context.getResources().getString(R.string.student_health_assessment_bhSuicidalAttempts));
    }

    public void validateBreakfastPlace()
    {
    
        validateNonNullField(model.getBreakfastPlace(), activity.getPage("Page 3"), R.id.breakfastPlaceContainer, context.getResources().getString(R.string.student_health_assessment_breakfastPlace));
    }

    public void validateBreakfastTime()
    {
    
        validateNonNullField(model.getBreakfastTime(), activity.getPage("Page 3"), R.id.breakfastTimeContainer, context.getResources().getString(R.string.student_health_assessment_breakfastTime));
    }

    public void validateBreakfastTypeOfFood()
    {
    
        validateNonNullField(model.getBreakfastTypeOfFood(), activity.getPage("Page 3"), R.id.breakfastTypeOfFoodContainer, context.getResources().getString(R.string.student_health_assessment_breakfastTypeOfFood));
    }

    public void validateLunchPlace()
    {
    
        validateNonNullField(model.getLunchPlace(), activity.getPage("Page 3"), R.id.lunchPlaceContainer, context.getResources().getString(R.string.student_health_assessment_lunchPlace));
    }

    public void validateLunchTime()
    {
    
        validateNonNullField(model.getLunchTime(), activity.getPage("Page 3"), R.id.lunchTimeContainer, context.getResources().getString(R.string.student_health_assessment_lunchTime));
    }

    public void validateLunchTypeOfFood()
    {
    
        validateNonNullField(model.getLunchTypeOfFood(), activity.getPage("Page 3"), R.id.lunchTypeOfFoodContainer, context.getResources().getString(R.string.student_health_assessment_lunchTypeOfFood));
    }

    public void validateSnackPlace()
    {
    
        validateNonNullField(model.getSnackPlace(), activity.getPage("Page 3"), R.id.snackPlaceContainer, context.getResources().getString(R.string.student_health_assessment_snackPlace));
    }

    public void validateSnackTime()
    {
    
        validateNonNullField(model.getSnackTime(), activity.getPage("Page 3"), R.id.snackTimeContainer, context.getResources().getString(R.string.student_health_assessment_snackTime));
    }

    public void validateSnackTypeOfFood()
    {
    
        validateNonNullField(model.getSnackTypeOfFood(), activity.getPage("Page 3"), R.id.snackTypeOfFoodContainer, context.getResources().getString(R.string.student_health_assessment_snackTypeOfFood));
    }

    public void validateDinnerPlace()
    {
    
        validateNonNullField(model.getDinnerPlace(), activity.getPage("Page 3"), R.id.dinnerPlaceContainer, context.getResources().getString(R.string.student_health_assessment_dinnerPlace));
    }

    public void validateDinnerTime()
    {
    
        validateNonNullField(model.getDinnerTime(), activity.getPage("Page 3"), R.id.dinnerTimeContainer, context.getResources().getString(R.string.student_health_assessment_dinnerTime));
    }

    public void validateDinnerTypeOfFood()
    {
    
        validateNonNullField(model.getDinnerTypeOfFood(), activity.getPage("Page 3"), R.id.dinnerTypeOfFoodContainer, context.getResources().getString(R.string.student_health_assessment_dinnerTypeOfFood));
    }

    public void validateMalnutrition()
    {
    
        validateNonNullField(model.getMalnutrition(), activity.getPage("Page 3"), R.id.malnutritionContainer, context.getResources().getString(R.string.student_health_assessment_malnutrition));
    }

    public void validateMalnutritionSpecify()
    {
  
        validateNonNullSpecifyField(model.getMalnutrition(),1,model.getMalnutritionSpecify(), activity.getPage("Page 3"), R.id.malnutritionSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_malnutritionSpecify));   
    }

    public void validateIdleHours()
    {
    
        validateNonNullField(model.getIdleHours(), activity.getPage("Page 3"), R.id.idleHoursContainer, context.getResources().getString(R.string.student_health_assessment_idleHours));
    }

    public void validateActiveHours()
    {
    
        validateNonNullField(model.getActiveHours(), activity.getPage("Page 3"), R.id.activeHoursContainer, context.getResources().getString(R.string.student_health_assessment_activeHours));
    }

    public void validateFamilyInteraction()
    {
    
        validateNonNullField(model.getFamilyInteraction(), activity.getPage("Page 3"), R.id.familyInteractionContainer, context.getResources().getString(R.string.student_health_assessment_familyInteraction));
    }

    public void validateFamilyInteractionSpecify()
    {
  
        validateNonNullSpecifyField(model.getFamilyInteraction(),0,model.getFamilyInteractionSpecify(), activity.getPage("Page 3"), R.id.familyInteractionSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_familyInteractionSpecify));   
    }

    public void validateCommunityInvolvement()
    {
    
        validateNonNullField(model.getCommunityInvolvement(), activity.getPage("Page 3"), R.id.communityInvolvementContainer, context.getResources().getString(R.string.student_health_assessment_communityInvolvement));
    }

    public void validateCommunityInvolvementSpecify()
    {
  
        validateNonNullSpecifyField(model.getCommunityInvolvement(),0,model.getCommunityInvolvementSpecify(), activity.getPage("Page 3"), R.id.communityInvolvementSpecifyContainer, context.getResources().getString(R.string.student_health_assessment_communityInvolvementSpecify));   
    }

    public void validateChildDrrKnowledge()
    {
    
        validateNonNullField(model.getChildDrrKnowledge(), activity.getPage("Page 3"), R.id.childDrrKnowledgeContainer, context.getResources().getString(R.string.student_health_assessment_childDrrKnowledge));
    }

    public void validateChildComplaint()
    {
    
        validateNonNullField(model.getChildComplaint(), activity.getPage("Page 3"), R.id.childComplaintContainer, context.getResources().getString(R.string.student_health_assessment_childComplaint));
    }


}
