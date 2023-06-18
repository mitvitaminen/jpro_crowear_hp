package net.chrisrocholl.homepage.ui.component.messagebox;

import java.util.List;

import com.google.inject.Inject;

import net.chrisrocholl.homepage.domain.model.Message;
import net.chrisrocholl.homepage.domain.service.AbstractJpaService;
import net.chrisrocholl.homepage.domain.service.LocaleManagerService;
import net.chrisrocholl.homepage.ui.BaseViewModel;

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
