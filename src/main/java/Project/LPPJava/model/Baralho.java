package Project.LPPJava.model;

public class Baralho {
    private String cartas_entrada;

    public Baralho(String cartas_entrada){
        setCartas_entrada(cartas_entrada);
    }
    public Baralho(){}

    public void setCartas_entrada(String cartas_entrada) {
        this.cartas_entrada = cartas_entrada;
    }

    public String getCartas_entrada() {
        return cartas_entrada;
    }
}
