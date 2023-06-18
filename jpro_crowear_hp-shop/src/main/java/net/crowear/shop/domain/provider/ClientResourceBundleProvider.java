package net.chrisrocholl.homepage.domain.provider;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.spi.AbstractResourceBundleProvider;

public class ClientResourceBundleProvider extends AbstractResourceBundleProvider {

   @Override
   public ResourceBundle getBundle(String baseName, Locale locale) {
      return super.getBundle(baseName, locale);
   }

}
