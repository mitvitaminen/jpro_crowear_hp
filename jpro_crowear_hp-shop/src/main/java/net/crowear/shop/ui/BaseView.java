package net.chrisrocholl.homepage.ui;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import net.chrisrocholl.homepage.domain.service.LocaleManagerService;

public abstract class BaseView<T extends BaseViewModel> implements FxmlView<T> {

   @InjectViewModel
   protected T viewModel;

   public LocaleManagerService getLang() {
      return viewModel.getLang();
   }

}
