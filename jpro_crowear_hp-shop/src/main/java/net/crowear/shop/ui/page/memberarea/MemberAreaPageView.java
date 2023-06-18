package net.crowear.shop.ui.page.memberarea;

import java.net.URL;
import java.util.ResourceBundle;

import jakarta.inject.Inject;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import net.crowear.shop.ui.page.Page;

public class MemberAreaPageView extends Page<MemberAreaPageViewModel> implements Initializable {

   @Inject
   public MemberAreaPageView(Stage primaryStage) {
      super(primaryStage);
   }

   @Override
   public String description() {
      return "This is the Member Area Page.";
   }

   @Override
   public void initialize(URL location, ResourceBundle resources) {
   }

   @Override
   public String title() {
      return "Member Area Page";
   }

}
