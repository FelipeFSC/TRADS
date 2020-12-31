package dino;

import java.util.Scanner;

public class ClassePrincipal {
    static Scanner input = new Scanner(System.in);
//------------------------------------------------------------------------------
                        // Classe Principal //
//------------------------------------------------------------------------------
    public static void main(String[] args) {
        
        login();
        
        jogoJurassicWar();
        
    }
//------------------------------------------------------------------------------
   
// Função feita para o login do Jogo. ******************************************
    static void login(){
        String senha, login;
        String senhaC, loginC;

        System.out.println("");
        System.out.println("======== Seja bem vindo ao Jurassic War ========");
        System.out.println("Faça o seu cadastro para garantir a sua aventura");
        // Login e Senha.
        System.out.print("Login: ");
        login = input.nextLine();
        System.out.print("Senha: ");
        senha = input.nextLine();
        // Confirmação de Login e Senha.
        System.out.println("=========== Confirme o seu Cadastro ============");
        // Laço de repetição pra caso o usuário digite o login ou senha incorretamente.
        do{
            System.out.print("Login: ");
            loginC = input.nextLine();
            System.out.print("Senha: ");
            senhaC = input.nextLine();
            
            // Caso a senha ou o Login estejam incorretos
            if(!loginC.equals(login) || !senhaC.equals(senha)){
                 System.err.println("- Login ou Senha incorretos -");
            }
        }while(!loginC.equals(login) || !senhaC.equals(senha));
    }
//******************************************************************************
    

// Função que chama o Menu do jogo. ********************************************
    static void jogoJurassicWar(){
        String opcao;
        
        do{
            //Menu do jogo 
            System.out.println("");
            System.out.println("============ Menu ============");
            System.out.println("|                            |");
            System.out.println("|          Tutorial          |");
            System.out.println("|           Jogar            |");
            System.out.println("|          Creditos          |");
            System.out.println("|            Sair            |");
            System.out.println("|                            |");
            
            // Função para a escolha de opções do menu
            opcao = geral.escolha();

            Controle(opcao);
        }while(!"S".equals(opcao));
    }
// Função de controle, chama as funções com base no Menu. **********************
    static void Controle(String opcao){
        
        switch(opcao){
            case "T":     // Tutorial //
                System.out.println("========== Tutorial ==========");
                tutorial(); // inicioFim.
                 
                break;
            case "J":       // Jogar //
                System.out.println("=========== Jogar ===========\n");
                jogo.jogoCompleto(); // jogo
                
                break;
            case "C":      // Creditos //
                System.out.println("========== Creditos ==========");
                creditos(); // inicioFim.
                
                break;
            case "S":        // Sair //
                    
                System.out.println("\nAté mais :)\n");
                    
                break;
            default: // Um bug inesperado
                System.err.println("Oxe!!!");
        }
    
    }
//******************************************************************************
    

// Função feita para mostrar o tutorial. ***************************************
    static void tutorial(){
        System.out.println("");
        System.out.println("              * Olá Soldado");
        System.out.println("Para que você não fique perdido em meio a guerra\n"
                         + "preparamos um treinamento especial para você.");
                
        System.out.println("");
        System.out.println("********************************************************");
        System.out.println("(Saiba que só iremos considerar a primeira letra das\n"
                         + "suas  escolhas, então  caso você  digite (12) iremos\n"
                         + "considerar somente o (1)).");
        System.out.println("********************************************************");
        System.out.println("");

        System.out.println("Fique ciente que sempre que aparecer esses 3 pontos\n"
                         + "( ... ) você terá que apertar  Enter para continuar\n"
                         + "a história.");
        geral.next();
        // Serve para dar uma pausa no dialogo.
        
        System.out.println("** Muito bem **\n");
        System.out.println("Os desafios serão  questões relacionadas a matéria\n"
                         + "de Pré-Calculo, fora umas surpresas ao decorrer da\n"
                         + "historia, nessa etapa você terá que escolher\n"
                         + "dentre 5 alternativas de A até E.");
        geral.next();
        System.out.println("");
        System.out.println("Se você conseguir cumprir o desafio ira aparecer\n"
                         + "na tela uma mensagem como: \n"
                         + "-( *MUITO BEM SOLDADO* )\n"
                         + " caso o contrário \n"
                         + "-( *VOCÊ FALHOU SOLDADO* )");
        geral.next();
        System.out.println("");
        System.out.println("Saiba que o seu desempenho nos desafios ira mudar\n"
                         + "a sua trajetória na história tanto para o \n"
                         + "lado BOM quanto para o lado RUIM.");
        geral.next();
        System.out.println("");
        System.out.println("Pronto soldado, agora o senhor esta pronto para \n"
                         + "a batalha,\n"
                         + " vamos acabar com essa temível raça alienígena!");
        geral.next();
    }
//******************************************************************************


// Função feita para mostrar os creditos. **************************************
    static void creditos(){
        System.out.println("      - Direção de Audio -");
        System.out.println("Sua mente!");
        System.out.println("");

        System.out.println("         - História -");
        System.out.println("Rafhael");
        System.out.println("");

        System.out.println("         - Desafios -");
        System.out.println("Rafhael");
        System.out.println("Luiz");
        System.out.println("");

        System.out.println("        - Programação -");
        System.out.println("Felipe");
        System.out.println("Rafhael");
        System.out.println("Jessica");
        System.out.println("Luiz");
        geral.next();
    }
//******************************************************************************
}
