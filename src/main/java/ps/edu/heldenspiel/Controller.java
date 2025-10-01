package ps.edu.heldenspiel;

import javafx.fxml.FXML;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import ps.edu.heldenspiel.hero.Hero;
import ps.edu.heldenspiel.hero.Magician;
import ps.edu.heldenspiel.hero.Warrior;
import javafx.fxml.Initializable;

public class Controller implements Initializable {
  // Ui items main_scene
  @FXML private Label health_uiLabel;
  @FXML private Label strength_uiLabel;
  @FXML private Label endurance_uiLabel;

  @FXML private ChoiceBox hero_uiChoiceBox;
  @FXML private ChoiceBox weapon_uiChoiceBox;

  @FXML private ImageView hero_imageView;

  private Map<String, Hero> heros = new HashMap<String, Hero>();
  private Map<String, Weapon> weapons = new HashMap<String, Weapon>();

  public Controller() throws IOException{
  }

  @Override
  public void initialize(URL location, ResourceBundle resources)  {

    // Init weapons and add to choiceBox
    ps.edu.heldenspiel.Weapon woodSword = new Weapon("wood sword", WeaponMaterial.WOOD);
    ps.edu.heldenspiel.Weapon stoneSword = new Weapon("stone sword", WeaponMaterial.STONE);

    weapon_uiChoiceBox.getItems().add(woodSword.getName());
    weapon_uiChoiceBox.getItems().add(stoneSword.getName());
    weapon_uiChoiceBox.getSelectionModel().selectFirst();

    weapon_uiChoiceBox.setOnAction((event) -> {onChoiceBoxChanged();});

    // Add weapons to hashmap
    this.weapons.put(woodSword.getName(), woodSword);
    this.weapons.put(stoneSword.getName(), stoneSword);

    // Init heros with standart weapon "wood sword" and add to choiceBox
    Hero magician = new Magician("magician", 12, 12, woodSword);
    Hero warrior = new Warrior("warrior", 16, 14, woodSword);

    hero_uiChoiceBox.getItems().add(magician.getName());
    hero_uiChoiceBox.getItems().add(warrior.getName());

    hero_uiChoiceBox.getSelectionModel().selectFirst();

    hero_uiChoiceBox.setOnAction((event) -> {onChoiceBoxChanged();});

    // Add heros to hashmap
    this.heros.put(magician.getName(), magician);
    this.heros.put(warrior.getName(), warrior);

    // Set values of labels
    onChoiceBoxChanged();
  }

  public void onChoiceBoxChanged() {
    Hero currentHero = this.heros.get(hero_uiChoiceBox.getValue());

    Image imageObject = new Image(String.valueOf(currentHero.getImagePath()));
    hero_imageView.setImage(imageObject);

    health_uiLabel.setText("Health: " + currentHero.getHealth());
    strength_uiLabel.setText("Strength: " + currentHero.getStrength() + " + " + this.weapons.get(weapon_uiChoiceBox.getValue()).getDamage(0));
    endurance_uiLabel.setText("Endurance: " + currentHero.getEndurance());
  }

  @FXML
  protected void onStart_uiButton() throws IOException {
    Monster monster = new Monster();
    CombatRule combatRule = new CombatRule();

    FXMLLoader loader = new FXMLLoader(getClass().getResource("matchScene.fxml"));
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));
    stage.show();
  }

}
