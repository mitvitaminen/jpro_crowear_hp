package net.crowear.shop.ui;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import net.crowear.shop.domain.service.LocaleManagerService;

public abstract class BaseView<T extends BaseViewModel> implements FxmlView<T> {

   @InjectViewModel
   protected T viewModel;

   public LocaleManagerService getLang() {
      return viewModel.getLang();
   }

}
