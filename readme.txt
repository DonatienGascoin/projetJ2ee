Noms :

- Justine Bodet-Villard
- Donatien Gascoin
- Romain Chazottier

Video:
https://youtu.be/XI8VuAeX55M

Base de donn�es:
�	Sur les postes de CPE: binome36 (voir le fichier Dao.java pour modifier la conf)

Commentaires :

- Premi�res pages OK : Splash Screen + Menu principal

- Template :
�	Header s�par� en deux :
�	Zone activit� (titre) + zone fond regroup� et prise en charge par les composites (selon l'activit�)
�	Zone label inscription + connexion dans le template
�	 Footer OK

- Ajout d'un template pour la gestion des pages administrateurs (qui reprend le template initial)
�	V�rification automatique de l'utilisateur


La partie sur les commentaires n'as pas �t� abord�e.



- Page inscription :
�	Formulaire OK + cr�ation d'un validateur par champ
�	Validateurs : Un par champ en v�rifiant les diff�rents pattern. Pour la confirmation du mot de passe, r�cup�ration dans le m�me validateur des 2 valeurs et comparaison
�	Ajout BDD :

- Gestion User
�	Ajout/Suppression/Modification

- Module recherche recette
�	Recherche exacte, pas de recherche partiel

- R�sultat recherche recette
�	Affichage sous forme de tableau avec possibilit� de voir le d�tail

- Recherche recette d�taill�e
�	Pop-up sur la page recherche recette, l'utilisateur doit �tre connect� pour avoir acc�s au d�tail (pour donner une utilit�e � l'enregistrement d'un utilisateur)

- Management recette
�	Pas d'ajout, seulement edition et suppression