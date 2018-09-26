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

	<h1>Location Detail</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">Code</label>
		<div class="col-sm-10">${location.locationId}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Adress</label>
		<div class="col-sm-10">${location.streetAddress}</div>
	</div>


	<div class="row">
		<label class="col-sm-2">Postal Code</label>
		<div class="col-sm-10">${location.postalCode}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">City</label>
		<div class="col-sm-10">${location.city}</div>
	</div>


	<div class="row">
		<label class="col-sm-2">Province</label>
		<div class="col-sm-10">${location.stateProvince}</div>
	</div>
	
		<div class="row">
		<label class="col-sm-2">Country</label>
		<div class="col-sm-10">${location.countries.countryName}</div>
	</div>

</div>

</body>
</html>