package net.crowear.shop.domain.service;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.spi.ResourceBundleProvider;

import com.google.inject.Inject;

import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;

public class LocaleManagerServiceImpl extends SimpleMapProperty<String, Object> implements LocaleManagerService {

   private final static String BUNDLENAME = "clientresources";
   private ResourceBundle bundle;

   private final ResourceBundleProvider bundleProvider;

   @Inject
   public LocaleManagerServiceImpl(ResourceBundleProvider bundleProvider) {
      super(FXCollections.observableHashMap());
      this.bundleProvider = bundleProvider;
      reload(Locale.GERMANY);
   }

   @Override
   public void changeLocale(final Locale newLocale) {
      Locale.setDefault(newLocale);
      reload(newLocale);
   }

   @Override
   public String getString(final String key) {
      return bundle.getString(key);
   }

   @SuppressWarnings("unchecked")
   private void reload(Locale locale) {
      bundle = bundleProvider.getBundle(BUNDLENAME, locale);

      final Enumeration<String> keys = bundle.getKeys();
      while (keys.hasMoreElements()) {
         final String key = keys.nextElement();
         final String value = bundle.getString(key);

         MapProperty<String, Object> map = this;

         final String[] parts = key.split("\\.");
         for (int i = 0; i < parts.length; i++) {

            final String part = parts[i];
            if (i == parts.length - 1) {
               map.put(part, value);
            } else {
               if (!map.containsKey(part)) {
                  map.put(part, new SimpleMapProperty<>(FXCollections.observableHashMap()));
               }
               map = (MapProperty<String, Object>) map.get(part);
            }
         }
      }
   }

}
