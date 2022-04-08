clc;
clear;
close;

data = load("donnees.mat");

disp("On choisi un polynome de degré : ")
n = 8

disp("Les coefs du polynome obtenu sont :")
c = MoindresCarres(data.tps,data.sortie,n)

N = 100; %Nombre de points pour tracé courbe
t = zeros(1,N);

%for i = 0:N
%   t(i+1) = i*0.5/N;
%end
t = 0 : 0.5/N : 0.5;
P = polyval(c,t);

figure
plot(t,P,data.tps, data.sortie, "*")


function [coeff] = MoindresCarres(xp,yp,n)
    l = size(xp,2);
    A = zeros(l,n);
    for i = 1:(n+1)
        A(:,n-i+2) = xp.^(i-1);
    end
    
    a = A.' * A;
    b = A.' * yp.';
    coeff = a\b;
end

