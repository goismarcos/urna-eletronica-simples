package model.bean;

/**
 *
 * @author Marcos
 */
public class Partido 
{
    private int id_partido;
    private String nome;

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString()
    {
        return getNome();
    }
    
}
