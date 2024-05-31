# TD B3 : Développement application Android

## Introduction

L’objectif de ce TD est de vous familiariser avec le développement Android en utilisant Android Studio et Kotlin. Vous créerez une application pour afficher une liste de personnages de la série Rick and Morty via une API.

Date de remise : **Dimanche 23 juin 2024**

Remise : Code au format .zip ou lien vers Github (projet public).

## Partie I : Création et configuration du projet

- [x] Créez un nouveau projet Android Studio nommé RickAndMorty.
- [x] Utilisez le package name : fr.epsi.[nom].rickandmorty.
- [x] Sélectionnez une « Empty Views Activity », niveau d’API supportant 96% des utilisateurs, et Kotlin.
- [x] Lancez l’application sur un émulateur ou smartphone Android.
- [x] Analysez la structure du projet.

## Partie II : Création de la liste des personnages

- [x] Familiarisez-vous avec les vues (TextView, Button, EditText, ConstraintLayout...).
- [x] Renommez MainActivity en CharactersListActivity et son layout en activity_characters_list.
- [x] Créez un layout character_item pour un item de la liste avec une CardView et un texte pour le nom du personnage.
- [x] Créez une RecyclerView pour afficher la liste des personnages avec une liste statique.

## Partie III : Récupération des données

- [x] Étudiez l’API : https://rickandmortyapi.com/documentation/#character.
- [x] Créez le modèle de données pour le nom des personnages.
- [x] Ajoutez un package `network` et créez `RickAndMortyApiService`.
- [x] Instanciez Retrofit et ajoutez une route pour récupérer la liste des personnages.
- [x] Ajoutez un ViewModel `CharactersListViewModel` pour récupérer les données.
- [x] Mettez à jour votre activité pour afficher les noms des personnages.

## Partie IV : Gestion des erreurs

- [x] Affichez un message d’erreur en cas de problème de connexion ou si le serveur ne répond pas.
- [x] Simulez une erreur en coupant le wifi et relancez l’application.

## Partie V : Détails d’un personnage

- [x] Créez une activité `CharacterDetailsActivity` affichée au clic sur un personnage.
- [x] Affichez le nom, le statut, l’espèce, le genre, l’origine et la localisation du personnage.

## Partie VI : Affichage des images

- [x] Récupérez et affichez les images des personnages depuis l’API.
- [x] Utilisez ImageView et la librairie Coil : https://coil-kt.github.io/coil/
- [x] Ajoutez une ImageView dans `CharacterDetailsActivity` et dans chaque item de la liste.

## Partie VII : Gestion de la toolbar

- [x] Ajoutez une toolbar dans l’écran principal avec le nom de l’application.
- [x] Ajoutez une toolbar dans `CharacterDetailsActivity` avec le nom du personnage.
- [x] Ajoutez un bouton retour à la toolbar.

## Partie VIII : Style

- [ ] Ajoutez du style à votre application en utilisant les thèmes Android : https://developer.android.com/develop/ui/views/theming/themes?hl=fr
- [ ] Améliorez la disposition des éléments sur l’écran de détails du personnage.

## Bonus I : Gestion de la pagination

- [ ] Gérez la pagination en récupérant l’URL de la page suivante et en l’appelant lors du scroll en bas de la RecyclerView.

## Bonus II : Stockage des données en local

- [ ] Stockez les données sur une base de données locale avec Room : https://developer.android.com/training/data-storage/room?hl=fr

## Bonus III : Utilisation de Jetpack Compose

- [ ] Reproduisez votre application avec Jetpack Compose : https://developer.android.com/jetpack/compose?hl=fr