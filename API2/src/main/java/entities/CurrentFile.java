/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.File;
import javax.swing.JOptionPane;

/**
 * Classe que representa o arquivo aberto/criado.
 *
 * @author XvierDev
 */
public class CurrentFile {

    private String fileName;
    private String filePath;
    private boolean saved;
    public String content;

    public CurrentFile(String fileName, String filePath, boolean isSaved) {
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

    public String getFullPath() {
        try {
            File file;
            if (filePath != null) {
                if (fileName != null){
                    file = new File(filePath, fileName);
                }
                else file = new File(filePath);
            }
            else{
                file = new File(System.getProperty("user.home"));
            }
            return file.getAbsolutePath();
        } catch (NullPointerException ex) {
            File file = new File(System.getProperty("user.home"));
            return file.getAbsolutePath();
        }
    }

    public boolean hasModifications(String content) {
        if (!this.content.equals(content)) {
            return true;
        } else {
            this.saved = false;
            return false;
        }
    }
}
