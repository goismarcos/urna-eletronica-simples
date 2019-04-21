package model.dao;

import conexao.Conexao;
import static conexao.Conexao.CloseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Candidato;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class CandidatoDAO 
{
    //METODO PARA CADASTRAR CANDIDATO
    public void Cadastrar_candidato(Candidato candidato)
    {
        //INSTANCIANDO A CONEXAO E O STATEMENT
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            //VERIFICA SE O NOME DO CANDIDATO FOI PREENCHIDO
            if("".equals(candidato.getNome()))
            {
                JOptionPane.showMessageDialog(null, "Erro: Digite o nome do candidato!");
            }
            else
            {
                //CHAMANDO A PROCEDURE PARA INSERIR CANDIDATO
                stmt = con.prepareStatement("CALL sp_inserir_candidatos('"+candidato.getNome()+"',"+candidato.getId_partido()+","+candidato.getId_cargo()+","+candidato.getNumero()+");");
                
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
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar candidato!"+ex);
        }
        finally
        {
            //FECHANDO CONEXAO E O STATEMENT
            CloseConnection(con,stmt);
        }
    }
    
    //METODO PARA DESATIVAR CANDIDATO
    public void Desativar_candidato(Candidato candidato)
    {
        //INSTANCIANDO A CONEXAO E O STATEMENT
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            //CHAMANDO A PROCEDURE PARA DESATIVAR CANDIDATO
            stmt = con.prepareStatement("CALL sp_update_candidatos("+candidato.getId_candidato()+")");
            
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
    
    //METODO PARA MOSTRAR OS CANDIDATOS CADASTRADOS
    public List<Candidato> Mostrar_candidatos()
    {
        //INSTANCIANDO A CONEXAO, STATEMENT E O RESULT SET
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        //CRIANDO UMA LIST DO TIPO CANDIDATO PARA ARMAZENAR OS CANDIDATOS ATIVOS
        List<Candidato> can = new ArrayList<>();
        
        try 
        {
            //QUERY QUE RETORNARA O CANDIATO CADASTRADO E ATIVO
            stmt = con.prepareStatement("SELECT c.id_candidatos, c.nome, p.nome, car.nome, c.numero FROM candidatos as c INNER JOIN partido as p on p.id_partido = c.id_partido INNER JOIN cargo car on car.id_cargo = c.id_cargo WHERE c.statuss = 1");
            
            //EXECUTANDO A QUERY
            rs = stmt.executeQuery();
            
            //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
            while(rs.next())
            {
                //INSTANCIANDO UM OBJETO CANDIDATO PARA ARMAZENAR NA LIST
                Candidato candidato = new Candidato();
                
                //PEGANDO OS COMPONENTES DO CANDIDATO
                candidato.setId_candidato(rs.getInt("c.id_candidatos"));
                candidato.setNome(rs.getString("c.nome"));
                candidato.setCargo(rs.getString("p.nome"));
                candidato.setPartido(rs.getString("car.nome"));
                candidato.setNumero(rs.getInt("c.numero"));
                
                //ADICIONANDO O CANDIDATO NA LIST
                can.add(candidato);
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
        return can;    
    }
  
}