package net.chrisrocholl.homepage.ui.component.localeselector;

import java.util.Locale;

import net.chrisrocholl.homepage.ui.BaseView;
import javafx.fxml.FXML;

public class LocaleSelectorView extends BaseView<LocaleSelectorViewModel> {

   @FXML
   private void flagGermanAction() {
      viewModel.getLang().changeLocale(Locale.GERMANY);
   }

   @FXML
   private void flagUSAction() {
      viewModel.getLang().changeLocale(Locale.US);
   }

}
