/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
/**
 *
 * @author Fatec
 */
public class SugestaoDAO {

    public void inserirSugestao(String codigoOriginal, String melhoriaSugerida) {
        String sql = "INSERT INTO melhorias (codigo_original, melhoria_sugerida, data_sugestao, utilizada) VALUES (?, ?, ?, ?)";
        
        // Usamos try-with-resources para garantir o fechamento automático da Connection e do PreparedStatement
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root","fatec");
             PreparedStatement ps = connection.prepareStatement(sql)) {
             
            ps.setString(1, codigoOriginal);
            ps.setString(2, melhoriaSugerida);
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            
// Inicia a sugestão como não utilizada
            ps.setBoolean(5, false);
            
            // Execução da query
            ps.executeUpdate();
            // Essa linha pode ser substituida por uma JPanel padrão.
            System.out.println("Sugestão armazenada com sucesso.");
             
        } catch (SQLException e) {
            // Trate a exceção adequadamente (pode ser um log ou uma mensagem mais elaborada)
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
    // Se precisar realizar mais operações (como atualização ou exclusão de sugestões),
    // métodos adicionais podem ser acrescentados na mesma classe.
}
