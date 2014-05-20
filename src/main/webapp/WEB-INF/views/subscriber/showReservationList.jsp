
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">



<jsp:include page="/WEB-INF/views/includes/header.jsp" />

<h1>Reservation Management for(${subscriber.name})</h1>

<table id="hovertable" class="hoverable">
				<thead>
				<tr>
					<th>Discription</th>
					<th>Tips</th>
					<th>Tips</th>
					
					
				</tr>
				</thead>
				<c:forEach items="${reservations}" var="reservation">
					 <c:if test="${reservation.subscriber.id == subscriber.id}"> 
					<tr class="hoverable" id="id${reservation.id}" onClick="document.location.href = 'getReservation?reservationId=${reservation.id}';">
						<td>${reservation.discription}</td>
						<td>${reservation.tips}</td>
						<td>${reservation.subscriber.name}</td>
						
						
					
						
					</tr>
				 </c:if>
				</c:forEach>
			</table>
			
			<a href="subscriberList">Go Back to Subscriber List</a>




</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
