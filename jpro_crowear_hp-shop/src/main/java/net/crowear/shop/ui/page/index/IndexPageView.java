package net.crowear.shop.ui.page.index;

import java.net.URL;
import java.util.ResourceBundle;

import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import net.crowear.shop.ui.page.Page;

public class IndexPageView extends Page<IndexPageViewModel> implements Initializable {

   @Inject
   public IndexPageView(Stage primaryStage) {
      super(primaryStage);
   }

   @Override
   public String description() {
      return "This is the index page.";
   }

   @Override
   public void initialize(final URL location, final ResourceBundle resources) {
   }

   @Override
   public String title() {
      return "Index Page";
   }

   @FXML
   private void buttonHandleAboutAction() {
      viewModel.openAboutDialog();
   }

   @FXML
   private void buttonHandleHomepageAction() {
      viewModel.loadHomepage();
   }

   @FXML
   private void buttonHandleLoginAction() {
      viewModel.loadLoginDialog();
   }
}
