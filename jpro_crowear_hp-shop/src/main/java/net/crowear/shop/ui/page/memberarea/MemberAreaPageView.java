package net.crowear.shop.ui.page.memberarea;

import java.net.URL;
import java.util.ResourceBundle;

import net.crowear.shop.ui.page.Page;
import javafx.fxml.Initializable;

public class MemberAreaPageView extends Page<MemberAreaPageViewModel> implements Initializable {

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
