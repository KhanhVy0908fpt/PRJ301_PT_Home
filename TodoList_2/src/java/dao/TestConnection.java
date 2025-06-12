package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=TodoList";
            String user = "sa";
            String pass = "12345";
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            
            if (conn != null) {
                System.out.println("✅ Kết nối CSDL thành công!");
            } else {
                System.out.println("❌ Kết nối CSDL thất bại!");
            }
        } catch (Exception e) {
            System.out.println("❌ Có lỗi khi kết nối:");
            e.printStackTrace();
        }
    }
}
