package dino;

import java.util.Scanner;
import java.util.Random;

public class jogo {
    static Scanner input = new Scanner(System.in);
    static Random randow = new Random(); 
    
    static void jogoCompleto(){
        boolean key[] = new boolean [5];
        boolean ajuda[] = new boolean [5];
        boolean fase[] = new boolean [5];
        boolean caminho[] = new boolean [5];
        String nome, classe;
        boolean tabelaDeConquistas[][];

        // Parte 1 da historia
        nome = introducao(); // Introdução / Nome .
        classe = classes(); // Classes.

        // Parte 2 da historia
        key[0] = desafio1( nome, classe ); // Desafio 1
        key[1] = desafio2( nome, classe ); // Desafio 1.2

//----------------------------1_GAME OVER---------------------------------------

           //-- SE O JOGADOR ESCOLHER A CLASSE 1 OU 3 ELE É SALVO --//
        ajuda[0] = classe.equals("Pterodátilo") || classe.equals("T-rex");

        if( key[0] == false && key[1] == false && ajuda[0] == true ){

            if ( classe.equals("Pterodátilo") ) {
                System.out.println("Como seus aliados estavam todos ocupados com os\n"
                                 + "misseis você não se vê a escolha e sai voando.");
                geral.next();
            }
            if ( classe.equals("T-rex") ) {
                System.out.println("Como os seus aliados estavam todos ocupados com\n"
                                 + "os misseis você libera o seu estinto primitivo\n"
                                 + "ataca os inimigos com os dentes e garras feroses\n"
                                 + "e consegue ganhar tempo até que seus aliados\n"
                                 + "cheguem para te ajudar.");
                geral.next();
            }

        } else {
            ajuda[0] = false;
        }
            //----------------------------------------------------//

// Para que você avance na historia você tera que no minimo passar em um desafio da parte 2
// ou escolher a classe certa.
        if( key[0] == true || key[1] == true || ajuda[0] == true ) {

            // Caso o jogador acerte os misseis porem não arrume a arma.
            if( key[1] == false && ajuda[0] == false ){
                System.out.println("Porem como você cuidou muito bem dos misseis no inicio,\n"
                                 + "seus aliados chegam a tempo para te ajudar. ");
                geral.next(); 
            }

            //System.out.println("Você passou para a proxima fase");
            fase[0] = true;

        // Caso o jogador não acerte os misseis e não arrume a arma
        } else {

            System.out.println("Graças ao seu erro no inicio seus aliados estão ocupados\n"
                             + "com os misseis e você acaba sendo capiturado.");
            geral.next();
            System.out.println(geral.red+"GAME OVER !"+geral.fim);
        }
//------------------------------GAME OVER---------------------------------------

//--------------------------Segunda fase do game--------------------------------
        if ( fase[0] == true ) {

            System.out.println("Você passou para a proxima fase");
            geral.next();

            key[2] = desafio3( nome, classe ); // Desafio 3
            
            // Se o pterodatilo ou t-rex acabar errando essa questão tambem é game over.
            if ( key[2] == false && key[0] == false && key[1] == false ) {
                if ( classe.equals("Pterodátilo") ) {
                    System.out.println("- Você se mostrou ser uma arma inútil para a guerra, com\n"
                            + "ordens do general Marcio você acaba sendo preso e voltou\n"
                            + "para a fase de testes.");
                    geral.next();
                } else {
                    System.out.println("Ja era esperado que isso fosse acontecer, mas depois de muita\n"
                            + "luta  o  (nome)  acabou  ficando  cansado  e  sendo capturado\n"
                            + "pelos TRADS.");
                    geral.next();
                }
                ajuda[1] = false;
            // mas se eles acertaram pelo menos uma eles passam de boas. e o triceratops vai vir direto 
            // pois ele não chegaria aqui se tivesse errado uma no inicio.
            } else {
                
                switch (classe) {
                    case "T-rex":
                        // se for o t-rex
                        if ( key[1] == false && key[2] == false ) { // se ele não conserta a arma e erra a 3
                            System.out.println("Ja era esperado que isso fosse acontecer, mas depois de muita\n"
                                    + "luta  o  (nome)  acabou  ficando  cansado  e  sendo capturado\n"
                                    + "pelos TRADS.");
                            ajuda[1] = false;
                        } else if ( key[1] == true && key[2] == false ) { // se ele errar porem se arrumar a arma.
                            System.out.println("\n(nome) começa a enfrentar os TRADS e quando estava quase cansando chega\n"
                                    + "um soldado com a arma que (nome) tinha consertado e acaba salvando sua vida.");
                            geral.next();
                            ajuda[1] = true;
                        } else {
                            ajuda[1] = true;
                        }   break;
                    case "Pterodátilo":
                        // senão se for o pterodatilo
                        if ( key[1] == false && key[2] == false ) {
                            System.out.println("Os soldados começam a desconfiar do potencial do (nome).");
                            geral.next();
                            ajuda[1] = true;
                        } else if ( key[2] == false ) {
                            System.out.println("- Porem os soldados ainda confiam no (nome).");
                            geral.next();
                            ajuda[1] = true;
                        } else {
                            ajuda[1] = true;
                            // segue normalmente.
                        }   break;
                    default:
                        if ( key[2] == false ) {
                            System.out.println("(nome) se mostrou ser resistente o bastastante e mesmo não se dando\n"
                                    + "bem com o armamento ele consegue sobreviver e graças ao desempenho no inicio\n"
                                    + "ele segue em frente.");
                            geral.next();
                            ajuda[1] = true;
                        } else {
                            ajuda[1] = true;
                        }   break;
                }
            }
            
            if( ajuda[1] == true ){
                
                fase[1] = true;
            
            } else {
                
                System.out.println(geral.red+"GAME OVER !"+geral.fim);
                
            }
        }
//------------------------Fim segunda fase do game------------------------------



//-------------Terceira fase do game (caminhos paralelos)-----------------------
        if( fase[1] == true ){
            System.out.println("Você passou para a proxima fase");
            geral.next();
            
            key[3] = desafio4( nome , classe );
            
            if ( key[3] == true ) {
                
                System.out.println("Graças ao nosso calculo exato de gastos conseguimos\n"
                                 + "planejar um meio de atirar um missel na nave mãe dos\n"
                                 + "TRADS.");
                System.out.println(geral.green+"*** Você desbloqueou a formula da ultima questão ***"+geral.fim);
                geral.next();
                
                key[4] = caminho1( nome , classe );
                
            } else {
                
                System.out.println("Sem o controle do nosso dinheiro tivemos que\n"
                                 + "tomar outro rumo...");
                System.out.println(geral.red+"*** Você não desbloqueou a formula da ultima questão ***"+geral.fim);
                geral.next();
                
                key[4] = caminho2( nome , classe );
                
            }
            
            // Caso o jogador tenha acertado o desafio final.
            if ( key[4] == true ) {
                
                switch( classe ){
                    case "T-rex" :
                        if ( key[0] == false && key[2] == false && key[3] == false ) {
                            
                            System.out.println("Por fim (nome) se mostrou muito destraido em meio a guerra\n"
                         + "e por mais um descuido acabou estando no lugar errado e a nave \n"
                         + "caiu em cima do (classe) e ele acabou morrendo.");
                            
                        }
                        
                        break;
                    case "Triceratops" :
                        
                        
                        break;
                    case "Pterodátilo" :
                        if ( key[0] == false && key[2] == false && key[3] == false ) {
                            
                            System.out.println("Por fim (nome) se mostrou muito destraido em meio a guerra\n"
                         + "e por mais um descuido acabou estando no lugar errado e a nave \n"
                         + "caiu em cima do (classe) e ele acabou morrendo.");
                            
                        }
                        
                        break;
                }
                
                /*System.out.println("Parabens você conseguiu derrubar a nave mãe \n"
                                 + "e acabou com a invasão do TRADS");*/
            } else { // Caso o jogador tenha errado o desafio final.
                
                switch( classe ){
                    case "T-rex" :
                        // Se o jogador acertou todas porem errou a ultima
                        if ( key[0] == true && key[1] == true && key[2] == true && key[3] == true ) {
                            
                            System.out.println("Você acabou errando os misseis, mas não desanime, você tem\n"
                                             + "mais uma chanse.");
                        
                            desafio52( nome , classe );
                        }
                        
                        break;
                    case "Triceratops" :
                        if ( key[0] == true && key[1] == true && key[2] == true && key[3] == true ) {
                            
                            System.out.println("Você acabou errando os misseis, mas não desanime, você tem\n"
                                             + "mais uma chanse.");
                            
                            desafio52( nome , classe );
                        }
                        
                        break;
                    case "Pterodátilo" :
                        if ( key[0] == true && key[1] == true && key[2] == true && key[3] == true ) {
                            
                            System.out.println("Você acabou errando os misseis, mas não desanime, você tem\n"
                                             + "mais uma chanse.");
                            
                            desafio52( nome , classe );
                        }
                        
                        break;
                }
                /*System.out.println("Você errou os misseis e os TRADS acabaram \n"
                                 + "dando um contra ataque e perdemos a guerra.");*/
            }
            
        }
    }
//-------------------------Fim terceira fase------------------------------------



// Parte 1 da historia, atribuindo Nome do personagem e classe *****************
    
    // Função para mostrar a introdução da historia e atribuir o nome do seu personagem.
    static String introducao(){
        String nome, confirmar;
        char classe;
        
        // Laço de repetição onde Guarda a escolha de nome para o personagem do usuario.
        do{
            System.out.print("Escolha o nome do seu personagem: ");
            nome = input.nextLine();
            System.out.println("( "+nome+" )");
            
            confirmar = geral.confirmar();
        }while(!confirmar.equals("S"));
        
        System.out.println("                      ____________ ");
        System.out.println("                     | INTRODUÇÃO |");
        System.out.println("                    /¨¨¨¨¨¨¨¨¨¨¨¨¨¨\\");
        System.out.println(geral.yellow+"***************************************************************"+geral.fim);
        System.out.println("Há cerca de 100 milhões de anos em uma região hoje conhecida \n"
                         + "como África e Europa, os poderosos e grandiosos  dinossauros \n"
                         + "viviam.  Após um estrondoso barulho e luzes vindas do céu, o \n"
                         + "caos e o medo se instauraram entre todos os dinossauros. ");
        geral.next(); // Um stop para ler
        System.out.println(geral.yellow+"***************************************************************"+geral.fim);
        System.out.println("Durante a  tentativa  de fuga, "+nome+" acabou caindo  em  um \n"
                           + "imenso e congelante rio ... milhões  de  anos  depois,  mais \n" 
                           + "precisamente no ano de 2680, devido ao excessivo aquecimento \n"
                           + "do planeta, o rio que "+nome+" acabou caindo e sendo congelado,\n"
                           + "descongelou e o libertou dessa eterna hibernação.");
        geral.next();
        System.out.println(geral.yellow+"***************************************************************"+geral.fim);      
        System.out.println("Pescadores ao  norte da Europa localizaram  oque parecia ser \n"
                         + "um enorme crocodilo. Porém, ao se  aproximarem, notaram  ser \n"
                         + "um animal – até então – desconhecido. O rio  foi isolado por \n"
                         + "militares e o ocorrido foi encoberto... ");
        geral.next();
        System.out.println(geral.yellow+"***************************************************************"+geral.fim);
        System.out.println("Após vários anos e muitas  pesquisas, os melhores cientistas \n"
                         + "do mundo  conseguiram  transformar  esse, até então, extinto \n"
                         + "dinossauro em  uma  incrível e letal arma de guerra, afim de \n"
                         + "combater a maior ameaça que o planeta Terra já enfrentou...");
        geral.next();
        System.out.println(geral.yellow+"***************************************************************"+geral.fim);
        System.out.println(geral.yellow+"|"+geral.fim+"                          TRADS                              "+geral.yellow+"|"+geral.fim);
        System.out.println(geral.yellow+"|"+geral.fim+"    ( Temivel Raça Alienígena Devoradora de Sociedade )      "+geral.yellow+"|"+geral.fim);
        System.out.println(geral.yellow+"***************************************************************"+geral.fim);
        geral.next();
        
        return nome;
    }
    
    // Função para atribuir a classe do jogador.
    static String classes(){
        String classe,confirmar,escolha;
        
        
        do{
            System.out.println("_______________________________________________________________");
            System.out.println(geral.purple+"                          Classes"+geral.fim);
            System.out.println("");
            System.out.println(" (1)   - T-rex -");
            System.out.println(" (2) - Triceratops -");
            System.out.println(" (3) - Pterodátilo -");
            System.out.println("");
                
            // Laço para caso o usuario digite um valor que esta fora das opções das classes
            do{
                System.out.print("Escolha uma classe: ");
                escolha = input.nextLine();
               
               // Se for diferente  de 1, 2 e 3 escreve a mensagem de erro e repete
                if(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3")){
                System.err.println("( Essa classe não exixte! )");
                }
            }while(!escolha.equals("1") && !escolha.equals("2") && !escolha.equals("3"));
        
            
            classe = ESPclasses(escolha); // Mostra as especificações da classe escolhida.
            System.out.println("");
            confirmar = geral.confirmar();
        }while(!confirmar.equals("S"));  
        
        return classe;
    }
    
    
    // Especificações Da classe escolha.
    static String ESPclasses(String x){        
        String classe = "asd";
        
        // Aqui atribuimos o nome da classe em uma variavel.
        switch(x){
            case "1":
                classe = "T-rex";
                break;
            case "2":
                classe = "Triceratops";
                break;
            case "3":
                classe = "Pterodátilo";
                break;
            default:
                System.err.println("COMO VOCÊ CHEGOU AQUI ?");
        }
        
        
        switch (x) {
            case "1":
                System.out.println("                                                                                                  \n" +
                        "                           .         .    ....   .  .   ...                                         \n" +
                        "                         .‘\"((((((((((((((==((=((==(((¦!..                                          \n" +
                        "                  ..‘(=(==777777===777777777777777777====((((¦\".. .              ..¦===(((¦*. . . . \n" +
                        "                 .(=7=7CCC77CCCC33JCCC77777777777CC77777C777==7=((((¦,.         \"77C73C=77===¦7(,   \n" +
                        "              .¦(77JJJ33333$$$33JJJJJCC33JJC3$JCCCCC7CCCCCC77777777777===(=*..\"7CCCJJ¦3$777=(=77.   \n" +
                        "           .\"==7CJ73$3J333$$$$$$$3333$J33$$3J33CJCCCJJJC3JC7CCCCCCC77===(==77CJCCCC3$33$$$J777=(*.  \n" +
                        "   .....\"¦77CJCJ3333..     .J$3$$$$33$$$$$$3$3JJJCCCJJJ$JJJJ3JJJJJJJC7C7=$J33C$3$$3J7CJ3JJJC77777=, \n" +
                        "‘7JJCCCCJJ3J$3$$               .7$3$$$3$$$$$33J3JJCCJJJ3$$$JJJ3JJJ3CCJCC3JCC33$$J3$$33$3C33JCC7CC(7 \n" +
                        "      ..‘‘. ..                    . ¦$$$$3$$$$33333$333$$$$$$3333$3JJJJ3$3$3$$$$$JJ333$$C333JJCCC7C.\n" +
                        "                                     . 7$3$3$$3333$$33$$$$$$3$$$$3J3$3C3$$$$$$$$$333$$$$$,J3J33JCCC.\n" +
                        "                                        ($$$3$$$$$$$$$$$$$$$3$3333$$$3$$$$$$33$$$$3$3$$3$$$**7..*7. \n" +
                        "                                      . 3$$$$33$$$$$$$$$33$$$$$$$$$3$$3$$333,3(. ($$33$($$$$,..   . \n" +
                        "                                     ‘333333$$3$$3$$$$$$$$$$$$$$$$$7$¦,     ‘3.    ¦33C¦$3$$.       \n" +
                        "                                .  .3J333333$$$$$!  J$$$$$$$$$..   ,,        .     .!$3(CC33.       \n" +
                        "                            .  .33333333$$$$3$3$      $$$$$$$                        .33¦(3$.       \n" +
                        "                              7333333$$$$3337. .      J$$$$$7                          ¦JJ7C        \n" +
                        "                            .¦333333$37‘             .!3$$$$3                                       \n" +
                        "                             3333333                   ,$3333(                          .           \n" +
                        "                            733333J                     3$337333. .                                 \n" +
                        "                           .J3J333.                     ,$333J333333(.                              \n" +
                        "                           ,33J3333.                      ,33333JJJJ3J(                             \n" +
                        "                           .3J3$3333,.                                                              \n" +
                        "                             JJJ3$3333¦ .                                                           \n" +
                        "                             . 77CJJ7                                                               \n" +
                        "                                . .   .        ");
                break;
            case "2":
                System.out.println("                                                  \n" +
                        "                                                            3A$J$$$%%‘                              \n" +
                        "                                                        ..\"$$$3J%%$J$3*.                            \n" +
                        "                                                       .7AJ$JJCJ3$$3$%,.                            \n" +
                        "                              .  .. .\"   ...          .=J3%3C3%$$$%%%J3.                            \n" +
                        "                           .‘J¦CA$$A%$%A$CJ(J\"‘ .    \"53$JJC7$$$CA@$$33.                            \n" +
                        "                        . AJ33J33C$3$3A33J3$C$J$$3(..*CC$JC=J333JJ#%CJ$=                            \n" +
                        "                       ‘JC=3JJ$$3J5333J%$$AJ33%%555@5$3J3C7=333JJ3JCJ3C.                            \n" +
                        "                    .,7%JJJ%3J333333CC$$J$3$33%%$%AA7J3333JC%3$$3CCC$=J* .                          \n" +
                        "                  .,C7C3J33J$$37JJ3333333JJ3%%%%AA@5%J%33J3JJJC333JCCJJCJ....  ..  .. ... .    .¦A‘ \n" +
                        "                 ‘(33J3JC3333J3J3J333JJJJ$7JC$%%AA55CJJ$3J333J7JJ333J33$J3J%%AAA%AAA%%A%%%AA%5@@@   \n" +
                        "             . *C$33C333J3333CC%JJC3JCCCCJ3JJJ333$A5JJJ3$$3333$%3JJ%JJ55555A$3$A@@@555@@@A$$A.  .   \n" +
                        "\"*.          333JJJJJ33$J3JJC$J%%3$$CCCJCJ3$3$$A#@C%CJ3J3A$3J3J33J3AJAAAAAAAAAAAAAA%AA%%AAA         \n" +
                        ".%$(. ....*J$%JC3J3333C=CJJ3J%3%%33JJCJ$J33CC$=5$3@@AJCJ33$3J$33J$%%3$5AAAAAA55AAAAA5A3.            \n" +
                        "  CJ3C$$3J3$CCJJ3$$$3JJJ3CCJ3%$A%$33JCJJ5CJ$CJJ3J5%@$%JCJ3JJ33$A$$33%%3CCC$$%AA%.     .             \n" +
                        "   . *$3J3333%$$3(\",,CJ7JJ$JJ$$@%CJ$$$%#33JC3CJ73$5@$3$$$53%%3J3J3JJ3$%%$33JJCJ$$3$(..     ..       \n" +
                        "    .   .          ,J7C3JJC7$3$5%$$%%%%3C=JJC7CJ$JA$$J33$%$J33%J33JC7JC3J$33$$$JJ3J3$#@%$5$.        \n" +
                        "                  =JJJJJ3CJC$$.35@%A%$3JC7C7CJJ$3%$%$3$3%%@33$$33JCJ3C3$3$JJ333$$3$$3CA55A.         \n" +
                        "                ..J3JC$JJCJ$$. ..3@@@$C37JCJCJJ...      A@##5AA3333333JJ3C3$$33JC3$3%73377          \n" +
                        "              ..\"J333C3J33$¦.. $5@##533CCC7C3..          %5AAA5A%‘‘\"J$C3J3JJ$$$JJ%$3CCC33$          \n" +
                        "              *JJ33$%AA%%..  ($A55@@%.3J7CJJJ . .         (%AA%%AJ.        .3J$$A#@#.AAAAA          \n" +
                        "             *733J3%$%$  . .‘JJ$A55#@53CCJ33$‘...........  ‘$5%$$%%.         ..=$AAA(..A7‘          \n" +
                        "             JJ33C$$%A5A5,,‘‘,$$%#@5@@$J3$J$$\"‘‘‘‘‘‘‘‘‘‘‘....$%3JC$3¦           ...CA .             \n" +
                        "            .JJ%3J3%%C3AA@@===(7A3====(CCJJJ3********,,,,,,‘,$$3J%$33C$C..          .               \n" +
                        "            .55%33$5AA33J======******,*C7CCJJ$¦**¦**====*****3$%JA%3J33J3$J                         \n" +
                        "            .=,,,,,\",,,,,,,**********,*JCCJJJ$$%%3$@¦========A%7C3J#A%3$3‘.                         \n" +
                        "               ..........‘‘‘‘‘‘‘‘,,,,,,CJJJ3$JJ$%CC$$********¦****,,‘‘‘..                           \n" +
                        "                            ......‘‘‘‘‘\"3CC3JJJC$%**,‘‘‘‘‘‘‘‘‘.....                                 \n" +
                        "                                  .....‘‘‘*$3¦**,‘....                                              \n" +
                        "                                                       ");
                break;
            case "3":
                System.out.println(" !#Ð%¦                                                                                             \n" +
                        "    ,@##5#@%.                                                                                       \n" +
                        "       ¦5@@55@Ð@#*  .                                                                               \n" +
                        "          ‘#5#Ð@###Ð@A,                                                                             \n" +
                        "             ‘%##@@@@ÐÐ@@Ð$   .                                                                     \n" +
                        "               .5A5##@###@@@##$                                                                     \n" +
                        "                . .5###@##@@@@@@@WJ                                                                 \n" +
                        "                     7AA5@@@##@##@#@@Ð.                                                             \n" +
                        "                        7$5#@##5#####5#@@                                                           \n" +
                        "                           J3$55#Ð#555###@#3 ,*.                                                    \n" +
                        "                             =3%A%%A55A55#55#®5¦$                                                   \n" +
                        "                               !$%%AAAA$$5A55@W3                                                    \n" +
                        "                                .$J$CJ%%%%555##Ð3                                                   \n" +
                        "                                  .3CCCJ$%$%A5#@Ð%                                                  \n" +
                        "                                   .,$CJ$$$JJC$Ð@@7.                                                \n" +
                        "                                      JJC3CC$J$A@#WA                                                \n" +
                        "                                      .JJ$JJCCJ$@Ð@#=‘                                              \n" +
                        "                                       ,%CJCCCJ3$@@W@A,                                             \n" +
                        "                                        $JJJJ%CJ$%@Ð5#5*                                            \n" +
                        "                                        3$$$CCCJ%%Ð#@55ÐJ                                           \n" +
                        "                                        A%A%J%$A#5#@ÐÐÐ#5==.           ¦A#J*                        \n" +
                        "                                        @%%A#AA@@ÐÐ@@Ð55@#=7Ð¦... J#Ð®@A#WW5A=,                     \n" +
                        "                                       $5555A@ÐWW@@#@5@@#5$J7CCC3J77$5#W#5WW##%5%C=, .              \n" +
                        "                                    .J5#5%A5@@55@##@@Ð@@@@ÐWWÐWWWWW®W@@®WW®Ð@@#5%AA%5AJ%            \n" +
                        "                            ,73J   %## .  ‘@W5#@ÐWWWWWWWWWWWWWW5J.                    .             \n" +
                        "                            ¦.J%Ð@@, . ,#@%5WW®WÐWWWW®®®®WWWÐ@@@@@J                                 \n" +
                        "                                ..7#$5W5*.    .WWWWWWWÐ@@55#5ÐWW@@ÐW$                               \n" +
                        "                           .,A55J.           %Ð@5Ð@##@##@AAC%CA%@ÐÐWWÐA‘                            \n" +
                        "               ¦7=J¦‘‘75=, . ..        ‘#AÐ@##$¦¦%5A@A55%AA%A$C%3#JA%@@#@A                          \n" +
                        "              J5##Ð*.                  AÐ,            ‘JA$%A%$A$$AC$C$CAAÐÐW.                       \n" +
                        "                                      !¦5                 ‘5$JJ$$$%%%J$CJJ$A@#%%                    \n" +
                        "                                                             J$$CJ%$$$3%3%$3J#A#‘#,                 \n" +
                        "                                                               .#$$$3%%%%A%5$$%5Ð .                 \n" +
                        "                                                                 .$$$$5AA%A%#AAAAÐ                  \n" +
                        "                                                                    ¦CJ$$5%%A###55Ð                 \n" +
                        "                                                                      *JJ$%A#5@#A@5J .              \n" +
                        "                                                                        *$$%55#@5@@#*               \n" +
                        "                                                                         .3A###@##Ð@#               \n" +
                        "                                                                           ,A5#@@#@@@A              \n" +
                        "                                                                            7A5######@*             \n" +
                        "                                                                             ,55#@5#@@@             \n" +
                        "                                                                              *55##@##A@            \n" +
                        "                                                                                #@###5@@‘.          \n" +
                        "                                                                                 @Ð@#@##Ð           \n" +
                        "                                                                                 .¦@@###5#          \n" +
                        "                                                                                    ®@@@@@¦         \n" +
                        "                                                                                     @@@@@A         \n" +
                        "                                                                                       @ÐÐ55.       \n" +
                        "                                                                                        ‘@##7       \n" +
                        "                                                                                          *#5*      \n" +
                        "                                                                                            ¦#‘");
                break;
            default:
                break;
        }
        
        // Estrutura Switch para exibir o comentario da classe escolhida pelo usuario
        switch(x){
            case "1":
                System.out.println("- "+geral.purple+"T-rex"+geral.fim+" -");
                System.out.println("Você  possui força extraordinária com  grandes vantagens \n"
                                 + "em batalhas corpo a corpo, porem uma pequena dificuldade \n"
                                 + "com armas.");
                break;
            case "2":
                System.out.println("- "+geral.purple+"Triceratops"+geral.fim+" -");
                System.out.println("Graças a sua força e resistência os cientistas conseguiram\n"
                                 + "desenvolver  uma  maneira de te  deixar  mega resistente a\n"
                                 + "balas com uma blindagem especial, porem você é um bastante\n"
                                 + "lento graças ao peso da blindagem.");
                break;
            case "3":
                System.out.println("- "+geral.purple+"Pterodátilo"+geral.fim+" -");
                System.out.println("Você tem uma grande velocidade e um grande arsenal aéreo \n"
                                 + "de  misseis, porem  você não  é muito  resistente em uma \n"
                                 + "batalha corpo a corpo");
                break;
            default:
                System.err.println("COMO VOCÊ CHEGOU AQUI ?");
        }
        
        return classe;
    }
//******************************************************************************
    
    
    
// Parte 2 da historia, Seus primeiros desafios. *******************************
    static boolean desafio1( String nome, String classe ){
        
        String escolha;
        boolean resposta = false;
        int var1 = 0, var2 = 0;
        int questao;
        
        questao = randow.nextInt(5);
        questao++;
        
        switch( questao ){
            case 1 :
                var1 = 125000;
                var2 = 216000;
                break;
            case 2 :
                var1 = 178900;
                var2 = 294000;
                break;
            case 3 :
                var1 = 190000;
                var2 = 301000;
                break;
            case 4 :
                var1 = 113640;
                var2 = 246130;
                break;
            case 5 :
                var1 = 179900;
                var2 = 294000;
                break;
        }
        
                // Introdução á sua primeira batalha // 
        System.out.println("");
        System.out.println("***"+geral.purple+" Gansu,China – 9:18 PM "+geral.fim+"***\n"+
        "\n" +
        "A invasão começou! Você precisará destruir as imensas naves de combate \n"
      + "enviadas pelos invasores. Nossa primeira linha de defesa, formada pelo \n"
      + "Exército Planetário"+geral.purple+"(EP)"+geral.fim+", foi aniquilada por armas avançadas.");
        geral.next();
        
        System.out.println("");
        System.out.println("-"+geral.blue+" “Não teremos nenhuma chance de vencer essa batalha,\n"
                         + " chamem nossa arma secreta!"+geral.fim+" ”(General Márcio)");
        geral.next();
        System.out.println("");
        
        System.out.println(nome+" chegou no campo de batalha, mostre para esses invasores o poder de suas armas!\n"
        + "Para derrota-los, será necessário usar seus mísseis nucleares,porém,\n"
        + "eles  possuem  alcance limitado. Sabendo  que  seus  mísseis cobrem\n"
        + geral.purple+""+var1+"metros"+geral.fim+" de distância e seu herói se encontra a "+geral.purple+""+var2+"metros"+geral.fim+" \n"
        + "de distância dos inimigos, quantos metros "+nome+" terá que andar\n"
        + "para conseguir destruir seus alvos?");
        System.out.println("(A)"+geral.purple+" 115100"+geral.fim+"metros."); // case 2
        System.out.println("(B)"+geral.purple+" 114100"+geral.fim+"metros."); // case 5
        System.out.println("(C)"+geral.purple+" 111000"+geral.fim+"metros."); // case 3
        System.out.println("(D)"+geral.purple+" 91000"+geral.fim+"metros.");  // case 1
        System.out.println("(E)"+geral.purple+" 132490"+geral.fim+"metros."); // case 4
        
        escolha = geral.desafio(); // Chamando a lista de alternativas
        
        switch( questao ){
            case 1 :
                resposta = geral.respD( escolha );
                break;
            case 2 :
                resposta = geral.respA( escolha );
                break;
            case 3 :
                resposta = geral.respC( escolha );
                break;
            case 4 :
                resposta = geral.respE( escolha );
                break;
            case 5 :
                resposta = geral.respB( escolha );
                break;
        }
        
        // Mensagem para caso o usuário tenha errado ou acertado a questão.
        if ( resposta == true ) {
            
            System.out.println(geral.green+"- Na mosca!!! Você atingiu seu alvo em cheio, parabéns! "+geral.fim);
            
        } else {
            geral.feedback1( var1 , var2 );
            System.out.println(geral.red+"- Infelizmente você ficou mal posicionado e errou o disparo!"+geral.fim);
            
        }
        System.out.println("");
        
        
        geral.next();
        return resposta;
    }
    
//-------------------------------DESAFIO 2-------------------------------------- 
    
    static boolean desafio2( String nome, String classe ){

        String escolha[] = new String[3];
        String desafio[];
        boolean resposta = false;
        int questao;
        
        questao = randow.nextInt(6);
        questao++;
        
        
        desafio = arrumaArma( questao );
        
        
        System.out.println("Cuidado!");
        System.out.println("");
        
        System.out.println("inimigos se aproximando, ligue seu canhão de protons, porem\n"
        + "para que isso aconteça você tera que interligar os pólos\n"
        + geral.purple+"negativo"+geral.fim+"( - ) e "+geral.purple+"positivo"+geral.fim+"( + ) nas entradas, seguindo a\n"
        + geral.purple+"regra de sinais"+geral.fim+" conforme a tabela a seguir: ");
        
        do{
            System.out.print("- Entrada 1 = "+desafio[0]+"--> "); // Pergunta 1 
            escolha[0] = input.nextLine();
            if( !escolha[0].equals("+") && !escolha[0].equals("-") ){ System.out.println(geral.red+"Somente + ou - por favor."+geral.fim); }
        }while( !escolha[0].equals("+") && !escolha[0].equals("-") );
        do{
            System.out.print("- Entrada 2 = "+desafio[1]+"--> "); // Pergunta 2 
            escolha[1] = input.nextLine();
            if( !escolha[1].equals("+") && !escolha[1].equals("-") ){ System.out.println(geral.red+"Somente + ou - por favor."+geral.fim); }
        }while( !escolha[1].equals("+") && !escolha[1].equals("-") );
        do{
            System.out.print("- Entrada 3 = "+desafio[2]+"--> "); // Pergunta 3 
            escolha[2] = input.nextLine();
            if( !escolha[2].equals("+") && !escolha[2].equals("-") ){ System.out.println(geral.red+"Somente + ou - por favor."+geral.fim); }
        }while( !escolha[2].equals("+") && !escolha[2].equals("-") );
        
        System.out.println("");
        resposta = validaConserto( escolha, questao );
        
        System.out.println("");
        if ( resposta == true ) {
            
            System.out.println(geral.green+"- Mui bem!"+geral.fim);
            System.out.println("Você ligou a arma e aniquilou os inimigos que estavam por vir\n"
                    + "agora vamos prosseguir com a nossa missão.");
            geral.next();
        } else {
            
            System.out.println(geral.red+"- infelismente você acabou não conseguindo arrumar a arma\n"
                    + "e ficou cercado "+geral.fim);
            geral.next();
        }
        
        return resposta;
    }
//----------------Funções para o Desafio 2--------------------------------------
    
    // Função feita para ajeitar a questão conforme o valor aleatorio.
    static String[] arrumaArma( int questao ){
        String desafio[] = new String[6];
        
        switch( questao ){
            case 1 :                          // RESPOSTAS //
                desafio[0] = ""+geral.purple+"[ + ]"+geral.fim+" * "+geral.purple+"[ + ]"+geral.fim+""; // +
                desafio[1] = ""+geral.purple+"[ - ]"+geral.fim+" * "+geral.purple+"[ + ]"+geral.fim+""; // -
                desafio[2] = ""+geral.purple+"[ + ]"+geral.fim+" * "+geral.purple+"[ - ]"+geral.fim+""; // -
                break;
            case 2 :
                desafio[0] = ""+geral.purple+"[ - ]"+geral.fim+" * "+geral.purple+"[ + ]"+geral.fim+""; // -
                desafio[1] = ""+geral.purple+"[ - ]"+geral.fim+" * "+geral.purple+"[ - ]"+geral.fim+""; // +
                desafio[2] = ""+geral.purple+"[ + ]"+geral.fim+" * "+geral.purple+"[ - ]"+geral.fim+""; // -
                break;
            case 3 :
                desafio[0] = ""+geral.purple+"[ - ]"+geral.fim+" * "+geral.purple+"[ + ]"+geral.fim+""; // -
                desafio[1] = ""+geral.purple+"[ + ]"+geral.fim+" * "+geral.purple+"[ - ]"+geral.fim+""; // -
                desafio[2] = ""+geral.purple+"[ + ]"+geral.fim+" * "+geral.purple+"[ + ]"+geral.fim+""; // +
                break;
            case 4:
                desafio[0] = ""+geral.purple+"[ - ]"+geral.fim+" * "+geral.purple+"[ - ]"+geral.fim+""; // +
                desafio[1] = ""+geral.purple+"[ + ]"+geral.fim+" * "+geral.purple+"[ + ]"+geral.fim+""; // +
                desafio[2] = ""+geral.purple+"[ - ]"+geral.fim+" * "+geral.purple+"[ + ]"+geral.fim+""; // -
                break;
            case 5:
                desafio[0] = ""+geral.purple+"[ + ]"+geral.fim+" * "+geral.purple+"[ + ]"+geral.fim+""; // +
                desafio[1] = ""+geral.purple+"[ - ]"+geral.fim+" * "+geral.purple+"[ + ]"+geral.fim+""; // -
                desafio[2] = ""+geral.purple+"[ - ]"+geral.fim+" * "+geral.purple+"[ - ]"+geral.fim+""; // +
                break;
            case 6:
                desafio[0] = ""+geral.purple+"[ - ]"+geral.fim+" * "+geral.purple+"[ + ]"+geral.fim+""; // -
                desafio[1] = ""+geral.purple+"[ - ]"+geral.fim+" * "+geral.purple+"[ - ]"+geral.fim+""; // +
                desafio[2] = ""+geral.purple+"[ + ]"+geral.fim+" * "+geral.purple+"[ + ]"+geral.fim+""; // +
                break;                        //----------//
        }
        
        return desafio;
    }
    static boolean validaConserto( String escolha[], int questao ){
        boolean resposta = false;
        boolean temp;
        
        switch( questao ){
            case 1 :
                temp = escolha[0].equals("+");
                mostraPolo1( temp );
                temp = escolha[1].equals("-");
                mostraPolo2( temp );
                temp = escolha[2].equals("-");
                mostraPolo2( temp );
                
                resposta = escolha[0].equals("+") && escolha[1].equals("-") && escolha[2].equals("-");
                break;
            case 2 :
                temp = escolha[0].equals("-");
                mostraPolo1( temp );
                temp = escolha[1].equals("+");
                mostraPolo2( temp );
                temp = escolha[2].equals("-");
                mostraPolo2( temp );
                
                resposta = escolha[0].equals("-") && escolha[1].equals("+") && escolha[2].equals("-");
                break;
            case 3 :
                temp = escolha[0].equals("-");
                mostraPolo1( temp );
                temp = escolha[1].equals("-");
                mostraPolo2( temp );
                temp = escolha[2].equals("+");
                mostraPolo2( temp );
                
                resposta = escolha[0].equals("-") && escolha[1].equals("-") && escolha[2].equals("+");
                break;
            case 4 :
                temp = escolha[0].equals("+");
                mostraPolo1( temp );
                temp = escolha[1].equals("+");
                mostraPolo2( temp );
                temp = escolha[2].equals("-");
                mostraPolo2( temp );
                
                resposta = escolha[0].equals("+") && escolha[1].equals("+") && escolha[2].equals("-");
                break;
            case 5 :
                temp = escolha[0].equals("+");
                mostraPolo1( temp );
                temp = escolha[1].equals("-");
                mostraPolo2( temp );
                temp = escolha[2].equals("+");
                mostraPolo2( temp );
                
                resposta = escolha[0].equals("+") && escolha[1].equals("-") && escolha[2].equals("+");
                break;
            case 6 :
                temp = escolha[0].equals("-");
                mostraPolo1( temp );
                temp = escolha[1].equals("+");
                mostraPolo2( temp );
                temp = escolha[2].equals("+");
                mostraPolo2( temp );
                
                resposta = escolha[0].equals("-") && escolha[1].equals("+") && escolha[2].equals("+");
                break;
        }
        
        return resposta;
    }
    
//------------------------------------------------------------------------------
    //-METODOS USADOS PARA MOSTRAR O POLO NA TELA CONFORME O RESULTADO DELE-----
    static void mostraPolo1( boolean valida ){
        if ( valida == true ) {
            System.out.println(geral.green+"- Entrada 1 -"+geral.fim);
        } else {
            System.out.println(geral.red+"- Entrada 1 -"+geral.fim);
        }      
    }
    static void mostraPolo2( boolean valida ){
        if ( valida == true ) {
            System.out.println(geral.green+"- Entrada 2 -"+geral.fim);
        } else {
            System.out.println(geral.red+"- Entrada 2 -"+geral.fim);
        }      
    }
    static void mostraPolo3( boolean valida ){
        if ( valida == true ) {
            System.out.println(geral.green+"- Entrada 3 -"+geral.fim);
        } else {
            System.out.println(geral.red+"- Entrada 3 -"+geral.fim);
        }
    }
    //--------------------------------------------------------------------------
//******************************************************************************
    
    
//************************* Parte 3 da historia ********************************
    static boolean desafio3( String nome, String classe ){
        
        int questao;
        int valor = 0;
        String escolha;
        boolean resposta = false;
        
        questao = randow.nextInt(5);
        questao++;
        
        switch( questao ){
            case 1 :
                valor = 200; // 5000
                break;
            case 2 :
                valor = 100; // 2500
                break;
            case 3 :
                valor = 150; // 3750
                break;
            case 4 :
                valor = 300; // 7500
                break;
            case 5 :
                valor = 250; // 6250
                break;
        }
        
        System.out.println("");
        System.out.println("***"+geral.purple+" Moscou,Rússia – 2:10 AM "+geral.fim+"***\n" +
"\n" +
                "Não temos tempo para descansar, os invasores estão destinados a destruírem\n"
                +"toda  a  raça  humana! Uma nova horda de "+geral.purple+"TADS"+geral.fim+" se  aproxima, dessa vez,\n"
                +"veículos terrestres avançam sobre nossas defesas, aja imediatamente!!!");
        geral.next();
        
        System.out.println("");
        System.out.println("Você dispara inúmeras vezes  contra os invasores usando  seus canhões de\n"
                         + "prótins, porém, as armas  lançam "+geral.purple+""+valor+" disparos"+geral.fim+"  durante  "+geral.purple+"2 minutos"+geral.fim+"(ciclo)\n"
                         + "e precisam de "+geral.purple+"24 segundos"+geral.fim+" de intervalo para recarregar. Quantos disparos\n"
                         + "conseguirá realizar em "+geral.purple+"1 hora"+geral.fim+"(60 minutos) ?");
        
        System.out.println("(A)"+geral.purple+" 2500 "+geral.fim+"disparos."); // 2
        System.out.println("(B)"+geral.purple+" 7500 "+geral.fim+"disparos."); // 4
        System.out.println("(C)"+geral.purple+" 6250 "+geral.fim+"disparos."); // 5
        System.out.println("(D)"+geral.purple+" 5000 "+geral.fim+"disparos."); // 1
        System.out.println("(E)"+geral.purple+" 3750 "+geral.fim+"disparos."); // 3
        
        escolha = geral.desafio();
        
        switch( questao ){
            case 1 :
                resposta = geral.respD( escolha );
                break;
            case 2 :
                resposta = geral.respA( escolha );
                break;
            case 3 :
                resposta = geral.respE( escolha );
                break;
            case 4 :
                resposta = geral.respB( escolha );
                break;
            case 5 :
                resposta = geral.respC( escolha );
                break;
        }
        
        if( resposta ==  true ){
            System.out.println(geral.green+"- Você é realmente formidável. Após várias horas, milhares \n"
                             + "de invasores foram aniquilados pelos seus canhões."+geral.fim);
            
        } else {
            geral.feedback3( valor );
            System.out.println(geral.red+"- Você mostrou ser um soldado sem experiência com armamentos."+geral.fim);
            
        }
        geral.next();
        return resposta;
    }
//***************************** Final parte 3 **********************************
    
    
    
//*************************** Parte 3 historia *********************************
    static boolean desafio4( String nome, String classe ){
        
        boolean resposta = false;
        int questao;
        double valor = 0;
        String escolha;
        
        questao = randow.nextInt(5);
        questao++;
        
        switch( questao ){
            case 1 :
                valor = 689.00; // 276,400,00
                break;
            case 2 :
                valor = 485.00; // 194,800,00
                break;
            case 3 :
                valor = 675.00; // 270,800,00
                break;
            case 4 :
                valor = 794.00; // 318,400,00
                break;
            case 5 :
                valor = 598.00; // 240,000,00
                break;
        }
        
        System.out.println("*** "+geral.purple+"Centro de Poltava, Ucrânia – 8:20 AM"+geral.fim+" ***\n" +
"\n" +
"A batalha ja dura mais de 9 meses e os gastos em equipamentos só aumenta, \n"
                + "logo logo ficaremos sem equipamentos, precisamos fazer um calculo mínimo\n"
                + "de gastos para conseguir segurar as nossas defesas por mais tempo.");
        
        System.out.println("");
        
        System.out.println("Na produção de armas, uma fábrica tem  um custo "+geral.purple+"fixo de R$ 800.00"+geral.fim+" mais um custo\n" +
                           ""+geral.purple+"variável de "+geral.purple+""+valor+"0"+geral.fim+" por  unidade  produzida. Sendo x o número de peças unitárias\n" +
                           "produzidas, o custo de produção de "+geral.purple+"400 peças"+geral.fim+":      (  "+geral.blue+"f(x) = ax + b"+geral.fim+"  ).");
        System.out.println("(A) R$"+geral.purple+" 270,800,00"+geral.fim+"."); // case 3
        System.out.println("(B) R$"+geral.purple+" 318,400,00"+geral.fim+"."); // case 4
        System.out.println("(C) R$"+geral.purple+" 194,800,00"+geral.fim+"."); // case 2
        System.out.println("(D) R$"+geral.purple+" 276,400,00"+geral.fim+"."); // case 1
        System.out.println("(E) R$"+geral.purple+" 240,000,00"+geral.fim+"."); // case 5
        
        escolha = geral.desafio();
        
        
        switch( questao ){
            case 1 :
                resposta = geral.respD( escolha );
                break;
            case 2 :
                resposta = geral.respC( escolha );
                break;
            case 3 :
                resposta = geral.respA( escolha );
                break;
            case 4 :
                resposta = geral.respB( escolha );
                break;
            case 5 :
                resposta = geral.respE( escolha );
                break;
        }
        
        if ( resposta == true ) {
            System.out.println(geral.green+"- Parabens, você conseguiu cortar um pouco dos nossos gastos."+geral.fim);
            
        } else {
            geral.feedback4( valor );
            System.out.println(geral.red+"- Infelizmente não conseguimos calcular os gastos corretamente."+geral.fim);
           
        }
        geral.next();
        return resposta;
    }
    
    //-----------------------Inicio Caminho 1-----------------------------------
    static boolean caminho1( String nome , String classe ){
        boolean fim = false;
        
        fim = desafio5( nome , classe ); 
         

        return fim;
    }
    //------------------------Fim caminho 1-------------------------------------
    
    
    //-----------------------Inicio Caminho 2-----------------------------------
    // Se perdeo desafio 4
    static boolean caminho2( String nome , String classe ){
        boolean fim = false; 
        
        fim = desafio51( nome , classe );
        
        
        return fim;
    }
    //------------------------Fim caminho 2-------------------------------------
    
    
    
    //-------------------- Desafio Final "facil" -------------------------------
    
    static boolean desafio5( String nome, String classe ){
        
        boolean resposta = false;
        int questao;
        int valor = 0;
        String escolha; 
        
        System.out.println("Em  mais  uma tentativa de destruir  uma  das  bases do EP, os TRADS  avançam\n"
                         + "junto com a sua nave mãe (talvez por que esse jogo tenha que acaber uma hora),\n"
                         + "temos uma unica chanse para destruir essa nave mãe e acabar com os TRADS.");
        geral.next();
        
        System.out.println("Vamos usar nossos misseis no plural que faz parecer que causa mais estrago. ");
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
        return resposta;
    }
    
    //-------------------- Desafio Final "dificil" -----------------------------
    static boolean desafio51( String nome, String classe ){
        
        boolean resposta = false;
        int questao;
        int valor = 0;
        String escolha; 
        
                                     // Historia //
        System.out.println("-"+geral.blue+"“Parece que eles não desistem nunca…"+geral.fim+"(Capitão Márcio)”. \n");
        geral.next();
        
        System.out.println("Em  mais  uma tentativa de destruir  uma  das  bases do EP, os TRADS  avançam\n"
                         + "junto com a sua nave mãe (talvez por que esse jogo tenha que acaber uma hora),\n"
                         + "temos uma unica chanse para destruir essa nave mãe e acabar com os TRADS.");
        geral.next();
        
        System.out.println("Vamos usar nossos misseis no plural que faz parecer que causa mais estrago. ");
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
                         + "(dados: "+geral.purple+"sen 45º"+geral.fim+" = "+geral.purple+"0,785"+geral.fim+")       ("+geral.blue+"..."+geral.fim+").");  
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
        return resposta;
    }
    //-------------------- Desafio Final 2° Chanse -----------------------------
    static boolean desafio52( String nome, String classe ){
        
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
        return resposta;
    }
    
    
//**************************** Final parte 3 ***********************************
}