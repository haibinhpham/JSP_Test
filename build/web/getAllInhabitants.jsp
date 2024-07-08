<%@ page import="Core.City, Core.Inhabitant" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Inhabitants</title>
</head>
<body>
    <h1>All Inhabitants</h1>

    <%-- Retrieve Frankfurt and Zurich from session --%>
    <%
        City frankfurtFromSession = (City) session.getAttribute("frankfurt");
        City zurichFromSession = (City) session.getAttribute("zurich");
    %>

    <h2>Frankfurt Inhabitants</h2>
    <%
        if (frankfurtFromSession != null) {
            for (Inhabitant inhabitant : frankfurtFromSession.getListInhabitants()) {
                out.println("Name: " + inhabitant.getName() + ", DOB: " + inhabitant.getDob() + ", Marital Status: " + inhabitant.getMarried() + "<br/>");
            }
        } else {
            out.println("No inhabitants found for Frankfurt.");
        }
    %>

    <h2>Zurich Inhabitants</h2>
    <%
        if (zurichFromSession != null) {
            for (Inhabitant inhabitant : zurichFromSession.getListInhabitants()) {
                out.println("Name: " + inhabitant.getName() + ", DOB: " + inhabitant.getDob() + ", Marital Status: " + inhabitant.getMarried() + "<br/>");
            }
        } else {
            out.println("No inhabitants found for Zurich.");
        }
    %>
</body>
</html>
