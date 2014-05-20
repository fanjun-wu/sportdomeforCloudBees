<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>    
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<title>Admin-Home</title>	
</head>
<body>
	
	<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
	
	

	<jsp:include page="/WEB-INF/views/includes/logo.jsp" />
	
<h1>
	Spring Sports Center Back-End Admin
</h1>


<p>
	The following administration pages are available:</p>
	<ul>
		
		 <li><a href="hallList">Hall Page</a></li>
		<li><a href="adminList">Admin Page</a></li>
		<li><a href="courtList">Court Page</a></li>
		<li><a href="capabilityList ">Capability Page</a></li>
		<li><a href="reservationList ">Reservation Page</a></li>		
		<li><a href="subscriberList">Subscriber Page</a></li>
		 <li><a href="timeIntervalList">TimeInterval Page</a></li>
		 
	</ul>

	
	<br/><a href="../home">---> &nbspHome</a>

<jsp:include page="/WEB-INF/views/includes/footer.jsp" />



</div>

	</tiles:putAttribute>
</tiles:insertDefinition>


</body>
</html>
