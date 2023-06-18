package net.crowear.shop.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Message implements DbObject {

   @Transient
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(nullable = false, updatable = false)
   public long id;
   public LocalDateTime inDate;
   public String message;
   public String topic;

   @Override
   public long getId() {
      return id;
   }

   public LocalDateTime getInDate() {
      return inDate;
   }

   public String getMessage() {
      return message;
   }

   public String getTopic() {
      return topic;
   }

   @Override
   public void setId(final long id) {
      this.id = id;

   }

   public void setInDate(final LocalDateTime inDate) {
      this.inDate = inDate;
   }

   public void setMessage(final String message) {
      this.message = message;
   }

   public void setTopic(final String topic) {
      this.topic = topic;
   }

}
