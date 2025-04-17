/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 * Classe que representa o arquivo aberto/criado.
 * @author XvierDev
 */
public class CurrentFile {
    private String fileName;
    private String filePath;
    private boolean saved;
    public String content;
    
    public CurrentFile(String fileName, String filePath, boolean isSaved){
        this.fileName = fileName;
        this.filePath = filePath;
        this.saved = isSaved;
    }
    
    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }
        
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }   
}
