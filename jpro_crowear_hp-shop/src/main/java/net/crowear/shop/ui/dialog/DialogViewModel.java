package net.chrisrocholl.homepage.ui.dialog;

import java.util.Optional;

import net.chrisrocholl.homepage.domain.service.LocaleManagerService;
import net.chrisrocholl.homepage.ui.BaseViewModel;
import javafx.stage.Stage;

public abstract class DialogViewModel extends BaseViewModel {

   private Optional<Stage> dialogStageOptional;

   public DialogViewModel(LocaleManagerService lang) {
      super(lang);
   }

   public void closeDialog() {
      dialogStageOptional.ifPresent(s -> s.close());
   }

   public void setDialogStage(Stage dialogStage) {
      dialogStageOptional = Optional.of(dialogStage);
   }

}
