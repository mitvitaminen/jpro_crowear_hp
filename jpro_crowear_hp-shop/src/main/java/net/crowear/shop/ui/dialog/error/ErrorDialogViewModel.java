package net.chrisrocholl.homepage.ui.dialog.error;

import com.google.inject.Inject;

import net.chrisrocholl.homepage.domain.service.LocaleManagerService;
import net.chrisrocholl.homepage.ui.dialog.DialogViewModel;
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
