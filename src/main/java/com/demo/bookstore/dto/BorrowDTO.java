package com.demo.bookstore.dto;

import java.time.LocalDate;

public class BorrowDTO {
    private int BorrowID;
    private int StudentID;
    private int BookID;
    private int Quantity;
    private LocalDate BorrowDate;

    public BorrowDTO(int borrowID, int studentID, int bookID, int quantity, LocalDate borrowDate) {
        this.BorrowID = borrowID;
        this.StudentID = studentID;
        this.BookID = bookID;
        this.Quantity = quantity;
        this.BorrowDate = borrowDate;
    }

    public int getBorrowID() {
        return BorrowID;
    }

    public void setBorrowID(int borrowID) {
        this.BorrowID = borrowID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        this.StudentID = studentID;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        this.BookID = bookID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }

    public LocalDate getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.BorrowDate = borrowDate;
    }
}
