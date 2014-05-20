<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<script type="text/javascript">

function cancelReservation(id)
{
	
	var cancelURL="${pageContext.request.contextPath}/admin/deleteReservation?reservationId="+id;
	var successURL="${pageContext.request.contextPath}/cancelSuccess";
	
	$.ajax({
	    type: 'GET',
	    url: cancelURL,
	    async: false,
	    
	    success: function(data) {
	       console.log('response data = ' + JSON.stringify(data));
	       console.log("cancel successfully!");	
	       
	       setTimeout(function(){pageLoad(successURL);}, 2000);
	    },
	    error: function(xhr, textStatus, error){
	        console.log("status: "+textStatus);
	        console.log("error: "+error);
	        setTimeout(function(){location.reload();}, 30000);
	    }
	});
	

	function pageLoad(url)
	{		
		window.location.replace(url);		
	}	

	
}



</script>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">



	<jsp:include page="/WEB-INF/views/includes/header.jsp" />

	<jsp:include page="/WEB-INF/views/includes/logo-for-cancellation.jsp" />
	
<div>

			<h1>Your Reservation</h1>

			<table id="hovertable" class="hoverable">
				<thead>
				<tr>
					<th>Subscriber Name</th>
					<th>Hall</th>
					<th>Court</th>
					<th>Time</th>
					
					 <th>Cancel</th> 
					
				</tr>
				</thead>			
					<%-- <tr class="hoverable" id="id${reservation.id}" >
						<td>${reservation}</td>
						<td>${reservation}</td>						
						<td><button type="button" onClick="cancelReservation(${reservation.id})">Cancel!</button></td>
					
					</tr> --%>
					
					
					<tr class="hoverable"  id="id${model.reservation.id}">
						<td>${model.subscriber.name}</td>
						<td>${model.hall.name}</td>
						<td>${model.court.name}</td>
						<td>${model.time}</td>						
						<td><button type="button" onClick="cancelReservation('${model.reservation.id}')">Cancel!</button></td>
					
					</tr>
				
			</table>
			<br/>

			<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

		 </div>
	 
	 
	 
	 </div>

	</tiles:putAttribute>
</tiles:insertDefinition>


	 