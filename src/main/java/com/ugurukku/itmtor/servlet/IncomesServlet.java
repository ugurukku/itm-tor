package com.ugurukku.itmtor.servlet;

import com.ugurukku.itmtor.repository.IncomesDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IncomesServlet",value = "/home",asyncSupported = true)
public class IncomesServlet extends HttpServlet {

    private final IncomesDaoImpl incomesDao;

    public IncomesServlet() {
        incomesDao = IncomesDaoImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("incomesDtos",incomesDao.getAllIncomes());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("incomes.jsp");
        requestDispatcher.forward(request, response);
    }
}
