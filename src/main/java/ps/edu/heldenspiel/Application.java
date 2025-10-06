package ps.edu.heldenspiel;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Application extends javafx.application.Application {
  private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

  @Override
  public void start(Stage stage) throws IOException {
    LOGGER.log(Level.INFO, "Building App...");
    FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main_scene.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 650, 300);
    stage.setTitle("Heldenspiel");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
