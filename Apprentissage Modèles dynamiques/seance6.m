tk = [0:15]';

% vecteur de sortie
y = [0 1.34 2.05 2.43 2.82 2.90 2.98 2.91 3.02 2.93 2.94 1.59 0.85 0.4 0.27 0.13]';

% mat regression


% vecteur de paramètres
theta = inv([a1 b0])

% calcul sortie avec theta estimé
ybis = phi * theta

% erreur entre mesures et estimation
residus = y-ybis
moyenneRes = mean(residus);
varianceRes = sqrt(std(residus));