package net.chrisrocholl.homepage.ui.component.content.admin;

import java.net.URL;
import java.util.ResourceBundle;

import net.chrisrocholl.homepage.ui.BaseView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class AdminContentView extends BaseView<AdminContentViewModel> implements Initializable {

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
