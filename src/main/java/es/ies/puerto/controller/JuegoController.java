package es.ies.puerto.controller;

import es.ies.puerto.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class JuegoController extends ControladorAbstracto {

    @FXML
    private TextField textFieldUsuario;

    @FXML
    private TextField textFieldNivel;

    @FXML
    private TextField textFieldPuntos;

    @FXML
    private Text textJuegoVictoria;

    @FXML
    private Button buttonJugarRegresar;

    @FXML
    private Button buttonJugarReiniciar;

    @FXML 
    private Canvas canvas;

    @FXML 
    private GridPane lettersGrid;

    private final String palabra = "JAVA";
    private final boolean[] guessedLetters = new boolean[palabra.length()];
    private int incorrectGuesses = 0;

    private void handleGuess(char guessedLetter, GraphicsContext gc, Button button) {
        button.setDisable(true);

        if (palabra.contains(String.valueOf(guessedLetter))) {
            updateWordDisplay(guessedLetter);
            if (isWordGuessed()) {
                textJuegoVictoria.setText("Ganaste  La Palabra era: "+palabra);
                getUsuarioActivo().setPuntos(getUsuarioActivo().getPuntos()+50);
                textFieldPuntos.setText(getUsuarioActivo().getPuntos().toString());
            };
        } else {
            incorrectGuesses++;
            drawHangman(gc);
            if (incorrectGuesses == 6) {
                textJuegoVictoria.setText("Perdiste  La Palabra era: "+palabra);
                if (getUsuarioActivo().getPuntos() > 0) {
                    getUsuarioActivo().setPuntos(getUsuarioActivo().getPuntos()-50); 
                }
                textFieldPuntos.setText(getUsuarioActivo().getPuntos().toString());
            }
        }
    }

    private void drawGallows(GraphicsContext gc) {
        gc.strokeLine(50, 250, 150, 250); 
        gc.strokeLine(100, 250, 100, 50); 
        gc.strokeLine(100, 50, 50, 50);   
        gc.strokeLine(50, 50, 50, 70);    
    }

    private void drawHangman(GraphicsContext gc) {
        switch (incorrectGuesses) {
            case 1 -> gc.strokeOval(30, 70, 40, 40); 
            case 2 -> gc.strokeLine(50, 110, 50, 170); 
            case 3 -> gc.strokeLine(50, 130, 30, 150); 
            case 4 -> gc.strokeLine(50, 130, 70, 150);
            case 5 -> gc.strokeLine(50, 170, 30, 210); 
            case 6 -> gc.strokeLine(50, 170, 70, 210); 
        }
    }

    private void updateWordDisplay(char guessedLetter) {
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == guessedLetter) guessedLetters[i] = true;
        }
    }

    private boolean isWordGuessed() {
        for (boolean guessed : guessedLetters) if (!guessed) return false;
        return true;
    }

    @FXML
    public void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawGallows(gc);
        createLetterButtons(gc);
        textFieldUsuario.setText(getUsuarioActivo().getNombre());
        textFieldNivel.setText(getUsuarioActivo().getNivel());
        textFieldPuntos.setText(getUsuarioActivo().getPuntos().toString());
    }

    private void createLetterButtons(GraphicsContext gc) {
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            Button button = new Button(String.valueOf(letter));
            button.setOnAction(e -> handleGuess(button.getText().charAt(0), gc, button));
            lettersGrid.add(button, (letter - 'A') % 13, (letter - 'A') / 13);
        }
    }


    @FXML
    protected void onClickJugarRegresar() {
        openPantalla(buttonJugarRegresar, "perfil.fxml", "Pantalla de Perfil");
    }

    @FXML
    protected void onClickJugarReiniciar() {
        openPantalla(buttonJugarReiniciar, "juego.fxml", "Pantalla de Juego");
    }
    
}

