
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">


	<jsp:include page="/WEB-INF/views/includes/header.jsp" />

	<jsp:include page="/WEB-INF/views/includes/logo.jsp" />
		<div>
		
			<h1>Modify Court</h1>
			
			
			<form:form name="modifyCourtForm" commandName="court" action="updateCourt" method="post">
				<jsp:include page="/WEB-INF/views/includes/court/courtDetails.jsp" />
				<br/>
				<a href="courtList">Back to list</a>&nbsp;&nbsp;&nbsp;
				<a href="javascript: document.forms.modifyCourtForm.submit();">Update court</a>&nbsp;&nbsp;&nbsp;
			
			<!-- 	<a href="deleteCourt?courtId=${court.id}">Delete court</a>&nbsp;&nbsp;&nbsp;	 -->
				
			</form:form>
			
			<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
		
		 </div>



</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
