package dino;

import java.util.Scanner;

public class geral {
    static Scanner input = new Scanner(System.in);

 // Cores para o terminal
    public static final String fim = "\u001B[0m";
    public static final String black = "\u001B[30m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36m";
    public static final String whyte = "\u001B[37m";
// -----------------------
    
    
//-------------------------Função para a escolha do menu------------------------
    static String escolha(){
        String escolha;

        do{
            System.out.print("Digite a inicial da opção desejada: ");
            escolha = input.nextLine();
                // Caso não seja nenhuma das opções acima, escolha ira receber 'n' e o laço será verdadeiro.
            switch(escolha){
                case "j":
                case "J":
                    escolha = "J"; // Jogar
                    break;
                case "t":
                case "T":
                    escolha = "T"; // Tutorial
                    break;
                case "s":
                case "S":
                    escolha = "S"; // Sair
                    break;
                case "c":
                case "C":
                    escolha = "C"; // Creditos
                    break;
                default:
                    System.err.println("- Opção invalida -");
                    escolha = "n";
            }
        }while("n".equals(escolha));
        System.out.println("");
        return escolha;
    }
//------------------------------------------------------------------------------
    

//---------------------------------Desafios-------------------------------------
    static String desafio(){
        String escolha;
// Uma cópia descarada do metodo acima.
        do{
            System.out.print("Digite a opção desejada: ");
            escolha = input.nextLine();
                // Caso não seja nenhuma das opções acima, escolha ira receber 'n' e o laço será verdadeiro.
            switch(escolha){
                case "a":
                case "A":
                    escolha = "a";
                    break;
                case "b":
                case "B":
                    escolha = "b";
                    break;
                case "c":
                case "C":
                    escolha = "c";
                    break;
                case "d":
                case "D":
                    escolha = "d";
                    break;
                case "e":
                case "E":
                    escolha = "e";
                    break;
                default:
                    System.err.println("- Opção invalida -");
                    escolha = "n";
            }
        }while(escolha.equals("n"));
        System.out.println("");
        return escolha;
    }
//------------------------------------------------------------------------------ 
    
    
//---------------------Função feita para pausa de dialogos----------------------
    static void next(){
        String next;
        System.out.print("...");
        next = input.nextLine();
        
        // Serve para garantir que o computador valide o Enter (Ja teve testes que ele teve um funcionamento duvidoso sem esse if).
        if(next.equals("")) {  }
    }
//------------------------------------------------------------------------------
    
    
//----------------Função usada para retornar a opção novamente.-----------------
    static String confirmar(){
        String opcao;
        do{
            System.out.print("Tem certeza ? (s/n): ");
            opcao = input.nextLine();
            // Verificação para que não aceite uma opção fora do desejado
            switch(opcao){
                case "s":
                case "S":
                    opcao = "S";
                    break;
                case "n":
                case "N":
                    break;
                default:
                    System.err.println("- Opção inválida -");
                    opcao = "x";
            }
        }while("x".equals(opcao));
        
        return opcao;
    }
//------------------------------------------------------------------------------
    
    
    
                            // A B C D E //
//-------------------Funções de validação de testes-----------------------------
    static boolean respA( String q ){ // Caso a resposta seja A
        boolean resp;
        resp = ( q.equals("a") || q.equals("A") );
        return resp;
    }
    static boolean respB( String q ){ // Caso a resposta seja B
        boolean resp;
        resp = ( q.equals("b") || q.equals("B") );
        return resp;
    }
    static boolean respC( String q ){ // Caso a resposta seja C
        boolean resp;
        resp = ( q.equals("c") || q.equals("C") );
        return resp;
    }
    static boolean respD( String q ){ // Caso a resposta seja D
        boolean resp;
        resp = ( q.equals("d") || q.equals("D") );
        return resp;
    }
    static boolean respE( String q ){ // Caso a resposta seja E
        boolean resp;
        resp = ( q.equals("e") || q.equals("E") );
        return resp;
    }
//------------------------------------------------------------------------------

    
//------------ Funções usadas para mandar o feedback das questões ------------//
    static void feedback1( int menor , int maior ){
        
        System.out.println("------------- "+geral.purple+"Como chegar á resposta"+geral.fim+" -------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Para obter o resultado basta : \n"
                         + "\n"
                         + ""+maior+"metros  -  "+menor+"metros  = "+geral.purple+""+(maior-menor)+"metros"+geral.purple);
        System.out.println("--------------------------------------------------");

    }
    
    // O feedback2 a propria questão ja é um feedback kkkkk.
    
    static void feedback3( int v ){

        System.out.println("------------- "+geral.purple+"Como chegar á resposta"+geral.fim+" -------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Se ( 2 min = "+v+" balas = 24 seg ); \n"
                         + geral.purple+"5x"+geral.fim+" ( 10 min = "+(v*5)+" balas = 120 seg("+geral.purple+"2 min"+geral.fim+") ).");
        System.out.println("");
        System.out.println("De inicio podemos concluir que ( "+geral.purple+"12 min"+geral.fim+" = "+geral.purple+""+(v*5)+" balas "+geral.fim+").");
        System.out.println("Agora basta fazer uma pequena "+geral.purple+"regra de 3"+geral.fim+" : \n");
        System.out.println("   12 min  =  "+(v*5)+"          12X = 60 * "+(v*5) );
        System.out.println("   60 min  =   X           12X = "+(60*(v*5)) );
        System.out.println("                             X = "+(60*(v*5))+" / 12");
        System.out.println(" X = "+geral.purple+""+(60*(v*5))/12+""+geral.fim);
        System.out.println("--------------------------------------------------");

    }
    
    static void feedback4( double v ){
        
        System.out.println("------------- "+geral.purple+"Como chegar á resposta"+geral.fim+" -------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Sabendo que a formula é ( "+geral.purple+"f(x) = ax + b"+geral.fim+" ) e temos : ");
        System.out.println(geral.purple+"  fixo    "+geral.fim+" : 800.00");
        System.out.println(geral.purple+"  variavel"+geral.fim+" : "+v+"0");
        System.out.println(geral.purple+"  X       "+geral.fim+" : 400");
        System.out.println("Logo : f("+geral.purple+"400"+geral.fim+") = "+geral.purple+""+v+"0"+geral.fim+" . "+geral.purple+"400"+geral.fim+" + "+geral.purple+"800.00"+geral.fim);
        System.out.println("       f(400) = "+v*400+"0 + 800.00");
        System.out.println("       f(400) = "+geral.purple+""+((v*400)+800)+"0"+geral.fim);
        System.out.println("--------------------------------------------------");

    }
    
    static void feedback5( int valor ){
        
        System.out.println("------------- "+geral.purple+"Como chegar á resposta"+geral.fim+" -------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Sabendo que a formula é ( "+geral.purple+"sen 45º"+geral.fim+" = "+geral.purple+"H"+geral.fim+" / "+geral.purple+"CO"+geral.fim+" ) e temos :");
        System.out.println(geral.purple+"  sen 45º"+geral.fim+" : 0,785 \n"
                         + geral.purple+"  H"+geral.fim+"       : X     \n"
                         + geral.purple+"  CO"+geral.fim+"      : "+valor);
        System.out.println("Logo : "+geral.purple+"0,785"+geral.fim+" = "+geral.purple+"X"+geral.fim+" / "+geral.purple+""+valor+""+geral.fim);
        System.out.println("         X   = 0,785 * "+valor+""+geral.purple);
        System.out.printf("         X   = %.0f",0.785*valor);
        System.out.println(geral.fim+"\n--------------------------------------------------");

    }
}