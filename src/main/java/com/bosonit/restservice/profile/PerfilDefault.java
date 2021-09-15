package com.bosonit.restservice.profile;

import com.bosonit.restservice.interfaces.IProfiles;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!perfil1 & !perfil2")
public class PerfilDefault implements IProfiles {

    private final String perfil = "default";

    @Override
    public void miFuncion() {
        System.out.println("Soy " + perfil);
    }
}
