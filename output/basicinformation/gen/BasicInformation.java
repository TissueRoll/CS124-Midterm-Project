package com.ajwcc.epinurse.basicinformation.gen;

import com.ajwcc.epinurse.common.utils.EpinurseModel;
import com.ajwcc.epinurse.common.utils.network.ExcludeFromJson;

import java.util.Date;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import com.zhuinden.realmautomigration.AutoMigration;

public class BasicInformation extends RealmObject implements EpinurseModel
{
    @PrimaryKey
    private String uuid;
    
    public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}

	public String getUuid()
	{
		return uuid;
	}

	@ExcludeFromJson
	private boolean editing;

	@Override
	public boolean isEditing() {
		return editing;
	}

	@Override
	public void setEditing(boolean editing) {
		this.editing = editing;
	}


	@ExcludeFromJson
	private String ownerUuid;

	@Override
	public String getOwnerUuid() {
		return ownerUuid;
	}

	@Override
	public void setOwnerUuid(String ownerUuid) {
		this.ownerUuid = ownerUuid;
	}


    
	@ExcludeFromJson
	private boolean synced;

	@Override
	public boolean isSynced() {
		return synced;
	}

	@Override
	public void setSynced(boolean synced) {
		this.synced = synced;
	}


	@ExcludeFromJson
	private Date createdAt;

	@Override
	public Date getCreatedAt() {
		return createdAt;
	}

	@Override
	public void setCreatedAt(Date date)
	{
		this.createdAt = date;
	}
    
	private String patientId;

	// Personal Information
	private String firstName;
	private String middleName;
	private String lastName;

	// Household Information

	// Socio-Economic Information
    
    

	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
	
		if (this.patientId==null || !this.patientId.equals(patientId))
		{
			editing = true;
			synced = false;
		}
	
		this.patientId = patientId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
	
		if (this.firstName==null || !this.firstName.equals(firstName))
		{
			editing = true;
			synced = false;
		}
	
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
	
		if (this.middleName==null || !this.middleName.equals(middleName))
		{
			editing = true;
			synced = false;
		}
	
		this.middleName = middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
	
		if (this.lastName==null || !this.lastName.equals(lastName))
		{
			editing = true;
			synced = false;
		}
	
		this.lastName = lastName;
	}

    
    
    @Override
	public String toString() {
		return "BasicInformation{" +
				"uuid='" + uuid + '\'' +
				", editing=" + editing +
				", synced=" + synced +
				", createdAt=" + createdAt +
				", patientId='" + patientId + '\'' +
				", firstName='" + firstName + '\'' +
				", middleName='" + middleName + '\'' +
				", lastName='" + lastName + '\'' +

				'}';
	}
}
