package net.chrisrocholl.homepage.ui.component.content.admin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;

import com.google.inject.Inject;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.chrisrocholl.homepage.domain.service.LocaleManagerService;
import net.chrisrocholl.homepage.ui.BaseViewModel;
import net.chrisrocholl.homepage.ui.dialog.about.AboutDialogView;
import net.chrisrocholl.homepage.ui.dialog.about.AboutDialogViewModel;
import net.chrisrocholl.homepage.ui.dialog.login.LoginDialogView;
import net.chrisrocholl.homepage.ui.dialog.login.LoginDialogViewModel;
import net.chrisrocholl.homepage.ui.page.memberarea.MemberAreaPageView;
import net.chrisrocholl.homepage.ui.page.memberarea.MemberAreaPageViewModel;
import net.chrisrocholl.homepage.ui.util.DialogHelper;

public class AdminContentViewModel extends BaseViewModel {

   private final Stage primaryStage;

   @Inject
   public AdminContentViewModel(LocaleManagerService lang, final Stage primaryStage,
         final org.apache.shiro.mgt.SecurityManager securityManager) {
      super(lang);
      this.primaryStage = primaryStage;
      SecurityUtils.setSecurityManager(securityManager);
   }

   public void initialize() {
      if (SecurityUtils.getSubject().hasRole("user")) {
         loadMemberSectionPage();
      }
   }

   public void loadHomepage() {
      final ViewTuple<AdminContentView, AdminContentViewModel> viewTuple = FluentViewLoader
            .fxmlView(AdminContentView.class).load();

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
      dialogStage.show();
   }

   @RequiresRoles("user")
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
