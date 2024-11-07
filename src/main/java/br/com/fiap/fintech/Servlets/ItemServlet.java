package br.com.fiap.fintech.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/teste")
public class ItemServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the parameter from the request (this could be the item ID)
        String itemId = request.getParameter("itemId");

        // If an itemId is passed, show the details of the item
        if (itemId != null) {
            // Just an example, you can fetch the item from the database or any other source
            String itemDetail = "Details of item with ID: " + itemId;
            request.setAttribute("itemDetail", itemDetail);
            RequestDispatcher dispatcher = request.getRequestDispatcher("itemDetail.jsp");
            dispatcher.forward(request, response);
        } else {
            // Display the list of items
            List<String> itemList = new ArrayList<>();
            itemList.add("Item 1");
            itemList.add("Item 2");
            itemList.add("Item 3");

            request.setAttribute("itemList", itemList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("itemList.jsp");
            dispatcher.forward(request, response);
        }
    }
}
