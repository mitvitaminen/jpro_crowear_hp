package net.crowear.shop.domain.model;

import java.io.Serializable;

public interface DbObject extends Serializable {
   long getId();

   void setId(long id);
}
