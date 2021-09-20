package com.bosonit.restservice.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil1")
public class Perfil1 implements IProfiles {

    private final String perfil = "perfil1";

    @Override
    public void miFuncion() {
        System.out.println("Soy " + perfil);
    }
}
