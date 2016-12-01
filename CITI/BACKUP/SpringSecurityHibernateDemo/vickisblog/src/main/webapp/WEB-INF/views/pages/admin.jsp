<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
				   <!-- <h2>Welcome : ${pageContext.request.userPrincipal.name}
                 | <!-- <a href="<c:url value="/logout" />" > Logout</a></h2>-->
	</c:if>
</body>
</html>