package net.chrisrocholl.homepage.domain.model;

import java.util.Collection;
import java.util.LinkedHashSet;
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

@Entity
@Table(name = "roles")
public class Role implements DbObject {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(nullable = false, updatable = false)
   public long id;
   @ManyToMany
   @JoinTable(name = "roles_permissions", joinColumns = @JoinColumn(name = "roles_id"), inverseJoinColumns = @JoinColumn(name = "permissions_id"))
   public Set<Permission> permissions;
   @Column(nullable = false, unique = true)
   public String rolename;
   @ManyToMany(mappedBy = "roles")
   public Set<User> users;

   public Role() {
   }

   public Role(long id, String rolename, Set<Permission> permissions) {
      this.id = id;
      this.rolename = rolename;
      this.permissions = permissions;
   }

   public void add(Permission permission) {
      Set<Permission> permissions = getPermissions();
      if (permissions == null) {
         permissions = new LinkedHashSet<>();
         setPermissions(permissions);
      }
      permissions.add(permission);
   }

   public void addAll(Collection<Permission> perms) {
      if (perms != null && !perms.isEmpty()) {
         Set<Permission> permissions = getPermissions();
         if (permissions == null) {
            permissions = new LinkedHashSet<>(perms.size());
            setPermissions(permissions);
         }
         permissions.addAll(perms);
      }
   }

   @Override
   public Object clone() {
      return id == 0 && StringUtils.isNullOrEmpty(this.getRolename()) && this.getPermissions().isEmpty() ? new Role()
            : new Role(id, this.getRolename(), this.getPermissions());
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }
      if (o instanceof Role r) {
         // only check name, since role names should be unique across an entire
         // application:
         return getRolename() != null ? getRolename().equals(r.getRolename()) : r.getRolename() == null;
      }
      return false;
   }

   @Override
   public long getId() {
      return id;
   }

   public Set<Permission> getPermissions() {
      return permissions;
   }

   public String getRolename() {
      return rolename;
   }

   @Override
   public int hashCode() {
      return getRolename() != null ? getRolename().hashCode() : 0;
   }

   public boolean isPermitted(Permission p) {
      final Collection<Permission> perms = getPermissions();
      if (perms != null && !perms.isEmpty()) {
         for (final Permission perm : perms) {
            if (perm.implies(p)) {
               return true;
            }
         }
      }
      return false;
   }

   @Override
   public void setId(long id) {
      this.id = id;
   }

   public void setPermissions(Set<Permission> permissions) {
      this.permissions = permissions;
   }

   public void setRolename(String rolename) {
      this.rolename = rolename;
   }

   @Override
   public String toString() {
      return getRolename();
   }

}
