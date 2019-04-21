package model.bean;
import model.dao.PartidoDAO;

/**
 *
 * @author Marcos
 */
public class Candidato 
{
    private int id_candidato;
    private String nome;
    private int id_partido;
    private int id_cargo;
    private int numero;
    private String partido;
    private String cargo;

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public int getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(int id_candidato) {
        this.id_candidato = id_candidato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public int toInt()
    {
        return getId_partido();
    }    
}
