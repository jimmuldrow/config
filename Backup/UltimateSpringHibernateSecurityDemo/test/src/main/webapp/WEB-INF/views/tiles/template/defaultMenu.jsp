
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 
<nav>    
    <ul id="menu">
    	<li><a href="${pageContext.request.contextPath}/login">Log In</a></li>
        <li><a href="${pageContext.request.contextPath}/logout">Log Out</a></li>
        <li><a href="${pageContext.request.contextPath}/newuser">Register</a></li>
        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA') or hasRole('USER')">
        <li><a href="${pageContext.request.contextPath}/listPersonCC">Main</a></li>
        </sec:authorize>
    </ul>
</nav>