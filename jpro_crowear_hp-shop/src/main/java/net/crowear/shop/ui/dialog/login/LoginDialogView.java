package net.crowear.shop.ui.dialog.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.crowear.shop.ui.dialog.DialogView;

public class LoginDialogView extends DialogView<LoginDialogViewModel> implements Initializable {

   @FXML
   private Label loginFailLabel;
   @FXML
   private PasswordField passwordField;
   @FXML
   private TextField usernameTextField;

   @Override
   public void initialize(final URL location, final ResourceBundle resources) {
      loginFailLabel.visibleProperty().bindBidirectional(viewModel.loginFailLabelVisibleProperty());
      usernameTextField.textProperty().bindBidirectional(viewModel.usernameProperty());
      passwordField.textProperty().bindBidirectional(viewModel.passwordProperty());
   }

   @FXML
   @Override
   protected void buttonHandleCancelAction() {
      viewModel.closeDialog();
   }

   @FXML
   private void buttonHandleLoginAction() {
      viewModel.doLogin();
   }

}
