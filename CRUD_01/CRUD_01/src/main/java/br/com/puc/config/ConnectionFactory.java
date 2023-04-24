//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.puc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private ConnectionFactory() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost/instituicaoBD", "postgres", "013576");
        } catch (SQLException var1) {
            throw new RuntimeException(var1);
        }
    }
}
