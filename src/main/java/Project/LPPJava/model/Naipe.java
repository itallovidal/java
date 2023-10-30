package Project.LPPJava.model;
import java.util.HashMap;

public abstract class Naipe {
    protected int quantidade_cartas = 13;
    protected String nome_naipe;
    protected boolean quantidade_valida = true;

    HashMap<Integer, Boolean> cartas =new HashMap<Integer, Boolean>();

    public Naipe( String nome_naipe)
    {
        this.nome_naipe = nome_naipe;
        preencheHashMap();
    }

    public void preencheHashMap()
    {
        cartas.put(1,false);
        cartas.put(2,false);
        cartas.put(3,false);
        cartas.put(4,false);
        cartas.put(5,false);
        cartas.put(6,false);
        cartas.put(7,false);
        cartas.put(8,false);
        cartas.put(9,false);
        cartas.put(10,false);
        cartas.put(11,false);
        cartas.put(12,false);
        cartas.put(13,false);
    }

    public void confereCarta(int numeroCarta)
    {
        // verificação pra ver se já ta true com o get pra ver se ta duplicado

        if(cartas.get(numeroCarta) == false)
        {
            cartas.put(numeroCarta, true);
            quantidade_cartas--;
        }
        else
            quantidade_valida=false;
    }

    public String qntCartasFaltantes()
    {
        if(quantidade_valida){
            return String.valueOf(quantidade_cartas);
        } else{
            return "Erro";
        }
    }
}
