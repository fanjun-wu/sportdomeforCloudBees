package org.groept.cloudMigration.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.model.Subscriber;
import org.groept.cloudMigration.model.TimeInterval;
import org.groept.cloudMigration.service.AdminService;
import org.groept.cloudMigration.service.CapabilityService;
import org.groept.cloudMigration.service.CourtService;
import org.groept.cloudMigration.service.HallService;
import org.groept.cloudMigration.service.ReservationService;
import org.groept.cloudMigration.service.SubscriberService;
import org.groept.cloudMigration.service.TimeIntervalService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;






import com.github.sendgrid.SendGrid;


@Service
public class FrontendService {
	

	@Autowired
	private ServiceVariables serviceVariabales;	
	@Autowired
	private CapabilityService capabilityService;
	@Autowired
	private TimeIntervalService timeIntervalService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private CourtService courtService;
	@Autowired
	private HallService hallService;
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private SubscriberService subscriberService;
	

	
	public List<Capability> getCapabilities() {

		List<Capability> capabilitiesTemp = capabilityService.getCapabilities();
		
		List<Capability> capabilities=new ArrayList<Capability>();
		
		for(Capability cap:capabilitiesTemp)
		{
			//didn't show the court info, because if yes, there is an json .... error in this case????  
			capabilities.add(new Capability(cap.getResource(),cap.getConditionCap(),cap.getDiscriptionCap()));
			
		}		
		System.out.println("capability types: "+capabilities.toString());
		
		return capabilities;
				
	}

	

	public void getCapabilitySelected(String capability) {

		System.out.println("inside //getCapabilities  POST");
		System.out.println("Capability recieved: "+capability);

		serviceVariabales.setSportsName(capability);
		Capability _capability=new Capability();
		
		for(int i=0;i<capabilityService.getCapabilities().size();i++)
		{
			Capability cap=(Capability)capabilityService.getCapabilities().get(i);
			if(cap.getResource().equalsIgnoreCase(capability))
				_capability=cap;	
			System.out.println("+++"+_capability.getResource());
		}
		
		
		//get all the courts can be used for this sport
		serviceVariabales.set_allCourtsThisCap(capabilityService.getCourts(_capability.getId()));	
		
		serviceVariabales.set_capability(_capability);
		

		System.out.println("size of courts for this sport: "+serviceVariabales.get_allCourtsThisCap().size());
		
		cleanVariablesAfterSelectSports();
	}
	
	
	
	public void getDateSelected(String dateRecieved)
	{		
		System.out.println("inside /getDate  POST");
		System.out.println("Date recieved: "+dateRecieved);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			serviceVariabales.setSportsDate(dateRecieved);
			serviceVariabales.setDateSelected(formatter.parse(dateRecieved));			
			System.out.println("Date recieved after parse: "+serviceVariabales.getDateSelected());

			serviceVariabales.set_timeIntervals(timeIntervalService.getTimeIntervalByDate(serviceVariabales.getDateSelected()));
			
			//get all the reservations for this date
			if(serviceVariabales.get_timeIntervals().size()!=0)
				for(TimeInterval tt:serviceVariabales.get_timeIntervals())
				{
					if(tt.getReservation().size()!=0)
						for(Reservation res:tt.getReservation())
						{
							serviceVariabales.get_reservations().add(res);					
						}

				}			
			
			System.out.println("TimeInterval(with same date) Size: "+serviceVariabales.get_timeIntervals().size());
			
			System.out.println("Reservations size: "+serviceVariabales.get_reservations().size()+" at "+dateRecieved);
			
			cleanVariablesAfterSelectDate();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	
	
	//list whose element[start time] begins from open to close, and return the elements[start time] which are not inside theset of timeSetReserved
	public Set<Integer> timeSetLeft(int open,int close,Set<Integer> timeSetReserved)
	{		
		Set<Integer> timeSetStandard=new HashSet<Integer>();
		Set<Integer> timeSetLeft=new HashSet<Integer>();

		for(int i=open;i<close;i++)
			timeSetStandard.add(i);
		
		System.out.println("timeSetReserved size: "+timeSetReserved.size());
		
		for(Integer t:timeSetReserved)
			System.out.println(": "+t);
		
		if(timeSetReserved.size()!=0)
		{
			
			for(Integer itr:timeSetStandard)
			{
				if(!timeSetReserved.contains(itr))
					timeSetLeft.add(itr);
			}
			
		}
		else
			timeSetLeft=timeSetStandard;
		
		return timeSetLeft;
	}


	public List<Integer> getTimeIntervals() {
		
		
		//get the start time list available for this sport at this day
		List< Set<Integer> > _startTimeSetLeftTotal=new ArrayList<Set<Integer>>();
		
		for(Court ct:serviceVariabales.get_allCourtsThisCap())
		{
			Set<Integer> _startTimeSetReservedSingleCourt=new HashSet<Integer>();
			Set<Integer> _startTimeSetLeftSingleCourt=new HashSet<Integer>();				
			
			//get all the reservation for that court in that day and manipulate the start time Set			
			
	//		System.out.println("ct getReservation() size(): "+ct.getReservation().size());			
			if(courtService.listofReservations(ct.getId()).size()!=0)
				for(Reservation res: courtService.listofReservations(ct.getId()))
				{

//					System.out.println("getTimeInterval() size: "+res.getTimeInterval().toString());
					for(TimeInterval tvl:res.getTimeInterval())
					{
						if( compareTwoDate(tvl.getDate(),serviceVariabales.getDateSelected()))
						{
							_startTimeSetReservedSingleCourt.add(tvl.getStartTime());
						}
							
					}									
				}

			System.out.println("_startTimeSetReservedSingleCourt size: "+_startTimeSetReservedSingleCourt.size());
			
			
			_startTimeSetLeftSingleCourt=timeSetLeft(ct.getHall().getOpenTime(),ct.getHall().getCloseTime(),_startTimeSetReservedSingleCourt);
			
			
			System.out.println("_startTimeSetLeftSingleCourt size: "+_startTimeSetLeftSingleCourt.size());
			
			_startTimeSetLeftTotal.add(_startTimeSetLeftSingleCourt);							
		}
		
		System.out.println("_startTimeSetLeftTotal size: "+_startTimeSetLeftTotal.size());
		
		for(Set<Integer> setElement:_startTimeSetLeftTotal )
			for(Integer element:setElement)
			{
				serviceVariabales.get_startTimeSetAvailable().add(element);
				System.out.println("-->  "+element);
			}

System.out.println("_startTimeSetAvailable size: "+serviceVariabales.get_startTimeSetAvailable().size());
		
		List<Integer> listTemp=new ArrayList<Integer>();
		for(Integer itg:serviceVariabales.get_startTimeSetAvailable())
			listTemp.add(itg);
		Collections.sort(listTemp);
		
		return listTemp;
	}

	
	
	public boolean compareTwoDate(Date d1,Date d2)
	{
		
		System.out.println("Compare details: "+d1.getYear()+" "+d2.getYear()+", "+d1.getMonth()+" "+d2.getMonth()+", "+d1.getDay()+" "+d2.getDay());
		
		if(d1.getYear()==d2.getYear()&&d1.getMonth()==d2.getMonth()&&d1.getDay()==d2.getDay())
			return true;
		else
			return false;
	}
	
	
	
	
	
	public void getTimeIntervalSelected(String interval) {
		

		serviceVariabales.setSportsTime(interval);
		serviceVariabales.set_startTimeRecieved(interval);
		
		System.out.println("start time recieved: "+interval);
		
		cleanVariablesAfterSelectTimeInterval();
		
	}

	
	public Set<Hall> getHallAvailables() {
		//calculate the halls available
				for(Court ct:serviceVariabales.get_allCourtsThisCap())
				{
					Set<Integer> startTimeReservedSingleCourt=new HashSet<Integer>();
					for(Reservation res:courtService.listofReservations(ct.getId()))
					{
						for(TimeInterval tv:res.getTimeInterval())
						{							
							if(compareTwoDate(tv.getDate(),serviceVariabales.getDateSelected()))							
								startTimeReservedSingleCourt.add(tv.getStartTime());
							
						}
						
					}
					
					
					//if the start time user choose isn't in the set of start time set reserved, then add this court or hall as available
					if(!startTimeReservedSingleCourt.contains(Integer.parseInt(serviceVariabales.get_startTimeRecieved())))
					{			
						Set<String> _hallName=new HashSet<String>();
						_hallName.add(ct.getHall().getName());
						
						
						if(serviceVariabales.get_hallsAvailable().size()==0)
						{
							serviceVariabales.get_hallsAvailable().add(ct.getHall());	
						}
						else
						{
							System.out.println(_hallName.contains(ct.getHall().getName()));
							
							if (!_hallName.contains(ct.getHall().getName()))
							{
								serviceVariabales.get_hallsAvailable().add(ct.getHall());	
								System.out.println(_hallName.contains(ct.getHall().getName()));
							}
						}
							
						
					}	
					
				}
				
				System.out.println("available halls size: "+serviceVariabales.get_hallsAvailable().size());
			
				

				
		Set<Hall> hallTemp=new HashSet<Hall>();		
		for(Hall ha:serviceVariabales.get_hallsAvailable())		
		{
			hallTemp.add(new Hall(ha.getName(),ha.getOpenTime(),ha.getCloseTime(),ha.getIntroduction()));			
		}	
		

		
		System.out.println("available halls size: "+hallTemp.iterator().next().getName());
		//don't return _hallsAvailable directly, throw away the relations here, 
		//just the hall info is needed, if not, we will get the json serialize error
		return hallTemp;

	}
	
	
	public void getHallSelected(String hall) {

		serviceVariabales.setSportsHall(hall);
		serviceVariabales.set_nameOfHallRecieved(hall);
		System.out.println("hall choosen: "+hall);
		
		cleanVariablesAfterSelectHall();
	}
	

	public Set<Court> getCourts() {

		Hall hallTemp=new Hall();
		for(Hall ha:serviceVariabales.get_hallsAvailable())
		{
			if(ha.getName().equalsIgnoreCase(serviceVariabales.get_nameOfHallRecieved()))
			{
				hallTemp=ha;				
			}			
		}
	
		/*for(Court ct:hallTemp.getCourt())*/		
			for(Court ct:hallService.listofCourts(hallTemp.getId()))
		{
				
			Set<Integer> startTimeReservedSingleCourt=new HashSet<Integer>();
			
			for(Capability cap:courtService.listofCapabilitys(ct.getId()))
			{
			
				if(cap.getResource().equalsIgnoreCase(serviceVariabales.get_capability().getResource()))
				{
					
					for(Reservation res:courtService.listofReservations(ct.getId()))
					{
						for(TimeInterval tv:res.getTimeInterval())
						{
							if( compareTwoDate(tv.getDate(),serviceVariabales.getDateSelected()))
								startTimeReservedSingleCourt.add(tv.getStartTime());
							
						}
						
					}
					
					//if the start time user choose isn't in the set of start time set reserved, then add this court or hall as available
					if(!startTimeReservedSingleCourt.contains(Integer.parseInt(serviceVariabales.get_startTimeRecieved())))
					{			
						System.out.println("this court can be reserved");
						serviceVariabales.get_courtsAvailable().add(ct);				
					}
					
					
				}
			
			
				
			}
					
			
		}
		
		
			
		Set<Court> courtTemp=new HashSet<Court>();
		courtTemp.clear();
		for(Court ct:serviceVariabales.get_courtsAvailable())
		{
			courtTemp.add(new Court(ct.getName(),ct.getIntroduction()));
			System.out.println("courts info: "+ct.getName()+"  "+ct.getIntroduction());
			
		}
		
		return courtTemp;
	}
	

	public void getCourtSelected( String court) {

		serviceVariabales.setSportsCourt(court);
		serviceVariabales.set_nameOfCourtRecieved(court);
	
		System.out.println("court selected: "+court);	
	}
	
	

	public void getUserInfo( String user)
	{				
		String[] userInfoTemp=user.split(","); 
		
		serviceVariabales.get_subscriber();
		
		serviceVariabales.get_subscriber().setName(userInfoTemp[0]);
		serviceVariabales.get_subscriber().setEmail(userInfoTemp[1]);
		serviceVariabales.get_subscriber().setTelephone(userInfoTemp[2]);
		UUID uniqueKey1= UUID.randomUUID();
		UUID uniqueKey2= UUID.randomUUID();
		String key=uniqueKey1.toString()+uniqueKey2.toString();
		serviceVariabales.get_subscriber().setAuthenKey(key);
		System.out.println("user info:"+serviceVariabales.get_subscriber().getName()+" "+serviceVariabales.get_subscriber().getEmail()+" "+serviceVariabales.get_subscriber().getTelephone());
		
		saveReservation(userInfoTemp[0],key,userInfoTemp[1]);
		cleanVaribalesAfterSubmit();

	}
	
	
	public void saveReservation(String name, String key,String email)
	{
		//serviceVariabales
		
		subscriberService.saveSubscriber(serviceVariabales.get_subscriber());
		TimeInterval tal=new TimeInterval(Integer.parseInt(serviceVariabales.get_startTimeRecieved()),serviceVariabales.getDateSelected());
		Set<TimeInterval> tals=new HashSet<TimeInterval>();
		tals.add(tal);
		timeIntervalService.saveTimeSet(tals);
				
		
		int startTimeRecieved = Integer.parseInt(serviceVariabales.get_startTimeRecieved());
		Reservation res=new Reservation();
		res.setDiscription("You have reserved " +serviceVariabales.get_capability().getResource()+" at "+ serviceVariabales.get_nameOfCourtRecieved()+" in " +serviceVariabales.get_nameOfHallRecieved() +" from "+ startTimeRecieved+" to "+(startTimeRecieved+1)+". See you there!");
		res.setTips("no");			       
		res.setCourt(courtService.getCourtByName(serviceVariabales.get_nameOfCourtRecieved()));                                                                  
		res.setSubscriber(serviceVariabales.get_subscriber());
		res.setTimeInterval(tals);
		
		tal.addReservation(res);
		reservationService.saveReservation(res);
		
		timeIntervalService.saveTimeInterval(tal);
		
		sendEmailSendGrid(name,key,email);
		//for testing below
		//sendEmailSendGrid("conna","0132165464648546","lihuachenchen0725@gmail.com");
		
	}
	
	

	public void sendEmailSendGrid(String name, String key,String email)
	{
		
		System.out.println("before sending email...: "+name+"  "+key+"  "+email);
		serviceVariabales.setEmailTo(email);
		
		SendGrid sendgrid = new SendGrid("cloudbees_fanjun-wu","kgdssm123");
	
		String emailContent00="Hello, "+name+", your reservation is successful: " +"Sports: "+serviceVariabales.getSportsName()+", Date: "+serviceVariabales.getSportsDate()+
	    		   ", Start Time: "+serviceVariabales.getSportsTime()+", Hall: "+serviceVariabales.getSportsHall()+
	    		   ", Court: "+serviceVariabales.getSportsCourt()+";"+"  If you want to cancel it, go to your reservation page: "+
	    				   serviceVariabales.getURLContex()+"login/user-name/"+name+"/user-authen-key/"+key;
	    
		
		String emailContent="<div style='background-color:#FFFF99'>"
				+ "<h3>Hello, "+name+", your reservation is successful: </h3>" +"</br><h2>Sports: "+serviceVariabales.getSportsName()+", Date: "+serviceVariabales.getSportsDate()+
	    		   ", Start Time: "+serviceVariabales.getSportsTime()+", Hall: "+serviceVariabales.getSportsHall()+
	    		   ", Court: "+serviceVariabales.getSportsCourt()+";</h2>"+" <h1></h1>If you want to cancel it, go to your reservation page: </br>"+
	    				   serviceVariabales.getURLContex()+"login/user-name/"+name+"/user-authen-key/"+key
	    				   +"</div>"+"<div><h3>see you soon!</h3></div>"
	    	               ;
	    
		
		sendgrid.addTo(serviceVariabales.getEmailTo());
		sendgrid.setFrom(serviceVariabales.getEmailFrom());
		sendgrid.setSubject(serviceVariabales.getEmailSubject());
		
		//sendgrid.setText(emailContent);
	
		sendgrid.setHtml(emailContent);
		
		sendgrid.send();
		
		System.out.println("finish sending ...");
		
		
	}
	
	

	
	public List<Integer> getHall1ReservationInfo()
	{
		List<Court> courts=new ArrayList<Court>();
		Set<Reservation> reservationsNow=new HashSet<Reservation>();
		reservationsNow.clear();
		
		List<Integer> reservationStatus=new ArrayList<Integer>(); 
		
		Hall hall1=new Hall();
				
		if(hallService.getHalls().size()!=0)
		{
			hall1=(Hall)hallService.getHalls().get(0);
			
			
			for(Court c:hallService.listofCourts(hall1.getId()))
			//for(Court c:hall1.getCourts())
			{
				courts.add(c);				
			}
		
			//order: from small to big 
			Collections.sort(courts, new CourtComparator());
			
			for(Court c:courts)
				
				System.out.println(c.toString());
			
			
		}
		
		
		if(reservationService.getReservations().size()!=0)
		{
			
			for(Reservation res:(List <Reservation>) reservationService.getReservations())	
			{
			//	System.out.println("***** "+res.toString());
				
				Set<TimeInterval> timeIntervals=res.getTimeInterval();
				for(TimeInterval tim:timeIntervals)
				{
					System.out.println(tim.getDate()+" "+tim.getStartTime());
					
		
					Calendar calNow = new GregorianCalendar(TimeZone.getTimeZone("Europe/Brussels"));
					
					
				//	System.out.println("Todat Test: "+cal.get(Calendar.YEAR)+", "+cal.get(Calendar.MONTH)+", "+cal.get(Calendar.DAY_OF_MONTH));
					
					
					Calendar calReserved = Calendar.getInstance();
					calReserved.setTime(tim.getDate());
					
					
					//if(compareTwoDate(tim.getDate(),today))
					if((calNow.get(Calendar.YEAR)==calReserved.get(Calendar.YEAR))&&(calNow.get(Calendar.MONTH)==calReserved.get(Calendar.MONTH))&&(calNow.get(Calendar.DAY_OF_MONTH)==calReserved.get(Calendar.DAY_OF_MONTH)))
					{
						System.out.println("------- "+res.toString());
		
						if(tim.getStartTime()==calNow.get(Calendar.HOUR_OF_DAY))
						{								
				    			reservationsNow.add(res);
				    			System.out.println("we find a new reservation, size: "+reservationsNow.size());
						}
					}					
				}				
			}	
				
		}
		
		System.out.println("reservation size: "+reservationsNow.size());
		for(Reservation res:reservationsNow)
			System.out.println("res: "+res.toString());
		System.out.println(courts.toString());
		
		int i=0;
		for(Court c:courts)
		{
			System.out.println("court: "+c.getName());
			for(Reservation r:reservationsNow)
			{
				System.out.println("compare: "+r.getCourt().getName());
				if(r.getCourt().getName().equalsIgnoreCase(c.getName()))
				{
					i++;
					reservationStatus.add(1);
					System.out.println("reserved");
					
				}
				
			}
			if(i==0)
			{
				reservationStatus.add(0);
				
				System.out.println("unreserved");
			}
			
		i=0;
		}
		
		return reservationStatus;
		
	}

	
	public String showDate(Date dt)
	{
		
		return ": "+dt.getYear()+" "+dt.getMonth()+" "+dt.getDay();
		
	}
	
	
	
	public int getBrusslesHour()
	{
	    Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("Europe/Brussels"));
	    int hour = cal.get(Calendar.HOUR_OF_DAY); // 0..24
	    return hour;
		
	}
	
	
	
	public int timeZoneToBelgium(int t)
	{
		if((t<18)&&(t>0))
			return t+6;
		else
			return t+6-24;
				
	}
	
	public Date timeZoneBrusselsDate()
	{
		Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("Europe/Brussels"));
		
		Date dt=new Date(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE));
		return dt;
		
	}
	
	
	
	public void cleanVaribalesAfterSubmit()
	{
		System.out.println("clean all after you reserve successfully!");
		
		
		serviceVariabales.set_capability(new Capability());
		serviceVariabales.get_allCourtsThisCap().clear();
		
		serviceVariabales.setDateSelected(null);
		serviceVariabales.get_timeIntervals().clear();
		serviceVariabales.get_reservations().clear();
		
		serviceVariabales.get_startTimeSetAvailable().clear();
		serviceVariabales.set_startTimeRecieved(null);
		
		serviceVariabales.get_hallsAvailable().clear();
		serviceVariabales.set_nameOfHallRecieved(null);
		
		serviceVariabales.get_courtsAvailable().clear();
		serviceVariabales.set_nameOfCourtRecieved(null);
		
		serviceVariabales.set_subscriber(new Subscriber());
		
		
	}
	
	public void cleanVariablesAfterSelectSports()
	{
		System.out.println("cleanVariablesAfterSelectSports");
		
		serviceVariabales.setDateSelected(null);
		serviceVariabales.get_timeIntervals().clear();
		serviceVariabales.get_reservations().clear();
		
		serviceVariabales.get_startTimeSetAvailable().clear();
		serviceVariabales.set_startTimeRecieved(null);
		
		serviceVariabales.get_hallsAvailable().clear();
		serviceVariabales.set_nameOfHallRecieved(null);
		
		serviceVariabales.get_courtsAvailable().clear();
		serviceVariabales.set_nameOfCourtRecieved(null);
		
		serviceVariabales.set_subscriber(new Subscriber());

		
	}
	
	public void cleanVariablesAfterSelectDate()
	{
		System.out.println("cleanVariablesAfterSelectDate");
		
		serviceVariabales.get_startTimeSetAvailable().clear();
		serviceVariabales.set_startTimeRecieved(null);
		
		serviceVariabales.get_hallsAvailable().clear();
		serviceVariabales.set_nameOfHallRecieved(null);
		
		serviceVariabales.get_courtsAvailable().clear();
		serviceVariabales.set_nameOfCourtRecieved(null);
		
		serviceVariabales.set_subscriber(new Subscriber());
		
	}
	
	public void cleanVariablesAfterSelectTimeInterval()
	{
		System.out.println("cleanVariablesAfterSelectTimeInterval");
		
		serviceVariabales.get_hallsAvailable().clear();
		serviceVariabales.set_nameOfHallRecieved(null);
		
		serviceVariabales.get_courtsAvailable().clear();
		serviceVariabales.set_nameOfCourtRecieved(null);
		
		serviceVariabales.set_subscriber(new Subscriber());
		
	}
	public void cleanVariablesAfterSelectHall()
	{
		System.out.println("cleanVariablesAfterSelectHall");
		
		serviceVariabales.get_courtsAvailable().clear();
		serviceVariabales.set_nameOfCourtRecieved(null);
		
		serviceVariabales.set_subscriber(new Subscriber());
		
	}
	

	
	
	
	
	public Date getDateByString(String dateString)
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");		
		
		Date date=new Date();
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;		
	}
	
	
	
	

}
