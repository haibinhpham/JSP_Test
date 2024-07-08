
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@ page import="Core.City , Core.Inhabitant, java.util.ArrayList" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test usebean</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            ArrayList<Inhabitant> list_fra = new ArrayList<>();
            Inhabitant john = new Inhabitant("john","2222","married");
            list_fra.add(john);
            City frankfurt = new City("frankfurt",list_fra);
            pageContext.setAttribute("frankfurt",frankfurt);
        %>
        <!--usebean-->
        <jsp:useBean id="frankfurt" class="Core.City" scope="session"></jsp:useBean>
        <jsp:getProperty name="frankfurt" property="cityName"></jsp:getProperty>
    </body>
</html>
