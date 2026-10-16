package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!doctype html>");
            out.println("<html><head><meta charset='UTF-8'><title>Hello Java</title>");
            out.println("<style>body{font-family:Arial,sans-serif;max-width:720px;margin:60px auto;padding:0 20px;color:#202938}"
                    + ".card{padding:28px;border:1px solid #d7dee8;border-radius:12px;background:#f8fafc}"
                    + "h1{color:#166534}</style></head><body>");
            out.println("<div class='card'><h1>Hello from Java!</h1>");
            out.println("<p>Your Java Servlet is running successfully on a servlet container.</p>");
            out.println("<p><b>CI/CD practice:</b> commit this project to GitHub and let Jenkins build the WAR.</p>");
            out.println("</div></body></html>");
        }
    }
}
