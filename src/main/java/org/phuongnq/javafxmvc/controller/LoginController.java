package org.phuongnq.javafxmvc.controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.phuongnq.javafxmvc.dto.UserCredentials;
import org.phuongnq.javafxmvc.service.LoadingService;
import org.phuongnq.javafxmvc.service.LoginService;
import org.phuongnq.javafxmvc.service.NotificationService;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class LoginController implements Initializable {
  private final LoginService loginService = LoginService.getInstance();
  private final LoadingService loadingService = LoadingService.getInstance();
  private final Consumer<String> consumerOnSuccess;

  @FXML
  private Label errorLabel;
  @FXML
  private TextField username;
  @FXML
  private TextField password;
  @FXML
  private Button loginButton;

  public LoginController(Consumer<String> consumerOnSuccess) {
    this.consumerOnSuccess = consumerOnSuccess;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    loginButton.setOnAction(event -> {
      if (!Objects.equals(username.getText(), "") && !Objects.equals(password.getText(), "")) {
        var loginTask = getLoginTask(new UserCredentials(username.getText(), password.getText()), consumerOnSuccess, this::onFailure);
        new Thread(loginTask).start();
      }
    });
  }

  public void onFailure(String error) {
    errorLabel.setText(error);
  }

  private Task<Boolean> getLoginTask(UserCredentials userCredentials,
  Consumer<String> callbackOnSuccess, Consumer<String> callbackOnFailure) {
    Task<Boolean> task = new Task<>() {
      @Override
      protected Boolean call() throws Exception {
        loadingService.showLoading();
        return loginService.authenticated(userCredentials);
      }
    };
    task.setOnSucceeded(event -> {
      var succeed = (Boolean) event.getSource().getValue();
      System.out.println("Succeeded:" + succeed);
      if (succeed) {
        System.out.println("authenticated!!!!");
        callbackOnSuccess.accept(userCredentials.getUsername());
      } else {
        Platform.runLater(() -> callbackOnFailure.accept("Error message from server..."));
      }
      loadingService.closeLoading();
    });
    task.setOnFailed(event -> {
      var succeed = (Boolean) event.getSource().getValue();
      System.out.println("Failed:" + succeed);
      loadingService.closeLoading();
    });
    return task;
  }
}