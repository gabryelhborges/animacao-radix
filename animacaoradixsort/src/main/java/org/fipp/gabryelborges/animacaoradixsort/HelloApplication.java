package org.fipp.gabryelborges.animacaoradixsort;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class HelloApplication extends Application {
    AnchorPane pane;
    Button botao_inicio;
    private Button[] vetor, vetorCounting;
    private int larguraBotao = 61;
    private Label[] labels, labelsCounting;
    private int yVetor = 100, xVetor = 20, yVetorCounting = 400;

    @Override
    public void start(Stage stage) {
        stage.setTitle("ANIMATION OF RADIX SORT");
        pane = new AnchorPane();
        pane.getStyleClass().add("pane");

        botao_inicio = new Button();
        botao_inicio.setLayoutX(10);
        botao_inicio.setLayoutY(1);
        botao_inicio.setText("Executar Radix");
        botao_inicio.setOnAction(e -> {
            Random rand = new Random();
            int index1 = rand.nextInt(vetor.length);
            int index2 = rand.nextInt(vetor.length);
            while (index1 == index2) {
                index2 = rand.nextInt(vetor.length);
            }
            move_botoes(index1, index2);
            radix();
        });
        pane.getChildren().add(botao_inicio);

        criaVetor();
        criaLabels();

        criaVetorCounting();
        criaLabelsCounting();

        Scene scene = new Scene(pane, 1000, 800);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void criaLabelsCounting() {
        labelsCounting = new Label[10];
        for (int i = 0; i < labelsCounting.length; i++) {
            labelsCounting[i] = new Label(String.valueOf(i)); // Aqui é o índice do vetor
            labelsCounting[i].setFont(new Font(16));
            labelsCounting[i].setLayoutX(xVetor + i * larguraBotao + (larguraBotao / 2) - 10); // Para centralizar a label abaixo do botão
            labelsCounting[i].setLayoutY(yVetorCounting + 60); // Posição Y um pouco abaixo dos botões
            pane.getChildren().add(labelsCounting[i]);
        }
    }

    private void criaVetorCounting() {
        vetorCounting = new Button[10];
        for (int i = 0; i < vetorCounting.length; i++) {
            vetorCounting[i] = botaoConfigurado();
            vetorCounting[i].setText("0");
            vetorCounting[i].setLayoutX(xVetor + i * larguraBotao);
            vetorCounting[i].setLayoutY(yVetorCounting);
            vetorCounting[i].setFont(new Font(16));

            pane.getChildren().add(vetorCounting[i]);
        }
    }

    private void criaVetor() {
        vetor = new Button[10];
        for(int i = 0; i < vetor.length; i++){
            vetor[i] = botaoConfigurado();
            vetor[i].setLayoutX(xVetor + i * larguraBotao);
            vetor[i].setLayoutY(yVetor);
            vetor[i].setFont(new Font(16));

            pane.getChildren().add(vetor[i]);
        }
    }

    private Button botaoConfigurado(){
        Random r = new Random();
        Button b = new Button(String.valueOf(r.nextInt(2000)));
        b.getStyleClass().add("botao-vetor");
        b.setMinHeight(60);
        b.setMinWidth(larguraBotao);
        return b;
    }

    private void criaLabels() {
        labels = new Label[10];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new Label(String.valueOf(i)); // Aqui é o índice do vetor
            labels[i].setFont(new Font(16));
            labels[i].setLayoutX(xVetor + i * larguraBotao + (larguraBotao / 2) - 10); // Para centralizar a label abaixo do botão
            labels[i].setLayoutY(yVetor + 60); // Posição Y um pouco abaixo dos botões
            pane.getChildren().add(labels[i]);
        }
    }

    public void move_botoes(int index1, int index2) {
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() {
                double distY = 8;
                // Calcular a distância entre as posições iniciais
                double initialX1 = vetor[index1].getLayoutX();
                double initialY1 = vetor[index1].getLayoutY();
                double initialX2 = vetor[index2].getLayoutX();
                double initialY2 = vetor[index2].getLayoutY();

                // Definir as posições finais de ambos os botões
                double finalX1 = initialX2;
                double finalY1 = initialY2;
                double finalX2 = initialX1;
                double finalY2 = initialY1;

                // Primeira animação: Subir e descer
                for (int i = 0; i < 10; i++) {
                    final double deltaY1 = distY;  // Subir para o primeiro botão
                    final double deltaY2 = 0 - distY; // Descer para o segundo botão

                    Platform.runLater(() -> {
                        // Atualiza a posição dos botões suavemente
                        vetor[index1].setLayoutY(vetor[index1].getLayoutY() + deltaY1);
                        vetor[index2].setLayoutY(vetor[index2].getLayoutY() + deltaY2);
                    });

                    try {
                        Thread.sleep(50); // Tempo de espera para animar cada movimento
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Segunda animação: Movimentar para o lado
                for (int i = 0; i < 16; i++) {
                    final double deltaX1 = (finalX1 - initialX1) / 16;
                    final double deltaX2 = (finalX2 - initialX2) / 16;

                    Platform.runLater(() -> {
                        // Atualiza a posição dos botões suavemente
                        vetor[index1].setLayoutX(vetor[index1].getLayoutX() + deltaX1);
                        vetor[index2].setLayoutX(vetor[index2].getLayoutX() + deltaX2);
                    });

                    try {
                        Thread.sleep(50); // Tempo de espera para animar cada movimento
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Terceira animação: Descer e subir
                for (int i = 0; i < 10; i++) {
                    final double deltaY1 = 0 - distY;  // Descer para o primeiro botão
                    final double deltaY2 = distY;   // Subir para o segundo botão

                    Platform.runLater(() -> {
                        // Atualiza a posição dos botões suavemente
                        vetor[index1].setLayoutY(vetor[index1].getLayoutY() + deltaY1);
                        vetor[index2].setLayoutY(vetor[index2].getLayoutY() + deltaY2);
                    });

                    try {
                        Thread.sleep(50); // Tempo de espera para animar cada movimento
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Troca os botões na estrutura de dados, mas não troca as labels
                Button aux = vetor[index1];
                vetor[index1] = vetor[index2];
                vetor[index2] = aux;

                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    public void radix(){
        int maior = pegaMaior();

        for (int exp = 1; maior/exp > 0; exp*=10) {
            counting(exp);
        }
    }

    private int pegaMaior() {
        int maior = Integer.parseInt(vetor[0].getText());
        for (int i = 1; i < vetor.length; i++) {
            if(maior < Integer.parseInt(vetor[i].getText())){
                maior = Integer.parseInt(vetor[i].getText());
            }
        }
        return maior;
    }

    public void counting(int exp){
        zeraVetorCounting();//C[i] = 0;
        Button[] aux = new Button[10];
        for (int i = 0; i < vetor.length; i++) {
            Button b = vetor[i];
            int numero = Integer.parseInt(b.getText());

            int digito = (numero / exp) % 10;

            vetorCounting[digito].setText(String.valueOf(Integer.parseInt(vetorCounting[digito].getText()) + 1));//C[A[j]] = C[A[j]] + 1;
        }

        for(int i = 1; i < vetorCounting.length; i++) {
            vetorCounting[i].setText(String.valueOf(Integer.parseInt(vetorCounting[i].getText()) + Integer.parseInt(vetorCounting[i-1].getText())));//C[i] = C[i] + C[i-1];
        }

        for (int i = vetorCounting.length; i >= 0; i--) {
            aux[Integer.parseInt(vetorCounting[Integer.parseInt(vetor[i].getText())].getText())] = vetor[i];//B[C[A[j]]] = A[j]
            vetorCounting[Integer.parseInt(vetor[i].getText())].setText(String.valueOf(Integer.parseInt(vetorCounting[Integer.parseInt(vetor[i].getText())].getText()) - 1));//C[A[j]] = C[A[j]] - 1;
        }
    }

    private void zeraVetorCounting() {
        for(Button b : vetorCounting){
            b.setText("0");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}