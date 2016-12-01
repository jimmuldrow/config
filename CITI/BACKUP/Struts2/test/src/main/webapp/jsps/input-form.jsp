<%@ page language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTL-8">
<title></title>
</head>
<body>
<h2>Input Form</h2>
        <s:form action="error" >
            <s:textfield name="userForm.userName" label="User Name" />
            <s:submit />
        </s:form>
</body>
</html>