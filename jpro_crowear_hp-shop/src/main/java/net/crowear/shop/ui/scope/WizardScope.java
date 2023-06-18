package net.chrisrocholl.homepage.ui.scope;

import de.saxsys.mvvmfx.Scope;
import de.saxsys.mvvmfx.utils.mapping.ModelWrapper;
import de.saxsys.mvvmfx.utils.validation.CompositeValidator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

public class WizardScope<T> implements Scope {

   private final ObjectProperty<Stage> dialogStageProperty = new SimpleObjectProperty<>();
   private final StringProperty dialogTitleProperty = new SimpleStringProperty();
   private final ObjectProperty<CompositeValidator> formValidatorProperty = new SimpleObjectProperty<>(
         new CompositeValidator());
   private final BooleanProperty isValid = new SimpleBooleanProperty(false);
   private final ModelWrapper<T> modelWrapper = new ModelWrapper<>();
   private final BooleanProperty nextPageButtonEnabled = new SimpleBooleanProperty(true);
   private final ObjectProperty<T> objectToEdit = new SimpleObjectProperty<>();
   private final BooleanProperty previousPageButtonEnabled = new SimpleBooleanProperty(true);

   public ObjectProperty<Stage> getDialogStageProperty() {
      return dialogStageProperty;
   }

   public StringProperty getDialogTitleProperty() {
      return this.dialogTitleProperty;
   }

   public ObjectProperty<CompositeValidator> getFormValdiatorProperty() {
      return formValidatorProperty;
   }

   public BooleanProperty getIsValid() {
      return this.isValid;
   }

   public ModelWrapper<T> getModelWrapper() {
      return this.modelWrapper;
   }

   public BooleanProperty getNextPageButtonEnabled() {
      return this.nextPageButtonEnabled;
   }

   public ObjectProperty<T> getObjectToEdit() {
      return this.objectToEdit;
   }

   public BooleanProperty getPreviousPageButtonEnabled() {
      return this.previousPageButtonEnabled;
   }

   public BooleanProperty getSaveButtonEnabled() {
      return this.isValid;
   }

   public void setDialogStageProperty(final Stage stage) {
      this.dialogStageProperty.set(stage);
   }

   public void setObjectToEdit(final T save) {
      this.objectToEdit.set(save);
   }

}
