<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<div class="container">

	<c:choose>
		<c:when test="${locationForm['new']}">
			<h1>Add Location</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Location</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/locations" var="userActionUrl" />

	<form:form class="form-horizontal" method="post"
		modelAttribute="locationForm" action="${userActionUrl}">

		<form:hidden path="locationId" />

		<spring:bind path="streetAddress">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Adress</label>
				<div class="col-sm-10">
					<form:input path="streetAddress" type="text" class="form-control "
						id="streetAddress" placeholder="streetAddress" />
					<form:errors path="streetAddress" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="postalCode">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Postal Code</label>
				<div class="col-sm-10">
					<form:input path="postalCode" type="text" class="form-control "
						id="postalCode" placeholder="postalCode" />
					<form:errors path="postalCode" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="city">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">City</label>
				<div class="col-sm-10">
					<form:input path="city" type="text" class="form-control " id="city"
						placeholder="city" />
					<form:errors path="city" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="stateProvince">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Province</label>
				<div class="col-sm-10">
					<form:input path="stateProvince" type="text" class="form-control "
						id="stateProvince" placeholder="stateProvince" />
					<form:errors path="stateProvince" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<spring:bind path="countries">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Country</label>
				<div class="col-sm-5">
					<form:select path="countries" class="form-control">
						<form:options items="${listCountries}" itemValue="countryId"
							itemLabel="countryName" />
					</form:select>
					<form:errors path="countries" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${countrieForm['new']}">
						<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>

</body>
</html>