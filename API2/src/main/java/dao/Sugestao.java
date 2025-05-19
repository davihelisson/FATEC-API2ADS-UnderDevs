/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Fatec
 */
public class Sugestao {
    private int id;
    private String codigoOriginal;
    private String melhoriaSugerida;
    private Timestamp dataSugestao;
    
    
    public Sugestao(int id, String codigoOriginal, String melhoriaSugerida, Timestamp dataSugestao, String autorSugestao) {
        this.id = id;
        this.codigoOriginal = codigoOriginal;
        this.melhoriaSugerida = melhoriaSugerida;
        this.dataSugestao = dataSugestao;
    }

    Sugestao(int id, String codigoOriginal, String melhoriaSugerida, Timestamp dataSugestao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // Getters
    public int getId() { return id; }
    public String getCodigoOriginal() { return codigoOriginal; }
    public String getMelhoriaSugerida() { return melhoriaSugerida; }
    public Timestamp getDataSugestao() { return dataSugestao; }
    
}
