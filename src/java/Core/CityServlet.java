/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Core;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author ad
 */
//@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //
    private ArrayList<City> cities;

    @Override
    public void init() throws ServletException {
        //create 2 list inhabitants
        ArrayList<Inhabitant> list_fra = new ArrayList<>();
        ArrayList<Inhabitant> list_zur = new ArrayList<>();
        //add ppl into lists
        Inhabitant john = new Inhabitant("john", "1111", "married");
        Inhabitant mary = new Inhabitant("mary", "2222", "not married");
        list_fra.add(mary);
        list_fra.add(john);
        Inhabitant mark = new Inhabitant("mark", "3333", "married");
        Inhabitant silvie = new Inhabitant("silvie", "44444", "married");
        list_zur.add(mark);
        list_zur.add(silvie);
        //create 2 cities
        City frankfurt = new City("frankfurt", list_fra);
        City zurich = new City("zurich", list_zur);

        cities = new ArrayList<>();
        //add city in
        cities.add(frankfurt);
        cities.add(zurich);
        //set attributes to cities
        getServletContext().setAttribute("cities", cities);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String cityName = request.getParameter("cityName");

        if (action != null && cityName != null) {
            switch (action) {
                case "searchInhabitant" -> {
                    String inhabitantName = request.getParameter("inhabitantName");
                    if (inhabitantName != null && !inhabitantName.isEmpty()) {
                        City city = getCityByName(cityName);
                        if (city != null) {
                            Inhabitant inhabitant = city.searchLocal(inhabitantName);
                            if (inhabitant != null) {
                                response.setContentType("text/html");
                                try (PrintWriter out = response.getWriter()) {
                                    out.println("<html><head><title>Search Result</title></head><body>");
                                    out.println("<h2>Search Result</h2>");
                                    out.println("<p>Inhabitant Found: " + inhabitant.getName() + ", " + inhabitant.getDob() + ", " + inhabitant.getMarried() + "</p>");
                                    out.println("<a href=\"index.html\">Back</a>");
                                    out.println("</body></html>");
                                }
                            } else {
                                response.setContentType("text/html");
                                try (PrintWriter out = response.getWriter()) {
                                    out.println("<html><head><title>Search Result</title></head><body>");
                                    out.println("<h2>Search Result</h2>");
                                    out.println("<p>Inhabitant not found in " + cityName + "</p>");
                                    out.println("<a href=\"index.html\">Back</a>");
                                    out.println("</body></html>");
                                }
                            }
                        } else {
                            response.sendRedirect("index.html"); // City not found
                        }
                    } else {
                        response.sendRedirect("index.html"); // Inhabitant name parameter missing
                    }
                }
                case "listInhabitants" -> {
                    City city = getCityByName(cityName);
                    if (city != null) {
                        ArrayList<Inhabitant> inhabitants = city.getListInhabitants();
                        response.setContentType("text/html");
                        try (PrintWriter out = response.getWriter()) {
                            out.println("<html><head><title>List of Inhabitants</title></head><body>");
                            out.println("<h2>List of Inhabitants in " + cityName + "</h2>");
                            out.println("<ul>");
                            for (Inhabitant i : inhabitants) {
                                out.println("<li>" + i.getName() + " - " + i.getDob() + " - " + i.getMarried() + "</li>");
                            }
                            out.println("</ul>");
                            out.println("<a href=\"index.html\">Back</a>");
                            out.println("</body></html>");
                        }
                    } else {
                        response.sendRedirect("index.html");
                    }
                }
                default ->
                    response.sendRedirect("index.html");
            }
        } else {
            response.sendRedirect("index.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String cityName = request.getParameter("cityName");

        if ("addInhabitant".equals(action) && cityName != null) {
            City city = getCityByName(cityName);
            if (city != null) {
                String name = request.getParameter("name");
                String dob = request.getParameter("dob");
                String maritalStatus = request.getParameter("maritalStatus");
                city.addInhabitant(name, dob, maritalStatus);
                response.setContentType("text/html");
                try (PrintWriter out = response.getWriter()) {
                    out.println("<html><head><title>Add Result</title></head><body>");
                    out.println("<h2>Add Result</h2>");
                    out.println("<p>Inhabitant added: " + name + ", " + dob + ", " + maritalStatus + "</p>");
                    out.println("<a href=\"index.html\">Back</a>");
                    out.println("</body></html>");
                    //response.sendRedirect("index.html");
                }
            } else {
//                response.sendRedirect("index.html");
                try (PrintWriter out = response.getWriter()) {
                    out.println("<html><head><title>Add Result</title></head><body>");
                    out.println("<h2>Add Result</h2>");
                    out.println("<p>Error Adding</p>");
                    out.println("<a href=\"index.html\">Back</a>");
                    out.println("</body></html>");
                }
            }
        }
        else{
            response.sendRedirect("index.html");
        }
    }
    //function to get city by name

    private City getCityByName(String cityName) {
        for (City city : cities) {
            if (city.getCityName().equalsIgnoreCase(cityName)) {
                return city;
            }
        }
        return null;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
