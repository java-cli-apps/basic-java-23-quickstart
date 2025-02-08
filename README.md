# Un template d'Application en Ligne de Commande (CLI) avec Java 23 et les JEP 458 et 477

Le template **basic-java-23-quickstart** permet de démarrer une nouvelle application en commande ligne avec Java sans
utiliser aucun système de build (autre que `make`).

Ce template nécessite d'utiliser Java 23 ou une version supérieure car il utilise les JEPs suivantes :

* La [JEP 458](https://openjdk.org/jeps/458) qui permet de lancer un programme Java dont le code est réparti dans
  plusieurs fichiers sources sans avoir besoin de les compiler préalablement
* La [JEP 477](https://openjdk.org/jeps/477) qui permet de :
  * Se passer de déclaration de classe
  * Simplifier la déclaration de la méthode `main`
  * Utiliser les méthodes de la classe `java.io.IO` sans devoir les importer

## Créer un dépôt depuis ce template

Pour créer un dépôt depuis ce template, on procédera comme suit :

<a href="https://asciinema.org/a/669372" target="_blank"><img src="https://asciinema.org/a/669372.svg" /></a>

## Construire votre application

Après avoir [créé le dépôt GitHub](https://github.com/new?template_name=basic-java-23-quickstart&template_owner=java-cli-apps)
de votre nouvelle application à partir de ce template, vous pouvez suivre les étapes suivantes pour construire votre application.

### Changer le nom de l'application

Pour changer le nom de l'application, initialement nommée _BasicQuickstart_, il faut modifier la variable `APP_NAME`
dans le terminal ou dans le fichier `.envrc`, comme suit :

```bash
$ export APP_NAME=MyCmdLine
```

### Lancer l'application localement

```bash
$ make test
```

```console
./bin/Application.sh
Do you speak English (Y/N) ? N
Bonjour 🇫🇷
```

### Construire le package de l'application

Le package de l'application comprend les sources ainsi que ses dépendances.

```bash
$ make package
```

```console
mkdir --parents build/MyCmdLine/src build/MyCmdLine/lib build/MyCmdLine/bin
cp --update --recursive src lib bin build/MyCmdLine
cd build/MyCmdLine \
	&& mv src/Application.java src/MyCmdLine.java \
	&& mv bin/Application.sh bin/MyCmdLine.sh
cd build \
	&& zip --quiet --recurse-paths MyCmdLine.zip MyCmdLine
```

#### Shell de lancement

Le script de lancement [Application.sh](bin/Application.sh), dont le rôle est de lancer le fichier
[Application.java](src/Application.java), est renommé lors de la construction du package en `MyCmdLine.sh`.

Cela permet d'ajouter plusieurs applications dans le `PATH` et donc d'invoquer directement `MyCmdLine.sh`.

### Installer l'application

```bash
$ DEST_DIR=/home/user make install
```

```console
unzip -q -d /home/user build/MyCmdLine.zip
```

### Lancer l'application installée

```bash
$ DEST_DIR=/home/user make test-install
```

```console
PATH=/home/user/MyCmdLine/bin:/usr/lib/jvm/jdk-23/bin:/home/fopy/.local/bin:... MyCmdLine.sh
Do you speak English (Y/N) ? N
Bonjour 🇫🇷
```

Il ne nous reste plus qu'à :

- Implémenter notre métier dans [Application.java](src/Application.java)
- Ajouter les fichiers qui déclarent les classes utilisées par `Application.java` dans le répertoire [src](src)
- Ajouter les jars de nos dépendances dans le répertoire [lib](lib)

## Autres templates

Si vous ne disposez pas de Java 23, vous pouvez utiliser le template [basic-java-quickstart](https://github.com/java-cli-apps/basic-java-quickstart)
qui ne requiert que la version 11 de Java. Il est alors nécessaire que tout le code Java réside dans le même fichier
comme décrit dans la [JEP 330](https://openjdk.org/jeps/330).
