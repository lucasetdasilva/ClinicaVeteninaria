/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Lucas Emanoel
 */
public class AdministradorDAO {
    
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastrarAdm(Administrador objadm){
        
        String sql = "insert into administrador(nome,email,senha) values (?,?,MD5(?))";
        
        conn = new ConexaoDAO().conectaBanco();
        
        try{
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, objadm.getNome());
            pstm.setString(2, objadm.getEmail());
            pstm.setString(3, objadm.getSenha());
            
            pstm.execute();
            pstm.close();
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            
            alert.setTitle("Salvamento de Dados");
            alert.setContentText("Seus dados foram salvos com sucesso !");
            alert.setHeaderText("Dados Salvos !");
            alert.showAndWait();
            
            
        } catch(SQLException e){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            
            alert.setTitle("Perda de Dados");
            alert.setContentText("Seus dados não foram salvos !");
            alert.setHeaderText("Ocorreu algum problema de processamento !");
            alert.showAndWait();
        }
        
        
    }
    
    
    
}
