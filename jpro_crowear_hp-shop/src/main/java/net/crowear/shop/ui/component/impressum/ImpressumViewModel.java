package net.chrisrocholl.homepage.ui.component.impressum;

import com.google.inject.Inject;

import net.chrisrocholl.homepage.domain.service.LocaleManagerService;
import net.chrisrocholl.homepage.ui.BaseViewModel;

public class ImpressumViewModel extends BaseViewModel {

   @Inject
   public ImpressumViewModel(LocaleManagerService lang) {
      super(lang);
   }

}
