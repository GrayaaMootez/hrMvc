<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<div class="container">

	<c:choose>
		<c:when test="${jobForm['new']}">
			<h1>Add Job</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Job</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/jobs" var="userActionUrl" />

	<form:form class="form-horizontal" method="post"
		modelAttribute="jobForm" action="${userActionUrl}">

		<spring:bind path="jobId">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Code</label>
				<div class="col-sm-10">
					<form:input path="jobId" type="text" class="form-control "
						id="jobId" placeholder="jobId" />
					<form:errors path="jobId" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="jobTitle">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Libellé</label>
				<div class="col-sm-10">
					<form:input path="jobTitle" type="text" class="form-control "
						id="jobTitle" placeholder="jobTitle" />
					<form:errors path="jobTitle" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="minSalary">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Min Salary</label>
				<div class="col-sm-10">
					<form:input path="minSalary" type="number" class="form-control "
						id="minSalary" placeholder="minSalary" />
					<form:errors path="minSalary" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<spring:bind path="maxSalary">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Max Salary</label>
				<div class="col-sm-10">
					<form:input path="maxSalary" type="number" class="form-control "
						id="maxSalary" placeholder="maxSalary" />
					<form:errors path="maxSalary" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${jobForm['new']}">
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