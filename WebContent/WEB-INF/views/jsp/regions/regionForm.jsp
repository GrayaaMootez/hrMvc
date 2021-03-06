<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<div class="container">

	<c:choose>
		<c:when test="${regionForm['new']}">
			<h1>Add Region</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Region</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/regions" var="userActionUrl" />

	<form:form class="form-horizontal" method="post"
		modelAttribute="regionForm" action="${userActionUrl}">

		<form:hidden path="regionId" />

		<spring:bind path="regionName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<form:input path="regionName" type="text" class="form-control "
						id="regionName" placeholder="regionName" />
					<form:errors path="regionName" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${regionForm['new']}">
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