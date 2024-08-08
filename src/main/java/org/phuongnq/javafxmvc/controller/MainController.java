package org.phuongnq.javafxmvc.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.phuongnq.javafxmvc.service.UserService;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
  private final UserService userService;

  public MainController(UserService userService) {
    this.userService = userService;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }
}