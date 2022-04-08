**Exercice 1 : pseudo code**

c = (xp, yp)

xp est le temps et yp les valeurs.

choix degrés poly : n

nombre de lignes : l = size(xp)

Création matrice vide de taille adaptée A = zeros(l,n) 

pour i allant de 1 à n+1 {

​	Remplissage de matrice A : A(: , n - i +1) = xp.^(i-1)

}

On effectue les calculs matriciels 



On ressort des calculs, un vecteur de taille n+1 contenant les coefficients du polynôme de meilleure approximation.



**Exercice 3**

Quelques tests intéressants :

![image-20220407145951732](C:\Users\julie\AppData\Roaming\Typora\typora-user-images\image-20220407145951732.png)

Pour n = 3, l'approximation est très mauvaise, nous devons augmenter encore le degré du polynôme.

![image-20220407145746049](C:\Users\julie\AppData\Roaming\Typora\typora-user-images\image-20220407145746049.png)

Pour un polynôme de degré 8, l'approximation n'est pas parfaite, mais Matlab n'a aucun mal à la faire.

![image-20220407145847903](C:\Users\julie\AppData\Roaming\Typora\typora-user-images\image-20220407145847903.png)

Pour n = 10, l'approximation est bien meilleure, mais Matlab a déjà plus de mal à faire les calculs (bien qu'il y arrive tout de même)

