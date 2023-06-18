package net.chrisrocholl.homepage.exceptions;

public class DatabaseOfflineException extends Exception {

   private static final long serialVersionUID = 1L;

   public DatabaseOfflineException() {
      super("error.databaseoffline");
   }
}
