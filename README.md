# 🎮 Tic-Tac-Toe Java (MVC & MySQL)

Ce projet est une implémentation complète du célèbre jeu Tic-Tac-Toe (Morpion) développée en Java. Il propose une interface graphique interactive, deux modes de jeu, et un système de sauvegarde des scores via une base de données MySQL.

## 🎯 Fonctionnalités Principales

* **Mode Multijoueur (PvP) :** Deux joueurs s'affrontent sur le même écran.
* **Mode Solo (PvE) :** Jouez contre une Intelligence Artificielle (choix de cases aléatoires).
* **Architecture MVC :** Séparation stricte du Modèle, de la Vue et du Contrôleur pour un code propre et maintenable.
* **Persistance des Données :** Enregistrement automatique des victoires dans une base de données avec système anti-doublon.
* **Interface Graphique :** Menu de sélection et grille de jeu développés avec Java Swing.

## 🛠️ Technologies Utilisées

* **Langage :** Java SE 21
* **Interface Graphique :** Java Swing / AWT
* **Base de Données :** MySQL Server & MySQL Workbench
* **Connectivité :** API JDBC (mysql-connector-j-9.7.0.jar)
* **IDE Recommandé :** Eclipse IDE

## 🚀 Installation et Configuration

Pour exécuter ce projet en local sur votre machine, suivez ces étapes :

### 1. Cloner le projet
Téléchargez le code source ou clonez le dépôt via le terminal :
`git clone https://github.com/VOTRE-LIEN/Tic-Tac-Toe.git`

### 2. Configuration de la Base de Données
1. Ouvrez MySQL Workbench.
2. Exécutez le script SQL fourni (`tictactoe_db.sql`) pour créer la base `tictactoe_db` et la table `scores`.

### 3. Configuration dans Eclipse
1. Importez le dossier du projet dans votre Workspace Eclipse.
2. Ajoutez le fichier `.jar` du pilote JDBC : 
   * Clic droit sur le projet > `Build Path` > `Configure Build Path...`
   * Onglet `Libraries` > `Classpath` > `Add JARs...`
   * Sélectionnez `mysql-connector-j-9.7.0.jar` situé dans le dossier `lib/`.
3. Ouvrez le fichier `ScoreDAO.java` (dans le package `modele`) et modifiez la variable `MOT_DE_PASSE` (ligne 12) pour qu'elle corresponde à votre serveur MySQL local.

## 🎮 Comment Jouer ?

* Naviguez vers le package `vue` dans Eclipse.
* Faites un clic droit sur `FenetreMenu.java` > `Run As` > `Java Application`.
* Choisissez votre mode de jeu et amusez-vous !

## 👨‍💻 Auteurs

* **Akram Asklou** * **Oussama EDDAJJANY** Projet réalisé dans le cadre du module de programmation orientée objet.
