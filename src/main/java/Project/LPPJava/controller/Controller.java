package Project.LPPJava.controller;

import Project.LPPJava.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

// Annotation que informa que essa classe é um controler
// Controler informa para aonde seguir de acordo com a requisição HTTP que receber

@org.springframework.stereotype.Controller
public class Controller {
    // Annotation que informa que quando o endpoint da requisição recebida pelo controller
    // for igual passado nele, o método seguinte deve ser executado
    @GetMapping("/")
    public String home(){
        return "home";
    }

    // ModelAndView é uma classe responsavel por juntar as informações do objeto + a view
    // para que seja possível retornar só um elemento que será mostrado na tela
    @PostMapping("/resultado")
    public ModelAndView main(Baralho baralho){
        // guarda o atributo cartas_entrada da classe baralho com o valor do input cartas_entrada passado por parametro
        String cartas_entrada = baralho.getCartas_entrada(), num = "";
        char naipe;
        int carta_valor;
        boolean isValid = true;
        Copas copas = new Copas();
        Espadas espadas = new Espadas();
        Ouros ouros = new Ouros();
        Paus paus= new Paus();

        if(cartas_entrada.length() % 3 == 0){
            for (int i = 0; i < cartas_entrada.length(); i = i + 3) {
                try{
                    num += cartas_entrada.charAt(i);
                    num += cartas_entrada.charAt(i + 1);
                    naipe = cartas_entrada.toLowerCase().charAt(i + 2); // add o naipe da carta minusculo
                    carta_valor = Integer.parseInt(num); // pega o numero da carta como int

                    if (carta_valor >= 1 && carta_valor <= 13 && ((naipe == 'c') || (naipe == 'e') || (naipe == 'u') || (naipe == 'p'))) {
                        switch (naipe) {
                            case 'c':
                                copas.confereCarta(carta_valor);
                                break;
                            case 'e':
                                espadas.confereCarta(carta_valor);
                                break;
                            case 'u':
                                ouros.confereCarta(carta_valor);
                                break;
                            case 'p':
                                paus.confereCarta(carta_valor);
                                break;
                        }
                    } else {
                        isValid = false;
                    }

                    num = "";
                } catch(NumberFormatException e){
                    isValid = false;
                }
            }
        } else{
            isValid = false;
        }

        ModelAndView mv;
        if(isValid){
            mv = new ModelAndView("resultado");
            mv.addObject("baralho", baralho); // add uma lista de objetos
            mv.addObject("copas", copas);
            mv.addObject("espadas", espadas);
            mv.addObject("ouros", ouros);
            mv.addObject("paus", paus);
        } else{
            mv = new ModelAndView("error");
        }

        return mv;
    }
}
