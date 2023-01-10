/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Lucas Emanoel
 */
public class ConexaoDAO {
    
    public Connection conectaBanco(){
        
        Connection conn = null;
        
        try{
            String url = "jdbc:mysql://localhost/clinica?user=root&password=";
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            
            alert.setTitle("Conexão com Banco de Dados");
            alert.setContentText("Não foi possível se conectar com o Banco de Dados");
            alert.setHeaderText("Alerta de Erro !");
            alert.showAndWait();
        }
     
        return conn;
    }
    
}
