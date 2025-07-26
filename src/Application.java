///usr/bin/env java --enable-preview --class-path ${APP_DIR:-.}/lib/'*' "$0" "$@"; exit $?

void main() {
    String languageAsString = readln("Quel langue parlez-vous / Which language do you speak (French / English) ?");
    Language language = Language.fromString(languageAsString);
    println(language.getGreeting());
}
