package dino;

import java.util.Scanner;
import java.util.Random;

public class testeDeMetodos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randow = new Random();
        
        boolean resposta = false;
        int questao;
        int valor = 0;
        String escolha; 
        
                                     // Historia //
        System.out.println("Essa sera a nossa ultima chanse, confiamos em você.");
        geral.next();
        
        questao = randow.nextInt(5);
        questao++;
        
        switch( questao ){
            case 1 :
                valor = 120000; // 94200
                break;
            case 2 :
                valor = 135400; // 106289
                break;
            case 3 :
                valor = 112200; // 88077
                break;
            case 4 :
                valor = 121000; // 94985
                break;
            case 5 :
                valor = 130000; // 102050
                break;
        }
        
        System.out.println("Os inimigos estão a "+geral.purple+""+valor+"m  de altura"+geral.fim+" do chão, e  seus mísseis  serão\n"
                         + "disparadas em  um ângulo de "+geral.purple+"45º graus"+geral.fim+".  "+geral.purple+"Quantos metros"+geral.fim+" seus mísseis\n"
                         + geral.purple+"deverão percorrer"+geral.fim+" em linha reta para que atinjam o alvo? \n"
                         + "(dados: "+geral.purple+"sen 45º"+geral.fim+" = "+geral.purple+"0,785"+geral.fim+")       ("+geral.blue+"sen 45º = Hipotenusa/Cateto Oposto"+geral.fim+").");  
        System.out.println("(A)"+geral.purple+" 102050"+geral.fim+"m  \n"
                         + "(B)"+geral.purple+" 94200"+geral.fim+"m   \n"
                         + "(C)"+geral.purple+" 94985"+geral.fim+"m   \n"
                         + "(D)"+geral.purple+" 106289"+geral.fim+"m  \n"
                         + "(E)"+geral.purple+" 88077"+geral.fim+"m ");
        escolha = geral.desafio();
        
        switch( questao ){
            case 1 :
                resposta = geral.respB( escolha );
                break;
            case 2 :
                resposta = geral.respD( escolha );
                break;
            case 3 :
                resposta = geral.respE( escolha );
                break;
            case 4 :
                resposta = geral.respC( escolha );
                break;
            case 5 :
                resposta = geral.respA( escolha );
                break;
        }
        
        if ( resposta == true ) {
        
            System.out.println(geral.green+"Muito bem !!!"+geral.fim);
        
        } else {
        
            geral.feedback5( valor );
            System.out.println(geral.red+"Não acredito que erramos esse missel"+geral.fim);
            
        }
        
        geral.next();
        
    }
}
