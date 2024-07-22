///usr/bin/env java --source 23 --enable-preview --class-path ${APP_DIR}/lib/'*' "$0" "$@"; exit $?

import language.api.Greeting;
import language.api.Greeting.Language;

import static language.api.Greeting.Language.English;
import static language.api.Greeting.Language.French;

void main() {
    var language = askLanguage();
    var greeting = Greeting.byLanguage(language);
    println(greeting.getGreeting());
    System.exit(0);
}

private Language askLanguage() {
    var response = readln("Do you speak English (Y/N) ? ");
    return switch (response) {
        case String s when s == null || s.isEmpty() -> throw new IllegalArgumentException("No response was provided !");
        case String s when s.equals("Y") -> English;
        default -> French;
    };
}
