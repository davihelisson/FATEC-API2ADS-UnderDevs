package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    /**
     * Obtém uma conexão com o banco de dados MySQL.
     *
     * @return Uma instância de {@link Connection} conectada ao banco de dados
     * MySQL.
     * @throws RuntimeException Se ocorrer um erro de SQL ao tentar estabelecer
     * a conexão.
     */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "fatec");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
