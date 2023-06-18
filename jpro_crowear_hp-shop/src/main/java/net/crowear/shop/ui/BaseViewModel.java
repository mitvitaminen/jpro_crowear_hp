package net.crowear.shop.ui;

import de.saxsys.mvvmfx.ViewModel;
import net.crowear.shop.domain.service.LocaleManagerService;

public abstract class BaseViewModel implements ViewModel {

   private final LocaleManagerService lang;

   public BaseViewModel(final LocaleManagerService lang) {
      this.lang = lang;
   }

   public LocaleManagerService getLang() {
      return lang;
   }

}
