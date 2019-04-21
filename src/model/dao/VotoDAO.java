package model.dao;

import conexao.Conexao;
import static conexao.Conexao.CloseConnection;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.HeadlessException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import model.bean.Candidato;
import model.bean.Voto;
import model.bean.Cargo;

/**
 *
 * @author Marcos
 */
public class VotoDAO 
{
    //METODO PARA CHAMAR O AUDIO   
    private void Chama_audio()
    {
        //PEGANDO O ENDEREÇO DO AUDIO
        URL url = getClass().getResource("/Som/fim.wav");
        
        //EXECUTANDO O AUDIO
        AudioClip audio =   Applet.newAudioClip(url);
        audio.play();
    }
    
    //METODO PARA INSERIR VOTOS PARA O CANDIDATO
    public void Inserir_votos(Voto voto)
    {
        //INSTANCIANDO A CONEXAO E O STATEMENT
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try
        {
            //VERIFICA SE O NUMERO DO CANDIDATO FOI PREENCHIDO
            if("".equals(voto.getNumero()))
            {
                JOptionPane.showMessageDialog(null, "Digite um numero valido!");
            }
            else
            {
                //CHAMANDO A PROCEDURE PARA INSERIR VOTOS
                stmt = con.prepareStatement("call sp_inserir_votos("+ voto.getNumero() +", "+ voto.getId_cargo() +")");
                
                //INSTANCIANDO O RESULT SET E EXECUTANDO A QUERY
                ResultSet rs = null;
                rs = stmt.executeQuery();
                
                //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
                while(rs.next())
                {
                    //RETORNANDO O ERRO OU ACERTO
                    //JOptionPane.showMessageDialog(null, rs.getString("error_message"));
                }
                Chama_audio();
            }
        }
        catch(HeadlessException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro ao votar!"+ex);
        }
        finally
        {
            //FECHANDO CONEXAO E O STATEMENT
            CloseConnection(con,stmt);
        }
    }
    
    //METODO PARA MOSTRAR RELATORIO DE VOTAÇÃO
    public List<Voto> Mostrar_relatorio(Cargo cargo)
    {
        //INSTANCIANDO A CONEXAO, STATEMENT E O RESULT SET
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        //CRIANDO UMA LIST DO TIPO VOTO PARA ARMAZENAR OS VOTOS
        List<Voto> vot = new ArrayList<>();
        
        try
        {
            //QUERY QUE RETORNARA  CADASTRADO E ATIVO
            stmt = con.prepareStatement("call sp_relatorio_votos("+cargo.getId_cargo()+")");
                        
            //EXECUTANDO A QUERY
            rs = stmt.executeQuery();
            
            //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
            while(rs.next())
            {
                //INSTANCIANDO UM OBJETO VOTO PARA ARMAZENAR NA LIST
                Voto voto = new Voto();
                
                //PEGANDO OS COMPONENTES DO CANDIDATO
                voto.setTotal_votos(rs.getInt("Total Votos"));
                voto.setNome(rs.getString("Candidato"));
                
                //ADICIONANDO O CANDIDATO NA LIST
                vot.add(voto);
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
        
        //RETORNANDO A LIST
        return vot;
    }
    
    //METODO PARA BUSCAR CANDIDATO
    public List<Candidato> Buscar_candidato(Candidato candidato)
    {
        //INSTANCIANDO A CONEXAO, STATEMENT E O RESULT SET
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        
        //CRIANDO UMA LIST DO TIPO VOTO PARA ARMAZENAR OS VOTOS
        List<Candidato> can = new ArrayList<>();
        
        try
        {
            //QUERY QUE RETORNARA  CADASTRADO E ATIVO
            stmt = con.prepareStatement("SELECT c.nome, p.nome FROM candidatos as c INNER JOIN  partido as p ON p.id_partido = c.id_partido WHERE  numero = "+candidato.getNumero()+" AND id_cargo = "+ candidato.getId_cargo()  +" ");
             
            //EXECUTANDO A QUERY
            rs = stmt.executeQuery();
            
            //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
            while(rs.next())
            {
                //INSTANCIANDO UM OBJETO VOTO PARA ARMAZENAR NA LIST
                Candidato cand = new Candidato();
                
                //PEGANDO OS COMPONENTES DO CANDIDATO
                cand.setNome(rs.getString("c.nome"));
                cand.setPartido(rs.getString("p.nome"));
                
                //ADICIONANDO O CANDIDATO NA LIST
                can.add(cand);
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
        
        //RETORNANDO A LIST
        return can;
    }
    
    //METODO PARA VERIFICAR SE HÁ UMA VOTAÇÃO
    public int Verifica_votos()
    {
        //INSTANCIANDO A CONEXAO, STATEMENT E O RESULT SET
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int total = -1;
        
        try
        {
            //QUERY QUE RETORNARA  CADASTRADO E ATIVO
            stmt = con.prepareStatement("SELECT COUNT(*) AS total FROM votos");
                        
            //EXECUTANDO A QUERY
            rs = stmt.executeQuery();
            
            //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
            while(rs.next())
            {
                //PEGANDO QUANTIDADE DE VOTOS
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
        
        //RETORNANDO O TOTAL DE VOTOS
        return total;
    }
    
    
    
    //METODO PARA APAGAR REGISTRO DAS TABELAS VOTOS E CANDIDATOS
    public void Apagar_registros()
    {
        //INSTANCIANDO A CONEXAO, STATEMENT E O RESULT SET
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            //QUERY QUE APAGA OS REGISTROS
            stmt = con.prepareStatement("CALL sp_truncate_tabelas()");
                        
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
    
    //METODO PARA TRANSMITIR DADOS DA VOTAÇÃO
    public void Transmitir_dados() throws IOException
    {
        //INSTANCIANDO A CONEXAO, RESUSLT SET E O STATEMENT
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        //GERAR NUMERO ELEATORIO PARA NAO SOBREPOR O ARQUIVO
        Random num = new Random();
        
        //PEGANDO ENDEREÇO DO ARQUIVO
        String nome_arquivo = "C:\\Users\\Marcos\\Desktop\\relatorio"+num.nextInt()+".txt";
               
        //INSTANCIANDO OBJETO PARA GRAVAR NO ARQUIVO TXT
        FileOutputStream out = new FileOutputStream(nome_arquivo);
        
        //DECLARANDO UMA STRING QUE CONTERÁ TEXTO PARA GRAVAÇÃO NO ARQUIVO
        String texto = "";
        
        //VARIAVEL RESPONSAVEL PELA CONVERSÃO PARA BYTE E GRAVAÇÃO DO ARQUIVO
        byte a[];
                
        //LIST'S  DE CADA VOTAÇÃO
        List<Voto> dep_est = new ArrayList<>();
        List<Voto> dep_fed = new ArrayList<>();
        List<Voto> senador = new ArrayList<>();
        List<Voto> governador = new ArrayList<>();
        List<Voto> presidente = new ArrayList<>();
        
        try
        {
            //ARMAZENANDO VOTAÇÃO PARA DEP ESTADUAL
            texto = "";
            texto = "Deputado Estadual\n";
            a = texto.getBytes();
            
            //GRAVANDO NO ARQUIVO
            out.write(a);
            
            //QUERY QUE RETORNARA VOTOS DOS CANDIDATOS A DEP ESTADUAL
            stmt = con.prepareStatement("call sp_relatorio_votos(1)");
            
            //EXECUTANDO A QUERY
            rs = stmt.executeQuery();
            
            //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
            while(rs.next())
            {
                //PEGANDO OS COMPONENTES DO CANDIDATO
                String S = "";
                S = (rs.getInt("Total Votos")+" - "+rs.getString("Candidato")+"\n" );
                byte b[] = S.getBytes();
                
                //GRAVANDO NO ARQUIVO
                out.write(b);
            }
            
            //----------------------------------------------------------------------
            
            //ARMAZENANDO VOTAÇÃO PARA DEP ESTADUAL
            texto = "";
            texto = "Deputado Federal\n";
            a = texto.getBytes();
            
            //GRAVANDO NO ARQUIVO
            out.write(a);
            
            //QUERY QUE RETORNARA VOTOS DOS CANDIDATOS A DEP FEDERAL
            stmt = con.prepareStatement("call sp_relatorio_votos(2)");
            
            //EXECUTANDO A QUERY
            rs = null;
            rs = stmt.executeQuery();
            
            //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
            while(rs.next())
            {
                String S = "";
                S = (rs.getInt("Total Votos")+" - "+rs.getString("Candidato")+"\n" );
                byte b[] = S.getBytes();
                
                //GRAVANDO NO ARQUIVO
                out.write(b);
            }
            
            //---------------------------------------------------------------------
            
            //ARMAZENANDO VOTAÇÃO PARA SENADOR
            texto = "";
            texto = "Senador\n";
            a = texto.getBytes();
            
            //GRAVANDO NO ARQUIVO
            out.write(a);
            
            //QUERY QUE RETORNARA VOTOS DOS CANDIDATOS A SENADOR
            stmt = con.prepareStatement("call sp_relatorio_votos(3)");
            
            //EXECUTANDO A QUERY
            rs = null;
            rs = stmt.executeQuery();
            
            //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
            while(rs.next())
            {
                String S = "";
                S = (rs.getInt("Total Votos")+" - "+rs.getString("Candidato")+"\n" );
                byte b[] = S.getBytes();
                
                //GRAVANDO NO ARQUIVO
                out.write(b);
            }
            
            //---------------------------------------------------------------------
            
            //ARMAZENANDO VOTAÇÃO PARA GOVERNADOR
            texto = "";
            texto = "Governador\n";
            a = texto.getBytes();
            
            //GRAVANDO NO ARQUIVO
            out.write(a);
            
            //QUERY QUE RETORNARA VOTOS DOS CANDIDATOS A GOVERNADOR
            stmt = con.prepareStatement("call sp_relatorio_votos(4)");
            
            //EXECUTANDO A QUERY
            rs = null;
            rs = stmt.executeQuery();
            
            //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
            while(rs.next())
            {
                String S = "";
                S = (rs.getInt("Total Votos")+" - "+rs.getString("Candidato")+"\n" );
                byte b[] = S.getBytes();
                
                //GRAVANDO NO ARQUIVO
                out.write(b);
            }
            
            //---------------------------------------------------------------------
            
            //ARMAZENANDO VOTAÇÃO PARA PRESIDENTE
            texto = "";
            texto = "Presidente\n";
            a = texto.getBytes();
            
            //GRAVANDO NO ARQUIVO
            out.write(a);
            
            //QUERY QUE RETORNARA VOTOS DOS CANDIDATOS A PRESIDENTE
            stmt = con.prepareStatement("call sp_relatorio_votos(5)");
            
            //EXECUTANDO A QUERY
            rs = null;
            rs = stmt.executeQuery();
            
            //ESTRUTURA PARA PEGAR O RETORNO DA QUERY
            while(rs.next())
            {
                String S = "";
                S = (rs.getInt("Total Votos")+" - "+rs.getString("Candidato")+"\n" );
                byte b[] = S.getBytes();
                
                //GRAVANDO NO ARQUIVO
                out.write(b);
            }
            
            //FECHANDO ARQUIVO
            out.close();
            
            //MENSAGEM DE SUCESSO
            JOptionPane.showMessageDialog(null, "Votação exportada com sucesso!");
                        
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