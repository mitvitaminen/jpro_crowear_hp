package net.crowear.shop.domain.model;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCart {

   private BigDecimal discount;
   private List<ShopItem> items;

   public BigDecimal getDiscount() {
      return discount;
   }

   public List<ShopItem> getItems() {
      return items;
   }

   public void setDiscount(BigDecimal discount) {
      this.discount = discount;
   }

   public void setItems(List<ShopItem> items) {
      this.items = items;
   }

}
