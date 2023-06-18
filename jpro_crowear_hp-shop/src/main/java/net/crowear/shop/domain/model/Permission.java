package net.crowear.shop.domain.model;

import java.util.Set;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.h2.util.StringUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "permissions")
public class Permission extends WildcardPermission implements DbObject {

   @Transient
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(nullable = false, updatable = false)
   public long id;
   @Column(nullable = false, unique = true)
   public String permission;
   @ManyToMany(mappedBy = "permissions")
   public Set<Role> roles;

   public Permission() {
   }

   public Permission(long id, String permission) {
      super(permission, false);
      this.permission = permission;
      setParts(permission, DEFAULT_CASE_SENSITIVE);
      this.id = id;
   }

   public Permission(String permission) {
      super(permission, false);
      this.permission = permission;
      setParts(permission, DEFAULT_CASE_SENSITIVE);
   }

   @Override
   public Object clone() {
      return StringUtils.isNullOrEmpty(getPermission()) && id == 0 ? new Permission()
            : new Permission(id, getPermission());
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }
      if (o instanceof final Permission p) {
         // only check permission, since permission should be unique across an entire
         // application:
         return getPermission() != null ? getPermission().equals(p.getPermission()) : p.getPermission() == null;
      }
      return false;
   }

   @Override
   public long getId() {
      return id;
   }

   public String getPermission() {
      return permission;
   }

   @Override
   public int hashCode() {
      return getPermission() != null ? getPermission().hashCode() : 0;
   }

   @Override
   public void setId(long id) {
      this.id = id;
   }

   public void setPermission(String permission) {
      this.permission = permission;
      setParts(permission, DEFAULT_CASE_SENSITIVE);
   }

   @Override
   public String toString() {
      return getPermission();
   }

}
