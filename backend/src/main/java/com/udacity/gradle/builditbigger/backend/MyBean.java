package com.udacity.gradle.builditbigger.backend;

import ml.shahidkamal.libjoker.Joker;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private Joker joker = new Joker();
    public String getJoke() {
        return joker.getRandomJoke();
    }
}