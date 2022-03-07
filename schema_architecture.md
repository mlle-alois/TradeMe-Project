# Justification des choix d'architecture

* Décideurs: Milutin Stanojevic, Ichaï Ctitski, Aloïs Zimmermann-Rosenthal
* Date: 07/03/2022

## Contexte et énoncé du problème

Dans le cadre de l'application Trade Me pour le projet d'architecture des Logiciels des 4ème années
nous voulons connaitre la justification des différents choix d'architecture pour répondre au besoin du projet.

## Facteurs de décision

* Indépendance des cas d'utilisation présentés par le sujet
* {driver 2, e.g., a force, facing concern, …}

## Options envisagées

* 1 seul module et division en packages par cas d'utilisation
* 1 module par cas d'utilisation
* Répartition en Bounded Context

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

### 1 seul module et division en packages par cas d'utilisation

{example | description | pointer to more information | …} <!-- optional -->

* Good, because {argument a}
* Good, because {argument b}
* Bad, because {argument c}
* … <!-- numbers of pros and cons can vary -->

### 1 module par cas d'utilisation

{example | description | pointer to more information | …} <!-- optional -->

* Good, because {argument a}
* Good, because {argument b}
* Bad, because {argument c}
* … <!-- numbers of pros and cons can vary -->

### Répartition en Bounded Context

{example | description | pointer to more information | …} <!-- optional -->

* Good, because {argument a}
* Good, because {argument b}
* Bad, because {argument c}
* … <!-- numbers of pros and cons can vary -->

## Liens

* {Link type} {Link to ADR} <!-- example: Refined by [ADR-0005](0005-example.md) -->
* … <!-- numbers of links can vary -->
