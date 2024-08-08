package org.phuongnq.javafxmvc.service;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;

public class UserService {
  private static UserService userService = null;
  @Getter
  private final StringProperty username = new SimpleStringProperty("");

  public static UserService getInstance() {
    if (userService == null) {
      userService = new UserService();
    }
    return userService;
  }
}
