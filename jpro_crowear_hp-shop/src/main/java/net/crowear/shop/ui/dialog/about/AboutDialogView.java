package net.crowear.shop.ui.dialog.about;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import net.crowear.shop.ui.dialog.DialogView;

public class AboutDialogView extends DialogView<AboutDialogViewModel> implements Initializable {

   @Override
   public void initialize(final URL location, final ResourceBundle resources) {
   }

   @Override
   protected void buttonHandleCancelAction() {
      viewModel.closeDialog();
   }

}
