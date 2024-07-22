package language.fr;

import java.util.Optional;

import language.api.Greeting;
import net.fellbaum.jemoji.Emoji;
import net.fellbaum.jemoji.EmojiManager;

public class Bonjour implements Greeting {

    @Override
    public String getGreeting() {
        Optional<Emoji> optionalEmoji = EmojiManager.getByAlias("fr");
        String flag = optionalEmoji.map(Emoji::getEmoji).orElse("");
        return "Bonjour " + flag;
    }
}
