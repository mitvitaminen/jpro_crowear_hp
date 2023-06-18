package net.chrisrocholl.homepage.ui.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.value.ObservableValue;

public final class ToStringFormatter {

   public static StringBinding emptyDateOnNull(final ObjectBinding<LocalDateTime> source) {
      return Bindings.createStringBinding(() -> {
         if (source.getValue() == null) {
            return "";
         }
         return DateTimeFormatter.ofPattern("yyyy.MM.dd - HH:MM").format(source.getValue());
      }, source);
   }

   public static StringBinding emptyStringOnNullLong(final ObservableValue<Long> source) {
      return Bindings.createStringBinding(() -> {
         if (source.getValue() == null) {
            return "";
         }
         return String.valueOf(source.getValue());
      }, source);
   }

   public static StringBinding emptyStringOnNullString(final ObservableValue<String> source) {
      return Bindings.createStringBinding(() -> {
         if (source.getValue() == null) {
            return "";
         }
         return source.getValue();
      }, source);
   }
}
