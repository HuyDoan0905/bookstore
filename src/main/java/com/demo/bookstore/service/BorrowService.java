package com.demo.bookstore.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.demo.bookstore.dao.BorrowDao;
import com.demo.bookstore.dto.BorrowDTO;



public class BorrowService {
    private BorrowDao borrowDao;

    public BorrowService(Connection connection) {
        this.borrowDao = new BorrowDao(connection);
    }

    // Method to get all borrow records
    public List<BorrowDTO> getAllBorrowRecords() throws SQLException {
        return borrowDao.getAllBorrowRecords();
    }

    // Method to add a new borrow record
    public boolean addNewBorrowRecord(BorrowDTO newBorrowRecord) throws SQLException {
        return borrowDao.addNewBorrowRecord(newBorrowRecord);
    }

    // Method to delete a borrow record
    public boolean deleteBorrowRecord(int borrowID) throws SQLException {
        return borrowDao.deleteBorrowRecord(borrowID);
    }
}
