package net.crowear.shop.module;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.h2.jdbcx.JdbcDataSource;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class DataSourceModule extends AbstractModule {

   static class DataSourceProvider implements Provider<DataSource> {
      private final String password;
      private final int timeout;
      private final String url;
      private final String username;

      @Inject
      public DataSourceProvider(@Named("jakarta.persistence.jdbc.url") final String url,
            @Named("jakarta.persistence.jdbc.user") final String username,
            @Named("jakarta.persistence.jdbc.password") final String password,
            @Named("jakarta.persistence.jdbc.timeout") final String timeout) {
         this.url = url;
         this.username = username;
         this.password = password;
         this.timeout = Integer.parseInt(timeout);
      }

      @Override
      public DataSource get() {
         final JdbcDataSource dataSource = new JdbcDataSource();
         dataSource.setURL(url);
         dataSource.setUser(username);
         dataSource.setPassword(password);
         dataSource.setLoginTimeout(timeout);
         return dataSource;
      }
   }

   private static final Logger LOG = LogManager.getLogger(DataSourceModule.class);

   @Override
   protected void configure() {
      super.configure();
      Names.bindProperties(binder(), loadDBProperties());
      bind(DataSource.class).toProvider(DataSourceProvider.class).asEagerSingleton();
   }

   private Properties loadDBProperties() {
      final Properties properties = new Properties();
      final InputStream stream = getClass().getResourceAsStream("/db.properties");
      if (stream == null) {
         LOG.error("No db.properties!!!");
      }
      try {
         properties.load(stream);
      } catch (final IOException e) {
         LOG.error("IOException loading db.properties");
      }
      return properties;
   }

}
