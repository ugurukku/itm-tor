package com.ugurukku.itmtor.servlet;

import com.ugurukku.itmtor.repository.GeneralDaoImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FinancialConditionServlet",value = "/maliyye-veziyyeti",asyncSupported = true)
public class FinancialConditionServlet extends HttpServlet {

  private final GeneralDaoImpl incomesDao;

  public FinancialConditionServlet() {
    incomesDao = GeneralDaoImpl.getInstance();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("rows",incomesDao.getAllFinancialConditionData());
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("financial_condition.jsp");
    requestDispatcher.forward(request, response);
  }
}
