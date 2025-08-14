package Inheritance;

class Order {
 String orderId;
 String orderDate;

 public Order(String orderId, String orderDate) {
     this.orderId = orderId;
     this.orderDate = orderDate;
 }

 public void getOrderStatus() {
     System.out.println("Order ID: " + orderId);
     System.out.println("Order Date: " + orderDate);
     System.out.println("Status: Order placed");
 }
}

class ShippedOrder extends Order {
 String trackingNumber;

 public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
     super(orderId, orderDate);
     this.trackingNumber = trackingNumber;
 }

 public void getOrderStatus() {
     super.getOrderStatus();
     System.out.println("Tracking Number: " + trackingNumber);
     System.out.println("Status: Order shipped");
 }
}
class DeliveredOrder extends ShippedOrder {
 String deliveryDate;

 public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
     super(orderId, orderDate, trackingNumber);
     this.deliveryDate = deliveryDate;
 }

 public void getOrderStatus() {
     super.getOrderStatus();
     System.out.println("Delivery Date: " + deliveryDate);
     System.out.println("Status: Order delivered");
 }
}

public class OrderApp {
 public static void main(String[] args) {
     DeliveredOrder order = new DeliveredOrder("ORD123", "2025-07-01", "TRK456789", "2025-07-05");
     order.getOrderStatus();
 }
}

