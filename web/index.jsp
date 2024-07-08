<%@ page import="Core.City , Core.Inhabitant, java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page session="true" %>

<%-- code for adding inhabitants to Frankfurt --%>
<%
    Inhabitant john = new Inhabitant();
    john.setName("john");
    john.setDob("1111");
    john.setMarried("married");
    ArrayList<Inhabitant> list_fra = new ArrayList<>();
    list_fra.add(john);
    
    City frankfurt = new City();
    frankfurt.setCityName("frankfurt");
    frankfurt.setListInhabitants(list_fra);
    session.setAttribute("frankfurt", frankfurt);
    
    out.println("Frankfurt set in session.<br/>");
%>

<%-- code for adding inhabitants to Zurich --%>
<%
    Inhabitant mark = new Inhabitant();
    mark.setName("mark");
    mark.setDob("3333");
    mark.setMarried("married");
    ArrayList<Inhabitant> list_zur = new ArrayList<>();
    list_zur.add(mark);
    
    City zurich = new City();
    zurich.setCityName("zurich");
    zurich.setListInhabitants(list_zur);
    session.setAttribute("zurich", zurich);
    out.println("Zurich set in session.<br/>");
%>

<!DOCTYPE html>
<html>
    <head>
        <title>City Management</title>
    </head>
    <body>
        <h1>City Management</h1>
        <p>Frankfurt: <%= session.getAttribute("frankfurt") %></p>
        <p>Zurich: <%= session.getAttribute("zurich") %></p>
        <h2>Page Attribute </h2>


        <h2>Print Inhabitants (Direct Access)</h2>
        <h3>Frankfurt Inhabitants</h3>
        <%
            City frankfurtFromSession = (City) session.getAttribute("frankfurt");
            if (frankfurtFromSession != null) {
                for (Inhabitant inhabitant : frankfurtFromSession.getListInhabitants()) {
                    out.println("Name: " + inhabitant.getName() + ", DOB: " + inhabitant.getDob() + ", Marital Status: " + inhabitant.getMarried() + "<br/>");
                }
            } else {
                out.println("No inhabitants found for Frankfurt.");
            }
        %>
        
        <h3>Zurich Inhabitants</h3>
        <%
            City zurichFromSession = (City) session.getAttribute("zurich");
            if (frankfurtFromSession != null) {
                for (Inhabitant inhabitant : zurichFromSession.getListInhabitants()) {
                    out.println("Name: " + inhabitant.getName() + ", DOB: " + inhabitant.getDob() + ", Marital Status: " + inhabitant.getMarried() + "<br/>");
                }
            } else {
                out.println("No inhabitants found for Zurich.");
            }
        %>
        <form action="getAllInhabitants.jsp" method="get">
            <h2>Print All Inhabitants</h2>
            <input type="submit" value="Print"/>
        </form>
    </body>
</html>
