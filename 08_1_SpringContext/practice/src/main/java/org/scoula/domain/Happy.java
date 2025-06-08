package org.scoula.domain;

import org.springframework.stereotype.Component;

@Component("해피")
public class Happy extends Dog {
    public Happy() {
        super("해피", "진돗개");
    }
}
