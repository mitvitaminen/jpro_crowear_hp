package net.crowear.shop.mod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.persist.jpa.JpaPersistOptions;

public class PersistenceModule extends AbstractModule {

   @Singleton
   static class PersistenceInitializer {
      @Inject
      public PersistenceInitializer(final PersistService service) {
         LOG.debug("Starting persistence.");
         service.start();
      }
   }

   private static final Logger LOG = LogManager.getLogger(PersistenceModule.class);

   @Override
   protected void configure() {
      super.configure();
      binder().install(new JpaPersistModule("myPersistenceUnit",
            JpaPersistOptions.builder().setAutoBeginWorkOnEntityManagerCreation(true).build())
            .properties(getPersistenceProperties()));
      binder().bind(PersistenceInitializer.class).asEagerSingleton();

   }

   private Properties getPersistenceProperties() {
      final Properties properties = new Properties();
      final InputStream stream = getClass().getResourceAsStream("/db.properties");
      if (stream == null) {
         LOG.error("No db.properties!!!");
      }
      try {
         properties.load(stream);
      } catch (final IOException e) {
         LOG.error("IOException loading db.properties");
      } finally {
         if (stream != null) {
            try {
               stream.close();
            } catch (final IOException ignored) {
            }
         }
      }
      return properties;
   }

}
