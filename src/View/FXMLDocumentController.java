/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Lenguaje;

/**
 *
 * @author Victor
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField textA;

    @FXML
    private TextField textB;

    @FXML
    private TextArea textResult;

    @FXML
    private Label labelAviso;

    @FXML
    public void putLambdaInA(ActionEvent event) {
        textA.setText(textA.getText() + "λ");
    }

    @FXML
    public void putLambdaInB(ActionEvent event) {
        textB.setText(textB.getText() + "λ");
    }

    public void addResult(String title, ArrayList<String> text) {
        if (textResult.getText().isEmpty()) {
            textResult.setText(title + ": " + text + "\n");
        } else {
            textResult.setText(textResult.getText() + title + ": " + text + "\n");
        }
    }

    public void limpiar() {
        textResult.clear();
    }

    public void getA() {
        if (textA.getText().isEmpty()) {
            labelAviso.setText("Primero debe escribir las cadenas del lenguaje");
        } else {
            addResult("L(A)", Lenguaje.getLenguaje(textA.getText()));
        }
    }

    public void getB() {
        if (textB.getText().isEmpty()) {
            labelAviso.setText("Primero debe escribir las cadenas del lenguaje");
        } else {
            addResult("L(B)", Lenguaje.getLenguaje(textB.getText()));
        }
    }

    public void getAAsterisco() {
        if (textA.getText().isEmpty()) {
            labelAviso.setText("Primero debe escribir las cadenas del lenguaje A");
        } else {
            addResult("L(A*)", Lenguaje.getAsterisco(textA.getText()));
        }
    }

    public void getBAsterisco() {
        if (textB.getText().isEmpty()) {
            labelAviso.setText("Primero debe escribir las cadenas del lenguaje B");
        } else {
            addResult("L(B*)", Lenguaje.getAsterisco(textB.getText()));
        }
    }

    public void getAMas() {
        if (textA.getText().isEmpty()) {
            labelAviso.setText("Primero debe escribir las cadenas del lenguaje A");
        } else {
            addResult("L(A+)", Lenguaje.getMas(textA.getText()));
        }
    }

    public void getBMas() {
        if (textB.getText().isEmpty()) {
            labelAviso.setText("Primero debe escribir las cadenas del lenguaje B");
        } else {
            addResult("L(B+)", Lenguaje.getMas(textB.getText()));
        }
    }

    public void getAUB() {
        if (textA.getText().isEmpty()) {
            labelAviso.setText("Primero debe escribir las cadenas del lenguaje A");
        } else {
            addResult("L(AUB)", Lenguaje.getUnion(textA.getText(), textB.getText()));
        }
    }

    public void getAB() {
        if (textA.getText().isEmpty() || textB.getText().isEmpty()) {
            labelAviso.setText("Primero debe escribir las cadenas");
        } else {
            addResult("L(AB)", Lenguaje.getConcatenacion(textA.getText(), textB.getText()));
        }
    }

    /**
     * Este método es AUB*
     */
    public void getAUBAsterisco() {
        if (textA.getText().isEmpty() || textB.getText().isEmpty()) {
            labelAviso.setText("Primero debe escribir las cadenas");
        } else {
            String lb = "";
            for (String string : Lenguaje.getAsterisco(textB.getText())) {
                lb += string + ",";
            }
            addResult("L(AUB*)", Lenguaje.getUnion(textA.getText(), lb));
        }
    }

    /**
     * Este es el método A^3B
     */
    public void getA3B() {
        if (textA.getText().isEmpty() || textB.getText().isEmpty()) {
            labelAviso.setText("Primero debe escribir las cadenas");
        } else {
            String a2 = "", a3 = "";
            for (String string : Lenguaje.getConcatenacion(textA.getText(), textA.getText())) {
                a2 += string + ",";
            }
            for (String string : Lenguaje.getConcatenacion(a2, textA.getText())) {
                a3 += string + ",";
            }
            addResult("L(A^3)", Lenguaje.getLenguaje(a3));
            addResult("L(A^3)L(B)", Lenguaje.getConcatenacion(a3, textB.getText()));
        }
    }

    /**
     * Este es el método B(AUB)
     */
    public void getBAUB() {
        if (textA.getText().isEmpty() || textB.getText().isEmpty()) {
            labelAviso.setText("Primero debe escribir las cadenas");
        } else {
            String AUB = "";
            for (String string : Lenguaje.getUnion(textA.getText(), textA.getText())) {
                AUB += string + ",";
            }
            addResult("L(B)L(AUB)", Lenguaje.getConcatenacion(textB.getText(), AUB));
        }
    }

    /**
     * Este es el método AB*A
     */
    public void getABA() {
        if (textA.getText().isEmpty() || textB.getText().isEmpty()) {
            labelAviso.setText("Primero debe escribir las cadenas");
        } else {
            String Bast = "", AB = "";
            for (String string : Lenguaje.getAsterisco(textB.getText())) {
                Bast += string + ",";
            }
            for (String string : Lenguaje.getConcatenacion(textA.getText(), Bast)) {
                AB += string + ",";
            }
            addResult("L(AB*)", Lenguaje.getConcatenacion(textA.getText(), Bast));
            addResult("L(AB*)L(B)", Lenguaje.getConcatenacion(AB, textA.getText()));
        }
    }

    /**
     * Este es el método B+UA*
     */
    public void getBUA() {
        if (textA.getText().isEmpty() || textB.getText().isEmpty()) {
            labelAviso.setText("Primero debe escribir las cadenas");
        } else {
            String Bmas = "", Aast = "";
            for (String string : Lenguaje.getMas(textB.getText())) {
                Bmas += string + ",";
            }
            for (String string : Lenguaje.getAsterisco(textA.getText())) {
                 Aast+= string + ",";
            }
            addResult("L(B+)UL(A*)", Lenguaje.getUnion(Bmas, Aast));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
