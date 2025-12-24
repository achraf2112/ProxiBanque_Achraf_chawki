# ProxiBanque - Application Bancaire

Application bancaire développée avec **Spring Boot** et une **architecture hexagonale** (Ports & Adapters).

## 📋 Description

ProxiBanque est une application de gestion bancaire permettant de :
- Gérer les clients et leurs comptes bancaires
- Créer des comptes courants et épargne
- Effectuer des virements entre comptes
- Gérer les cartes bancaires
- Assigner des clients aux conseillers
- Auditer les agences

Architecture Hexagonale
```
src/main/java/org/example/proxibanque_achraf_chawki/
│
├── domain/                          # Cœur métier ( aucun relation avec le framework spring)
│   ├── model/                       # Entités métier (POJOs c'est à dire des objets 100% java)
│   ├── port/
│   │   ├── in/                      # Interfaces UseCases
│   │   └── out/                     # Interfaces RepositoryPorts
│   └── service/                     # Implémentations des UseCases
│
├── application/                     # Couche applicative
│   └── dto/                         # Objets de transfert ( également c'est un dessign pattern de type structurelle)
│
└── infrastructure/                  # Adapters externes
    ├── adapter/
    │   ├── in/web/                  # Controllers REST
    │   └── out/persistence/         # JPA Entities, Repositories, Adapters
    ├── mapper/                      # Mappers MapStruct ( framework de mapping dto vers entity et le contraire)
    └── config/                      # là on peut ajouter des config (comme le cas de spring security)
