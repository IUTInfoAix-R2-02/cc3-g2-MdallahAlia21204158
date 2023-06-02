package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    @FXML
    Button videButton;

    @FXML
    Button traceButton;

    @FXML
    TextField txtFieldComp1;

    @FXML
    TextField txtFieldComp2;

    @FXML
    TextField txtFieldComp3;

    @FXML
    TextField txtFieldComp4;

    @FXML
    TextField txtFieldComp5;

    @FXML
    TextField txtFieldComp6;

    @FXML
    Pane scene;

    @FXML
    Line line;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    private void Dessiner(double value, int axis){
        double y = getYRadarChart(value, axis);
        double x = getXRadarChart(value, axis);

        Circle c1 = new Circle(y, x, 5);
        c1.setCenterX(x);
        c1.setCenterY(y);
        c1.setRadius(5);

        scene.getChildren().add(c1);
    }



    @FXML
    private void traceClicked(){
        traceButton.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent ->{
            String comp1 = txtFieldComp1.getText();
            int saisie = Integer.parseInt(txtFieldComp1.getText());
            Dessiner(saisie, 25);

            String comp2 = txtFieldComp2.getText();
            int saisie2 = Integer.parseInt(txtFieldComp2.getText());
            Dessiner(saisie2, 200);

            String comp3 = txtFieldComp3.getText();
            int saisie3 = Integer.parseInt(txtFieldComp3.getText());
            Dessiner(saisie3, 225);

            String comp4 = txtFieldComp4.getText();
            int saisie4 = Integer.parseInt(txtFieldComp4.getText());
            Dessiner(saisie4, 100);

            String comp5 = txtFieldComp5.getText();
            int saisie5 = Integer.parseInt(txtFieldComp5.getText());
            Dessiner(saisie5, 125);

            String comp6 = txtFieldComp6.getText();
            int saisie6 = Integer.parseInt(txtFieldComp6.getText());
            Dessiner(saisie6, 150);
        });
    }

    @FXML
    private void videClicked(){
        videButton.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent ->{
            txtFieldComp1.clear();
            txtFieldComp2.clear();
            txtFieldComp3.clear();
            txtFieldComp4.clear();
            txtFieldComp5.clear();
            txtFieldComp6.clear();
        });
    }
}
