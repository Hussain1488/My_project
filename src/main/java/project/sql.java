package main.java.project;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sql extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>MySQL Data</h1>");

        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/myDatabase";  // Replace with your database URL
        String jdbcUsername = "root";  // Replace with your MySQL username
        String jdbcPassword = "password";  // Replace with your MySQL password

        // Create connection
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM myTable";  // Replace with your table name and query
            ResultSet resultSet = statement.executeQuery(query);

            // Loop through the result set and display the data
            while (resultSet.next()) {
                String data = resultSet.getString("column_name");  // Replace 'column_name' with your column name
                response.getWriter().println("<p>Data: " + data + "</p>");
            }

            resultSet.close();
            statement.close();
            connection.close(); // Close the MySQL connection
        } catch (Exception e) {
            response.getWriter().println("<p>Error connecting to MySQL: " + e.getMessage() + "</p>");
            e.printStackTrace();
        }
    }
}