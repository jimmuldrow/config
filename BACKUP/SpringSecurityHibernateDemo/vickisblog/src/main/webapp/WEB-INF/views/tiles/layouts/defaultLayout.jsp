<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 
<html>
 
<head>
</head>
  
<body>
           <div style="text-align: center;"><tiles:insertAttribute name="header" /></div>  
            <div style="float:left;padding:10px;width:15%;"><tiles:insertAttribute name="menu" /></div>  
            <div style="float:left; padding:10px;width:80%;border-left:1px solid blue;">  
            <tiles:insertAttribute name="body" /></div>  
            <div style="clear:both; text-align: center;"><tiles:insertAttribute name="footer" /></div>  
</body>
</html>