package org.cranberry.statement.resources;

import java.util.ListResourceBundle;

/**
 * The type Messages ru.
 */
public final class messages_ru extends ListResourceBundle {

    @Override
    protected final Object[][] getContents() {
        return new Object[][] {
                { "detail.default", "Ожидается '%s', но получили '%s'" }
        };
    }
}
