package net.chrisrocholl.homepage.ui.component.menu;

import java.net.URL;
import java.util.ResourceBundle;

import net.chrisrocholl.homepage.ui.BaseView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MenuView extends BaseView<MenuViewModel> implements Initializable {

   @FXML
   private Button buttonAdminArea;
   @FXML
   private Button buttonLoginAction;
   @FXML
   private Button buttonLogoutAction;
   @FXML
   private Button buttonMitgliederArea;

   @Override
   public void initialize(final URL location, final ResourceBundle resources) {
      buttonAdminArea.disableProperty().bind(viewModel.isAdminProperty());
      buttonLoginAction.visibleProperty().bind(viewModel.isLoggedInProperty().not());
      buttonLogoutAction.visibleProperty().bind(viewModel.isLoggedInProperty());
      buttonMitgliederArea.disableProperty().bind(viewModel.isUserProperty());
   }

   @FXML
   private void loadAdminAreaPage() {
      viewModel.loadAdminAreaPage();
   }

   @FXML
   private void loadHomepage() {
      viewModel.loadHomepage();
   }

   @FXML
   private void loadMitgliederArea() {
      viewModel.openMitgliederArea();
   }

   @FXML
   private void logoutAction() {
      viewModel.logout();
   }

   @FXML
   private void openAboutDialog() {
      viewModel.openAboutDialog();
   }

   @FXML
   private void openLoginDialog() {
      viewModel.openLoginDialog();
   }
}
