package com.ugurukku.itmtor.servlet;

import com.ugurukku.itmtor.repository.GeneralRepository;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConsumptionStructureServlet", value = "/maliyye-istehlakin-strukturu", asyncSupported = true)
public class ConsumptionStructureServlet extends HttpServlet {

  private final GeneralRepository incomesDao;

  public ConsumptionStructureServlet() {
    incomesDao = GeneralRepository.getInstance();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("rows",incomesDao.getAllRawConsumptionStructureData());
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("consumption_structure.jsp");
    requestDispatcher.forward(request, response);
  }
}
