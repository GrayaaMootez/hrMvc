<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<div class="container">

	<c:choose>
		<c:when test="${empForm['new']}">
			<h1>Add Employees</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Employees</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/employees" var="userActionUrl" />

	<form:form class="form-horizontal" method="post"
		modelAttribute="empForm" action="${userActionUrl}">

		<form:hidden path="employeeId" />

		<spring:bind path="firstName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">First Name</label>
				<div class="col-sm-10">
					<form:input path="firstName" type="text" class="form-control "
						id="firstName" placeholder="firstName" />
					<form:errors path="firstName" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="lastName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Last Name</label>
				<div class="col-sm-10">
					<form:input path="lastName" type="text" class="form-control "
						id="lastName" placeholder="lastName" />
					<form:errors path="lastName" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="email">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Mail</label>
				<div class="col-sm-10">
					<form:input path="email" type="text" class="form-control "
						id="email" placeholder="email" />
					<form:errors path="email" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<spring:bind path="phoneNumber">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Phone</label>
				<div class="col-sm-10">
					<form:input path="phoneNumber" type="text" class="form-control "
						id="phoneNumber" placeholder="phoneNumber" />
					<form:errors path="phoneNumber" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<spring:bind path="hireDate">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Hire Date</label>
				<div class="col-sm-10">
					<form:input path="hireDate" type="date" class="form-control "
						id="hireDate" placeholder="hireDate" />
					<form:errors path="hireDate" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="salary">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Salary</label>
				<div class="col-sm-10">
					<form:input path="salary" type="number" class="form-control "
						id="salary" placeholder="salary" />
					<form:errors path="salary" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="commissionPct">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Comission Pct</label>
				<div class="col-sm-10">
					<form:input path="commissionPct" type="text" class="form-control "
						id="commissionPct" placeholder="commissionPct" />
					<form:errors path="commissionPct" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<spring:bind path="jobs">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Jobs</label>
				<div class="col-sm-5">
					<form:select path="jobs" class="form-control">
						<form:options items="${listJos}" itemValue="jobId"
							itemLabel="jobTitle" />
					</form:select>
					<form:errors path="jobs" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>

		<spring:bind path="employees">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Manager</label>
				<div class="col-sm-5">
					<form:select path="employees" class="form-control">
						<form:options items="${listEmp}" itemValue="employeeId"
							itemLabel="lastName" />
					</form:select>
					<form:errors path="employees" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>

		<spring:bind path="departments">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Departments</label>
				<div class="col-sm-5">
					<form:select path="departments" class="form-control">
						<form:options items="${listDeps}" itemValue="departmentId"
							itemLabel="departmentName" />
					</form:select>
					<form:errors path="departments" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${empForm['new']}">
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