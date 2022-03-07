# Justification des choix d'architecture

* Décideurs: Milutin Stanojevic, Ichaï Ctitski, Aloïs Zimmermann-Rosenthal
* Date: 07/03/2022

## Contexte et énoncé du problème

Dans le cadre de l'application Trade Me pour le projet d'architecture des Logiciels des 4ème années
nous voulons connaitre la justification des différents choix d'architecture pour répondre au besoin du projet.

### Résumé de notre architecture
* TradeMe-Project
  * AssignTradesman
    * general
      * application
      * domain
      * exposition
      * infrastructure
    * kernel
  * CreateProject
      * general
          * application
          * domain
          * exposition
          * infrastructure
      * kernel
  * EducationCertificate
      * general
          * application
          * domain
          * exposition
          * infrastructure
      * kernel
  * EndProject
      * general
          * application
          * domain
          * exposition
          * infrastructure
      * kernel
  * Member
      * general
          * application
          * domain
          * exposition
          * infrastructure
      * kernel

## Options envisagées

* division en packages par cas d'utilisation
* 1 module par cas d'utilisation

## Résultat de la décision

Nous avons choisi l'option "1 module par cas d'utilisation", afin de garantir l'indépendance de chaque cas d'utilisation,
chaque module était autonome et une "mini application"

### Conséquences positives

* Indépendance de chaque cas d'utilisation
* Aucune donnée superflue dans les cas d'utilisation (classes servant spécifiquement pour ce cas)

### Conséquences négatives

* Doublon de code (ex : Kernel)
* Classes métiers non communs entre les modules
* Aucune communication entre les cas d'utilisation

## Avantages et inconvénients des options

### Division en packages par cas d'utilisation

* C'est un bon choix car :
    * cela permet de faire un package des classes communes
    * simple d'utilisation
    * s'orienter vers une architecture avec du Bounded Context
* C'est un mauvais choix car :
    * on peut facilement se parasiter avec les classes des autres packages
    * cela manque de d'indépendance entre les cas d'utilisation

### 1 module par cas d'utilisation

* C'est un bon choix car :
    * les cas d'utilisation sont indépendants à 100 %, comme des "minis applications"
    * simple d'utilisation
    * on ne garde que l'essentiel
* C'est un mauvais choix car :
    * il y a des doublons de code
    * pas de dossier partagé entre les cas d'utilisation
