package com.zhdanko.resources;

import java.util.ListResourceBundle;

public class resource_be extends ListResourceBundle {
    private static final Object[][] contents = {
            { "greeting", "Прывітанне, мой сябар!"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
