AwesomePasswordChecker
AwesomePasswordChecker est une application Java qui fournit des outils pour :

Évaluer la force des mots de passe en calculant leur distance par rapport à des centres de clusters prédéfinis.
Générer un hash MD5 pour un mot de passe donné.
Ce projet est conçu pour analyser des mots de passe en utilisant une logique de clustering pour les catégoriser et les évaluer.

Fonctionnalités principales
Chargement des centres de clusters :
Les centres de clusters sont chargés à partir d'un fichier CSV pour analyser les mots de passe.
Masquage des caractères :
Les mots de passe sont transformés en masques basés sur leurs caractères.
Calcul de distance euclidienne :
La distance entre le masque d’un mot de passe et les centres de clusters est calculée.
Hashage MD5 :
Génération d'un hash MD5 pour sécuriser les mots de passe.
Structure du projet
src/main/java/org/Taha/AwesomePasswordChecker.java : Le fichier principal contenant la logique de traitement.
src/main/ressources/cluster_centers_HAC_aff.csv : Le fichier contenant les centres de clusters nécessaires à l'analyse.
Installation et exécution
Prérequis
Java : JDK.
Maven : Pour gérer les dépendances et construire le projet.
Étape 1 : Cloner le dépôt
bash
Copier le code
git clone https://github.com/Tadoriya/TP1RevueDeCcode
cd TP1RevueDeCcode
git branch -r
git checkout master
git fetch origin master
git checkout master
Étape 2 : Compilation et exécution
Compiler le projet avec Maven :

bash
Copier le code
mvn clean compile
Exécuter l'application :

bash
Copier le code
cd src/main/java/org/Taha/
javac AwesomePasswordChecker.java
java AwesomePasswordChecker.java
Utilisation
Lors de l'exécution, l'application vous demande de saisir un mot de passe :

text
Copier le code
Enter a password: 
L'application :

Calcule la distance minimale entre le masque du mot de passe et les centres de clusters.
Génère le hash MD5 du mot de passe.
Affiche les résultats :
text
Tadoriya3
Distance: 4.688994465931258
MD5 Hash: 2f93e7e3526a9fab0cc40c724175bddf
Configuration
Fichier de clusters : Le fichier CSV cluster_centers_HAC_aff.csv doit contenir les centres des clusters sous forme de lignes de valeurs séparées par des virgules (e.g., 1.0,2.0,3.0,...). Placez ce fichier dans :
src/main/ressources/cluster_centers_HAC_aff.csv.

Changer le chemin d'accès au fichier : Si le fichier est situé ailleurs, mettez à jour le chemin dans le code :

java
Copier le code
File file = new File("chemin/vers/votre/cluster_centers_HAC_aff.csv");
Tests
Tester avec Maven :
Pour exécuter les tests unitaires  :

bash
Copier le code
mvn test

Soumettez vos changements via une pull request.
Auteur
Taha
Contact : tahaaitahmedouaal@gmail.com

