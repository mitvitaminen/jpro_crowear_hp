package net.crowear.shop.ui.dialog.about;

import java.net.URL;
import java.util.ResourceBundle;

import net.crowear.shop.ui.component.dialog.DialogView;
import javafx.fxml.Initializable;

public class AboutDialogView extends DialogView<AboutDialogViewModel> implements Initializable {

   @Override
   public void initialize(final URL location, final ResourceBundle resources) {
   }

   @Override
   protected void buttonHandleCancelAction() {
      viewModel.closeDialog();
   }

}
