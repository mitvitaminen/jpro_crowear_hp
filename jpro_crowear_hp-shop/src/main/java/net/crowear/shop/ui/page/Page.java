package net.crowear.shop.ui.page;

import com.jpro.webapi.WebAPI;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.scene.Node;
import javafx.stage.Stage;
import net.crowear.shop.domain.service.LocaleManagerService;
import net.crowear.shop.ui.BaseViewModel;
import one.jpro.routing.View;

public abstract class Page<T extends BaseViewModel> extends View implements FxmlView<T> {
   WebAPI webApi;
   @InjectViewModel
   protected T viewModel;
   private Node content;
   private final Stage stage;

   public Page(Stage primaryStage) {
      stage = primaryStage;
   }

   @Override
   public Node content() {
      return content;
   }

   public LocaleManagerService getLang() {
      return viewModel.getLang();
   }

   public WebAPI getWebApi() {
      return WebAPI.isBrowser() ? WebAPI.getWebAPI(stage) : null;
   }

   public void setContent(Node content) {
      this.content = content;
   }
}
