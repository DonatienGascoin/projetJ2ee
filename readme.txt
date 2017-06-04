Noms :

- Justine Bodet-Villard
- Donatien Gascoin
- Romain Chazottier

Video:
https://youtu.be/XI8VuAeX55M

Base de données:
•	Sur les postes de CPE: binome36 (voir le fichier Dao.java pour modifier la conf)

Commentaires :

- Premières pages OK : Splash Screen + Menu principal

- Template :
•	Header séparé en deux :
•	Zone activité (titre) + zone fond regroupé et prise en charge par les composites (selon l'activité)
•	Zone label inscription + connexion dans le template
•	 Footer OK

- Ajout d'un template pour la gestion des pages administrateurs (qui reprend le template initial)
•	Vérification automatique de l'utilisateur


La partie sur les commentaires n'as pas été abordée.



- Page inscription :
•	Formulaire OK + création d'un validateur par champ
•	Validateurs : Un par champ en vérifiant les différents pattern. Pour la confirmation du mot de passe, récupération dans le même validateur des 2 valeurs et comparaison
•	Ajout BDD :

- Gestion User
•	Ajout/Suppression/Modification

- Module recherche recette
•	Recherche exacte, pas de recherche partiel

- Résultat recherche recette
•	Affichage sous forme de tableau avec possibilité de voir le détail

- Recherche recette détaillée
•	Pop-up sur la page recherche recette, l'utilisateur doit être connecté pour avoir accès au détail (pour donner une utilitée à l'enregistrement d'un utilisateur)

- Management recette
•	Pas d'ajout, seulement edition et suppression