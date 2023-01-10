package DAO;

import DTO.Responsavel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Lucas Emanoel
 */
public class ResponsavelDAO {
    
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastroResp(Responsavel objresp){
        
        String sql = "insert into responsavel(cpf, nome, telefone, data_nascimento, email, senha) values (?, ?, ?, ?, ?, ?)";
        
        conn = new ConexaoDAO().conectaBanco();
        
        try{
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, objresp.getCpf());
            pstm.setString(2, objresp.getNome());
            pstm.setLong(3, objresp.getTelefone());
            pstm.setString(4, objresp.getData_nascimento());
            pstm.setString(5, objresp.getEmail());
            pstm.setString(6, objresp.getSenha());
            
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
