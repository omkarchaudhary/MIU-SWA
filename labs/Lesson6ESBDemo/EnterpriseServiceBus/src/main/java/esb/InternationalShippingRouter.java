package esb;

public class InternationalShippingRouter {
    public String route(Order order) {
        if (order.getOrderType().equals(OrderType.INTERNATIONAL.toString())) {
            return "internationalshippingchannel";
        } else {
            return "domesticshippingchannel";
        }
    }
}
