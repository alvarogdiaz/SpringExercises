package com.bosonit.restservice.profile;

import com.bosonit.restservice.interfaces.IProfiles;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil2")
public class Perfil2 implements IProfiles {

    private final String perfil = "perfil2";

    @Override
    public void miFuncion() {
        System.out.println("Soy " + perfil);
    }
}
