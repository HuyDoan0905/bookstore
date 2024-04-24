package com.demo.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.bookstore.dto.BorrowDTO;

public class BorrowDao {
    private Connection connection;

    public BorrowDao(Connection connection) {
        this.connection = connection;
    }

    // Method to retrieve all borrow records from the database
    public List<BorrowDTO> getAllBorrowRecords() throws SQLException {
        List<BorrowDTO> borrowRecords = new ArrayList<>();
        String query = "SELECT * FROM borrow_records";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int borrowID = resultSet.getInt("BorrowID");
                int studentID = resultSet.getInt("StudentID");
                int bookID = resultSet.getInt("BookID");
                int quantity = resultSet.getInt("Quantity");
                // Assuming you have a borrowDate column in your borrow_records table
                java.sql.Date borrowDate = resultSet.getDate("BorrowDate");

                BorrowDTO borrowRecord = new BorrowDTO(borrowID, studentID, bookID, quantity, borrowDate.toLocalDate());
                borrowRecords.add(borrowRecord);
            }
        }

        return borrowRecords;
    }

    // Method to add a new borrow record to the database
    public boolean addNewBorrowRecord(BorrowDTO newBorrowRecord) throws SQLException {
        String query = "INSERT INTO borrow_records (StudentID, BookID, Quantity, BorrowDate) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, newBorrowRecord.getStudentID());
            statement.setInt(2, newBorrowRecord.getBookID());
            statement.setInt(3, newBorrowRecord.getQuantity());
            // Assuming borrowDate is of type LocalDate
            statement.setDate(4, java.sql.Date.valueOf(newBorrowRecord.getBorrowDate()));

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
    }

    // Method to delete a borrow record from the database by borrow ID
    public boolean deleteBorrowRecord(int borrowID) throws SQLException {
        String query = "DELETE FROM borrow_records WHERE BorrowID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, borrowID);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
    }
}
