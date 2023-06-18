package net.crowear.shop.domain.model;

import java.math.BigDecimal;

public class ShopItem implements DbObject {

   public enum Size {
      L, M, S, XL, XS, XXL
   }

   private static final long serialVersionUID = 1L;;

   public String artikelnummer;
   public BigDecimal discount;
   public long id;
   public BigDecimal price;
   public Size size;

   public String getArtikelnummer() {
      return artikelnummer;
   }

   public BigDecimal getDiscount() {
      return discount;
   }

   @Override
   public long getId() {
      return id;
   }

   public int getPrice() {
      return price.intValue();
   }

   public Size getSize() {
      return size;
   }

   public void setArtikelnummer(String artikelnummer) {
      this.artikelnummer = artikelnummer;
   }

   public void setDiscount(BigDecimal discount) {
      this.discount = discount;
   }

   @Override
   public void setId(long id) {
      this.id = id;
   }

   public void setPrice(BigDecimal price) {
      this.price = price;
   }

   public void setSize(Size size) {
      this.size = size;
   }

}
