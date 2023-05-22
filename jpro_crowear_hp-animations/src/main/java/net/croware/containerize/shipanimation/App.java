package net.croware.containerize.shipanimation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.inject.Module;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import de.saxsys.mvvmfx.guice.MvvmfxGuiceApplication;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.croware.containerize.shipanimation.ui.mainview.MainView;
import net.croware.containerize.shipanimation.ui.mainview.MainViewModel;

public class App extends MvvmfxGuiceApplication {

   private static final Logger LOG = LogManager.getLogger(App.class);

   public static void main(final String[] args) {
      LOG.debug("Starting App");
      launch(args);
   }

   @Override
   public void initGuiceModules(final List<Module> modules) throws Exception {

   }

   @Override
   public void startMvvmfx(final Stage stage) throws Exception {
      final ViewTuple<MainView, MainViewModel> viewTuple = FluentViewLoader.fxmlView(MainView.class).load();

      final Scene scene = new Scene(viewTuple.getView());
      scene.getStylesheets().add("css-homepage.css");

      stage.setTitle("containerize client");
      stage.setScene(scene);
      stage.centerOnScreen();
      stage.show();
   }

}
