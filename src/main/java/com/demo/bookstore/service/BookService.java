package com.demo.bookstore.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.bookstore.dao.BookDao;

import com.demo.bookstore.dto.BookDTO;


public class BookService {
    private BookDao bookDao;


    public BookService(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.bookDao = new BookDao(jdbcURL, jdbcUsername, jdbcPassword);
    }


    public List<BookDTO> getAllBooks() throws SQLException {
        return this.bookDao.getAllBooks();
    }

    /*// Phương thức để thêm một cuốn sách mới vào cơ sở dữ liệu
    public boolean addNewBook(BookDTO newBook) throws SQLException {
        return bookDao.addNewBook(newBook);
    }

    // Phương thức để cập nhật thông tin của một cuốn sách đã tồn tại trong cơ sở dữ liệu
    public boolean updateBook(BookDTO book) throws SQLException {
        return bookDao.updateBook(book);
    }

    // Phương thức để lấy thông tin của một cuốn sách dựa trên ID của nó
    public BookDTO getBookById(int id) throws SQLException {
        return bookDao.getBookById(id);
    }*/
}
