package fooddeliverybh.infra;

import fooddeliverybh.domain.*;
import fooddeliverybh.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusViewHandler {


    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            OrderStatus orderStatus = new OrderStatus();
            // view 객체에 이벤트의 Value 를 set 함
            orderStatus.setStatus(주문됨);
            // view 레파지 토리에 save
            orderStatusRepository.save(orderStatus);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_1(@Payload Delivered delivered) {
        try {
            if (!delivered.validate()) return;
                // view 객체 조회

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCooked_then_UPDATE_2(@Payload Cooked cooked) {
        try {
            if (!cooked.validate()) return;
                // view 객체 조회

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

