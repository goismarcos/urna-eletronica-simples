package model.dao;

import conexao.Conexao;
import static conexao.Conexao.CloseConnection;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Eleitor;

/**
 *
 * @author Marcos
 */
public class EleitorDAO 
{
    //METODO PARA GERAR ELEITOR
    public void Gerar_eleitor()
    {
        //INSTANCIANDO A CONEXAO E O STATEMENT
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        int num_eleitor = -1;
        
        try 
        {
            //CHAMANDO A PROCEDURE PARA INSERIR CANDIDATO
            stmt = con.prepareStatement("CALL sp_inserir_eleitor()");

            //INSTANCIANDO O RESULT SET E EXECUTANDO A QUERY
            ResultSet rs = null;
            rs = stmt.executeQuery();

            //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
            while(rs.next())
            {
                //NUMERO ELEITOR
                num_eleitor = rs.getInt("value_return");
            }
            
            //RETORNANDO O NUMERO PARA PODER VOTAR
            JOptionPane.showMessageDialog(null, "Seu numero de eleitor para poder votar é : "+ num_eleitor);
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar eleitor!"+ex);
        }
        finally
        {
            //FECHANDO CONEXAO E O STATEMENT
            CloseConnection(con,stmt);
        }
    }
    
    //METODO PARA VERIFICAR SE HÁ UMA VOTAÇÃO
    public int Verifica_eleitor(Eleitor eleitor)
    {
        //INSTANCIANDO A CONEXAO, STATEMENT E O RESULT SET
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int total = 0;
        
        try
        {
            //QUERY QUE RETORNARA  CADASTRADO E ATIVO
            stmt = con.prepareStatement("SELECT COUNT(*) AS total FROM eleitor WHERE num_eleitor = "+eleitor.getNum_eleitor()+" AND statuss = 0");
                        
            //EXECUTANDO A QUERY
            rs = stmt.executeQuery();
            
            //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
            while(rs.next())
            {
                //PEGANDO O ELEITOR
                total = rs.getInt("total");
            }         
        }
        catch(HeadlessException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        finally
        {
            //FECHANDO CONEXAO E O STATEMENT
            Conexao.CloseConnection(con, stmt, rs);
        }
        
        //RETORNANDO O ELEITOR
        return total;
    }
    
    //METODO PARA DESABILITAR ELEITOR (NAO VOTAR MAIS QUE UMA VEZ)
    public void Desabilita_eleitor(Eleitor eleitor)
    {
        //INSTANCIANDO A CONEXAO, STATEMENT E O RESULT SET
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            //QUERY QUE RETORNARA  CADASTRADO E ATIVO
            stmt = con.prepareStatement("CALL sp_update_eleitor("+eleitor.getNum_eleitor()+")");
                        
            //EXECUTANDO A QUERY
            rs = stmt.executeQuery();
                   
        }
        catch(HeadlessException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        finally
        {
            //FECHANDO CONEXAO E O STATEMENT
            Conexao.CloseConnection(con, stmt, rs);
        }
    }
}