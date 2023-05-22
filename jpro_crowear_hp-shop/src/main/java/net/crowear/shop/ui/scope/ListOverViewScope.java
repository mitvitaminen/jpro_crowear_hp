package net.crowear.shop.ui.scope;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class ListOverViewScope<T, ID> extends OverViewScope<T> {

   private final ObjectProperty<ObservableMap<ID, ObservableList<T>>> itemsMap = new SimpleObjectProperty<>();
   private final ObjectProperty<ObservableList<T>> selectedObjectsProperty = new SimpleObjectProperty<>();

   public ObjectProperty<ObservableMap<ID, ObservableList<T>>> getObjectMap() {
      return itemsMap;
   }

   public ObjectProperty<ObservableList<T>> getSelectedObjectListProperty() {
      return this.selectedObjectsProperty;
   }

   public void setSelectedObject(final ObservableList<T> selectedObjects) {
      getSelectedObjectListProperty().set(selectedObjects);
   }
}
