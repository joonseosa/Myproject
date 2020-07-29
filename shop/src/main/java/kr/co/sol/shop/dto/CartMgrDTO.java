package kr.co.sol.shop.dto;

import java.util.Hashtable;

public class CartMgrDTO {
	  private Hashtable<Integer, OrderDTO> hCart = 
			  new Hashtable<Integer, OrderDTO>();
	  
	  public Hashtable<Integer, OrderDTO> getCartList() {
	      return hCart;
	  }
	  
	  public void updateCart(OrderDTO odto) {
	      int product_no = odto.getProduct_no();
	      hCart.put(product_no, odto);
	  }
	  
	  public void deleteCart(OrderDTO odto) {
	      int product_no = odto.getProduct_no();
	      hCart.remove(product_no);
	  }
	  
	  public void addCart(OrderDTO odto) {
	      int product_no = odto.getProduct_no();
	      int quantity = odto.getQuantity();
	      if (quantity > 0) {
	          if (hCart.containsKey(product_no)) {
	        	 OrderDTO tempOrder = 
	        		   (OrderDTO) hCart.get(product_no);
	             quantity += tempOrder.getQuantity();
	             tempOrder.setQuantity(quantity);
	             hCart.put(product_no, tempOrder);
	          }else {
	             hCart.put(product_no, odto);
	          }
	      }
	  }
	}