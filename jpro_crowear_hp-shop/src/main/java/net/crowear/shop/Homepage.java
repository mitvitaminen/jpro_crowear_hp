package net.crowear.shop;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.inject.Module;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import de.saxsys.mvvmfx.guice.MvvmfxGuiceApplication;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import net.crowear.shop.module.DataSourceModule;
import net.crowear.shop.module.EventBusModule;
import net.crowear.shop.module.PersistenceModule;
import net.crowear.shop.module.RepositoryModule;
import net.crowear.shop.module.ServiceModule;
import net.crowear.shop.module.ShiroAuthModule;
import net.crowear.shop.ui.dialog.error.ErrorDialogView;
import net.crowear.shop.ui.dialog.error.ErrorDialogViewModel;
import net.crowear.shop.ui.page.index.IndexPageView;
import net.crowear.shop.ui.page.index.IndexPageViewModel;
import net.crowear.shop.ui.page.memberarea.MemberAreaPageView;
import net.crowear.shop.ui.page.memberarea.MemberAreaPageViewModel;
import net.crowear.shop.ui.util.DialogHelper;
import one.jpro.routing.Route;
import one.jpro.routing.RouteNode;
import one.jpro.routing.RouteUtils;
import one.jpro.routing.sessionmanager.SessionManager;

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
      modules.add(new RepositoryModule());
      modules.add(new ServiceModule());
      modules.add(new ShiroAuthModule());
   }

   @Override
   public void startMvvmfx(final Stage stage) throws Exception {
      try {
         final RouteNode routeNode = new RouteNode(stage);

         final StackPane root = new StackPane(routeNode);

         final Scene scene = new Scene(root);
         scene.getStylesheets().add("css-homepage.css");

         stage.setTitle("crowear webshopapplication");
         stage.setScene(scene);
         stage.sizeToScene();
         stage.centerOnScreen();
         routeNode.setRoute(createRoute(stage));
         stage.show();
         routeNode.start(SessionManager.getDefault(routeNode, stage));
      } catch (final Exception e) {
         final ViewTuple<ErrorDialogView, ErrorDialogViewModel> viewTuple = FluentViewLoader
               .fxmlView(ErrorDialogView.class).load();

         final Stage dialogStage = DialogHelper.showDialog(viewTuple.getView(), stage, "css-homepage.css");
         dialogStage.show();
         viewTuple.getViewModel().setDialogStage(dialogStage);
         e.printStackTrace();
      }
   }

   private Route createRoute(Stage stage) {
      final ViewTuple<IndexPageView, IndexPageViewModel> indexPageViewTuple = FluentViewLoader
            .fxmlView(IndexPageView.class).load();
      indexPageViewTuple.getCodeBehind().setContent(indexPageViewTuple.getView());

      final ViewTuple<MemberAreaPageView, MemberAreaPageViewModel> memberAreaPageViewTuple = FluentViewLoader
            .fxmlView(MemberAreaPageView.class).load();
      memberAreaPageViewTuple.getCodeBehind().setContent(memberAreaPageViewTuple.getView());

      return Route.empty().and(RouteUtils.redirect("/", "/crowearindex"))
            .and(RouteUtils.get("/crowearindex", (s) -> indexPageViewTuple.getCodeBehind()))
            .and(RouteUtils.get("/memberarea", (s) -> memberAreaPageViewTuple.getCodeBehind()));
   }

}
