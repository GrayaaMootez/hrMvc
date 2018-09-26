<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<div class="container">

	<c:choose>
		<c:when test="${countrieForm['new']}">
			<h1>Add Countries</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Countries</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/countries" var="userActionUrl" />

	<form:form class="form-horizontal" method="post"
		modelAttribute="countrieForm" action="${userActionUrl}">


		<spring:bind path="countryId">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Code</label>
				<div class="col-sm-10">
					<form:input path="countryId" type="text" class="form-control "
						id="countryName" placeholder="countryId" />
					<form:errors path="countryId" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="countryName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Libellé</label>
				<div class="col-sm-10">
					<form:input path="countryName" type="text" class="form-control "
						id="countryName" placeholder="countryName" />
					<form:errors path="countryName" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<spring:bind path="regions">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Regions</label>
				<div class="col-sm-5">
					<form:select path="regions" class="form-control">
						<form:options items="${contactTypeSelect}" itemValue="regionId"
							itemLabel="regionName" />
					</form:select>
					<form:errors path="regions" class="control-label" />
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
</html>