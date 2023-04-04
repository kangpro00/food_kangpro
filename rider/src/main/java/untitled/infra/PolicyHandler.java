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
    DeleiveryRepository deleiveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Cookfinished'"
    )
    public void wheneverCookfinished_LoadDeliveryInfo(
        @Payload Cookfinished cookfinished
    ) {
        Cookfinished event = cookfinished;
        System.out.println(
            "\n\n##### listener LoadDeliveryInfo : " + cookfinished + "\n\n"
        );

        // Sample Logic //
        Deleivery.loadDeliveryInfo(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Orderplaced'"
    )
    public void wheneverOrderplaced_LoadDeliveryInfo(
        @Payload Orderplaced orderplaced
    ) {
        Orderplaced event = orderplaced;
        System.out.println(
            "\n\n##### listener LoadDeliveryInfo : " + orderplaced + "\n\n"
        );

        // Sample Logic //
        Deleivery.loadDeliveryInfo(event);
    }
}
