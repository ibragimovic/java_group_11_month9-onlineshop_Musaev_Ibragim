package edu.attractor.onlineshop.exception;

import edu.attractor.onlineshop.dto.GadgetType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
@Getter
@Setter
public class NotValidCountGadget extends RuntimeException {
    private String type;
    private String name;

    public NotValidCountGadget(GadgetType gadgetType, String gadgetName) {
        super();
        this.type = gadgetType.toString();
        this.name = gadgetName;
    }

}
