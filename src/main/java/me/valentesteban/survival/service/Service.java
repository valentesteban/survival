package me.valentesteban.survival.service;

public interface Service {
    void start();

    default void stop() {}
}
