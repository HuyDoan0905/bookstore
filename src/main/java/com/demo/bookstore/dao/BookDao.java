package com.demo.bookstore.dao;



import com.demo.bookstore.dto.BookDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/**
 * Product DAO Implement.
 * @author giaule
 *
 */
public class BookDao {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;



    public BookDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        super();
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public List<BookDTO> getAllBooks() throws SQLException {
        List<BookDTO> listBook = new ArrayList<BookDTO>();

        String sql = "SELECT * FROM books";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("BookID");
            String name = resultSet.getString("Name");
            int totalPage = resultSet.getInt("TotalPage");
            String type = resultSet.getString("Type");
            int quantity = resultSet.getInt("Quantity");
            BookDTO book = new BookDTO(id, name, totalPage, type, quantity);
            listBook.add(book);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listBook;
    }


    /*@Override
    public boolean addNewProduct(ProductDTO newProduct) throws SQLException {
        String sqlInsert = "INSERT INTO product (name, description, price) VALUES (?, ?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sqlInsert);
        statement.setString(1, newProduct.getName());
        statement.setString(2, newProduct.getDescription());
        statement.setFloat(3, newProduct.getPrice());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    @Override
    public boolean updateProduct(ProductDTO product) throws SQLException {
        String sql = "UPDATE product SET name = ?, description = ?, price = ?  WHERE product_id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, product.getName());
        statement.setString(2, product.getDescription());
        statement.setFloat(3, product.getPrice());
        statement.setInt(4, product.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    @Override
    public boolean deleteProduct(ProductDTO product) throws SQLException {
        String sql = "DELETE FROM book where product_id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, product.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    @Override
    public ProductDTO getProductById(int id) throws SQLException {
        ProductDTO prod = null;
        String sql = "SELECT * FROM product WHERE product_id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String title = resultSet.getString("name");
            String author = resultSet.getString("description");
            float price = resultSet.getFloat("price");

            prod = new ProductDTO(id, title, author, price);
        }

        resultSet.close();
        statement.close();

        return prod;
    }
}
*/
}