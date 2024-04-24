package com.demo.bookstore.dto;

public class BookDTO {
    private int BookID;
    private String Name;
    private int TotalPage;
    private String Type;
    private int Quantity;

    public BookDTO(int bookID, String name, int totalPage, String type, int quantity) {
        this.BookID = bookID;
        this.Name = name;
        this.TotalPage = totalPage;
        this.Type = type;
        this.Quantity = quantity;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        this.BookID = bookID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getTotalPage() {
        return TotalPage;
    }

    public void setTotalPage(int totalPage) {
        this.TotalPage = totalPage;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }
}

