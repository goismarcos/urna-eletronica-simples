package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Marcos
 */
public class Conexao 
{
    //VARIAVEIS PARA A CONEXAO DO BANCO DE DADOS
    private static final String DRIVE = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_urna";;
    private static final String USER = "root";
    private static final String PASS = "";
    
    //PEGANDO A CONEXAO
    public static Connection getConnection()
    {
        try 
        {
            Class.forName(DRIVE);
            return DriverManager.getConnection(URL, USER, PASS);
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            throw new RuntimeException("Erro ao conectar com o banco", ex);
        }
    }
    
    //FECHANDO A CONEXAO
    public static void CloseConnection(Connection con)
    {
            try 
            {
                if(con != null)
                    con.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    //FECHANDO A CONEXAO E O PREPARED STATEMENT (SOBRECARGA DE MÉTODO)
    public static void CloseConnection(Connection con, PreparedStatement stmt)
    {
        CloseConnection(con);
            try 
            {
                if(stmt != null)
                    stmt.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    //FECHANDO A CONEXAO, PREPARED STATEMENT E O RESULT SET (SOBRECARGA DE MÉTODO)
    public static void CloseConnection(Connection con, PreparedStatement stmt, ResultSet rs)
    {
        CloseConnection(con, stmt);
            try 
            {
                if(rs != null)
                    rs.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
