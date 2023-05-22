package net.crowear.shop;

import com.jpro.webapi.WebAPI;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import one.jpro.routing.Route;
import one.jpro.routing.RouteNode;

public interface RouteApp {

   Route createRoute(Stage stage);

   default WebAPI getWebAPI(Stage stage) {
      return WebAPI.isBrowser() ? WebAPI.getWebAPI(stage) : null;
   }

   default void startRoute(Stage stage) {
      final RouteNode routeNode = new RouteNode(stage);

      // Add node between RouteNode and Scene, so Popups work correctly with
      // ScenicView
      final StackPane root = new StackPane(routeNode);

      final Scene scene = new Scene(root);
      stage.setScene(scene);
      routeNode.setRoute(createRoute(stage));
      stage.show();
      routeNode.start(SessionManager.getDefault(routeNode, stage));
   }
}
