package net.crowear.shop.ui.component.content.low;

import java.net.URL;
import java.util.ResourceBundle;

import net.crowear.shop.ui.BaseView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class LowContentView extends BaseView<LowContentViewModel> implements Initializable {

   @Override
   public void initialize(final URL location, final ResourceBundle resources) {

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
