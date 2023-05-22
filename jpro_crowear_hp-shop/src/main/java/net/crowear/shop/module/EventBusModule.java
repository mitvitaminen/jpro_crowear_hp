package net.crowear.shop.module;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;

public class EventBusModule extends AbstractModule {

   static class EventBusProvider implements Provider<EventBus> {
      @Override
      public EventBus get() {
         return new EventBus("Default EventBus");
      }
   }

   @Override
   protected void configure() {
      super.configure();
      bind(EventBus.class).toProvider(EventBusProvider.class);
   }

}
