package com.tcma.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * A sample servlet
 * </p>
 *
 * <p>
 * The servlet is registered and mapped to /SampleServlet using the {@linkplain WebServlet
 * @HttpServlet}.
 * </p>
 *
 * @author Ting-Chong Ma
 */
@SuppressWarnings("serial")
@WebServlet("/health")
public class HealthServlet extends HttpServlet {
    static String PAGE_HEADER = "<html><head><title>Health Servlet</title></head><body>";
    static String PAGE_FOOTER = "</body></html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(PAGE_HEADER);
        writer.println("<h1>Hi.</h1>");
        writer.println("Date is " + new java.util.Date().toString() + " at the server.");
        writer.println(PAGE_FOOTER);
        writer.close();
    }
}