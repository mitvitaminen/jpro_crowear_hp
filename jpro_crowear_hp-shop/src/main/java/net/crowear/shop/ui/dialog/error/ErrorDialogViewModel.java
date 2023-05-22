package net.crowear.shop.ui.dialog.error;

import com.google.inject.Inject;

import net.crowear.shop.domain.service.LocaleManagerService;
import net.crowear.shop.ui.component.dialog.DialogViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ErrorDialogViewModel extends DialogViewModel {

   private final StringProperty errorInputProperty = new SimpleStringProperty();

   @Inject
   public ErrorDialogViewModel(LocaleManagerService lang) {
      super(lang);
   }

   StringProperty getErrorInputProperty() {
      return errorInputProperty;
   }

   void sendEmailCloseDialog() {
      // TODO sendemail here
      closeDialog();
   }
}
