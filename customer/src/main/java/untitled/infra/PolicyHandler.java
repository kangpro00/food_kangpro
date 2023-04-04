package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Foodpicked'"
    )
    public void wheneverFoodpicked_Updatestatus(
        @Payload Foodpicked foodpicked
    ) {
        Foodpicked event = foodpicked;
        System.out.println(
            "\n\n##### listener Updatestatus : " + foodpicked + "\n\n"
        );

        // Sample Logic //
        Order.updatestatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_Updatestatus(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener Updatestatus : " + cookStarted + "\n\n"
        );

        // Sample Logic //
        Order.updatestatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryConfirmed'"
    )
    public void wheneverDeliveryConfirmed_Updatestatus(
        @Payload DeliveryConfirmed deliveryConfirmed
    ) {
        DeliveryConfirmed event = deliveryConfirmed;
        System.out.println(
            "\n\n##### listener Updatestatus : " + deliveryConfirmed + "\n\n"
        );

        // Sample Logic //
        Order.updatestatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Cookfinished'"
    )
    public void wheneverCookfinished_Updatestatus(
        @Payload Cookfinished cookfinished
    ) {
        Cookfinished event = cookfinished;
        System.out.println(
            "\n\n##### listener Updatestatus : " + cookfinished + "\n\n"
        );

        // Sample Logic //
        Order.updatestatus(event);
    }
}
