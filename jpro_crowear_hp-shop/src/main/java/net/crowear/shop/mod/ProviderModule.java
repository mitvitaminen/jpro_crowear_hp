package net.chrisrocholl.homepage.mod;

import java.util.spi.ResourceBundleProvider;

import com.google.inject.AbstractModule;

import net.chrisrocholl.homepage.domain.provider.ClientResourceBundleProvider;

public class ProviderModule extends AbstractModule {
   @Override
   protected void configure() {
      bind(ResourceBundleProvider.class).to(ClientResourceBundleProvider.class).asEagerSingleton();
   }
}
