<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>
			<spring:message code="jobs.all" text="default text" />
		</h1>

		<spring:url value="/jobs/add" var="addUrl" />
		<button class="btn btn-danger" onclick="location.href='${addUrl}'"
			style="margin-left: 900px">ADD</button>


		<table class="table table-striped" id="tab">
			<thead>
				<tr>
					<th>employe</th>
					<th>departements</th>
					<th>start date</th>
					<th>end date</th>
					<th>job</th>
					<th>Operations</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="job" items="${histJobs}">
					<tr>
						<td>${job.employees.firstName}</td>
						<td>${job.jobs.jobTitle}</td>
						<td>${job.id.dateDeb}</td>
						<td>${job.dateFin}</td>
						<td>${job.departments.departmentName}</td>
						<td><spring:url value="/histJob/${job.id.employeeId}/${job.id.startDate2}" var="userUrl" />
							<spring:url value="/histJob/${job.id}/update" var="updateUrl" />

							<button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>
							<button class="btn btn-primary"
								onclick="location.href='${updateUrl}'">Update</button>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>