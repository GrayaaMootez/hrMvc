<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<br />
<br />
<div class="container">

	<div class="panel panel-default">
		<div class="panel-heading">User Detail</div>
		<div class="panel-body">

			<c:if test="${not empty msg}">
				<div class="alert alert-${css} alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>${msg}</strong>
				</div>
			</c:if>

			<div class="row">
				<label class="col-sm-2">Code</label>
				<div class="col-sm-10">${countrie.countryId}</div>
			</div>

			<div class="row">
				<label class="col-sm-2">Libell�</label>
				<div class="col-sm-10">${countrie.countryName}</div>
			</div>


			<div class="row">
				<label class="col-sm-2">Region</label>
				<div class="col-sm-10">${countrie.regions.regionName}</div>
			</div>
		</div>
	</div>

</div>

</body>
</html>