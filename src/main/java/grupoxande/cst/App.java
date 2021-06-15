package grupoxande.cst;




import CSTgame.time;
import java.io.FileInputStream;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * JavaFX App
 */
public class App extends Application{
    private static Scene scene;
    public static String[] nomes = new String[2];
    public static Rectangle[][] tabuleiro;
    public static ImageView[][] imagens;
    public static ImageView[][] animacoesAtaques;
    public static int tamanhoTabul;
    public static int ID;
    public static String posicao;
    public static String posicaoFinal;
    public static Label[] legendaLinha;
    public static Label[] legendaColuna;
    public static String nomeVencedor;
    public static time timeVencedor = null;
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("telaInicial"), 640, 480);
        stage.getIcons().add(new Image(new FileInputStream("C:\\Users\\Pedrão Barros\\Documents\\NetBeansProjects\\CST\\src\\main\\resources\\grupoxande\\cst\\imagem\\icone.png")));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void main(String[] args) {
        launch(args);
        System.out.println("ola mundo");
        /*Scanner scan = new Scanner(System.in);
        boolean pog = true;
        System.out.println("Seja Bem vindo ao Comp-Senai-Tactics");
        while(pog){
        System.out.println("EScolha qual ação quer visualizar: ");
        System.out.println("1 - Jogar");
        System.out.println("2 - Ver Regras");
        System.out.println("3 - Creditos");
        System.out.println("4 - Sair do jogo");
        int selec = scan.nextInt();
            switch (selec) {
                case 1:
                    rodarPartida(scan);
                    break;
                case 2:
                    try {
                        ManipuladorDeArquivo.lerArquivo("C:\\Users\\Pedrão Barros\\Documents\\NetBeansProjects\\CST\\src\\main\\java\\grupoxande\\cst\\Regras.txt");
                        scan.nextLine();
                        scan.nextLine();
                        UI.limparTelaConsole();
                    } catch (IOException e) {
                    }       break;
                case 3:
                    try {
                        ManipuladorDeArquivo.lerArquivo("creditos.txt");
                        scan.nextLine();
                        scan.nextLine();
                        UI.limparTelaConsole();
                    } catch (IOException e) {
                    }       break;
                case 4:
                    System.out.println("Saindo...");
                    pog = false;
                    break;
                default:
                    break;
            }
    }*/
      }

      /*public static void rodarPartida(Scanner scan){
        int selec, linhas, colunas, ID = 1;
        String resp = "S";
       
        linhas = UI.escolhaDoFormato(scan);
        switch (linhas) {
            case 20:
                ID = 1;
                break;
            case 10:
                ID = 2;
                break;
            case 26:
                ID = 3;
                break;
            default:
                break;
        }
        colunas = linhas;
        String[] nomes = UI.lerNomes(scan);
        boolean[][] possiveisAlgumaCoisa;
        
        partidaCST partidaCST = new partidaCST(linhas, colunas, ID);
        
         while("S".equals(resp)){
            
            
            UI.printarSorteioAtqPecas(partidaCST);
            scan.nextLine();
            scan.nextLine();
            while(partidaCST.ispartida()){
                try{
                
                selec = UI.printarPartida(partidaCST, nomes, linhas, scan);
                if(partidaCST.ispartida() == false){
                    partidaCST.escreverNoArquivo(partidaCST);
                    break;
                }
                    switch (selec) {
                        case 1:
                            scan.nextLine();
                            System.out.println();
                            System.out.println("Ataque");
                            System.out.print("posicao origem: ");
                            CSTposicao posicaoAtacante = UI.lerPosicao(scan, linhas);
                            possiveisAlgumaCoisa = partidaCST.possiveisAtaques(posicaoAtacante);
                            UI.limparTelaConsole();
                            UI.printarTabuleiro(partidaCST.getPecas(), linhas, possiveisAlgumaCoisa);
                            System.out.println();
                            System.out.print("posicao destino: ");
                            CSTposicao posicaoAtacado = UI.lerPosicao(scan, linhas);
                            partidaCST.perfomaceAtaque(posicaoAtacante, posicaoAtacado);
                            break;
                    //alou;
                    //alou
                        case 2:
                            {
                                scan.nextLine();
                                System.out.println();
                                System.out.println("Movimento");
                                System.out.print("posicao origem: ");
                                CSTposicao origem = UI.lerPosicao(scan, linhas);
                                possiveisAlgumaCoisa = partidaCST.possiveisMovimentos(origem);
                                UI.limparTelaConsole();
                                UI.printarTabuleiro(partidaCST.getPecas(), linhas, possiveisAlgumaCoisa);
                                System.out.println();
                                System.out.print("posicao destino: ");
                                CSTposicao destino = UI.lerPosicao(scan, linhas);
                                partidaCST.perfomaceFazerMovimento(origem, destino);
                                break;
                            }
                        case 3:
                            {
                                scan.nextLine();
                                System.out.println();
                                System.out.println("Habilidade");
                                System.out.print("posicao origem: ");
                                CSTposicao origem = UI.lerPosicao(scan, linhas);
                                System.out.println();
                                if(partidaCST.getJogador().getPecaAtual() instanceof racoba){
                                    System.out.println();
                                    partidaCST.perfomaceHabilidade(origem, origem);
                                }
                                else{
                                    System.out.print("posicao destino: ");
                                    CSTposicao destino = UI.lerPosicao(scan, linhas);
                                    partidaCST.perfomaceHabilidade(origem, destino);
                                }           break;
                            }
                        case 4:
                            if(partidaCST.getJogador().getPecaAtual() instanceof racoba){
                                System.out.println("Nada de itens! só equipamentos gacha!!!!");
                            }
                            else{
                                scan.nextLine();
                                UI.menuItem(scan, partidaCST);
                                System.out.println();
                            }       break;
                        default:
                            break;
                    }
                }
                catch(exececaoCST | InputMismatchException e){
                    System.out.println(e.getMessage());
                    scan.nextLine();
                    scan.nextLine();
                }
            }
            System.out.println("Quer jogar de novo[S/N}");
            resp = scan.nextLine();
            if("N".equals(resp.intern())){
                break;
            }else{
                resp = "S";
                partidaCST.resetarPartida(linhas, colunas, ID);
            }
        }
      }*/
           

        

    
    
}