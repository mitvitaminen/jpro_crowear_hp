package net.crowear.shop.ui.component.messagebox;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;

import net.crowear.shop.ui.BaseView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class MessageBoxView extends BaseView<MessageBoxViewModel> implements Initializable {
   @FXML
   private VBox messagesVBox;

   @Override
   public void initialize(final URL location, final ResourceBundle resources) {
      viewModel.getMessages().forEach(message -> {
         final Label inDateLabel = new Label(
               message.getInDate().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
         inDateLabel.getStyleClass().add("messageInDateLabel");
         inDateLabel.setWrapText(true);
         // inDateLabel.setMaxWidth(270);

         final Label topic = new Label(message.getTopic());
         topic.getStyleClass().add("messageTopicLabel");
         topic.setWrapText(true);
         // topic.setMaxWidth(270);

         final Label msg = new Label(message.getMessage());
         msg.getStyleClass().add("messageText");
         msg.setWrapText(true);
         // msg.setMaxWidth(270);

         final Separator seperator = new Separator();

         final VBox messageVBox = new VBox();
         messageVBox.setSpacing(5);
         messageVBox.getChildren().add(inDateLabel);
         messageVBox.getChildren().add(topic);
         messageVBox.getChildren().add(msg);
         messageVBox.getChildren().add(seperator);

         messagesVBox.getChildren().add(messageVBox);
      });
   }

}
