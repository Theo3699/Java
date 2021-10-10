package com.theo.lab2corect.DTO;

import java.util.ListResourceBundle;

public class Message extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }
    static final Object[][] contents = { { "Category", "Select the category: " },
            { "Key", "Type in a key: " }, { "Value", "Type in a value: " }, };
}