package DaoManager;

import Factory.ConnectionFactory;
import entities.PromptForm;
import enums.PromptType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PromptDao {

    private Connection connection;

    public PromptDao() {
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

    public String getPrompt(int type) {
        String sql = "SELECT code FROM prompt WHERE description = ?";
        StringBuilder allPromptCodes = new StringBuilder();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            String description = PromptType.getByCodigo(type).toString();
            stmt.setString(1, description);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String currentCode = rs.getString("code");
                    if (currentCode != null) {
                        allPromptCodes.append(currentCode);
                        if (!rs.isLast()) {
                            allPromptCodes.append("\n");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PromptDao.class.getName()).log(java.util.logging.Level.SEVERE, "Erro ao obter prompts: " + ex.getMessage(), ex);
        } catch (IllegalArgumentException e) {
            Logger.getLogger(PromptDao.class.getName()).log(java.util.logging.Level.WARNING, () -> "Tipo de prompt inválido: " + type + ". " + e.getMessage());
        }
        return allPromptCodes.toString();
    }

    public static void main(String[] args) {
        PromptDao pd = new PromptDao();
        System.out.println(pd.getPrompt(0));
    }
}
