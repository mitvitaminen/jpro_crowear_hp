package net.crowear.shop.ui.dialog.error;

import java.net.URL;
import java.util.ResourceBundle;

import net.crowear.shop.ui.component.dialog.DialogView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class ErrorDialogView extends DialogView<ErrorDialogViewModel> implements Initializable {

   @FXML
   private TextArea errorInputTextArea;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      errorInputTextArea.textProperty().bindBidirectional(viewModel.getErrorInputProperty());

   }

   @FXML
   @Override
   protected void buttonHandleCancelAction() {
      viewModel.closeDialog();

   }

   @FXML
   private void buttonHandleSendenAction() {
      viewModel.sendEmailCloseDialog();
   }

}
