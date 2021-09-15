package com.bosonit.restservice.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!perfil1 & !perfil2")
public class PerfilDefault implements IPerfiles {

    private final String perfil = "default";

    @Override
    public void miFuncion() {
        System.out.println("Soy " + perfil);
    }
}
