package net.chrisrocholl.homepage.domain.model;

import java.io.Serializable;

public interface DbObject extends Serializable {
   long getId();

   void setId(long id);
}
