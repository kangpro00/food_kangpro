package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class Cookfinished extends AbstractEvent {

    private Long id;

    public Cookfinished(Cooking aggregate) {
        super(aggregate);
    }

    public Cookfinished() {
        super();
    }
}
