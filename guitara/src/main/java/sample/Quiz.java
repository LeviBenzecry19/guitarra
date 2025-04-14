package sample;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class Quiz {
    private int score = 0;
    private int currentQuestion = 0;

    private String[] questions = {
        "Você se considera uma pessoa cautelosa com seu dinheiro?",
        "Você tem um horizonte de investimentos de longo prazo?",
        "Você aceita correr riscos para tentar obter grandes retornos?",
        "Você já tem alguma experiência com investimentos?",
        "Você prefere aprender mais sobre investimentos?",
        "Você prefere investir em produtos de baixo risco, como a poupança?",
        "Você tem uma reserva de emergência?"
    };

    private int[][] points = {
        {0, 3, 5, 7, 10}, // resposta1
        {0, 3, 5, 7, 10}, // resposta2
        {10, 7, 5, 3, 0}, // resposta3
        {10, 7, 5, 3, 0}, // resposta4
        {10, 7, 5, 3, 0}, // resposta5
        {0, 3, 5, 7, 10}, // resposta6
        {10, 7, 5, 3, 0}  // resposta7
    };

    private Scene scene;
    private VBox layout;
    private Label questionLabel;

    public Quiz() {
        layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        questionLabel = new Label();
        layout.getChildren().add(questionLabel);
        showQuestion();
        scene = new Scene(layout, 500, 300);
    }

    public Scene getScene() {
        return scene;
    }

    private void showQuestion() {
        layout.getChildren().clear();

        if (currentQuestion < questions.length) {
            questionLabel.setText(questions[currentQuestion]);
            layout.getChildren().add(questionLabel);

            for (int i = 0; i < 5; i++) {
                Button option = new Button((i + 1) + "");
                int pointsEarned = points[currentQuestion][i];
                option.setOnAction(e -> {
                    score += pointsEarned;
                    currentQuestion++;
                    showQuestion();
                });
                layout.getChildren().add(option);
            }
        } else {
            showResult();
        }
    }

    private void showResult() {
        layout.getChildren().clear();
        Label resultLabel = new Label("Seu score final é: " + score + "\n");

        if (score <= 30) {
            resultLabel.setText(resultLabel.getText() + "Você é um investidor Conservador.");
        } else if (score <= 60) {
            resultLabel.setText(resultLabel.getText() + "Você é um investidor Moderado.");
        } else {
            resultLabel.setText(resultLabel.getText() + "Você é um investidor Arrojado.");
        }

        layout.getChildren().add(resultLabel);
    }
}
