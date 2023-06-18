package net.crowear.shop.mod;

import java.util.spi.ResourceBundleProvider;

import com.google.inject.AbstractModule;

import net.crowear.shop.domain.provider.ClientResourceBundleProvider;

public class ProviderModule extends AbstractModule {
   @Override
   protected void configure() {
      bind(ResourceBundleProvider.class).to(ClientResourceBundleProvider.class).asEagerSingleton();
   }
}
