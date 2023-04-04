package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class DeleiveryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Deleivery>> {

    @Override
    public EntityModel<Deleivery> process(EntityModel<Deleivery> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/pickfood")
                .withRel("pickfood")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/confirm")
                .withRel("confirm")
        );

        return model;
    }
}
