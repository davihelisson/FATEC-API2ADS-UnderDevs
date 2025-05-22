package DaoManager;

import Factory.ConnectionFactory;
import entities.PromptForm;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PromptDAO {

    private Connection connection;

    public PromptDAO() {
        this.connection = new ConnectionFactory().getConnection();

        try {
            try (Statement stmt = connection.createStatement()) {
                stmt.execute("USE api");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar o banco de dados", e);
        }
    }

    public void salvaPrompt(PromptForm prompt) {
        String sql = "INSERT INTO prompt(description, code) VALUES(?, ?)";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, prompt.getDescricao());
                stmt.setString(2, prompt.getCodigo());
                stmt.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public List<PromptForm> listarPrompts() {
        List<PromptForm> list = new ArrayList<>();
        try {
            String sql = "SELECT Id_Prompt, description, code FROM prompt";
            try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("Id_Prompt");
                    String description = rs.getString("description");
                    String code = rs.getString("code");
                    PromptForm prompt = new PromptForm(id, description, code);
                    list.add(prompt);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;

    }

    public void atualizaPrompt(PromptForm prompt) {
        try {
            String sql = "UPDATE prompt SET description = ?, code = ? WHERE Id_Prompt = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, prompt.getDescricao());
                stmt.setString(2, prompt.getCodigo());
                stmt.setInt(3, prompt.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletaPrompt(int id) {
        try {
            String sql = "DELETE FROM prompt WHERE Id_Prompt = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
