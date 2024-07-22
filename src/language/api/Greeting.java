package language.api;

import language.en.Hello;
import language.fr.Bonjour;

public interface Greeting {

    enum Language {
        French, English
    }

    static Greeting byLanguage(Language language) {
        return switch (language) {
            case French -> new Bonjour();
            case English -> new Hello();
        };
    }

    String getGreeting();
}
