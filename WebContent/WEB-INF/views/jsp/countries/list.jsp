<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
</head>


<body>


	<div class="container">
		<spring:url value="/countries/add" var="addUrl" />

		
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
			<spring:message code="countries.all" text="default text" />
		</h1>
		
		<button class="btn btn-danger" onclick="location.href='${addUrl}'" style="margin-left: 900px">ADD</button>

		<table class="table table-striped" id="tab">
			<thead>
				<tr>
					<th style="text-align: center;">code</th>
					<th style="text-align: center;">libellé</th>
					<th style="text-align: center;">Region</th>
					<th style="text-align: center;">opérations</th>
				</tr>
			</thead>

			<tfoot>
				<tr>
					<th>code</th>
					<th>libellé</th>
					<th>Region</th>
					<th>operations</th>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach var="Countries" items="${listCountries}">
					<tr>

						<td>${Countries.countryId}</td>
						<td>${Countries.countryName}</td>
						<td>${Countries.regions.regionName}</td>
						<td><spring:url value="/countries/${Countries.countryId}"
								var="userUrl" /> <spring:url
								value="/countries/${Countries.countryId}/delete" var="deleteUrl" />
							<spring:url value="/countries/${Countries.countryId}/update"
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