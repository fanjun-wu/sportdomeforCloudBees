package org.groept.cloudMigration.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.context.annotation.Scope;

import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.model.Subscriber;
import org.groept.cloudMigration.model.TimeInterval;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class ServiceVariables {

	
	//private String URLContex="http://localhost:8080/springsportscenter-mongo/";	
	private String URLContex="http://springsportscenter-cloudmigration.rhcloud.com/";	
	private String emailFrom="noreply@springsportscenter.be";
	private String emailSubject="Spring Sports Center Reservation";		
	private String emailTo=null;
	private String sportsName=null;
	private String sportsTime=null;
	private String sportsDate=null;
	private String sportsHall=null;
	private String sportsCourt=null;
	
	
	
	private Capability _capability=new Capability();
	private List<TimeInterval> _timeIntervals = new ArrayList<TimeInterval>();
	
	private Set<Hall> _hallsAvailable = new HashSet<Hall>();
	private List<Court> _allCourtsThisCap = new ArrayList<Court>();
	private Set<Court> _courtsAvailable= new HashSet<Court>();
	private Set<Reservation> _reservations=new HashSet<Reservation>();
	
	private Set<Integer> _startTimeSetAvailable=new HashSet<Integer>();
	private Date dateSelected=null; 
	private String _startTimeRecieved=null;	
	private Subscriber _subscriber=new Subscriber();
	
	
	private String _nameOfHallRecieved=null;
	private String _nameOfCourtRecieved=null;
	public String getURLContex() {
		return URLContex;
	}
	public void setURLContex(String uRLContex) {
		URLContex = uRLContex;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getEmailTo() {
		return emailTo;
	}
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	public String getSportsName() {
		return sportsName;
	}
	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}
	public String getSportsTime() {
		return sportsTime;
	}
	public void setSportsTime(String sportsTime) {
		this.sportsTime = sportsTime;
	}
	public String getSportsDate() {
		return sportsDate;
	}
	public void setSportsDate(String sportsDate) {
		this.sportsDate = sportsDate;
	}
	public String getSportsHall() {
		return sportsHall;
	}
	public void setSportsHall(String sportsHall) {
		this.sportsHall = sportsHall;
	}
	public String getSportsCourt() {
		return sportsCourt;
	}
	public void setSportsCourt(String sportsCourt) {
		this.sportsCourt = sportsCourt;
	}
	public Capability get_capability() {
		return _capability;
	}
	public void set_capability(Capability _capability) {
		this._capability = _capability;
	}
	public List<TimeInterval> get_timeIntervals() {
		return _timeIntervals;
	}
	public void set_timeIntervals(List<TimeInterval> _timeIntervals) {
		this._timeIntervals = _timeIntervals;
	}
	public Set<Hall> get_hallsAvailable() {
		return _hallsAvailable;
	}
	public void set_hallsAvailable(Set<Hall> _hallsAvailable) {
		this._hallsAvailable = _hallsAvailable;
	}
	public List<Court> get_allCourtsThisCap() {
		return _allCourtsThisCap;
	}
	public void set_allCourtsThisCap(List<Court> _allCourtsThisCap) {
		this._allCourtsThisCap = _allCourtsThisCap;
	}
	public Set<Court> get_courtsAvailable() {
		return _courtsAvailable;
	}
	public void set_courtsAvailable(Set<Court> _courtsAvailable) {
		this._courtsAvailable = _courtsAvailable;
	}
	public Set<Reservation> get_reservations() {
		return _reservations;
	}
	public void set_reservations(Set<Reservation> _reservations) {
		this._reservations = _reservations;
	}
	public Set<Integer> get_startTimeSetAvailable() {
		return _startTimeSetAvailable;
	}
	public void set_startTimeSetAvailable(Set<Integer> _startTimeSetAvailable) {
		this._startTimeSetAvailable = _startTimeSetAvailable;
	}
	public Date getDateSelected() {
		return dateSelected;
	}
	public void setDateSelected(Date dateSelected) {
		this.dateSelected = dateSelected;
	}
	public String get_startTimeRecieved() {
		return _startTimeRecieved;
	}
	public void set_startTimeRecieved(String _startTimeRecieved) {
		this._startTimeRecieved = _startTimeRecieved;
	}
	public Subscriber get_subscriber() {
		return _subscriber;
	}
	public void set_subscriber(Subscriber _subscriber) {
		this._subscriber = _subscriber;
	}
	public String get_nameOfHallRecieved() {
		return _nameOfHallRecieved;
	}
	public void set_nameOfHallRecieved(String _nameOfHallRecieved) {
		this._nameOfHallRecieved = _nameOfHallRecieved;
	}
	public String get_nameOfCourtRecieved() {
		return _nameOfCourtRecieved;
	}
	public void set_nameOfCourtRecieved(String _nameOfCourtRecieved) {
		this._nameOfCourtRecieved = _nameOfCourtRecieved;
	}
	
	
	
	
}
