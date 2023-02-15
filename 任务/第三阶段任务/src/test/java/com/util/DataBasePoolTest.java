package com.util;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;


public class DataBasePoolTest {
    @Test
    void TestGetConnection() throws InterruptedException, SQLException {

        DateBasePool dateBasePool = new DateBasePool();

        for (int i = 0; i < 50; i++) {
            Connection connection = dateBasePool.getConnection();
            System.out.println("第" + i + "个 " + connection);
            if (i % 2 == 0 && connection != null) {
                connection.close();
            }
        }




    }
}
