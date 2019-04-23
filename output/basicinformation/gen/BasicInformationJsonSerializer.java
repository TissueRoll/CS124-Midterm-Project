package com.ajwcc.epinurse.basicinformation.gen;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;


public class BasicInformationJsonSerializer implements JsonSerializer<BasicInformation> {

    @Override
    public JsonElement serialize(BasicInformation model, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        
        object.add("uuid", context.serialize(model.getUuid()));
        object.add("ownerUuid", context.serialize(model.getOwnerUuid()));
        
		serializePatientId(model, object, context); // patient_id

		// Personal Information
		serializeFirstName(model, object, context); // first_name
		serializeMiddleName(model, object, context); // middle_name
		serializeLastName(model, object, context); // last_name

		// Household Information

		// Socio-Economic Information
 
       
        return object;
    }
    

    public void serializePatientId(BasicInformation model, JsonObject object, JsonSerializationContext context)
    {
        object.add("patient_id", context.serialize(model.getPatientId()));
    }

    public void serializeFirstName(BasicInformation model, JsonObject object, JsonSerializationContext context)
    {
        object.add("first_name", context.serialize(model.getFirstName()));
    }

    public void serializeMiddleName(BasicInformation model, JsonObject object, JsonSerializationContext context)
    {
        object.add("middle_name", context.serialize(model.getMiddleName()));
    }

    public void serializeLastName(BasicInformation model, JsonObject object, JsonSerializationContext context)
    {
        object.add("last_name", context.serialize(model.getLastName()));
    }
 
    

}