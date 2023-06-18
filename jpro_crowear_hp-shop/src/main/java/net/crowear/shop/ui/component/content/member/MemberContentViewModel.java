package net.chrisrocholl.homepage.ui.component.content.member;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;

import com.google.inject.Inject;

import net.chrisrocholl.homepage.domain.service.LocaleManagerService;
import net.chrisrocholl.homepage.ui.BaseViewModel;
import net.chrisrocholl.homepage.ui.dialog.about.AboutDialogView;
import net.chrisrocholl.homepage.ui.dialog.about.AboutDialogViewModel;
import net.chrisrocholl.homepage.ui.dialog.login.LoginDialogView;
import net.chrisrocholl.homepage.ui.dialog.login.LoginDialogViewModel;
import net.chrisrocholl.homepage.ui.page.memberarea.MemberAreaPageView;
import net.chrisrocholl.homepage.ui.page.memberarea.MemberAreaPageViewModel;
import net.chrisrocholl.homepage.ui.util.DialogHelper;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MemberContentViewModel extends BaseViewModel {

   private final Stage primaryStage;

   @Inject
   public MemberContentViewModel(LocaleManagerService lang, final Stage primaryStage) {
      super(lang);
      this.primaryStage = primaryStage;
   }

   public void initialize() {
      if (SecurityUtils.getSubject().hasRole("user")) {
         loadMemberSectionPage();
      }
   }

   public void loadHomepage() {
      final ViewTuple<MemberContentView, MemberContentViewModel> viewTuple = FluentViewLoader
            .fxmlView(MemberContentView.class).load();

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
