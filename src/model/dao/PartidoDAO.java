package model.dao;

import conexao.Conexao;
import static conexao.Conexao.CloseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Partido;

/**
 *
 * @author Marcos
 */
public class PartidoDAO 
{
    //METODO PARA CADASTRAR PARTIDO
    public void Cadastrar_partido(Partido partido)
    {
        //INSTANCIANDO A CONEXAO E O STATEMENT
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            //VERIFICA SE O NOME DO PARTIDO FOI PREENCHIDO
            if("".equals(partido.getNome()))
            {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar partido!");
            }
            else
            {
                //CHAMANDO A PROCEDURE PARA INSERIR CANDIDATO
                stmt = con.prepareStatement("CALL sp_inserir_partido('"+ partido.getNome() +"')");
                
                //INSTANCIANDO O RESULT SET E EXECUTANDO A QUERY
                ResultSet rs = null;
                rs = stmt.executeQuery();
                
                //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
                while(rs.next())
                {
                    //RETORNANDO O ERRO OU ACERTO
                    JOptionPane.showMessageDialog(null, rs.getString("error_message"));
                }
            }
           
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar partido!"+ex);
        }
        finally
        {
            //FECHANDO CONEXAO E O STATEMENT
            CloseConnection(con,stmt);
        }
    }
    
    //METODO PARA DESATIVAR PARTIDO
    public void Desativar_partido(Partido partido)
    {
        //CHAMANDO A PROCEDURE PARA DESATIVAR PARTIDO
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            //CHAMANDO A PROCEDURE PARA DESATIVAR PARTIDO
            stmt = con.prepareStatement("CALL sp_update_partido("+partido.getId_partido()+")");
            
            //INSTANCIANDO O RESULT SET E EXECUTANDO A QUERY
            ResultSet rs = null;
            rs = stmt.executeQuery();
            
            //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
            while(rs.next())
            {
                //RETORNANDO O ERRO OU ACERTO
                JOptionPane.showMessageDialog(null, rs.getString("error_message"));
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao desativar candidato!"+ex);
        }
        finally
        {
            //FECHANDO CONEXAO E O STATEMENT
            CloseConnection(con,stmt);
        }
    }
    
    //METODO PARA MOSTRAR OS PARTIDOS CADASTRADOS
    public List<Partido> Mostrar_partidos()
    {
        //INSTANCIANDO A CONEXAO, STATEMENT E O RESULT SET
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        //CRIANDO UMA LIST DO TIPO PARTIDO PARA ARMAZENAR OS PARTIDOS ATIVOS
        List<Partido> par = new ArrayList<>();
        
        try 
        {
            //QUERY QUE RETORNARA O CANDIATO CADASTRADO E ATIVO
            stmt = con.prepareStatement("SELECT * FROM partido WHERE statuss = 1");
            
            //EXECUTANDO A QUERY
            rs = stmt.executeQuery();
            
            //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
            while(rs.next())
            {
                //INSTANCIANDO UM OBJETO PARTIDO PARA ARMAZENAR NA LIST
                Partido partido = new Partido();
                
                //PEGANDO OS COMPONENTES DO PARTIDO
                partido.setNome(rs.getString("nome"));
                partido.setId_partido(rs.getInt("Id_partido"));
                
                //ADICIONANDO O PARTIDO NA LIST
                par.add(partido);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            //FECHANDO CONEXAO E O STATEMENT
            Conexao.CloseConnection(con, stmt, rs);
        }
        
        //RETORNANDO A LIST
        return par;      
    }
}