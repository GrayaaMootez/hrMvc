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

	<h1>job History Detail</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">Employee</label>
		<div class="col-sm-10">${hist.employees.firstName}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Start Date</label>
		<div class="col-sm-10">${hist.id.dateDeb}</div>
	</div>


	<div class="row">
		<label class="col-sm-2">Departement</label>
		<div class="col-sm-10">${hist.departments.departmentName}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Job</label>
		<div class="col-sm-10">${hist.jobs.jobTitle}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">End Date</label>
		<div class="col-sm-10">${hist.dateFin}</div>
	</div>



</div>
</body>
</html>