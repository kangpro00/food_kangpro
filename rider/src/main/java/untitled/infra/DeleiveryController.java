package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

@RestController
// @RequestMapping(value="/deleiveries")
@Transactional
public class DeleiveryController {

    @Autowired
    DeleiveryRepository deleiveryRepository;

    @RequestMapping(
        value = "deleiveries/{id}/pickfood",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Deleivery pickfood(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /deleivery/pickfood  called #####");
        Optional<Deleivery> optionalDeleivery = deleiveryRepository.findById(
            id
        );

        optionalDeleivery.orElseThrow(() -> new Exception("No Entity Found"));
        Deleivery deleivery = optionalDeleivery.get();
        deleivery.pickfood();

        deleiveryRepository.save(deleivery);
        return deleivery;
    }

    @RequestMapping(
        value = "deleiveries/{id}/confirm",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Deleivery confirm(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /deleivery/confirm  called #####");
        Optional<Deleivery> optionalDeleivery = deleiveryRepository.findById(
            id
        );

        optionalDeleivery.orElseThrow(() -> new Exception("No Entity Found"));
        Deleivery deleivery = optionalDeleivery.get();
        deleivery.confirm();

        deleiveryRepository.save(deleivery);
        return deleivery;
    }
}
