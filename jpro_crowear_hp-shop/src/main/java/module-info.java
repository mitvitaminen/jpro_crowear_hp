module net.chrisrocholl.homepage {
   requires com.google.common;
   requires com.h2database;
   requires de.mkammerer.argon2.nolibs;
   requires de.saxsys.mvvmfx;
   requires de.saxsys.mvvmfx.guice;
   requires de.saxsys.mvvmfx.validation;
   requires jakarta.inject;
   requires java.sql;
   requires javafx.fxml;
   requires one.jpro.routing.core;
   requires org.apache.logging.log4j;

   requires shiro.guice;

   requires transitive com.google.guice;
   requires transitive com.google.guice.extensions.persist;
   requires transitive jakarta.persistence;
   requires transitive javafx.graphics;
   requires transitive jpro.webapi;
   requires transitive shiro.core;

   opens net.chrisrocholl.homepage.mod;
   opens net.chrisrocholl.homepage.ui;
   opens net.chrisrocholl.homepage.ui.component.banner;
   opens net.chrisrocholl.homepage.ui.component.content.admin;
   opens net.chrisrocholl.homepage.ui.component.content.low;
   opens net.chrisrocholl.homepage.ui.component.content.member;
   opens net.chrisrocholl.homepage.ui.component.impressum;
   opens net.chrisrocholl.homepage.ui.component.localeselector;
   opens net.chrisrocholl.homepage.ui.component.menu;
   opens net.chrisrocholl.homepage.ui.component.messagebox;
   opens net.chrisrocholl.homepage.ui.component.statusbar;
   opens net.chrisrocholl.homepage.ui.dialog;
   opens net.chrisrocholl.homepage.ui.dialog.about;
   opens net.chrisrocholl.homepage.ui.dialog.error;
   opens net.chrisrocholl.homepage.ui.dialog.login;
   opens net.chrisrocholl.homepage.ui.page;
   opens net.chrisrocholl.homepage.ui.page.index;
   opens net.chrisrocholl.homepage.ui.page.memberarea;

   provides java.util.spi.ResourceBundleProvider with net.chrisrocholl.homepage.domain.provider.ClientResourceBundleProvider;

   exports net.chrisrocholl.homepage.domain.model to eclipselink;
   exports net.chrisrocholl.homepage.domain.provider to com.google.guice;
   exports net.chrisrocholl.homepage.domain.repository to com.google.guice;
   exports net.chrisrocholl.homepage.domain.service to com.google.guice;
   exports net.chrisrocholl.homepage.ui.component.banner to com.google.guice;
   exports net.chrisrocholl.homepage.ui.component.content.admin to com.google.guice;
   exports net.chrisrocholl.homepage.ui.component.content.low to com.google.guice;
   exports net.chrisrocholl.homepage.ui.component.content.member to com.google.guice;
   exports net.chrisrocholl.homepage.ui.component.impressum to com.google.guice;
   exports net.chrisrocholl.homepage.ui.component.localeselector to com.google.guice;
   exports net.chrisrocholl.homepage.ui.component.menu to com.google.guice;
   exports net.chrisrocholl.homepage.ui.component.messagebox to com.google.guice;
   exports net.chrisrocholl.homepage.ui.component.statusbar to com.google.guice;
   exports net.chrisrocholl.homepage.ui.dialog to com.google.guice;
   exports net.chrisrocholl.homepage.ui.dialog.about to com.google.guice;
   exports net.chrisrocholl.homepage.ui.dialog.error to com.google.guice;
   exports net.chrisrocholl.homepage.ui.dialog.login to com.google.guice;
   exports net.chrisrocholl.homepage.ui.page to com.google.guice;
   exports net.chrisrocholl.homepage.ui.page.index to com.google.guice;
   exports net.chrisrocholl.homepage.ui.page.memberarea to com.google.guice;
   exports net.chrisrocholl.homepage;
}