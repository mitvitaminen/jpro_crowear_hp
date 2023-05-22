package net.crowear.shop.ui.page.memberarea;

import com.google.inject.Inject;

import net.crowear.shop.domain.service.LocaleManagerService;
import net.crowear.shop.ui.BaseViewModel;

public class MemberAreaPageViewModel extends BaseViewModel {

   @Inject
   public MemberAreaPageViewModel(LocaleManagerService lang) {
      super(lang);
   }

}
