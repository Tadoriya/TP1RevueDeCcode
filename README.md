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
