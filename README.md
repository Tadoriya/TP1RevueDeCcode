# AwesomePasswordChecker

**AwesomePasswordChecker** est une application Java qui fournit des outils pour :

- Évaluer la force des mots de passe en calculant leur distance par rapport à des centres de clusters prédéfinis.
- Générer un hash MD5 pour un mot de passe donné.

Ce projet est conçu pour analyser des mots de passe en utilisant une logique de clustering pour les catégoriser et les évaluer.

---

## Fonctionnalités principales

- **Chargement des centres de clusters** : Les centres de clusters sont chargés à partir d'un fichier CSV pour analyser les mots de passe.
- **Masquage des caractères** : Les mots de passe sont transformés en masques basés sur leurs caractères.
- **Calcul de distance euclidienne** : La distance entre le masque d’un mot de passe et les centres de clusters est calculée.
- **Hashage MD5** : Génération d'un hash MD5 pour sécuriser les mots de passe.

---

## Structure du projet

- **Code principal** : `src/main/java/org/Taha/AwesomePasswordChecker.java`
- **Fichier de centres de clusters** : `src/main/ressources/cluster_centers_HAC_aff.csv`

---

## Installation et exécution

### Prérequis

- **Java** : JDK.
- **Maven** : Pour gérer les dépendances et construire le projet.

### Étape 1 : Cloner le dépôt

```bash
git clone https://github.com/Tadoriya/TP1RevueDeCcode
cd TP1RevueDeCcode
git branch -r
git fetch origin master
git checkout master
```


## Étape 2 : Compilation et exécution

### Compiler le projet avec Maven :

`mvn clean compile`

### Exécuter l'application :

1. Allez dans le répertoire source :
   
   `cd src/main/java/org/Taha/`
   
2. Compilez le fichier Java :
   
   `javac AwesomePasswordChecker.java`

3. Exécutez l'application :
   
   `java AwesomePasswordChecker.java`

---

## Utilisation

Lors de l'exécution, l'application vous demande de saisir un mot de passe :

`Enter a password:`

L'application :

1. Calcule la distance minimale entre le masque du mot de passe et les centres de clusters.
2. Génère le hash MD5 du mot de passe.
3. Affiche les résultats :

Exemple:
`password:"Tadoriya3"`
`distance:4.688994465931258`
`MD5 Hash: 2f93e7e3526a9fab0cc40c724175bddf`

## Auteur
Taha AIT AHMED OUAAL
Contact: tahaaitahmedouaal@gmail.com

