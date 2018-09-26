<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>countries Page</title>
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
			<spring:message code="employees.all" text="default text" />
		</h1>

		<spring:url value="/employees/add" var="addUrl" />
		<button class="btn btn-danger" onclick="location.href='${addUrl}'"
			style="margin-left: 900px">ADD</button>

		<table class="table table-striped" id="tab1">
			<thead>
				<tr>
					<th style="text-align: center;">Code</th>
					<th style="text-align: center;">Name</th>
					<th style="text-align: center;">First Name</th>
					<th style="text-align: center;">Mail</th>
					<th style="text-align: center;">Phone</th>
					<th style="text-align: center;">Dire Date</th>
					<th style="text-align: center;">Salary</th>
					<th style="text-align: center;">Commission Pct</th>
					<th style="text-align: center;">Job</th>
					<th style="text-align: center;">Manager</th>
					<th style="text-align: center;">Department</th>
					<th style="text-align: center;">Opérations</th>

				</tr>
			</thead>

			<tfoot>
				<tr>
					<th style="text-align: center;">Code</th>
					<th style="text-align: center;">Name</th>
					<th style="text-align: center;">First Name</th>
					<th style="text-align: center;">Mail</th>
					<th style="text-align: center;">Phone</th>
					<th style="text-align: center;">Dire Date</th>
					<th style="text-align: center;">Salary</th>
					<th style="text-align: center;">Commission Pct</th>
					<th style="text-align: center;">Job</th>
					<th style="text-align: center;">Manager</th>
					<th style="text-align: center;">Department</th>
					<th style="text-align: center;">Opérations</th>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach var="emp" items="${listEmp}">
					<tr>

						<td>${emp.employeeId}</td>
						<td>${emp.firstName}</td>
						<td>${emp.lastName}</td>
						<td>${emp.email}</td>
						<td>${emp.phoneNumber}</td>
						<td>${emp.hireDate}</td>
						<td>${emp.salary}</td>
						<td>${emp.commissionPct}</td>
						<td>${emp.jobs.jobTitle}</td>
						<td>${emp.employees.firstName}${emp.employees.lastName}</td>
						<td>${emp.departments.departmentName}</td>
						<td><spring:url value="/employees/${emp.employeeId}"
								var="userUrl" /> <spring:url
								value="/employees/${emp.employeeId}/delete" var="deleteUrl" />
							<spring:url value="/employees/${emp.employeeId}/update"
								var="updateUrl" />

							<button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>
							<button class="btn btn-primary"
								onclick="location.href='${updateUrl}'">Update</button>
							<button class="btn btn-danger"
								onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>


</html>