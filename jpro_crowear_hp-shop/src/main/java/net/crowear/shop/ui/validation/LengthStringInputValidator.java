package net.chrisrocholl.homepage.ui.validation;

import de.saxsys.mvvmfx.utils.validation.FunctionBasedValidator;
import de.saxsys.mvvmfx.utils.validation.Severity;
import de.saxsys.mvvmfx.utils.validation.ValidationMessage;
import javafx.beans.value.ObservableValue;

public class LengthStringInputValidator extends FunctionBasedValidator<String> {

   private static final String MSG = "error.inputtoolong";

   public LengthStringInputValidator(ObservableValue<String> source, int length) {
      super(source, input -> input.trim().length() > length ? new ValidationMessage(Severity.ERROR, MSG) : null);
   }

}
