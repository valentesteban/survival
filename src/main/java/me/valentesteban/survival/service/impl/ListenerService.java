package me.valentesteban.survival.service.impl;

import me.valentesteban.survival.Survival;
import me.valentesteban.survival.service.Service;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import team.unnamed.inject.InjectAll;

@InjectAll
public class ListenerService implements Service {

    private Survival survival;
    //private ParkourMapListener parkourMapListener;

    @Override
    public void start() {
        registerListeners(
                //parkourMapListener
        );
    }

    private void registerListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, survival);
        }
    }
}
