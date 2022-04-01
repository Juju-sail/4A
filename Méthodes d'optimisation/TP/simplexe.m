%% Attention, ce script ne fonctionne qu'avec des problèmes de même taille (problème plan)%%
clc;
clear;
%% Passer de la forme standard à un tableau pour étape 1 de la méthode :
%A = [3 9 ; 4 5 ; 2 1 ];
%A = [2 3 ; 4 2];
%A = [2 1 ; 1 2 ; 0 1];
A = [2 3 ; 4 2];
%C = [6 4];
%C = [20 25];
%C = [4 5];
C = [20 25];
%B = [81 55 20];
%B = [40 48];
%B = [800 700 300];
B = [40 48];
tab = fromSTRDtoMAT(A,B,C);

%% Appel de la méthode des tableaux
disp("Matrice de départ : ")
matrice = tab
iter = 0;
[x,y] = size(matrice);

while matrice(x,y-2)>0||matrice(x,y-1)>0
    [matrice, Fmax] = methodesTableaux(matrice);
    iter = iter +1;
end

disp("Valeur fonction objectif : "+abs(Fmax))
disp("Nombre d'étapes à la méthode des tableaux : " + iter)
disp("Variables hors base : x"+matrice(1,y-2)+" & x"+matrice(1,y-1))
disp(' ')
disp("Matrice finale : ")
matrice

%% Fonctions propre :
function [tab] = fromSTRDtoMAT(A,B,C)
    N =(size(C,2)+1:1:size(C,2)+size(B,2));%N = [3 4 5];
    H = (1:1:size(C,2));%H = [1 2];
    I3 = eye(size(A,1));
    LN = zeros(1,size(B,2));%LN = [0 0 0];

    tab = [N H 0; %Première ligne du tableau : nos variables (N H et vide)
    I3 A transpose(B); % AN (ici I3) AH et B pour le deuxième Bloc
    LN C 0]; % LN LH et -F (ici nulle)
end

function [Xopt, ValFoncObjectif] = methodesTableaux(mat)
    %On prend le max de LH
    [x, y] = size(mat);
    LH = [mat(x,y-2) mat(x,y-1)]; %valable uniquement si on travaille avec deux variables hors base
    [maxi , indexMax] = max(LH);
    %Et on recuperer le num de la variable associée
    indexMax = indexMax + y - 3; %valable uniquement si on travaille avec deux variables hors base
    % On en deduis notre variable entrante :
    e = mat(1, indexMax);

    %On fait nos rapports et on garde le plus petit
    min = Inf;
    for i = 2:(y-2) %valable uniquement si on travaille avec deux variables hors base
        tempo = mat(i,y)/mat(i,indexMax);
        if min>tempo && mat(i,indexMax)>0 % La deuxième partie du if permet de ne pas prendre un pivot negatif
            min = tempo;
            indexMin = i;
        end
    end
    % Le plus petit rapport est :
    min;
    % il nous permet d'avoir notre pivot
    coordPivot = [indexMax indexMin]
    valPivot = mat(indexMin,indexMax);
    %Trouvons la variable associée (et donc sortante)
    I3 = eye(y-3);
    [a,indexa] = find(I3((indexMin - 1),:));
    s = mat(1, indexa);
    
    % Transformons nos lignes par rapport au pivot
    Xopt = zeros(x,y);
    Xopt(1,:) = mat(1,:);
    for i=2:indexMin-1
        Xopt(i,:) = mat(i,:) - (mat(i,indexMax)/valPivot)*mat(indexMin,:);
    end
    for i=indexMin+1:size(mat)
        Xopt(i,:) = mat(i,:) - (mat(i,indexMax)/valPivot)*mat(indexMin,:);
    end
    Xopt(indexMin,:) = mat(indexMin,:)/valPivot;
    
    % Remettons la matrice à l'endroit (Identité en premier)
    tempo = Xopt(:,indexMax);
    Xopt(:,indexMax) = Xopt(:,indexa);
    Xopt(:,indexa) = tempo;

    % extraire la valeur de F :

    ValFoncObjectif = Xopt(x,y);
end