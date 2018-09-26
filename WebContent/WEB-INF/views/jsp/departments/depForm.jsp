<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">


<div class="container">
	<c:choose>
		<c:when test="${depForm['new']}">
			<h1>Add Departments</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Departments</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/departments" var="userActionUrl" />

	<form:form class="form-horizontal" method="post"
		modelAttribute="depForm" action="${userActionUrl}">

		<form:hidden path="departmentId" />

		<spring:bind path="departmentName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Libellé</label>
				<div class="col-sm-10">
					<form:input path="departmentName" type="text" class="form-control "
						id="departmentName" placeholder="departmentName" />
					<form:errors path="departmentName" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="locations">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Location</label>
				<div class="col-sm-5">
					<form:select path="locations" class="form-control">
						<form:options items="${locList}" itemValue="locationId"
							itemLabel="streetAddress" />
					</form:select>
					<form:errors path="locations" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>


		<spring:bind path="employees">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Manager</label>
				<div class="col-sm-5">
					<form:select path="employees" class="form-control">
						<form:options items="${empList}" itemValue="employeeId"
							itemLabel="firstName" />
					</form:select>
					<form:errors path="employees" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${depForm['new']}">
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