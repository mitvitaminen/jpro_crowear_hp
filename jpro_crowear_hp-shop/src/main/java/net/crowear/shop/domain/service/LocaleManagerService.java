package net.crowear.shop.domain.service;

import java.util.Locale;

import javafx.collections.ObservableMap;

public interface LocaleManagerService {

   void changeLocale(Locale newLocale);

   ObservableMap<String, Object> get();

   String getString(String key);

   void set(ObservableMap<String, Object> newValue);

}
