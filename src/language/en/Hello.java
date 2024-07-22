package language.en;

import java.util.Optional;

import language.api.Greeting;
import net.fellbaum.jemoji.Emoji;
import net.fellbaum.jemoji.EmojiManager;

public class Hello implements Greeting {

    @Override
    public String getGreeting() {
        Optional<Emoji> optionalEmoji = EmojiManager.getByAlias("gb");
        String flag = optionalEmoji.map(Emoji::getEmoji).orElse("");
        return "Hello " + flag;
    }
}
