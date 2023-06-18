package net.crowear.shop;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.inject.Module;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import de.saxsys.mvvmfx.guice.MvvmfxGuiceApplication;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.crowear.shop.mod.DataSourceModule;
import net.crowear.shop.mod.EventBusModule;
import net.crowear.shop.mod.PersistenceModule;
import net.crowear.shop.mod.ProviderModule;
import net.crowear.shop.mod.RepositoryModule;
import net.crowear.shop.mod.ServiceModule;
import net.crowear.shop.mod.ShiroAuthModule;
import net.crowear.shop.ui.dialog.error.ErrorDialogView;
import net.crowear.shop.ui.dialog.error.ErrorDialogViewModel;
import net.crowear.shop.ui.page.index.IndexPageView;
import net.crowear.shop.ui.page.index.IndexPageViewModel;
import net.crowear.shop.ui.util.DialogHelper;

public class Homepage extends MvvmfxGuiceApplication {

   private static final Logger LOG = LogManager.getLogger(Homepage.class);

   public static void main(final String[] args) {
      LOG.debug("Starting App");
      launch(args);
   }

   @Override
   public void initGuiceModules(final List<Module> modules) throws Exception {
      modules.add(new DataSourceModule());
      modules.add(new EventBusModule());
      modules.add(new PersistenceModule());
      modules.add(new ProviderModule());
      modules.add(new RepositoryModule());
      modules.add(new ServiceModule());
      modules.add(new ShiroAuthModule());
   }

   @Override
   public void startMvvmfx(final Stage stage) throws Exception {
      try {

         final ViewTuple<IndexPageView, IndexPageViewModel> indexPageViewTuple = FluentViewLoader
               .fxmlView(IndexPageView.class).load();

         final Scene scene = new Scene(indexPageViewTuple.getView());
         scene.getStylesheets().addAll("css-homepage.css");
         stage.setScene(scene);
         stage.show();
      } catch (final Exception e) {
         final ViewTuple<ErrorDialogView, ErrorDialogViewModel> viewTuple = FluentViewLoader
               .fxmlView(ErrorDialogView.class).load();

         final Stage dialogStage = DialogHelper.showDialog(viewTuple.getView(), stage, "css-homepage.css");
         dialogStage.show();
         viewTuple.getViewModel().setDialogStage(dialogStage);

         throw e;
      }
   }

}
