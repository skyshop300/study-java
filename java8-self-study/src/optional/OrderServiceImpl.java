package optional;

import optional.model.Address;
import optional.model.Member;
import optional.model.Order;

import java.util.Optional;

public class OrderServiceImpl {
    public String getCityOfMemberFromOrder(Order order) {
//        return Optional.ofNullable(order)
//                .map(Order::getMember)
//                .map(Member::getAddress)
//                .map(Address::getCity)
//                .orElse("Seoul");
        return Optional.ofNullable(order)
                .map(item -> Order.getMember())
                .map(Member::getAddress)
                .map(Address::getCity)
                .orElse("Seoul");
    }

}