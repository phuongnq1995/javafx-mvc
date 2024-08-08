package org.phuongnq.javafxmvc.service;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.util.Duration;
import lombok.Getter;
import org.phuongnq.javafxmvc.dto.ServerInfo;

import java.util.Random;
import java.util.concurrent.Executors;

public class ServerService {
  private static ServerService serverService = null;
  @Getter
  private final ServerInfo serverInfo = new ServerInfo();
  public static ServerService getInstance() {
    if (serverService == null) {
      serverService = new ServerService();
    }
    return serverService;
  }

  private ServerService() {
    // Simulate fetching server info schedule
    ScheduledService<ServerInfo.Status> statusScheduledService = new ScheduledService<>() {
      @Override
      protected Task<ServerInfo.Status> createTask() {
        Task<ServerInfo.Status> task = new Task<>() {
          @Override
          protected ServerInfo.Status call() throws Exception {
            ServerInfo.Status[] statuses = ServerInfo.Status.values();
            return statuses[new Random().nextInt(statuses.length)];
          }
        };
        task.setOnSucceeded(event -> serverService.getServerInfo().getStatus().setValue((ServerInfo.Status) event.getSource().getValue()));
        return task;
      }
    };
    statusScheduledService.setPeriod(Duration.seconds(3));
    statusScheduledService.setExecutor(Executors.newSingleThreadExecutor());
    statusScheduledService.start();
  }
}
