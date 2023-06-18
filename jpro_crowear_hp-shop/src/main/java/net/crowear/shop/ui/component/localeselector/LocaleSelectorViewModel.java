package net.chrisrocholl.homepage.ui.component.localeselector;

import com.google.inject.Inject;

import net.chrisrocholl.homepage.domain.service.LocaleManagerService;
import net.chrisrocholl.homepage.ui.BaseViewModel;

public class LocaleSelectorViewModel extends BaseViewModel {

   @Inject
   public LocaleSelectorViewModel(LocaleManagerService lang) {
      super(lang);
   }

}
