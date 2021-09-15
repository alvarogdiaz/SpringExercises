package com.bosonit.restservice.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil2")
public class Perfil2 implements IPerfiles {

    private final String perfil = "perfil2";

    @Override
    public void miFuncion() {
        System.out.println("Soy " + perfil);
    }
}
