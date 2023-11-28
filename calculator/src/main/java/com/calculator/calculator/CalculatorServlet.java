package com.calculator.calculator;

import com.calculator.calculator.service.OperationService;
import com.calculator.calculator.service.impl.*;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/calculatorServlet")
public class CalculatorServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String numA = null;
        String numB = null;
        try {
            numA = request.getParameter("numberA");
            numB = request.getParameter("numberB");
        } catch(Exception e) {
            e.printStackTrace();
        }
        if (numA == null || numB == null) {
            request.setAttribute("msg", "Please enter the number A or B!!!");
            request.getRequestDispatcher("index.jsp").forward(request,response);
            return;
        }
        String operand = request.getParameter("operand");
        Integer numberA = Integer.parseInt(numA);
        Integer numberB = Integer.parseInt(numB);
        if (operand.equals("/") && numberB == 0) {
            request.setAttribute("msg", "Indeterminate");
            request.getRequestDispatcher("index.jsp").forward(request,response);
            return;
        }
        OperationService oper = null;
        switch (operand) {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationMinus();
                break;
            case "*":
                oper = new OperationMultiply();
                break;
            case "/":
                oper = new OperationDivision();
                break;
            case "^":
                oper = new OperationPower();
                break;
        }
        request.setAttribute("msg", "The calculation for " + numberA + " " + operand + " " + numberB + " is : " + oper.getResult(numberA, numberB));
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}