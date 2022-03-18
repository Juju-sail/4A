clc;
clear;
%% Attention, ce script ne fonctionne qu'avec des problèmes de même taille%%
A = [3 9 ; 4 5 ; 2 1 ];
C = [6 4];
B = [81 55 20];

N = [3 4 5];
H = [1 2];
I3 = eye(size(A,1));
LN = [0 0 0];

tab = [N H 0; %Première ligne du tableau : nos variables (N H et vide)
    I3 A transpose(B); % AN (ici I3) AH et B pour le deuxième Bloc
    LN C 0] % LN LH et -F (ici nulle)
% tab = [3,4,1,5,2,0;
%     1,0,0,-1.5,7.5,51;
%     0,1,0,-2,3,15;
%     0,0,1,0.5,0.5,10;
%     0,0,0,-3,1,-60]

C = [-3,1];
%% Preparation fonction :
% Choix variable entrante : 
%On prend le max de LH
[x, y] = size(tab);
LH = C; %LH = [tab(x,y-2) tab(x,y-1)];
[max , indexMax] = max(LH);
%Et on recuperer le num de la variable associée
indexMax = indexMax + size(A,1); % indexMax = indexMax + y - 3;
% Variable entrante :
e = tab(1, indexMax);

% Choix variable sortante :
%On fait nos rapports et on garde le plus petit
min = Inf;
for i = 2:(size(A,1)+1)
    tempo = tab(i,6)/tab(i,indexMax);
    if min>tempo
        min = tempo;
        indexMin = i;
    end
end
% Le plus petit rapport est :
min;
% il nous permet d'avoir notre pivot
coordPivot = [indexMax indexMin];
valPivot = tab(indexMin,indexMax);
%Trouvons la variable associée (et donc sortante)
[a,indexa] = find(I3((indexMin - 1),:));

s = tab(1, indexa);

% Transformons nos lignes par rapport au pivot

Xxopt = zeros(x,y);
Xxopt(1,:) = tab(1,:);

for i=2:indexMin-1
    Xxopt(i,:) = tab(i,:) - (tab(i,indexMax)/valPivot)*tab(indexMin,:);
end

for i=indexMin+1:size(tab)
    Xxopt(i,:) = tab(i,:) - (tab(i, indexMax)/valPivot)*tab(indexMin,:);
end
Xxopt(indexMin,:) = tab(indexMin,:)/valPivot;

% extraire la valeur de F :
F = Xxopt(x,y);
% IL FAUT MAINTENANT REMETTRE LA MATRICE à L'ENDROIT !!!
tempo = Xxopt(:,indexMax);
Xxopt(:,indexMax) = Xxopt(:,indexa);
Xxopt(:,indexa) = tempo;


% Le tout à recommencer jusqu'a ce que les deux coefs de LH soient negatifs
% Il y aura également d'autres conditions d'arret à ajouter
%% Appel méthode propre
[TAB, FObj] = methodesTableaux(tab) % Le premier cycle passe bien
[TAB2, FObj2] = methodesTableaux(TAB) % Le deuxième cycle passe bien

% Il faudra ensuite mettre un while propre
%% Fonction propre :

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
        tempo = mat(i,6)/mat(i,indexMax);
        if min>tempo
            min = tempo;
            indexMin = i;
        end
    end
    % Le plus petit rapport est :
    min;
    % il nous permet d'avoir notre pivot
    coordPivot = [indexMax indexMin];
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