package net.crowear.shop.ui.component.statusbar;

import com.google.inject.Inject;

import net.crowear.shop.domain.service.LocaleManagerService;
import net.crowear.shop.ui.BaseViewModel;

public class StatusBarViewModel extends BaseViewModel {

   @Inject
   public StatusBarViewModel(LocaleManagerService lang) {
      super(lang);
      // TODO Auto-generated constructor stub
   }

}
