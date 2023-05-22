package net.crowear.shop.ui.dialog.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;

import com.google.common.base.Strings;
import com.google.inject.Inject;

import net.crowear.shop.domain.service.LocaleManagerService;
import net.crowear.shop.ui.component.dialog.DialogViewModel;
import net.crowear.shop.ui.page.memberarea.MemberAreaPageView;
import net.crowear.shop.ui.page.memberarea.MemberAreaPageViewModel;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginDialogViewModel extends DialogViewModel {

   private static final Logger LOG = LogManager.getLogger(LoginDialogViewModel.class);

   private final BooleanProperty loginFailVisibleProperty = new SimpleBooleanProperty();
   private final StringProperty passwordProperty = new SimpleStringProperty();
   private final Stage primaryStage;
   private final StringProperty usernameProperty = new SimpleStringProperty();

   @Inject
   public LoginDialogViewModel(LocaleManagerService lang, Stage primaryStage) {
      super(lang);
      this.primaryStage = primaryStage;
      loginFailVisibleProperty.set(false);
   }

   void doLogin() {
      if (usernameProperty.isNotEmpty().get() && !Strings.isNullOrEmpty(usernameProperty.get().trim())
            && passwordProperty.isNotEmpty().get() && !Strings.isNullOrEmpty(passwordProperty.get().trim())) {
         final Subject currentUser = SecurityUtils.getSubject();
         final UsernamePasswordToken token = new UsernamePasswordToken(usernameProperty.get(), passwordProperty.get());
         try {
            LOG.debug(new StringBuilder("tryingToLogin with ").append(token.getUsername()).append(" and ")
                  .append(token.getCredentials().toString()));

            currentUser.login(token);
         } catch (final UnknownAccountException uae) {
            LOG.error(new StringBuilder().append("\n###### ").append(UnknownAccountException.class.getName())
                  .append("\n###### +++ username: ").append(token.getUsername()).toString());
         } catch (final IncorrectCredentialsException ice) {
            // do sth send user emailmessage? would be good to change passoword!
            LOG.error(new StringBuilder().append("\n###### ").append(IncorrectCredentialsException.class.getName())
                  .append("\n###### +++ username: ").append(token.getUsername()).toString());
         } catch (final LockedAccountException lae) {
            // sendEmail with support info and reason to user
            LOG.error(new StringBuilder().append("\n###### ").append(LockedAccountException.class.getName())
                  .append("\n###### +++ username: ").append(token.getUsername()).toString());
         } catch (final AuthenticationException ae) {
            LOG.error(new StringBuilder().append("\n###### ").append(AuthenticationException.class.getName())
                  .append("\n###### +++ username: ").append(token.getUsername()).toString());
         }
         if (!currentUser.isAuthenticated()) {
            loginFailVisibleProperty.set(true);
         } else if (currentUser.isAuthenticated()) {
            loadMemberSectionPage();
         }
      }
   }

   BooleanProperty loginFailLabelVisibleProperty() {
      return loginFailVisibleProperty;
   }

   StringProperty passwordProperty() {
      return passwordProperty;
   }

   StringProperty usernameProperty() {
      return usernameProperty;
   }

   @RequiresRoles("user")
   private void loadMemberSectionPage() {
      closeDialog();
      final ViewTuple<MemberAreaPageView, MemberAreaPageViewModel> viewTupleStartingPageView = FluentViewLoader
            .fxmlView(MemberAreaPageView.class).load();

      final Scene scene = new Scene(viewTupleStartingPageView.getView());
      scene.getStylesheets().add("css-homepage.css");

      primaryStage.centerOnScreen();
      primaryStage.setScene(scene);
      primaryStage.setMaximized(true);
   }

}
