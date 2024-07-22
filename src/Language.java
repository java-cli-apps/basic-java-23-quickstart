import net.fellbaum.jemoji.Emoji;
import net.fellbaum.jemoji.EmojiManager;

import java.util.Optional;

public enum Language {
    French("Bonjour", "fr") ,
    English("Hello", "gb");

    private final String message;
    private final String alias;

    Language(String message, String alias) {
        this.message = message;
        this.alias = alias;
    }

    public String getGreeting() {
        Optional<Emoji> optionalEmoji = EmojiManager.getByAlias(alias);
        String flag = optionalEmoji.map(Emoji::getEmoji).orElse("");
        return message + " " + flag;
    }
}
