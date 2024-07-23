///usr/bin/env java --source 23 --enable-preview --class-path ${APP_DIR}/lib/'*' "$0" "$@"; exit $?

void main() {
    var language = askLanguage();
    println(language.getGreeting());
}

private Language askLanguage() {
    var response = readln("Do you speak English (Y/N) ? ");
    return switch (response) {
        case String s when (s == null || s.isEmpty()) -> {
            throw new IllegalArgumentException("No response was provided !");
        }
        case String s when s.equals("Y") -> Language.English;
        default -> Language.French;
    };
}
