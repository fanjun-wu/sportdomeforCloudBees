
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<link href="<c:url value="/resources/css/hall.css"/>" rel="stylesheet"/>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>

<script>

$(document).ready(function() {
	
	
	
var checkReservationStatusURL="${pageContext.request.contextPath}/getHall1ReservationInfo";	
	
	$.ajax({
	    type: 'GET',
	    url: checkReservationStatusURL,
	    async: false,
	    
	    success: function(data) {
	       console.log('response data = ' + JSON.stringify(data));
	       console.log("cancel successfully!");	
	       	       
	       for(var i=0;i<data.length;i++)
	       {
	    	   if(data[i]==1)
	    	   {
	    		   var j=i+1;
	    			var courtId="court"+j;
	    			reserved(courtId);
	    		   
	    	   }
	    	   else
	    	   {
	    		   
	    		   var j=i+1;
	    			var courtId="court"+j;
	    			unReserved(courtId);
	    		   	    		   
	    	   }
	    	   
	    	   
	    	   
	    	   
	    		
	       }
	       
	    },
	    error: function(xhr, textStatus, error){
	        console.log("status: "+textStatus);
	        console.log("error: "+error);
	    }
	});
	
			function reserved(id)
			{				
				$("#"+id).attr({			  
					  title: "reserved",				  
					});				
				$("#"+id).css("opacity", "0.1" );
	    
			}
			
			function unReserved(id)
			{				
				$("#"+id).attr({			  
					  title: "unreserved",				  
					});				
				$("#"+id).css("opacity", "1" );
	    
			}
	
})


</script>






<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

	<div class="body">




	<div class="app-map">

			<div id="hall-floor">

				<div class="left-zone">
				
					<div class="badminton-zone">

						<div id="court1">
							
							<img  class="badminton" 
								src="<c:url value="/resources/image/badminton-h-3.jpg"/>">
						</div>

						<div id="court2">
							
							<img  class="badminton"
								src="<c:url value="/resources/image/badminton-h-3.jpg"/>">
						</div>

						<div id="court3">
							<img  class="badminton"
								src="<c:url value="/resources/image/badminton-h-3.jpg"/>">
						</div>
						
						
					<div class="court-title">
						<div class="small-title">
						<h4>H1C10</h4>
						</div>
						<div class="small-title">
						<h4>H1C11</h4>
						</div>
						
						<div class="small-title">
						<h4>H1C12</h4>
						</div>
						
						
					</div>
						
					</div>
					
					

					<div class="basketball-zone">
						<div id="court4">
							<img  class="basketball" 
								src="<c:url value="/resources/image/basketball-h-1.jpg"/>">
						</div>

						<div id="court5">
							<img  class="basketball"
								src="<c:url value="/resources/image/basketball-h-1.jpg"/>">
						</div>

						<div id="court6">
							<img  class="basketball"
								src="<c:url value="/resources/image/basketball-h-1.jpg"/>">
						</div>


						
					<div class="court-title">
						<div class="small-title">
						<h4>H1C20</h4>
						</div>
						<div class="small-title">
						<h4>H1C21</h4>
						</div>
						
						<div class="small-title">
						<h4>H1C22</h4>
						</div>
						
					</div>
					</div>
					


			<div class="left-bottom-zone">
			
					
					<div class="left-bottom-left-zone">
					
					
					<div class="pingpong-zone">
						
					<div class="court-title">
						<div class="small-title2">
						<h4>H1C30</h4>
						</div>
						<div class="small-title2">
						<h4>H1C31</h4>
						</div>
						
						<div class="small-title2">
						<h4>H1C32</h4>
						</div>
						<div class="small-title2">
						<h4>H1C33</h4>
						</div>
						<div class="small-title2">
						<h4>H1C34</h4>
						</div>
						
						<div class="small-title2">
						<h4>H1C35</h4>
						</div>
						
					</div>
					
					<div class="court-zone">
							<div id="court7">
							<img  class="pingpong"
								src="<c:url value="/resources/image/pingpong-v-1.jpg"/>">
						</div>

						<div id="court8">
							<img  class="pingpong"
								src="<c:url value="/resources/image/pingpong-v-1.jpg"/>">
						</div>

						<div id="court9">
							<img  class="pingpong"
								src="<c:url value="/resources/image/pingpong-v-1.jpg"/>">
						</div>

						<div id="court10">
							<img  class="pingpong"
								src="<c:url value="/resources/image/pingpong-v-1.jpg"/>">
						</div>

						<div id="court11">
							<img  class="pingpong"
								src="<c:url value="/resources/image/pingpong-v-1.jpg"/>">
						</div>

						<div id="court12">
							<img  class="pingpong"
								src="<c:url value="/resources/image/pingpong-v-1.jpg"/>">
						</div>
											
					</div>
					
					

						</div>
					
					</div>
					
					<div class="left-bottom-right-zone">
					
						
						<div class="small-title3">
						<h4>Entrence</h4>
						</div>
						<div id="entrance">
							<img  class="entrance"
								src="<c:url value="/resources/image/entrance-v-1.png"/>">
						</div>
						
					</div>
					
					

					
			
			
			</div>



				

				</div>

				<div class="right-zone">
				
					<div class=="right-top-zone">
							
							
					<div class="tennis-zone">
					
					<div class="court-title">
						<div class="small-title4">
						<h4>H1C40</h4>
						</div>
						<div class="small-title4">
						<h4>H1C41</h4>
						</div>
						
					</div>
					
						<div id="court13">
							<img  class="tennis"
								src="<c:url value="/resources/image/tennis-v-1.jpg"/>">
						</div>

						<div id="court14">
							<img  class="tennis"
								src="<c:url value="/resources/image/tennis-v-1.jpg"/>">
						</div>

					
					</div>
				
				</div>
				
				<div class=="right-bottom-zone">

					<div class="tennis-zone">
					
					<div class="court-title">
						<div class="small-title4">
						<h4>H1C42</h4>
						</div>
						<div class="small-title4">
						<h4>H1C43</h4>
						</div>
						
					</div>
								<div id="court15">
									<img class="tennis"
										src="<c:url value="/resources/image/tennis-v-1.jpg"/>">
								</div>

								<div id="court16">
									<img class="tennis"
										src="<c:url value="/resources/image/tennis-v-1.jpg"/>">
								</div>

					</div>



				</div>
				
				

					</div>


				</div>

			</div>
	
	
	
		</div>



	</tiles:putAttribute>
</tiles:insertDefinition>