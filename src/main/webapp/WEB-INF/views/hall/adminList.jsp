<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">

	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<body>
	<jsp:include page="/WEB-INF/views/includes/logo.jsp" />
	
	
		<div>

			<h1>Admin List</h1>

			<table id="hovertable" class="hoverable">
				<thead>
				<tr>
					<th>Admin Name</th>
					<th>Email</th>
					<th>Telephone</th>
					<th>Gender</th>
					<th>Age</th>
					
					
				</tr>
				</thead>
				<c:forEach items="${admins}" var="admin">
					<tr class="hoverable" id="id${admin.id}" onClick="document.location.href = 'getAdmin?adminId=${admin.id}';">
						<td>${admin.name}</td>
						<td>${admin.email}</td>
						<td>${admin.telephone}</td>
						<td>${admin.gender}</td>
						<td>${admin.age}</td>
						<td><a href="AdminLink?hallId=${hallId}&adminId=${admin.id}">Set</a></td>
					
						
					</tr>
				</c:forEach>
			</table>
			<br/>
			

			<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

		 </div>
	 
	 		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>