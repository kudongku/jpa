package jdbc;

import jdbc.dao.AccountDAO;
import jdbc.vo.AccountVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest {

    @Test
    void jdbcTest() {
        // given
        String url = "jdbc:postgresql://localhost:5432/messenger";
        String username = "teasun";
        String password = "pass";

        // when
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String createSql = "CREATE TABLE ACCOUNT (id SERIAL PRIMARY KEY, username varchar(255), password varchar(255))";
            PreparedStatement statement = connection.prepareStatement(createSql);
            statement.execute();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("JDBC 삽입/조회 실습")
    void jdbcInsertSelectTest() throws SQLException {
        // given
        String url = "jdbc:postgresql://localhost:5432/messenger";
        String username = "teasun";
        String password = "pass";

        // when
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection created: " + connection);

            String insertSql = "INSERT INTO ACCOUNT (id, username, password) VALUES (1, 'user1', 'pass1')";
            try (PreparedStatement statement = connection.prepareStatement(insertSql)) {
                statement.execute();
            }

            // then
            String selectSql = "SELECT * FROM ACCOUNT";
            try (PreparedStatement statement = connection.prepareStatement(selectSql)) {
                var result = statement.executeQuery();
                while (result.next()) {
                    System.out.printf("%d, %s, %s%n", result.getInt(1), result.getString(2),
                            result.getString(3));
                }
            }
        }
    }

    @Test
    @DisplayName("JDBC DAO 삽입/조회 실습")
    void jdbcDAOInsertSelectTest() {
        // given
        AccountDAO accountDAO = new AccountDAO();

        // when
        Integer id = accountDAO.insertAccount(new AccountVO("new user", "new password"));

        // then
        var account = accountDAO.selectAccount(id);
        assert account.getUsername().equals("new user");
    }


//    @Test
//    @DisplayName("SQL Mapper - JDBC Template 실습")
//    void sqlMapper_JDBCTemplateTest() throws SQLException {
//        // given
//        String url = "jdbc:postgresql://localhost:5432/messenger";
//        String username = "teasun";
//        String password = "pass";
//
//        // when
//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            System.out.println("Connection created: " + connection);
//
//            // then
//            String selectSql = "SELECT * FROM ACCOUNT";
//            try (PreparedStatement statement = connection.prepareStatement(selectSql)) {
//                var rs = statement.executeQuery();
//                while (rs.next()) {
//
//                }
//            }
//        }
//    }
}
