package org.phuongnq.javafxmvc.dto;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class ServerInfo {
  private final ObjectProperty<Status> status =
      new SimpleObjectProperty<>(Status.DOWN);

  @Getter
  @RequiredArgsConstructor
  public enum Status {
    UP(Color.GREEN), DOWN(Color.RED), UNSTABLE(Color.ORANGE);

    private final Color color;
  }
}
