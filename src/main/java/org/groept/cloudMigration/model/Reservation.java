package org.groept.cloudMigration.model;
import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



 
@Document
public class Reservation
{
	
	@Id
    private ObjectId id;

	private String discription;

	private String tips;
	 
	//@DBRef(lazy = true)
	@DBRef(lazy = true)
	private Subscriber subscriber;
	 
	@DBRef(lazy=true)
	private Set<TimeInterval> timeInterval;
	 
	@DBRef(lazy=true)
	private Court court;
	 
	
 
	public Reservation(String discription, String tips) {
	
		this.discription = discription;
		this.tips = tips;
	}

	public void setTimeInterval(Set<TimeInterval> timeInterval) {
		this.timeInterval = timeInterval;
	}

	public Reservation(){
		
	}
 
	public void basicSetSubscriber(Subscriber mySubscriber) {
		if (this.subscriber != mySubscriber) {
			if (mySubscriber != null){
				if (this.subscriber != mySubscriber) {
					Subscriber oldsubscriber = this.subscriber;
					this.subscriber = mySubscriber;
					if (oldsubscriber != null)
						oldsubscriber.removeReservation(this);
				}
			}
		}	
	}
	
	 
	
	
	
	
	
	
	  
	public ObjectId getId() {
		return id;
	}






	public String getDiscription() {
		return discription;
	}






	public void setDiscription(String discription) {
		this.discription = discription;
	}






	public String getTips() {
		return tips;
	}






	public void setTips(String tips) {
		this.tips = tips;
	}






	public void setId(ObjectId id) {
		this.id = id;
	}


	public void unsetId() {
		this.id = null;	
	}



	
	
 
	public Subscriber getSubscriber() {
		return this.subscriber;	
	}
	 
	public Set<TimeInterval> getTimeInterval() {
		if(this.timeInterval == null) {
				this.timeInterval = new HashSet<TimeInterval>();
		}
		return (Set<TimeInterval>) this.timeInterval;	
	}
	 
	public Court getCourt() {
		return this.court;	
	}
	
	
	public void addAllTimeInterval(Set<TimeInterval> newTimeInterval) {
		if (this.timeInterval == null) {
			this.timeInterval = new HashSet<TimeInterval>();
		}
		for (TimeInterval tmp : newTimeInterval)
			tmp.addReservation(this);
			
	}
	 
	public void removeAllTimeInterval(Set<TimeInterval> newTimeInterval) {
		if(this.timeInterval == null) {
			return;
		}
		
		this.timeInterval.removeAll(newTimeInterval);	
	}
	
	
 
	
	
	 
	/*public void setSubscriber(Subscriber mySubscriber) {
		this.basicSetSubscriber(mySubscriber);
		mySubscriber.addReservation(this);	
	}*/
	
	 
	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	
	public void addTimeInterval(TimeInterval newTimeInterval) {
		if(this.timeInterval == null) {
			this.timeInterval = new HashSet<TimeInterval>();
		}
		
		timeInterval.add(newTimeInterval);
		//newTimeInterval.addReservation(this);	
	}
	 
	/*public void setCourt(Court myCourt) {
		this.basicSetCourt(myCourt);
		myCourt.addReservation(this);	
	}*/
	
	 
	
	
	
	
	
	 
	public void unsetDiscription() {
		this.discription = "";	
	}
	
	 
	public void setCourt(Court court) {
		this.court = court;
	}

	public void unsetTips() {
		this.tips = "";	
	}
	
	 
	public void unsetSubscriber() {
		if (this.subscriber == null)
			return;
		Subscriber oldsubscriber = this.subscriber;
		this.subscriber = null;
		oldsubscriber.removeReservation(this);	
	}
	
	 
	public void removeTimeInterval(TimeInterval oldTimeInterval) {
		if(this.timeInterval == null)
			return;
		
		if (this.timeInterval.remove(oldTimeInterval))
			oldTimeInterval.removeReservation(this);
			
	}
	
 
	@Override
	public String toString()
	{		
		String timeInfo="time: ";
		for(TimeInterval t:timeInterval)
			timeInfo+=" "+t.toString();
		System.out.println("show time: "+timeInfo+"  ");
//		if(subscriber!=null)
//			System.out.println("show sub: "+subscriber.toString());
//		else
//			System.out.println("null sub");
		String res=court.getHall().getName()+" "+court.getName()+" "+timeInfo+"  ";
		
		return res;
		
	}
	
	
}

