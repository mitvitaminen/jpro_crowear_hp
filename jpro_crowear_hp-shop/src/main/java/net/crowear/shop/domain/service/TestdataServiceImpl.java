package net.crowear.shop.domain.service;

import java.time.LocalDateTime;
import java.util.Set;

import com.google.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.crowear.shop.domain.model.Message;
import net.crowear.shop.domain.model.Permission;
import net.crowear.shop.domain.model.Role;
import net.crowear.shop.domain.model.User;
import net.crowear.shop.security.shiro.Argon2CredentialsMatcher;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;
import javafx.collections.FXCollections;

public class TestdataServiceImpl implements TestdataService {

   private final static Logger LOG = LogManager.getLogger(TestdataService.class);

   private final AbstractJpaService<Message, Long> messageService;
   private final AbstractJpaService<Permission, Long> permissionService;
   private final AbstractJpaService<Role, Long> roleService;
   private final UserService userService;

   @Inject
   public TestdataServiceImpl(final AbstractJpaService<Message, Long> messageService,
         final AbstractJpaService<Permission, Long> permissionService, final AbstractJpaService<Role, Long> roleService,
         final UserService userService) {
      this.messageService = messageService;
      this.permissionService = permissionService;
      this.roleService = roleService;
      this.userService = userService;
   }

   @Override
   public void createData() {
      LOG.debug("creating testdata");
      createPermissions();
      createRoles();
      createUser();
      createMessages();

   }

   private Message createMessage(final String topic, final String msg) {
      final Message m = new Message();
      m.setInDate(LocalDateTime.now());
      m.setTopic(topic);
      m.setMessage(msg);
      return m;
   }

   private void createMessages() {
      for (int i = 0; i <= 20; i++) {
         final Message m = createMessage("topic" + i,
               " Lorem ipsum dolor sit amet, consectetur adipiscing elit.Vestibulum sed sollicitudin eros."
                     + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                     + "Vestibulum sed sollicitudin eros. Etiam porttitor metus "
                     + "nisl. Etiam vestibulum tincidunt lectus, in malesuada est "
                     + "fermentum ut. Vivamus tincidunt velit a tortor rutrum efficitur. "
                     + "Aenean faucibus, sem in pellentesque accumsan, nulla quam lacinia "
                     + "ipsum, vel facilisis massa ante quis mi. Cras fermentum convallis "
                     + "est id rhoncus. Nam facilisis ligula eu euismod lacinia. Aenean mollis "
                     + "egestas nibh in imperdiet. Aenean luctus risus mauris, eget rhoncus"
                     + "eros fringilla nec. In vel nisl dignissim, posuere diam vel, "
                     + "facilisis arcu. Suspendisse ut dictum sapien. ");
         messageService.save(m);
      }
   }

   private void createPermissions() {
      final Permission userCreatePermission = new Permission();
      userCreatePermission.setPermission("user:create:*");

      final Permission userUpdatePermission = new Permission();
      userUpdatePermission.setPermission("user:update:*");

      final Permission userDeletePermission = new Permission();
      userDeletePermission.setPermission("user:delete:*");

      permissionService.save(userCreatePermission);
      permissionService.save(userUpdatePermission);
      permissionService.save(userDeletePermission);
   }

   private void createRoles() {
      final Permission userCreatePermission = permissionService.findByColumNameValue("permission", "user:create:*")
            .stream().findFirst().orElse(null);

      final Permission userUpdatePermission = permissionService.findByColumNameValue("permission", "user:update:*")
            .stream().findFirst().orElse(null);

      final Permission userDeletePermission = permissionService.findByColumNameValue("permission", "user:delete:*")
            .stream().findFirst().orElse(null);

      final Set<Permission> adminPermissions = FXCollections.observableSet(userCreatePermission, userUpdatePermission,
            userDeletePermission);

      final Role adminRole = new Role();
      adminRole.setRolename("admin");
      adminRole.setPermissions(adminPermissions);

      final Set<Permission> userPermissions = FXCollections.observableSet(userCreatePermission, userUpdatePermission);

      final Role userRole = new Role();
      userRole.setRolename("user");
      userRole.setPermissions(userPermissions);

      roleService.save(adminRole);
      roleService.save(userRole);
   }

   private void createUser() {
      final Argon2 argon2 = Argon2Factory.create(Argon2Types.ARGON2id);

      final Role adminRole = roleService.findByColumNameValue("rolename", "admin").stream().findFirst().orElse(null);

      final Role userRole = roleService.findByColumNameValue("rolename", "user").stream().findFirst().orElse(null);

      final Set<Role> adminUserRoleList = FXCollections.observableSet(adminRole, userRole);

      final Set<Role> userRoleList = FXCollections.observableSet(userRole);

      final User user1 = new User();
      user1.setUsername("testUser1");
      user1.setPassword(argon2.hash(Argon2CredentialsMatcher.ARGON2_ITERATIONS, Argon2CredentialsMatcher.ARGON2_MEMORY,
            Argon2CredentialsMatcher.ARGON2_PARALLELISM, "testUser1".toCharArray()));
      user1.setRoles(adminUserRoleList);
      userService.save(user1);

      final User user2 = new User();
      user2.setUsername("testUser2");
      user2.setPassword(argon2.hash(Argon2CredentialsMatcher.ARGON2_ITERATIONS, Argon2CredentialsMatcher.ARGON2_MEMORY,
            Argon2CredentialsMatcher.ARGON2_PARALLELISM, "testUser2".toCharArray()));
      user2.setRoles(userRoleList);
      userService.save(user2);
   }

}
