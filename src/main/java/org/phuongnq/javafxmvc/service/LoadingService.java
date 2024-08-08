package org.phuongnq.javafxmvc.service;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import lombok.Getter;

public class LoadingService {
  private static LoadingService loadingService = null;
  @Getter
  private final BooleanProperty loadingProperty = new SimpleBooleanProperty(false);

  public static LoadingService getInstance() {
    if (loadingService == null) {
      loadingService = new LoadingService();
    }
    return loadingService;
  }

  public void showLoading() {
    loadingProperty.setValue(true);
  }

  public void closeLoading() {
    loadingProperty.setValue(false);
  }
}
