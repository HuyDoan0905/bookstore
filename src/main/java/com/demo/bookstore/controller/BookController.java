package com.demo.bookstore.controller;

import com.demo.bookstore.dto.BookDTO;
import com.demo.bookstore.service.BookService;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BookController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BookService bookService;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("dbURL");
        String jdbcUsername = getServletContext().getInitParameter("dbUsername");
        String jdbcPassword = getServletContext().getInitParameter("dbPassword");

        this.bookService = new BookService(jdbcURL, jdbcUsername, jdbcPassword);

    }

    public BookController(){

    };
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<BookDTO> listBook = this.bookService.getAllBooks();

            request.setAttribute("listBook", listBook);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        catch (SQLException e){
            e.printStackTrace();
        };

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void getListBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        List<BookDTO> listBook = this.bookService.getAllBooks();

        request.setAttribute("listBook", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    /*private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDTO existingBook = this.productService.getProductById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("newProductForm.jsp");
        request.setAttribute("product", existingBook);
        dispatcher.forward(request, response);

    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String des = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));

        ProductDTO newProduct = new ProductDTO(id, name, des, price);
        this.productService.updateProduct(newProduct);
        response.sendRedirect("product");
    }*/
}

