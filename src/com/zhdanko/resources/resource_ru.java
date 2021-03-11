package com.zhdanko.resources;

import java.util.ListResourceBundle;

public class resource_ru extends ListResourceBundle {
    private static final Object[][] contents = {
            { "greeting", "Привет, мой друг!"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
