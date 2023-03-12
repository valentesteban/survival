package me.valentesteban.survival.placeholder;

import me.valentesteban.survival.placeholder.types.UserPlaceholder;
import team.unnamed.inject.AbstractModule;

public class PlaceholderModule
        extends AbstractModule {

    @Override
    protected void configure() {
        bind(Placeholder.class)
                .to(UserPlaceholder.class)
                .singleton();
    }
}