/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Veteninario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Lucas Emanoel
 */
public class VeteninarioDAO {
    
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastrarVet(Veteninario objvet){
        
        String sql = "insert into veteninario(cpf, nome, telefone, email, senha) values (?, ?, ?, ?, MD5(?))";
        
        conn = new ConexaoDAO().conectaBanco();
        
        try{
            
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, objvet.getCpf());
            pstm.setString(2, objvet.getNome());
            pstm.setLong(3, objvet.getTelefone());
            pstm.setString(4, objvet.getEmail());
            pstm.setString(5, objvet.getSenha());
            
            pstm.execute();
            pstm.close();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            
            alert.setTitle("Salvamento de Dados");
            alert.setContentText("Seus dados foram salvos com sucesso !");
            alert.setHeaderText("Dados Salvos !");
            alert.showAndWait();
            
        } catch(SQLException e){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            
            alert.setTitle("Falha no Salvamento");
            alert.setContentText("Seus dados não foram salvos !");
            alert.setHeaderText("Algo não correu como o planejado !");
            alert.showAndWait();
            
        }
        
    }
    
    public ResultSet loginVet(Veteninario objvet){
        
        String query = "select * from veteninario where cpf = ? and senha = MD5(?)";
        
        conn = new ConexaoDAO().conectaBanco();
        
        try{
           
            pstm = conn.prepareStatement(query);
            
            pstm.setString(1, objvet.getCpf());
            pstm.setString(2, objvet.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            
            return rs;
            
        } catch(SQLException e){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            
            alert.setTitle("Login");
            alert.setContentText("Não foi possível realizar o Login !");
            alert.setHeaderText("CPF ou senha invalidos !");
            alert.showAndWait();
            return null;
        }
        
    }
    
}
