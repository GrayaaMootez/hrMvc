<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

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

	<h1>Employees Detail</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">Code</label>
		<div class="col-sm-10">${emp.employeeId}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">First Name</label>
		<div class="col-sm-10">${emp.firstName}</div>
	</div>


	<div class="row">
		<label class="col-sm-2">Last Name</label>
		<div class="col-sm-10">${emp.lastName}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Mail</label>
		<div class="col-sm-10">${emp.email}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Phone</label>
		<div class="col-sm-10">${emp.phoneNumber}</div>
	</div>


	<div class="row">
		<label class="col-sm-2">Hire Date</label>
		<div class="col-sm-10">${emp.hireDate}</div>
	</div>


	<div class="row">
		<label class="col-sm-2">Salary</label>
		<div class="col-sm-10">${emp.salary}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Comission Pct</label>
		<div class="col-sm-10">${emp.commissionPct}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Job</label>
		<div class="col-sm-10">${emp.jobs.jobTitle}</div>
	</div>


	<div class="row">
		<label class="col-sm-2">Manager</label>
		<div class="col-sm-10">${emp.employees.firstName}
			${emp.employees.lastName}</div>
	</div>


	<div class="row">
		<label class="col-sm-2">Departments</label>
		<div class="col-sm-10">${emp.departments.departmentName}"</div>
	</div>
</div>
</body>
</html>