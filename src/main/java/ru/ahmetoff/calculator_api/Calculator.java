package ru.ahmetoff.calculator_api;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculator", value = "/calculator")
public class Calculator extends HttpServlet {
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String operation = request.getParameter("operation");
        float a = Float.parseFloat(request.getParameter("a"));
        float b = Float.parseFloat(request.getParameter("b"));
        float answer = 0;

        if (operation.equals("sum")) {
            answer = a + b;
        } else if (operation.equals("sub")) {
            answer = a - b;
        } else if (operation.equals("mul")) {
            answer = a * b;
        } else if (operation.equals("div")) {
            answer = a / b;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>" + String.format("%.2f", answer) + "<h1>");
    }

    public void destroy() {

    }
}
