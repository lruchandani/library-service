package com.lalit.library.acceptance;

import com.lalit.library.command.AuthorCommand;
import com.lalit.library.command.BookCommand;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;

public class CustomTypeConfigurer implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(DataTableType.entry(BookCommand.class));
        typeRegistry.defineDataTableType(DataTableType.entry(AuthorCommand.class));
    }
}
