package net.crowear.shop.ui;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;

public abstract class BaseView<T extends BaseViewModel> implements FxmlView<T> {

   @InjectViewModel
   protected T viewModel;

}
