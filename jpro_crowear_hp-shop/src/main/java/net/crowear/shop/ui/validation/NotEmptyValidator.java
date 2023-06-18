package net.chrisrocholl.homepage.ui.validation;

import de.saxsys.mvvmfx.utils.validation.FunctionBasedValidator;
import de.saxsys.mvvmfx.utils.validation.Severity;
import de.saxsys.mvvmfx.utils.validation.ValidationMessage;
import javafx.beans.value.ObservableValue;

public class NotEmptyValidator extends FunctionBasedValidator<String> {

   private static final String MSG = "error.notempty";

   public NotEmptyValidator(ObservableValue<String> source) {
      super(source,
            input -> input == null || input.trim().isEmpty() ? new ValidationMessage(Severity.ERROR, MSG) : null);
   }

}
