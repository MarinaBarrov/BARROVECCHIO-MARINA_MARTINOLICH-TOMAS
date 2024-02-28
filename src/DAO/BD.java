package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class BD {

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/odontologo",
                "sa", "sa");
    }
}
