package org.phuongnq.javafxmvc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import org.phuongnq.javafxmvc.service.UserService;
import org.phuongnq.javafxmvc.service.LoadingService;
import org.phuongnq.javafxmvc.service.ServerService;
import org.phuongnq.javafxmvc.view.LoginView;
import org.phuongnq.javafxmvc.view.MainView;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
  private final UserService userService = UserService.getInstance();
  private final ServerService serverService = ServerService.getInstance();
  private final LoadingService loadingService = LoadingService.getInstance();
  @FXML
  public Label usernameLabel;
  @FXML
  public Button logoutBtn;
  @FXML
  private Label serverStatusLabel;
  @FXML
  private HBox applicationContainer;
  @FXML
  private StackPane loadingContainer;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // Simulate server status fetching
    configServerStatus();
    configUser();
    configLoadingScreen();
    showLogin();
  }

  public void showLogin() {
    System.out.println("show login");
    applicationContainer.getChildren().clear();
    applicationContainer.getChildren().add(new LoginView(this::loginSuccess).build());
  }

  public void showMain() {
    System.out.println("show main");
    applicationContainer.getChildren().clear();
    applicationContainer.getChildren().add(new MainView(userService).build());
  }

  private void loginSuccess(String username) {
    userService.getUsername().setValue(username);
    showMain();
  }

  private void logout() {
    userService.getUsername().setValue(null);
    showLogin();
  }

  private void configServerStatus() {
    serverService.getServerInfo().getStatus().addListener((observable, oldValue, newValue) -> {
      if (oldValue != newValue) {
        serverStatusLabel.setText(newValue.name());
        serverStatusLabel.setTextFill(newValue.getColor());
      }
    });
  }

  private void configLoadingScreen() {
    loadingContainer.visibleProperty().bind(loadingService.getLoadingProperty());
  }

  private void configUser() {
    usernameLabel.textProperty().bind(userService.getUsername());
    logoutBtn.visibleProperty().bind(userService.getUsername().isNotEmpty());
    logoutBtn.setOnAction(event -> logout());
  }
}