<%@ page language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTL-8">
<title></title>
<s:head />
</head>
<body>
<h2>Login</h2>
        <s:form action="welcome" >
            <s:textfield name="userForm.userName" label="User Name" />
            <s:textfield name="userForm.password" label="Password" />
            <s:submit />
        </s:form>
</body>
</html>