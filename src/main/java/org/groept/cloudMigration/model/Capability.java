package org.groept.cloudMigration.model;
import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;





@Document
public class Capability
{
	 
	@Id
    private ObjectId id;
	
	
	private String resource;

	
	private String conditionCap;
	
	private String discriptionCap;
	 
	 

	//@DBRef
	/*@DBRef (lazy = true)
	private Set<Court> court;*/

	
	private Set<ObjectId> courts;
	
	public void addCourt(Court court)
	{
		if(courts == null) {
			this.courts = new HashSet<ObjectId>();
		}
		courts.add( court.getId());
	}
	
	


	public Set<ObjectId> getCourts() {
		if(courts == null) {
			this.courts = new HashSet<ObjectId>();
		}
		return courts;
	}



	public void setCourts(Set<ObjectId> court) {
		this.courts = court;
	}







	
	@Override
	public String toString() {
		return "Capability [id=" + id + ", resource=" + resource
				+ ", conditionCap=" + conditionCap + ", discriptionCap="
				+ discriptionCap + "]";
	}



	public Capability(String resource, String conditionCap,
			String discriptionCap) {
		super();
		this.resource = resource;
		this.conditionCap = conditionCap;
		this.discriptionCap = discriptionCap;
	}



	public Capability(){
		
	}


	
	public ObjectId getId() {
		return id;
	}



	public void setId(ObjectId id) {
		this.id = id;
	}



	public String getResource() {
		return resource;
	}



	public void setResource(String resource) {
		this.resource = resource;
	}



	public String getConditionCap() {
		return conditionCap;
	}



	public void setConditionCap(String conditionCap) {
		this.conditionCap = conditionCap;
	}



	public String getDiscriptionCap() {
		return discriptionCap;
	}



	public void setDiscriptionCap(String discriptionCap) {
		this.discriptionCap = discriptionCap;
	}



	public void unsetId() {
		this.id = null;	
	}

	

	


	public void unsetResource() {
		this.resource = "";	
	}
	

	public void unsetCondition() {
		this.conditionCap = "";	
	}
	

	public void unsetDiscription() {
		this.discriptionCap = "";	
	}

	

	/*public void setCourt(Set<Court> court) {
		this.court = court;
	}


	public Set<Court> getCourt() {
		if(this.court == null) {
				this.court = new HashSet<Court>();
		}
		return (Set<Court>) this.court;	
	}
	


	
	

	public void addAllCourt(Set<Court> newCourt) {
		if (this.court == null) {
			this.court = new HashSet<Court>();
		}
		for (Court tmp : newCourt)
			tmp.addCapability(this);
			
	}
	
	
	
	

	public void removeAllCourt(Set<Court> newCourt) {
		if(this.court == null) {
			return;
		}
		
		this.court.removeAll(newCourt);	
	}
	

	
	
	


 
	public void addCourt(Court newCourt) {
		if(this.court == null) {
			this.court = new HashSet<Court>();
		}
		
		if (this.court.add(newCourt))
			newCourt.addCapability(this);	
	}



public void removeCourt(Court oldCourt) {
		if(this.court == null)
			return;
		
		if (this.court.remove(oldCourt))
			oldCourt.removeCapability(this);
			
	}
*/
	
	
}

