package net.chrisrocholl.homepage.ui.scope;

import java.util.List;

import de.saxsys.mvvmfx.utils.mapping.ModelWrapper;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;

public class ListWizardScope<T> extends WizardScope<T> {

   private final List<ModelWrapper<T>> modelWrapper = FXCollections.observableArrayList();

   private final ObjectProperty<List<T>> objectsToEdit = new SimpleObjectProperty<>();

   public List<ModelWrapper<T>> getModelWrapperList() {
      return this.modelWrapper;
   }

   public ObjectProperty<List<T>> getObjectsToEdit() {
      return this.objectsToEdit;
   }

}
