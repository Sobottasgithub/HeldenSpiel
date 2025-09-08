package ps.edu.heldenspiel;

import ps.edu.heldenspiel.heros.Hero;
import ps.edu.heldenspiel.monster.Monster;
import ps.edu.heldenspiel.weapons.CombatRule;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class Controller {
    @FXML
    private Label welcomeText;


    public Controller() throws IOException {
        Hero atherion = new Hero("Atherion", 11, 17, 32);
        Monster monster = new Monster(12, 46);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Heldenspiel");
    }
}