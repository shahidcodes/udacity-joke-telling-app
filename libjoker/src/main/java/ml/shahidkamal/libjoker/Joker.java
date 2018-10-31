package ml.shahidkamal.libjoker;

import java.util.Random;

public class Joker {
    private String[] jokes = {
            "How do you keep a programmer in the shower all day?\n" +
                    "Give him a bottle of shampoo which says \"lather, rinse, repeat.\"",
            "There are three kinds of lies: Lies, damned lies, and benchmarks.",
            "Unix is user friendly. It's just very particular about who it's friends are.",
            "All programmers are playwrights and all computers are lousy actors.",
            "There are only 10 types of people in the world:\nThose that understand binary and those that don't."
    };
    private Random random = new Random();


    public String[] getJokes() {
        return jokes;
    }

    public String getRandomJoke(){
        return this.jokes[random.nextInt(jokes.length)];
    }
}
