package me.valentesteban.survival.service.impl;

import me.valentesteban.survival.Survival;
import me.valentesteban.survival.scheduler.ScoreboardScheduler;
import me.valentesteban.survival.service.Service;
import team.unnamed.inject.InjectAll;

@InjectAll
public class SchedulerService
        implements Service {

    private Survival survival;
    private ScoreboardScheduler scoreboardScheduler;

    @Override
    public void start() {
        scoreboardScheduler.runTaskTimerAsynchronously(survival, 300, 1);
    }

    @Override
    public void stop() {
        scoreboardScheduler.cancel();
    }
}