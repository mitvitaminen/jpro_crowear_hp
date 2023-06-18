package net.crowear.shop.ui.component.banner;

import com.google.inject.Inject;

import net.crowear.shop.domain.service.LocaleManagerService;
import net.crowear.shop.ui.BaseViewModel;

public class BannerViewModel extends BaseViewModel {

   @Inject
   public BannerViewModel(LocaleManagerService lang) {
      super(lang);
   }

}
