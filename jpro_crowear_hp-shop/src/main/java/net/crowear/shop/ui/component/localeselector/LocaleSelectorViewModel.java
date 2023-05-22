package net.crowear.shop.ui.component.localeselector;

import com.google.inject.Inject;

import net.crowear.shop.domain.service.LocaleManagerService;
import net.crowear.shop.ui.BaseViewModel;

public class LocaleSelectorViewModel extends BaseViewModel {

   @Inject
   public LocaleSelectorViewModel(LocaleManagerService lang) {
      super(lang);
   }

}
