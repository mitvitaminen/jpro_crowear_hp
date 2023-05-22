package net.crowear.shop.ui.component.menu;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;

import com.google.inject.Inject;

import net.crowear.shop.domain.service.LocaleManagerService;
import net.crowear.shop.ui.BaseViewModel;
import net.crowear.shop.ui.dialog.login.LoginDialogView;
import net.crowear.shop.ui.dialog.login.LoginDialogViewModel;
import net.crowear.shop.ui.page.index.IndexPageView;
import net.crowear.shop.ui.page.index.IndexPageViewModel;
import net.crowear.shop.ui.page.memberarea.MemberAreaPageView;
import net.crowear.shop.ui.page.memberarea.MemberAreaPageViewModel;
import net.crowear.shop.ui.util.DialogHelper;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuViewModel extends BaseViewModel {
   private final SimpleBooleanProperty isAdminProperty = new SimpleBooleanProperty(false);
   private final SimpleBooleanProperty isLoggedInProperty = new SimpleBooleanProperty(false);
   private final SimpleBooleanProperty isUserProperty = new SimpleBooleanProperty(false);
   private final Stage primaryStage;

   @Inject
   public MenuViewModel(LocaleManagerService lang, Stage primaryStage) {
      super(lang);
      this.primaryStage = primaryStage;
   }

   public void initialize() {
      if (SecurityUtils.getSubject().isAuthenticated()) {
         isLoggedInProperty.set(true);
         if (SecurityUtils.getSubject().hasRole("admin")) {
            isAdminProperty.set(true);
         }
         if (SecurityUtils.getSubject().hasRole("user")) {
            isUserProperty.set(true);
         }
      }
   }

   BooleanProperty isAdminProperty() {
      return isAdminProperty;

   }

   BooleanProperty isLoggedInProperty() {
      return isLoggedInProperty;
   }

   BooleanProperty isUserProperty() {
      return isUserProperty;
   }

   @RequiresRoles("admin")
   void loadAdminAreaPage() {

   }

   void loadHomepage() {
      final ViewTuple<IndexPageView, IndexPageViewModel> viewTuple = FluentViewLoader.fxmlView(IndexPageView.class)
            .load();

      final Scene scene = new Scene(viewTuple.getView());
      scene.getStylesheets().add("css-homepage.css");

      primaryStage.setScene(scene);
   }

   void logout() {
      SecurityUtils.getSubject().logout();
      loadHomepage();
   }

   void openAboutDialog() {

   }

   void openLoginDialog() {
      final ViewTuple<LoginDialogView, LoginDialogViewModel> viewTuple = FluentViewLoader
            .fxmlView(LoginDialogView.class).load();

      final Stage dialogStage = DialogHelper.showDialog(viewTuple.getView(), primaryStage, "css-homepage.css");
      dialogStage.sizeToScene();
      viewTuple.getViewModel().setDialogStage(dialogStage);
      dialogStage.show();

   }

   @RequiresRoles("user")
   void openMitgliederArea() {
      final ViewTuple<MemberAreaPageView, MemberAreaPageViewModel> viewTuple = FluentViewLoader
            .fxmlView(MemberAreaPageView.class).load();

      final Scene scene = new Scene(viewTuple.getView());
      scene.getStylesheets().add("css-homepage.css");

      primaryStage.setScene(scene);
   }

}
