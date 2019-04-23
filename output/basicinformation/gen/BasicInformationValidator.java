package com.ajwcc.epinurse.BasicInformation.gen;

import com.ajwcc.epinurse.common.BaseValidator;
import com.ajwcc.util.ui.validation.ValidationHandler;
import com.ajwcc.epinurse.R;

public class BasicInformationValidator extends BaseValidator implements ValidationHandler<BasicInformation>
{
    protected BasicInformation model;
    protected BasicInformationActivity activity;


    public BasicInformationValidator(BasicInformationActivity a)
    {
    	super(a);
        activity = a;
    }

    @Override
    public void setModel(BasicInformation model)
    {
        this.model = model;
    }

    @Override
    public void validateModel()
    {
		validateFirstName();
		//  middleName optional
		validateLastName();

    }


    public void validateFirstName()
    {
    
        validateNonNullField(model.getFirstName(), activity.getPage("Personal Information"), R.id.firstNameContainer, context.getResources().getString(R.string.basic_information_firstName));
    }

    public void validateLastName()
    {
    
        validateNonNullField(model.getLastName(), activity.getPage("Personal Information"), R.id.lastNameContainer, context.getResources().getString(R.string.basic_information_lastName));
    }


}
