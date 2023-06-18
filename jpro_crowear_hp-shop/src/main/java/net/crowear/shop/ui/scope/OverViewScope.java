package net.chrisrocholl.homepage.ui.scope;

import de.saxsys.mvvmfx.Scope;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class OverViewScope<T> implements Scope {

   private final ObjectProperty<Stage> dialogStageProperty = new SimpleObjectProperty<>();
   private final ObjectProperty<ObservableList<T>> eventsList = new SimpleObjectProperty<>(
         FXCollections.observableArrayList());
   private final ObjectProperty<T> selectedVorgang = new SimpleObjectProperty<>();

   public ObjectProperty<Stage> getDialogStageProperty() {
      return dialogStageProperty;
   }

   public ObjectProperty<ObservableList<T>> getObjectList() {
      return this.eventsList;
   }

   public ObjectProperty<T> getSelectedObjectProperty() {
      return this.selectedVorgang;
   }

   public void setDialogStageProperty(Stage stage) {
      this.dialogStageProperty.set(stage);
   }

   public void setSelectedObject(final T selectedVorgang) {
      getSelectedObjectProperty().set(selectedVorgang);
   }

}
