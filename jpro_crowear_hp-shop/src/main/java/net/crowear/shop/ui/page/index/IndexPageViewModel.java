package net.crowear.shop.ui.page.index;

import org.apache.shiro.SecurityUtils;

import com.google.inject.Inject;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.crowear.shop.domain.service.LocaleManagerService;
import net.crowear.shop.domain.service.TestdataService;
import net.crowear.shop.ui.BaseViewModel;
import net.crowear.shop.ui.dialog.about.AboutDialogView;
import net.crowear.shop.ui.dialog.about.AboutDialogViewModel;
import net.crowear.shop.ui.dialog.login.LoginDialogView;
import net.crowear.shop.ui.dialog.login.LoginDialogViewModel;
import net.crowear.shop.ui.page.memberarea.MemberAreaPageView;
import net.crowear.shop.ui.page.memberarea.MemberAreaPageViewModel;
import net.crowear.shop.ui.util.DialogHelper;

public class IndexPageViewModel extends BaseViewModel {

   private final Stage primaryStage;
   private final TestdataService testDataService;

   @Inject
   public IndexPageViewModel(LocaleManagerService lang, final Stage primaryStage,
         final org.apache.shiro.mgt.SecurityManager securityManager, final TestdataService testDataService) {
      super(lang);
      this.primaryStage = primaryStage;
      this.testDataService = testDataService;
      SecurityUtils.setSecurityManager(securityManager);
   }

   public void initialize() {
      testDataService.createData();
   }

   public void loadHomepage() {
      final ViewTuple<IndexPageView, IndexPageViewModel> viewTuple = FluentViewLoader.fxmlView(IndexPageView.class)
            .load();

      final Scene scene = new Scene(viewTuple.getView());
      scene.getStylesheets().add("css-homepage.css");

      primaryStage.setTitle("potpourri cannabis social club homepage");
      primaryStage.setScene(scene);
      primaryStage.sizeToScene();
      primaryStage.centerOnScreen();
      primaryStage.show();

   }

   public void openAboutDialog() {
      final ViewTuple<AboutDialogView, AboutDialogViewModel> viewTupleDialogView = FluentViewLoader
            .fxmlView(AboutDialogView.class).load();

      final Stage dialogStage = DialogHelper.showDialog(viewTupleDialogView.getView(), primaryStage,
            "css-homepage.css");
      dialogStage.show();

   }

   void loadLoginDialog() {
      final ViewTuple<LoginDialogView, LoginDialogViewModel> viewTupleLoginDialogView = FluentViewLoader
            .fxmlView(LoginDialogView.class).load();

      final Stage dialogStage = DialogHelper.showDialog(viewTupleLoginDialogView.getView(), primaryStage,
            "css-homepage.css");
      viewTupleLoginDialogView.getViewModel().setDialogStage(dialogStage);
      dialogStage.show();

   }

//   @RequiresRoles("user")
   private void loadMemberSectionPage() {
      final ViewTuple<MemberAreaPageView, MemberAreaPageViewModel> viewTupleStartingPageView = FluentViewLoader
            .fxmlView(MemberAreaPageView.class).load();

      final Scene scene = new Scene(viewTupleStartingPageView.getView());
      scene.getStylesheets().add("css-homepage.css");

      primaryStage.centerOnScreen();
      primaryStage.setScene(scene);
      primaryStage.setMaximized(true);
   }

}
