package net.chrisrocholl.homepage.ui.page.memberarea;

import com.google.inject.Inject;

import net.chrisrocholl.homepage.domain.service.LocaleManagerService;
import net.chrisrocholl.homepage.ui.BaseViewModel;

public class MemberAreaPageViewModel extends BaseViewModel {

   @Inject
   public MemberAreaPageViewModel(LocaleManagerService lang) {
      super(lang);
   }

}
