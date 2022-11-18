package com.javarush.task.task17.task1706;

import java.util.Optional;

public class OurPresident {
    private static OurPresident president;

    static {
        synchronized (OurPresident.class) {
            OurPresident.president = new OurPresident();
        }
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
