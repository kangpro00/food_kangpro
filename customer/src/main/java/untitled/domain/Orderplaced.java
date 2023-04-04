package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class Orderplaced extends AbstractEvent {

    private Long id;
    private String foodid;
    private String option;
    private String adress;

    public Orderplaced(Order aggregate) {
        super(aggregate);
    }

    public Orderplaced() {
        super();
    }
}
