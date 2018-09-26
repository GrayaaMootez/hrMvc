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

	<h1>Jobs Detail</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">Code</label>
		<div class="col-sm-10">${job.jobId}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Libellé</label>
		<div class="col-sm-10">${job.jobTitle}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Min Salary</label>
		<div class="col-sm-10">${job.minSalary}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Max Salary</label>
		<div class="col-sm-10">${job.maxSalary}</div>
	</div>
</div>
</body>
</html>