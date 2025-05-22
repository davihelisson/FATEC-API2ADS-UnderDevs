package DAO;

import Factory.ConnectionFactory;
import PromptForm.PromptForm;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class PromptDAO {
    private Connection connection;
    
    public PromptDAO(){
        this.connection = new ConnectionFactory().getConnection();
        
        try {
        Statement stmt = connection.createStatement();
        stmt.execute("USE api"); // Seleciona o banco manualmente
        stmt.close();
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao selecionar o banco de dados", e);
    }
    }
    
    public void salvaPrompt(PromptForm prompt){
        String sql = "INSERT INTO prompt(Descricao, Codigo) VALUES(?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, prompt.getDescricao());
            stmt.setString(2, prompt.getCodigo());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    public List<PromptForm> listarPrompts() {
        List<PromptForm> lista = new ArrayList<>();
        String sql = "SELECT Id_Prompt, descricao, codigo FROM prompt";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Id_Prompt");
                String descricao = rs.getString("descricao");
                String codigo = rs.getString("codigo");
                PromptForm prompt = new PromptForm(id, descricao, codigo);
                lista.add(prompt);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
        
    }

    public void atualizaPrompt(PromptForm prompt) {
        String sql = "UPDATE prompt SET descricao = ?, codigo = ? WHERE Id_Prompt = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, prompt.getDescricao());
            stmt.setString(2, prompt.getCodigo());
            stmt.setInt(3, prompt.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void deletaPrompt(int id) {
        String sql = "DELETE FROM prompt WHERE Id_Prompt = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
