package com.zhdanko.resources;

import java.util.ListResourceBundle;

public class resource extends ListResourceBundle {
    private static final Object[][] contents = {
            { "greeting", "Hello, my friend!"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
