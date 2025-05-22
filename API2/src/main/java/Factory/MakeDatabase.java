package Factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MakeDatabase {

    private final Connection conn;

    public MakeDatabase() throws SQLException {
        this.conn = new Factory.ConnectionFactory().getConnection();
        String sql = "CREATE DATABASE IF NOT EXISTS api";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
    }
}
