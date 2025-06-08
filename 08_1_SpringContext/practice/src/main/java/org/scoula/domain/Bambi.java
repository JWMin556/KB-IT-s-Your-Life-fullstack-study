package org.scoula.domain;

import org.springframework.stereotype.Component;

@Component("밤비")
public class Bambi extends Dog {
    public Bambi() {
        super("밤비", "시바견");
    }
}
