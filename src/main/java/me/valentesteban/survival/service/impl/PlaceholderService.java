package me.valentesteban.survival.service.impl;

import me.valentesteban.survival.placeholder.applier.PlaceholderApplier;
import me.valentesteban.survival.placeholder.types.UserPlaceholder;
import me.valentesteban.survival.service.Service;
import team.unnamed.inject.InjectAll;

@InjectAll
public class PlaceholderService
        implements Service {

    private PlaceholderApplier placeholderApplier;
    private UserPlaceholder userPlaceHolder;

    @Override
    public void start() {
        placeholderApplier.getPlaceHolders().add(userPlaceHolder);
    }
}