package me.valentesteban.survival;

import me.valentesteban.survival.service.Service;
import org.bukkit.plugin.java.JavaPlugin;
import team.unnamed.inject.Injector;

import javax.inject.Inject;
import java.util.Set;

public class Survival
        extends JavaPlugin {

    @Inject
    private Set<Service> services;

    @Override
    public void onLoad() {
        Injector.create(new SurvivalModule(this))
                .injectMembers(this);
    }

    @Override
    public void onEnable() {
        for (Service service : services) {
            service.start();
        }
    }

    @Override
    public void onDisable() {
        for (Service service : services) {
            service.stop();
        }
    }
}
