package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long id;

    public Canceled(Order aggregate) {
        super(aggregate);
    }

    public Canceled() {
        super();
    }
}
