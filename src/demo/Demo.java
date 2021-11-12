package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {

    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
    }
}
