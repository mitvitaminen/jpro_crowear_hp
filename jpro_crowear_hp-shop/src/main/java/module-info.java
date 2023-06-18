module net.crowear.shop {
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

   requires transitive shiro.guice;
   requires transitive com.google.guice;
   requires transitive com.google.guice.extensions.persist;
   requires transitive jakarta.persistence;
   requires transitive javafx.graphics;
   requires transitive jpro.webapi;
   requires transitive shiro.core;

   opens net.crowear.shop.mod;
   opens net.crowear.shop.ui;
   opens net.crowear.shop.ui.component.banner;
   opens net.crowear.shop.ui.component.content.admin;
   opens net.crowear.shop.ui.component.content.low;
   opens net.crowear.shop.ui.component.content.member;
   opens net.crowear.shop.ui.component.impressum;
   opens net.crowear.shop.ui.component.localeselector;
   opens net.crowear.shop.ui.component.menu;
   opens net.crowear.shop.ui.component.messagebox;
   opens net.crowear.shop.ui.component.statusbar;
   opens net.crowear.shop.ui.dialog;
   opens net.crowear.shop.ui.dialog.about;
   opens net.crowear.shop.ui.dialog.error;
   opens net.crowear.shop.ui.dialog.login;
   opens net.crowear.shop.ui.page;
   opens net.crowear.shop.ui.page.index;
   opens net.crowear.shop.ui.page.memberarea;

   provides java.util.spi.ResourceBundleProvider
         with net.crowear.shop.domain.provider.ClientResourceBundleProvider;

   exports net.crowear.shop.domain.model to eclipselink;
   exports net.crowear.shop.domain.provider to com.google.guice;
   exports net.crowear.shop.domain.repository to com.google.guice;
   exports net.crowear.shop.domain.service to com.google.guice;
   exports net.crowear.shop.ui.component.banner to com.google.guice;
   exports net.crowear.shop.ui.component.content.admin to com.google.guice;
   exports net.crowear.shop.ui.component.content.low to com.google.guice;
   exports net.crowear.shop.ui.component.content.member to com.google.guice;
   exports net.crowear.shop.ui.component.impressum to com.google.guice;
   exports net.crowear.shop.ui.component.localeselector to com.google.guice;
   exports net.crowear.shop.ui.component.menu to com.google.guice;
   exports net.crowear.shop.ui.component.messagebox to com.google.guice;
   exports net.crowear.shop.ui.component.statusbar to com.google.guice;
   exports net.crowear.shop.ui.dialog to com.google.guice;
   exports net.crowear.shop.ui.dialog.about to com.google.guice;
   exports net.crowear.shop.ui.dialog.error to com.google.guice;
   exports net.crowear.shop.ui.dialog.login to com.google.guice;
   exports net.crowear.shop.ui.page to com.google.guice;
   exports net.crowear.shop.ui.page.index to com.google.guice;
   exports net.crowear.shop.ui.page.memberarea to com.google.guice;
   exports net.crowear.shop;
}