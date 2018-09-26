<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<li><a href="#">${menuitem.menuName}</a> <c:if
		test="${fn:length(menuitem.menuTrees) gt 0}">
		<ul class="droprightMenu">
			<c:forEach var="menuitem" items="${menuitem.menuTrees}">
				<c:set var="menuitem" value="${menuitem}" scope="request" />
				<jsp:include page="test.jsp" />
			</c:forEach>
		</ul>
	</c:if></li>