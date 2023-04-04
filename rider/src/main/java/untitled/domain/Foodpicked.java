package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class Foodpicked extends AbstractEvent {

    private Long id;

    public Foodpicked(Deleivery aggregate) {
        super(aggregate);
    }

    public Foodpicked() {
        super();
    }
}
