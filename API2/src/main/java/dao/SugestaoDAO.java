/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Fatec
 */
public class SugestaoDAO {

    public void inserirSugestao(String codigoOriginal, String melhoriaSugerida) {
        String sql = "INSERT INTO melhorias (codigo_original, melhoria_sugerida, data_sugestao, utilizada) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root","fatec");
             PreparedStatement ps = connection.prepareStatement(sql)) {
             
            ps.setString(1, codigoOriginal);
            ps.setString(2, melhoriaSugerida);
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            
            ps.setBoolean(5, false);
            
            ps.executeUpdate();
            // Essa linha pode ser substituida por uma JPanel padrão.
            System.out.println("Sugestão armazenada com sucesso.");
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void marcarSugestaoComoUtilizada(int id) {
        String sql = "UPDATE melhorias SET utilizada = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root","fatec");
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public List<Sugestao> buscarSugestoesNaoUtilizadas() {
        List<Sugestao> sugestoes = new ArrayList<>();
        String sql = "SELECT id, codigo_original, melhoria_sugerida, data_sugestao, autor_sugestao "
                   + "FROM sugestoes WHERE utilizada = ? ORDER BY data_sugestao DESC";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root","fatec");
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setBoolean(1, false);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String codigoOriginal = rs.getString("codigo_original");
                String melhoriaSugerida = rs.getString("melhoria_sugerida");
                Timestamp dataSugestao = rs.getTimestamp("data_sugestao");
                

                Sugestao sugestao = new Sugestao(id, codigoOriginal, melhoriaSugerida, dataSugestao);
                sugestoes.add(sugestao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sugestoes;
    }
}
