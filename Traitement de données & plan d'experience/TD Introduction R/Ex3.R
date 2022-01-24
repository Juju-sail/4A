#Vecteurs

#créons des vecteurs de plusieurs modes
vecteur1 <- c(5,6,1,4,5)
vecteur2 <- c('bleu', 'vert', 'jaune')
vecteur3 <- c(T,T,F,T,F,F)

#connaitre le mode d'un vecteur
mode(vecteur1)
mode(vecteur2)
mode(vecteur3)

#trouvons la taille de ces 3 vecteurs
l1 = length(vecteur1)
l2 <- length(vecteur2)
l3 = length(vecteur3)

#pour verrifier le mode des objets d'un element
is.vector(vecteur1)
is.vector(suite1)

#afficher le deuxième element du vecteur1
vecteur1[2]

#afficher les element 2 à 4 du vecteur1
vecteur1[2:4]

# operations entre vecteurs
x<- c(2,3,6,10,12)
y<- c(1,6,7,2,1)
z<- x+y
a <- 2*x+5
b <- (x+y)/2

# extraire les element 2 et 4 du vecteur x
xx <- x[c(2,4)]

# creer un vecteur comme x avec les element 2 et 4 en moins
new_x <- x[-c(2,4)]

#creer un vecteur avec uniquement les elements superieurs à 4 de y
yy <- y[y>4]

#modifier un element d'un vecteur
x[3]<- 35
y[y==1] <- 25
x[x>=5] <- 20

#repetitions de vecteurs
donnees <- c(1,2,3)
rep(x = donnees, times = 2)
rep(1,50)
vect <- rep('POLYTECH',5)

#Sans commentaire.... ah bah si.
notes <- c(Anglais=12, Informatique=19, Maths=8)
notes
matieres <- c('Anglais', 'Informatique', 'Maths')
evaluation <- c(12,19,8)
names(evaluation)<- matieres
evaluation