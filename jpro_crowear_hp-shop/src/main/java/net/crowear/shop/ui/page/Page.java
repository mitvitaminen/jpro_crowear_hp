package net.crowear.shop.ui.page;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.scene.Node;
import net.crowear.shop.ui.BaseViewModel;
import one.jpro.routing.View;

public abstract class Page<T extends BaseViewModel> extends View implements FxmlView<T> {
   @InjectViewModel
   protected T viewModel;
   private Node content;

   @Override
   public Node content() {
      return content;
   }

   public void setContent(Node content) {
      this.content = content;
   }

}
