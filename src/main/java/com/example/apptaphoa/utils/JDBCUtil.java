package com.example.apptaphoa.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JDBCUtil {
	public static Connection getConnection() {
        Connection c = null;

        try {
            // Các thông số
            String url = "jdbc:sqlserver://localhost:1433;database=AppTapHoa;encrypt=true;trustServerCertificate=true;";
            String username = "sa";
            String password = "Tri12092005";

            // Tạo kết nối
            c = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void testGetConnection() {
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            assertNotNull(conn, "Kết nối trả về là null");
            assertFalse(conn.isClosed(), "Kết nối đã bị đóng");
        } catch (Exception e) {
            fail("Không thể kết nối tới SQL Server: " + e.getMessage());
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = getConnection();
            if (conn != null && !conn.isClosed()) {
                System.out.println("Kết nối thành công tới SQL Server");
            } else {
                System.out.println("Kết nối thất bại");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi kết nối:");
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
    }

}
