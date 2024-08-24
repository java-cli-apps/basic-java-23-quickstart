///usr/bin/env java --enable-preview --class-path ${APP_DIR}/lib/'*' "$0" "$@"; exit $?

void main() {
    var response = readln("Do you speak English (Y/N) ? ");
    var language = Language.fromString(response);
    println(language.getGreeting());
}
