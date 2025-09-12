package ps.edu.heldenspiel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class Controller {
    @FXML
    private Label welcomeText;


    public Controller() throws IOException {
        CombatRule combatRule = new CombatRule();

        Hero atherion = new Hero("Atherion", 11, 11, 32);
        Monster monster = new Monster(12, 46);

        combatRule.fight(atherion, monster);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Heldenspiel");
    }
}