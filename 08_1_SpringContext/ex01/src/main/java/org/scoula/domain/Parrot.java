package org.scoula.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component  // 디폴트 컴포넌트의 name: 클래스명의 camelCase - parrot
public class Parrot {
    private String nama;

    @PostConstruct
    public void init() {
        this.nama = "Kiki";
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
