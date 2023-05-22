package net.crowear.shop.ui.component.dialog;

import net.crowear.shop.ui.BaseView;

public abstract class DialogView<T extends DialogViewModel> extends BaseView<T> {

   protected abstract void buttonHandleCancelAction();
}
