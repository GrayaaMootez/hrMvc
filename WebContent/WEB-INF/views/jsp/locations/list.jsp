<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
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
			<spring:message code="regions.all" text="default text" />
		</h1>

		<spring:url value="/locations/add" var="addUrl" />
		<button class="btn btn-danger" onclick="location.href='${addUrl}'"
			style="margin-left: 900px">ADD</button>

		<table class="table table-striped" id="tab">
			<thead>
				<tr>
					<th style="text-align: center;">Code</th>
					<th style="text-align: center;">Street</th>
					<th style="text-align: center;">Postal Code</th>
					<th style="text-align: center;">City</th>
					<th style="text-align: center;">Countries</th>
					<th style="text-align: center;">Province</th>
					<th style="text-align: center;">Opérations</th>
				</tr>
			</thead>

			<tfoot>
				<tr>
					<th>Code</th>
					<th>Street</th>
					<th>Postal Code</th>
					<th>City</th>
					<th>Countries</th>
					<th>Province</th>
					<th>Opérations</th>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach var="location" items="${ListLocation}">
					<tr>

						<td>${location.locationId}</td>
						<td>${location.streetAddress}</td>
						<td>${location.postalCode}</td>
						<td>${location.city}</td>
						<td>${location.countries.countryName}</td>
						<td>${location.stateProvince}</td>
						<td><spring:url value="/locations/${location.locationId}"
								var="userUrl" /> <spring:url
								value="/locations/${location.locationId}/delete" var="deleteUrl" />
							<spring:url value="/locations/${location.locationId}/update"
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