module ps.edu.heldenspiel {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.web;
  requires java.logging;

  opens ps.edu.heldenspiel to
      javafx.fxml;

  exports ps.edu.heldenspiel;
  exports ps.edu.heldenspiel.hero;

  opens ps.edu.heldenspiel.hero to
      javafx.fxml;

  exports ps.edu.heldenspiel.utils;

  opens ps.edu.heldenspiel.utils to
      javafx.fxml;
}
