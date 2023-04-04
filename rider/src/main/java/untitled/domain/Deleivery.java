package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.RiderApplication;

@Entity
@Table(name = "Deleivery_table")
@Data
public class Deleivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderid;

    private String address;

    private String status;

    @PostPersist
    public void onPostPersist() {}

    public static DeleiveryRepository repository() {
        DeleiveryRepository deleiveryRepository = RiderApplication.applicationContext.getBean(
            DeleiveryRepository.class
        );
        return deleiveryRepository;
    }

    public void pickfood() {
        Foodpicked foodpicked = new Foodpicked(this);
        foodpicked.publishAfterCommit();
    }

    public void confirm() {
        DeliveryConfirmed deliveryConfirmed = new DeliveryConfirmed(this);
        deliveryConfirmed.publishAfterCommit();
    }

    public static void loadDeliveryInfo(Cookfinished cookfinished) {
        /** Example 1:  new item 
        Deleivery deleivery = new Deleivery();
        repository().save(deleivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookfinished.get???()).ifPresent(deleivery->{
            
            deleivery // do something
            repository().save(deleivery);


         });
        */

    }

    public static void loadDeliveryInfo(Orderplaced orderplaced) {
        /** Example 1:  new item 
        Deleivery deleivery = new Deleivery();
        repository().save(deleivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderplaced.get???()).ifPresent(deleivery->{
            
            deleivery // do something
            repository().save(deleivery);


         });
        */

    }
}
