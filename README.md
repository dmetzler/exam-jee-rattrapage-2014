# Examen de rattrapage JEE 01/09/2014

Cet examen est en deux parties qui peuvent être traitées indépendament l'une de l'autre. 

## Modalités de rendu : 1 point

Pour rendre votre travail, vous devrez :

 * Implémenter les différentes méthodes demandées
 * Modifier dans le fichier `pom.xml` le nom de l'artifactId sous la forme suivante :
 
 		<artifactId>exam-rattrapage-NOM-PRENOM</artifactid>
 		
 	Remplacer les espaces et tout caractère non alphanumérique dans le nom et prénom par un `-`. Par exemple : `Gérard D'Orimont de Haute Cloque` donnera :
 	
	 	<artifactId>exam-rattrapage-D-ORIMONT-DE-HAUTE-CLOQUE-GERARD</artifactid>
	 	
 * Zipper le répertoire de travail sans le répertoire `target` et renommer le fichier :
 		
 		exam-rattrapage-2014-NOM-PRENOM.zip
 
 * Envoyer le fichier zip à `dmetzler@gmail.com` avec comme sujet Exam rattrapage 2014 : Nom Prénom
 
 

## Première partie : TDD sur 10 points

Dans cette première partie, on développera une librairie permettant de compter les points d'un jeu d'une manche de tennis. Vous devrez implémenter les tests proposés pour ensuite implémenter la librairie elle même.

### Règle du tennis

Dans un jeu de tennis, un joueur démarre avec le socre de 0. A chaque fois qu'il marque, il remporte plus de point suivant la séquence suivante : 0 -> 15 -> 30 -> 40

Si un joueur a 40 points et qu'il remporte le point, il gagne le jeu si l'autre joueur n'a pas aussi 40 points. Si les deux joueurs ont 40 points, les joueurs sont à égalité.

Quand un joueur marque alors qu'il est à égalité, on dit qu'il prend l'avantage. Si il marque une seconde fois, il remporte le jeu, si il perd alors on retourne à égalité. 

Suivant les différents cas, le score devra s'afficher comme suite :

 * 0 partout
 * 30-15
 * Egalité
 * Avantage NomDuJoueur
 * NomDuJoueur gagne le jeu

### Tests

Vous disposez dans le projet Maven de trois classes :

 * `TennisGame` : le contrat que doit suivre un jeu de tennis
 * `TennisGameImpl` : l'implémentation
 * `TennisGameTest` : la classe de test contenant des méthodes de test vide. 
	
En prenant un test à la fois, implémenter le corps de celui-ci en fonction de la description contenue dans la javadoc. 

Compléter ensuite TennisGameImpl pour que le test passe, puis passer au test suivant.


## Deuxième partie : Servlet sur 10 points

A l'aide d'une servlet, on exposera la librairie précédente pour pouvoir afficher le score d'un jeu ainsi qu'enregistrer les points des joueurs.

Pour cet exercice vous disposez de deux classes :

 * `TennisScoreServlet` : la classe qui doit être une servlet et répondre à l'URL `/score`
 * `TennisServletTest`: une classe de test déjà remplie qui doit vous aider à valider votre servlet. 

Suivre les instructions présentes dans la Javadoc de chaque test.
 
 
Dans le cas où vous ne seriez pas arrivés à implémenter la classe `TennisGameImpl` dans la partie 1, vous disposez de la classe `ObfuscatedTennisGameImpl` que vous pouvez utiliser à la place. Comme son nom l'indique, il ne sert à rien d'essayer de comprendre le code de celle-ci, ni même d'espérer pouvoir vous en inspirer pour la première partie.
 
### Indices

On utilisera le mécanisme de la session web (`HttpRequest#getSession()`) dans lequel on pourra stocker l'état courant du jeu (`setAttribute()`et `getAttribute()`). Par exemple : 

	TennisGame game = (TennisGame) req.getSession().getAttribute("game");
	


Pour tester votre servlet, vous pouvez bien sûr utiliser les tests, mais vous pouvez aussi lancer l'application à l'aide de Maven en lançant la commande :

	mvn jetty:run
	
Cela lance un serveur d'application avec une page web utilisant la servlet à l'adresse [http://127.0.0.1:8080/#/](). Attention cependant, seul la validation de chaque test permet de ramener des points. 

 
 

