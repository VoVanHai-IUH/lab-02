package vn.edu.iuh.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.backend.models.Customer;
import vn.edu.iuh.backend.services.CustomerServices;
import vn.edu.iuh.frontend.model.CustomerModel;
import vn.edu.iuh.frontend.model.EmployeeModel;

import java.io.IOException;
import java.util.List;

@WebServlet("/controls")
public class ServletController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object actionObject = req.getParameter("action");
            if (actionObject != null) {
                String action = actionObject.toString();
                if (action.equals("insertEmp")) {
                    EmployeeModel empModel = new EmployeeModel();
                    empModel.insertEmp(req, resp);
                } else if (action.equals("insertCust")) {
                    CustomerModel customerModel =new CustomerModel();
                    customerModel.insertCust(req,resp);
                }
            } else {
                resp.sendRedirect("customerListing.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object actionObject = req.getParameter("action");
        if (actionObject != null) {
            String action = actionObject.toString();
            if(action.equals("cust_list")){
               /* CustomerServices services =new CustomerServices();
                List<Customer> lst = services.getAll();
                HttpSession session =req.getSession(true);
                session.setAttribute("customers",lst);*/
                resp.sendRedirect("customerListing.jsp");
            }else{

            }
        } else {
            resp.sendRedirect("test.jsp");
        }
    }
}
