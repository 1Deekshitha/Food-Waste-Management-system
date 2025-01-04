package com.servlet.fooddetails;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fooddetails")
public class FooddetailsServlet extends HttpServlet{

    //create the query
    private static final String INSERT_QUERY ="INSERT INTO DETAILS(RESTNAME,RESTLOCATION,CATEGORY,EMAIL,DATE,PLATES,IMG) VALUES(?,?,?,?,?,?,?)";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set Content type
        res.setContentType("text/hmtl");
        //read the form values
        String restname = req.getParameter("restname");
        String restlocation = req.getParameter("restlocation");
        String category = req.getParameter("category");
        String email = req.getParameter("email");
         String date = req.getParameter("date");
 String plates = req.getParameter("plates");
 String img = req.getParameter("img");
try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //create the connection
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///firstdb","root","Kavya@321");
                PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
            //set the values
            ps.setString(1, restname);
            ps.setString(2, restlocation);
            ps.setString(3, category);
            ps.setString(4, email);
            ps.setString(5, date);
              ps.setString(6, plates);
 ps.setString(7, img);
            //execute the query
            int count = ps.executeUpdate();

            if(count==0) {
            	res.sendRedirect("succe.html");
            }else {
            	res.sendRedirect("success.html");
            }
        }catch(SQLException se) {
            pw.println(se.getMessage());
            se.printStackTrace();
        }catch(Exception e) {
            pw.println(e.getMessage());
            e.printStackTrace();
        }

        //close the stream
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }
}
