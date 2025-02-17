//package main.java.project;
//
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//public class mongo extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.getWriter().println("<h1>MongoDB Data</h1>");
//
//        // Connect to MongoDB (ensure MongoDB is running locally on default port)
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        MongoDatabase database = mongoClient.getDatabase("myDatabase");  // Replace with your database name
//        MongoCollection<Document> collection = database.getCollection("myCollection");  // Replace with your collection name
//
//        // Retrieve a document (you can modify this to query the collection)
//        Document document = collection.find().first();  // Retrieve the first document
//
//        if (document != null) {
//            response.getWriter().println("<p>Document: " + document.toJson() + "</p>");
//        } else {
//            response.getWriter().println("<p>No data found in MongoDB collection.</p>");
//        }
//
//        mongoClient.close(); // Close the MongoDB connection
//    }
//}
