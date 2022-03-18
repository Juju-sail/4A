clear all
z1 = [0.8 -0.8 1 -1 1.2 -1.2];


y = zeros(20,1);

for i = z1
    for k = 1:100
        f(k) = i^k;
        
    end
    figure
    plot(1:100,f)
end