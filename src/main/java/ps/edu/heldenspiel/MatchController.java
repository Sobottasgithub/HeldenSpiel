package ps.edu.heldenspiel;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import ps.edu.heldenspiel.hero.Hero;
import ps.edu.heldenspiel.hero.Magician;
import ps.edu.heldenspiel.utils.CombatRule;
import ps.edu.heldenspiel.utils.EntityType;
import ps.edu.heldenspiel.utils.Monster;
import ps.edu.heldenspiel.utils.PlayerAction;

public class MatchController {
    @FXML private ImageView hero_uiImageView;
    @FXML private ImageView monster_uiImageView;
    @FXML private Label turnBanner_uiLabel;
    @FXML private Label heroDice_uiLabel;
    @FXML private Label monsterDice_uiLabel;
    @FXML private Label heroHealth_uiLabel;
    @FXML private Label monsterHealth_uiLabel;
    @FXML private ProgressBar heroHealthIndicator_uiProgressBar;
    @FXML private ProgressBar monsterHealthIndicator_uiProgressBar;
    @FXML private Button heal_uiButton;
    @FXML private Button attack_uiButton;

    Hero hero;
    Monster monster;
    CombatRule combatRule;

    public MatchController() {}

    public void initMatchScene(Hero hero) {
        this.hero = hero;
        this.hero.setHealth(this.hero.getMaxHealth());
        this.monster = new Monster();
        this.combatRule = new CombatRule();

        // Set hero's image in GUI
        Image heroImage = new Image(String.valueOf(this.hero.getImagePath()));
        hero_uiImageView.setImage(heroImage);

        // Set monsters image in GUI
        Image monsterImage = new Image(String.valueOf(Controller.class.getResource("images/monster.png")));
        monster_uiImageView.setImage(monsterImage);

        // Disable heal button if hero is not of class Magician
        if(this.hero.getClass() != Magician.class) {
            heal_uiButton.setVisible(false);
        }

        updateHealth();
    }

    public void updateHealth() {
        // Set hero's health in GUI
        int heroHealth = this.hero.getHealth();
        int heroMaxHealth = this.hero.getMaxHealth();
        heroHealth_uiLabel.setText(heroHealth + "/" + heroMaxHealth);
        heroHealthIndicator_uiProgressBar.setProgress((double) heroHealth / (double) heroMaxHealth);

        // Set monsters health in GUI
        int monsterHealth = this.monster.getHealth();
        int monsterMaxHealth = this.monster.getMaxHealth();
        monsterHealth_uiLabel.setText(monsterHealth + "/" + monsterMaxHealth);
        monsterHealthIndicator_uiProgressBar.setProgress((double) monsterHealth / (double) monsterMaxHealth);
    }

    public void runCycle(PlayerAction playerAction) throws InterruptedException {
        // Disable ui buttons so the player can not interfere with the game cycle
        attack_uiButton.setDisable(true);
        heal_uiButton.setDisable(true);

        // Check if player action is heal or attack
        if(playerAction == playerAction.HEAL) {
            ((Magician) hero).heal();
            turnBanner_uiLabel.setText("Healed!");
        } else if (playerAction == PlayerAction.ATTACK) {
            EntityType winner = this.combatRule.fight();
            if (winner == EntityType.HERO) {
                turnBanner_uiLabel.setText("Success!");
                monster.setHealth(monster.getHealth() - hero.getAttackDamage());
            } else if (winner == EntityType.MONSTER) {
                turnBanner_uiLabel.setText("Blocked!");
                hero.setHealth(hero.getHealth() - 1);
            } else {
                turnBanner_uiLabel.setText("Equal!");
            }

            // Set rolled dice number
            heroDice_uiLabel.setText(String.valueOf(combatRule.getHeroDiceResult()));
            monsterDice_uiLabel.setText(String.valueOf(combatRule.getMonsterDiceRoll()));
        } else {
            throw new java.lang.RuntimeException("Unknown player action!");
        }

        // Make new scene so all ui changes can be seen
        PauseTransition pause1 = new PauseTransition(Duration.seconds(1));
        pause1.setOnFinished(event1 -> {

            updateHealth();
            // If the health of the hero or monster is 0, the winner is displayed, else the monster attacks
            if (hero.getHealth() == 0 || monster.getHealth() == 0) {
                PauseTransition pause2 = new PauseTransition(Duration.seconds(1));
                pause2.setOnFinished(event2 -> {
                    evalWinner();
                });

                pause2.play();
            } else {
                turnBanner_uiLabel.setText("Monsters turn");

                PauseTransition pause2 = new PauseTransition(Duration.seconds(1.5));
                pause2.setOnFinished(event2 -> {
                    EntityType winner = this.combatRule.fight();
                    if (winner == EntityType.HERO) {
                        turnBanner_uiLabel.setText("Blocked!");
                        monster.setHealth(monster.getHealth() - 1);
                    } else if (winner == EntityType.MONSTER) {
                        turnBanner_uiLabel.setText("Monster attacked!");
                        hero.setHealth(hero.getHealth() - monster.getAttackDamage());
                    } else {
                        turnBanner_uiLabel.setText("Equal!");
                    }
                    heroDice_uiLabel.setText(String.valueOf(combatRule.getHeroDiceResult()));
                    monsterDice_uiLabel.setText(String.valueOf(combatRule.getMonsterDiceRoll()));

                    updateHealth();
                    // If the health of the hero or monster is 0, the winner is displayed, else enable ui
                    if (hero.getHealth() == 0 || monster.getHealth() == 0) {
                        PauseTransition pause3 = new PauseTransition(Duration.seconds(1));
                        pause3.setOnFinished(event3 -> {
                            evalWinner();
                        });
                        pause3.play();
                    } else {
                        PauseTransition pause3 = new PauseTransition(Duration.seconds(1));
                        pause3.setOnFinished(event3 -> {
                            turnBanner_uiLabel.setText("Your turn");
                            attack_uiButton.setDisable(false);
                            heal_uiButton.setDisable(false);
                        });
                        pause3.play();
                    }
                });
                pause2.play();
            }
        });
        pause1.play();
    }

    public void evalWinner() {
        // Outsourced to this function to prevent code duplicates
        if(hero.getHealth() == 0) {
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> turnBanner_uiLabel.setText("MONSTER WINS!"));
            pause.play();
        } else {
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> turnBanner_uiLabel.setText("HERO WINS!"));
            pause.play();
        }
    }

    @FXML
    protected void onHeal_uiButton() throws InterruptedException {
        runCycle(PlayerAction.HEAL);
    }

    @FXML
    protected void onAttack_uiButton() throws InterruptedException {
        runCycle(PlayerAction.ATTACK);
    }
}
