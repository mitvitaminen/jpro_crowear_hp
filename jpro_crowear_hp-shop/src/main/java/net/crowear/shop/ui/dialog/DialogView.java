package net.chrisrocholl.homepage.ui.dialog;

import net.chrisrocholl.homepage.ui.BaseView;

public abstract class DialogView<T extends DialogViewModel> extends BaseView<T> {

   protected abstract void buttonHandleCancelAction();
}
