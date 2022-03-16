clc;
clear;
%% Attention, ce script ne fonctionne qu'avec des problèmes de même taille%%
A = [3 9 ; 4 5 ; 2 1 ]
C = [6 4]
B = [81 55 20]

N = [3 4 5];
H = [1 2];
I3 = eye(size(A,1));
LN = [0 0 0];

tab = [N H 0; %Première ligne du tableau : nos variables (N H et vide)
    I3 A transpose(B); % AN (ici I3) AH et B pour le deuxième Bloc
    LN C 0] % LN LH et -F (ici nulle)

%% Preparation fonction :
% Choix variable entrante : 
%On prend le max de LH
LH = C; 
[max , indexMax] = max(LH);
%Et on recuperer le num de la variable associée
indexMax = indexMax + size(A,1);
% Variable entrante :
e = tab(1, indexMax)

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
valPivot = tab(indexMax,indexMin);
%Trouvons la variable associée (et donc sortante)
[x,index1] = find(I3((indexMin - 1),:));

s = tab(1, index1)


