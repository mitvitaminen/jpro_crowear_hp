package net.chrisrocholl.homepage.domain.model;

import java.util.Set;

import org.h2.util.StringUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
public class User implements DbObject {

   @Transient
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(nullable = false, updatable = false)
   public long id;
   @Column(nullable = false)
   public String password;
   @ManyToMany
   @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
   public Set<Role> roles;
   @Column(nullable = false, unique = true, updatable = false)
   public String username;

   public User() {
   }

   public User(long id, String username, String password, Set<Role> roles) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.roles = roles;
   }

   @Override
   public Object clone() {
      return id == 0 && StringUtils.isNullOrEmpty(username) && StringUtils.isNullOrEmpty(password) && roles.isEmpty()
            ? new User()
            : new User(id, username, password, roles);
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }
      if (o instanceof User u) {
         // only check name, since role names should be unique across an entire
         // application:
         return getUsername() != null ? getUsername().equals(u.getUsername()) : u.getUsername() == null;
      }
      return false;
   }

   @Override
   public long getId() {
      return id;
   }

   public String getPassword() {
      return password;
   }

   public Set<Role> getRoles() {
      return roles;
   }

   public String getUsername() {
      return username;
   }

   @Override
   public int hashCode() {
      return getUsername() != null ? getUsername().hashCode() : 0;
   }

   @Override
   public void setId(long id) {
      this.id = id;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public void setRoles(Set<Role> roles) {
      this.roles = roles;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   @Override
   public String toString() {
      return getUsername();
   }

}
