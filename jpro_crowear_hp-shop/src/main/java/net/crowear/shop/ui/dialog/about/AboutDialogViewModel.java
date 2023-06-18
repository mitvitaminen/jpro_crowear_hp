package net.chrisrocholl.homepage.ui.dialog.about;

import com.google.inject.Inject;

import net.chrisrocholl.homepage.domain.service.LocaleManagerService;
import net.chrisrocholl.homepage.ui.dialog.DialogViewModel;

public class AboutDialogViewModel extends DialogViewModel {

   @Inject
   public AboutDialogViewModel(LocaleManagerService lang) {
      super(lang);

   }

}
