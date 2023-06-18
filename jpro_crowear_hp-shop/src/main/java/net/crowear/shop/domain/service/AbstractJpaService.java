package net.chrisrocholl.homepage.domain.service;

import java.util.Optional;

import net.chrisrocholl.homepage.domain.repository.AbstractJpaRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface AbstractJpaService<T, ID> {

   default ObservableList<T> findAll() {
      return getRepository().findAll();
   }

   default ObservableList<T> findByColumNameValue(final String columnName, String value) {
      return FXCollections.observableArrayList(getRepository().findByColumnValue(columnName, value));
   }

   default Optional<T> findById(final ID id) {
      return getRepository().findById(id);
   }

   AbstractJpaRepository<T, ID> getRepository();

   default void remove(final ID id) {
      getRepository().delete(id);
   }

   default T save(final T t) {
      return getRepository().save(t);
   }

}
