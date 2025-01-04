package com.servletfetch;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
  
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/fetch")
public class FetchServlet extends HttpServlet {
 

 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     PrintWriter pw = res.getWriter();
     res.setContentType("text/html");


     HttpSession session = req.getSession();
     RequestDispatcher dispatcher = null;
     //load the jdbc driver
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         
     } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }

     try (Connection con = DriverManager.getConnection("jdbc:mysql:///firstdb", "root", "Kavya@321");
          PreparedStatement ps = con.prepareStatement("select * from details ");) {
         ResultSet rs = ps.executeQuery();

         pw.println("<html>");
         pw.println("<head><title>Uploaded Food Details</title></head>");
         pw.println("<style>");
         pw.println("body {");
         pw.println("    background-image: url('img2.jpg');");
         pw.println("    background-size: cover;");
         pw.println("}");
         pw.println("</style>");
         pw.println("<body>");
         pw.println("<h1>Uploaded Food Details</h1>");
         pw.println("<table border='4' width='60%' height='40%'>");
         pw.println("<tr>");
         pw.println("<th>RESTAURANT NAME</th>");
         pw.println("<th>RESTAURANT LOCATION</th>");
         pw.println("<th>CATEGORY</th>");
         pw.println("<th>CONTACT NUMBER</th>");
         pw.println("<th>DATE</th>");
         pw.println("<th>PLATES</th>");
         pw.println("</tr>");

         while (rs.next()) {
        	 String restname = rs.getString("restname");
             String restlocation = rs.getString("restlocation");
             String category = rs.getString("category");
             String email= rs.getString("email");
             String date = rs.getString("date");
             int plates= rs.getInt("plates");
            
             pw.println("<tr>");
             pw.println("<td>" +restname+ "</td>");
             pw.println("<td>" + restlocation + "</td>");
             pw.println("<td>" + category + "</td>");
             pw.println("<td>" + email + "</td>");
             pw.println("<td>" + date + "</td>");
             pw.println("<td>" + plates + "</td>");
             pw.println("</tr>");
         }

         pw.println("</table>");
         pw.println("</body>");
         pw.println("</html>");
     } catch (SQLException se) {
         pw.println(se.getMessage());
         se.printStackTrace();
     } catch (Exception e) {
         pw.println(e.getMessage());
         e.printStackTrace();
     }

     pw.close();
 }
 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     // TODO Auto-generated method stub
     doGet(req, resp);
 }

}


