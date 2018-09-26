<%@ attribute name="list" required="true" type="java.util.List"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/css/menu.css" var="menuCss" />
<spring:url value="/resources/js/menu.js" var="menuJs" />

<link href="${menuCss}" rel="stylesheet" />
<li><c:if test="${!empty list}">
		<ul>
			<c:forEach var="folderGroup" items="${list}">
				<a href="#">${folderGroup.menuName}</a>
				<myTags:nodeTree list="${folderGroup.menuTrees}" />
			</c:forEach>
		</ul>
	</c:if></li>
