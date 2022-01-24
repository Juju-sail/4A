tk = [0:0.1:0.9]';

% vecteur de sortie
y = [0.2 0.21 0.23 0.26 0.28 0.32 0.35 0.4 0.44 0.49]';

% mat regression
phi = [1/2*tk.^2 tk ones(length(y),1)]

% vecteur de paramètres
theta = inv(phi'*phi)*phi'*y

% calcul sortie avec theta estimé
ybis = phi * theta

% erreur entre mesures et estimation
residus = y-ybis
moyenneRes = mean(residus);
varianceRes = sqrt(std(residus));