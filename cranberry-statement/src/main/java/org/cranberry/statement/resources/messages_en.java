package org.cranberry.statement.resources;

import java.util.ListResourceBundle;

/**
 * The type Messages en.
 */
public final class messages_en extends ListResourceBundle {

    @Override
    protected final Object[][] getContents() {
        return new Object[][] {
                { "detail.default", "'%s' is expected but actually was '%s'" }
        };
    }
}
