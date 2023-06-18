package net.chrisrocholl.homepage.ui.component.banner;

import com.google.inject.Inject;

import net.chrisrocholl.homepage.domain.service.LocaleManagerService;
import net.chrisrocholl.homepage.ui.BaseViewModel;

public class BannerViewModel extends BaseViewModel {

   @Inject
   public BannerViewModel(LocaleManagerService lang) {
      super(lang);
   }

}
