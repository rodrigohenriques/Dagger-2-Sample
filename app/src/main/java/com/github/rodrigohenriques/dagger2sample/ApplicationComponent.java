package com.github.rodrigohenriques.dagger2sample;

import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
