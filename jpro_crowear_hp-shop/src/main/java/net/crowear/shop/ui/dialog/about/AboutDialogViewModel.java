package net.crowear.shop.ui.dialog.about;

import com.google.inject.Inject;

import net.crowear.shop.domain.service.LocaleManagerService;
import net.crowear.shop.ui.dialog.DialogViewModel;

public class AboutDialogViewModel extends DialogViewModel {

   @Inject
   public AboutDialogViewModel(LocaleManagerService lang) {
      super(lang);

   }

}
