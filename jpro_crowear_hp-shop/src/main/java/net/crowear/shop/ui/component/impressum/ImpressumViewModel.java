package net.crowear.shop.ui.component.impressum;

import com.google.inject.Inject;

import net.crowear.shop.domain.service.LocaleManagerService;
import net.crowear.shop.ui.BaseViewModel;

public class ImpressumViewModel extends BaseViewModel {

   @Inject
   public ImpressumViewModel(LocaleManagerService lang) {
      super(lang);
   }

}
