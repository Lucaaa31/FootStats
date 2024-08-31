package unibo.footstats.application;


import unibo.footstats.model.stagione.Stagione;
import unibo.footstats.view.LogInView;
import unibo.footstats.view.MainView;

import java.sql.DriverManager;

public final class AppLauncher{
    private AppLauncher(){}

    public static void main(String[] args){
        final MainView mainView = new MainView();
    }
}