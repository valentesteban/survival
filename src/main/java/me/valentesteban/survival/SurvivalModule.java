package me.valentesteban.survival;

import me.valentesteban.survival.file.YamlFile;
import me.valentesteban.survival.placeholder.PlaceholderModule;
import me.valentesteban.survival.scoreboard.registry.ScoreboardRegistry;
import me.valentesteban.survival.service.Service;
import me.valentesteban.survival.service.impl.ListenerService;
import me.valentesteban.survival.service.impl.PlaceholderService;
import me.valentesteban.survival.service.impl.SchedulerService;
import team.unnamed.inject.AbstractModule;

import java.util.HashSet;
import java.util.Set;

public class SurvivalModule
        extends AbstractModule {
    private final Survival survival;

    public SurvivalModule(Survival survival) {
        this.survival = survival;
    }

    @Override
    protected void configure() {
        YamlFile config = new YamlFile(survival, "config");
        bind(YamlFile.class)
                .toInstance(config);

        bind(YamlFile.class)
                .named("scoreboards")
                .toInstance(new YamlFile(survival, "scoreboards"));

        multibind(Service.class)
                .asCollection(Set.class, HashSet::new)
                .to(ListenerService.class)
                .to(PlaceholderService.class)
                .to(SchedulerService.class)
                .singleton();

        bind(ScoreboardRegistry.class)
                .singleton();

        install(new PlaceholderModule());

        bind(Survival.class).toInstance(survival);
    }
}
