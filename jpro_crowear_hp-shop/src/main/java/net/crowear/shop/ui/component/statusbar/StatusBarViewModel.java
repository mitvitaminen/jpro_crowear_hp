package net.chrisrocholl.homepage.ui.component.statusbar;

import com.google.inject.Inject;

import net.chrisrocholl.homepage.domain.service.LocaleManagerService;
import net.chrisrocholl.homepage.ui.BaseViewModel;

public class StatusBarViewModel extends BaseViewModel {

   @Inject
   public StatusBarViewModel(LocaleManagerService lang) {
      super(lang);
      // TODO Auto-generated constructor stub
   }

}
