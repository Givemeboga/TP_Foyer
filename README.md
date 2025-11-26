# 🎉 Système de Gestion du Foyer Universitaire 🎓

Bienvenue dans l'application de gestion du foyer universitaire ! Cette application Spring Boot est conçue pour simplifier la gestion des foyers, blocs, chambres, étudiants et réservations. 🚀

## 🌟 Fonctionnalités

- **🏠 Gestion des Foyers** : Créez, modifiez et supprimez des foyers et gérez leurs blocs associés.
- **🏢 Gestion des Blocs** : Organisez vos blocs et assignez-leur des chambres.
    - 📌 **Assigner des chambres** (`Chambre`) à des blocs (`Bloc`).
    - ❌ **Supprimer l'affectation** des chambres des blocs.
- **🛏️ Réservations de Chambres** : Permettez aux étudiants de réserver des chambres facilement.
- **👩‍🎓 Gestion des Étudiants** : Gérez les informations des étudiants et leurs réservations.
- **🔄 Relations Bidirectionnelles** : Relations entre entités comme `One-to-Many`, `Many-to-Many`, etc.

## 🛠️ Technologies Utilisées

- **☕ Java** : Langage de programmation principal.
- **🌱 Spring Boot** : Framework pour construire l'application.
- **📦 Hibernate/JPA** : ORM pour l'interaction avec la base de données.
- **🔧 Maven** : Gestion des dépendances.
- **✨ Lombok** : Réduction du code répétitif.
- **💾 H2/MySQL** : Base de données (configurable dans `application.properties`).

## 🗂️ Structure du Projet

- 📁 `src/main/java/org/esprim/tpfoyer/entities` : Classes d'entités comme `Foyer`, `Bloc`, `Chambre`, `Etudiant` et `Reservation`.
- 📁 `src/main/java/org/esprim/tpfoyer/repositories` : Interfaces des repositories pour les opérations sur la base de données.
- 📁 `src/main/java/org/esprim/tpfoyer/services` : Classes de services pour la logique métier, comme `BlocServiceImpl`.
- 📁 `src/main/java/org/esprim/tpfoyer/controllers` : Contrôleurs REST pour gérer les requêtes HTTP.
- 📁 `src/main/java/org/esprim/tpfoyer` : Classe principale de l'application `TpFoyerApplication`.

## 🔑 Méthodes Clés

### 🏢 Gestion des Blocs
- **`affecterChambreABloc`** : Assigne une liste de chambres à un bloc.
- **`desaffecterFoyerDeUniversite`** : Supprime l'association entre un foyer et une université.

### 🛏️ Repository des Chambres
- **`findAllByNumChambreIn`** : Récupère une liste de chambres par leurs numéros.
- **`findNonReservedRoomsByUniversityAndType`** : Récupère les chambres non réservées par université et type.

### 🌐 Endpoints REST

#### Chambres
- **`POST /api/chambres`** : Crée une nouvelle chambre.
- **`PUT /api/chambres/{id}`** : Met à jour une chambre existante.
- **`DELETE /api/chambres/{id}`** : Supprime une chambre.
- **`GET /api/chambres/{id}`** : Récupère une chambre par son ID.
- **`GET /api/chambres`** : Récupère toutes les chambres.
- **`GET /api/chambres/bloc/{idBloc}/type`** : Récupère les chambres par bloc et type.
- **`GET /api/chambres/non-reserve`** : Récupère les chambres non réservées par université et type.

## 🚀 Comment Exécuter

1. **Cloner le Dépôt** :
   ```bash
   git clone https://github.com/Givemeboga/TP_Foyer.git
   cd TP_Foyer