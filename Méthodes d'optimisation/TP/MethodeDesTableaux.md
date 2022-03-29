**Ma réalisation du script permettant une résolution d'un problème de maximisation via la méthode des tableaux : **
Aujourd'hui, il est capable de résoudre uniquement des problèmes plans.

Afin d'utiliser le script, commencez par définir A, B et C les trois matrices d'un problème de maximisation sous forme standard.

Le script fait appel à une première fonction qui transforme le problème (forme standard) en matrice. ![image-20220329175354395](C:\Users\julie\AppData\Roaming\Typora\typora-user-images\image-20220329175354395.png)Avant appeler réellement notre méthode des tableaux.![image-20220329175423661](C:\Users\julie\AppData\Roaming\Typora\typora-user-images\image-20220329175423661.png)

Vous l'avez surement remarqué, j'ai défini ligne 17 une matrice "tab" et j'ai ensuite appeler la méthode des tableaux avec une autre matrice. En effet, je préfère sécuriser la matrice de départ. De plus, x et y sont les dimensions de cette matrice.

Vous pouvez lancer le script. 

Portez votre attention sur le volet de commande :![image-20220329175728394](C:\Users\julie\AppData\Roaming\Typora\typora-user-images\image-20220329175728394.png)

Le script a bien résolu le problème.

_______________________________________________________________________________________________________________________________________________________

Si vous souhaitez plus d'informations sur le contenu de la fonction, je vous conseille de vous reportez au code qui est extrêmement commenté.

_________________________________________________________________________________

Pour créer ce script, j'y suis allé pas à pas en commençant par faire un script "dur", très statique basé sur mes exercices de TD. Par exemple pour créer ma matrice de départ, je rentrais N, H, I3, LN, A, B et C. C'est seulement une fois que mon script statique fonctionnait que j'ai cherché à l'optimiser, l'automatiser. Il conserve malheureusement une grosse faille : il ne peut résoudre uniquement des problèmes plans (soit avec deux variables hors base). J'ai déjà identifié les lignes à changer, mais n'ai pas réussi à finaliser l'optimisation.

________

