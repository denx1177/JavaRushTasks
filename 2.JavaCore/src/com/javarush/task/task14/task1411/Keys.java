package com.javarush.task.task14.task1411;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Keys {
    user,
    loser,
    coder,
    proger;

    public static List<String> asStringList()
    {
        ArrayList<String> list = new ArrayList<>();

        for (Keys value : values()) {
            list.add(value.toString());
        }
        return list;
    }

}

