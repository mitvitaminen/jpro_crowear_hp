package net.crowear.shop.ui.component.dialog;

import java.util.Optional;

import net.crowear.shop.domain.service.LocaleManagerService;
import net.crowear.shop.ui.BaseViewModel;
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
