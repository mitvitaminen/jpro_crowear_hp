package net.crowear.shop.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.inject.persist.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Transactional
public interface AbstractJpaRepository<T, ID> {

   default void delete(ID id) {
      final EntityManager entityManager = getEntityManager();
      final T toBeRemoved = entityManager.getReference(getType(), id);
      entityManager.remove(toBeRemoved);
   }

   default ObservableList<T> findAll() {
      final EntityManager entityManager = getEntityManager();

      final CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(getType());
      criteriaQuery.from(getType());

      final ObservableList<T> list = FXCollections
            .observableArrayList(entityManager.createQuery(criteriaQuery).getResultList());
      return list;
   }

   default List<T> findByColumnValue(final String columnHeader, final String columnValue) {
      final EntityManager entityManager = getEntityManager();

      final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

      final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getType());

      final Root<T> from = criteriaQuery.from(getType());

      criteriaQuery.select(from);
      criteriaQuery.where(criteriaBuilder.equal(from.get(columnHeader), columnValue));

      final TypedQuery<T> typed = entityManager.createQuery(criteriaQuery);
      return typed.getResultStream().collect(Collectors.toList());
   }

   default Optional<T> findById(final ID id) {
      final EntityManager entityManager = getEntityManager();
      return Optional.ofNullable(entityManager.find(getType(), id));
   }

   EntityManager getEntityManager();

   Class<T> getType();

   @Transactional
   default T save(final T t) {
      final EntityManager entityManager = getEntityManager();
      return entityManager.merge(t);
   }

}
