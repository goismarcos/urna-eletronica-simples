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
import model.bean.Cargo;

/**
 *
 * @author Marcos
 */
public class CargoDAO 
{
    //METODO PARA CADASTRAR CARGO
    public void Cadastrar_cargo(Cargo cargo)
    {
        //INSTANCIANDO A CONEXAO E O STATEMENT
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            //VERIFICA SE A SIGLA FOI PREENCHIDA
            if("".equals(cargo.getNome()))
            {
                JOptionPane.showMessageDialog(null, "Erro: Digite a sigla!");
            }
            else
            {
                //CHAMANDO A PROCEDURE PARA INSERIR PARTIDO
                stmt = con.prepareStatement("CALL sp_inserir_partido('"+cargo.getNome()+"');");
                
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
    
    //METODO PARA MOSTRAR OS PARTIDOS CADASTRADOS
    public List<Cargo> Mostrar_cargos()
    {
        //INSTANCIANDO A CONEXAO, STATEMENT E O RESULT SET
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        //CRIANDO UMA LIST DO TIPO CARGO PARA ARMAZENAR OS CARGOS ATIVOS
        List<Cargo> car = new ArrayList<>();
        
        try 
        {
            //QUERY QUE RETORNARA OS CARGOS CADASTRADO E ATIVO
            stmt = con.prepareStatement("SELECT * FROM cargo");
            
            //EXECUTANDO A QUERY
            rs = stmt.executeQuery();
            
            //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
            while(rs.next())
            {
                //INSTANCIANDO UM ABJETO CARGO PARA ARMAZENAR NA LIST
                Cargo partido = new Cargo();
                
                //PEGANDO OS COMPONENTES DO CARGO
                partido.setNome(rs.getString("nome"));
                partido.setId_cargo(rs.getInt("Id_cargo"));
                
                //ADICIONANDO O CARGO NA LIST
                car.add(partido);
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
        return car;       
    }    
}