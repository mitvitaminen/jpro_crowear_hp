package net.crowear.shop.ui.util;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DialogHelper {
   public static Stage showDialog(final Parent view, final Stage parentStage, final String... sceneStyleSheets) {
      final Stage dialogStage = new Stage(StageStyle.UNDECORATED);
      dialogStage.initOwner(parentStage);
      dialogStage.initModality(Modality.APPLICATION_MODAL);
      if (dialogStage.getScene() == null) {
         final Scene dialogScene = new Scene(view);
         dialogScene.getStylesheets().addAll(sceneStyleSheets);
         dialogStage.setScene(dialogScene);
         dialogStage.sizeToScene();
      }
      return dialogStage;
   }

}
