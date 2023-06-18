package net.crowear.shop.ui.component.messagebox;

import java.util.List;

import com.google.inject.Inject;

import net.crowear.shop.domain.model.Message;
import net.crowear.shop.domain.service.AbstractJpaService;
import net.crowear.shop.domain.service.LocaleManagerService;
import net.crowear.shop.ui.BaseViewModel;

public class MessageBoxViewModel extends BaseViewModel {

   private final AbstractJpaService<Message, Long> messageService;

   @Inject
   public MessageBoxViewModel(LocaleManagerService lang, AbstractJpaService<Message, Long> messageService) {
      super(lang);
      this.messageService = messageService;
   }

   List<Message> getMessages() {
      return messageService.findAll();
   }

}
