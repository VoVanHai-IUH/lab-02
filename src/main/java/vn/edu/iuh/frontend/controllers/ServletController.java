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
import vn.edu.iuh.frontend.model.ProductModel;

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
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.insertCust(req, resp);
                } else if (action.equals("insert_products")) {
                    ProductModel pm = new ProductModel();
                    pm.insertProduct(req, resp);
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
        try {
            Object actionObject = req.getParameter("action");
            if (actionObject != null) {
                String action = actionObject.toString();
                if (action.equals("cust_list")) {
                    resp.sendRedirect("customerListing.jsp");
                } else if (action.equals("delete_product")) {
                    ProductModel pm = new ProductModel();
                    pm.deleteProduct(req, resp);
                }
            } else {
                resp.sendRedirect("test.jsp");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
