package com.ugurukku.itmtor.servlet;

import com.ugurukku.itmtor.repository.GeneralDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IncomesServlet",value = "/gelirler",asyncSupported = true)
public class IncomesServlet extends HttpServlet {

    private final GeneralDaoImpl incomesDao;

    public IncomesServlet() {
        incomesDao = GeneralDaoImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("rows",incomesDao.getAllIncomesData());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("incomes.jsp");
        requestDispatcher.forward(request, response);
    }
}
