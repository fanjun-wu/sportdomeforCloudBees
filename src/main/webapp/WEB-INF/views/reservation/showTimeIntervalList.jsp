
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">

<jsp:include page="/WEB-INF/views/includes/header.jsp" />


<h1>Add TimeInterval for reservation(${reservation.discription})</h1>

<table id="hovertable" class="hoverable">
				<thead>
				<tr>
					<th>Start Time</th>
					<th>Date</th>
					
					
				</tr>
				</thead>
				<c:forEach items="${timeIntervals}" var="timeInterval">
					<tr class="hoverable" id="id${timeInterval.id}" onClick="document.location.href = 'getTimeInterval?timeIntervalId=${timeInterval.id}';">
						<td>${timeInterval.startTime}</td>
						<td>${timeInterval.date}</td>
						<td><a href="reservationAddTime?reservationId=${reservation.id}&timeIntervalId=${timeInterval.id}">Add</a></td>
					
						
					</tr>
				</c:forEach>
			</table>
			<a href="reservationList">Go Back to Reservation List</a>

</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
