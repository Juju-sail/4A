# Working directory
setwd("~/_PolytechNancy/Cours/2i/4A/Traitement de données & plan d'experience/TD1")

# --------------------------------------
# Design the Experiments
# --------------------------------------

# Building the design
# Loaing the suited library
library(FrF2)
doe=pb(nruns = 16, randomize=FALSE, factor.names = list(A=c(5.5,11.5), B=c(3,5),C=c(1.5,5.5),D=c(0,2.5),E=c(5,11),F=c(1.5,2.5),G=c("thin","thick"))) # n=12 is explained by the PB formula
# only 8 factors to be tested: we keep the first 8 columns
doe=doe[,1:8]
# adding the names of factors
#names(doe)=c('A','B','C','D','E','F','G','H')
# checking:
doe


# Estimate the nb of replicates:
# library(daewr)
# rmin <- 2 # smallest number of replicates
# rmax <- 4 # largest number of replicates
# sigma <- 0.21
# alpha <- 0.05
# Delta <- 0.5 # the size of a practical difference in two marginal factor level means.
# nlev <- c(2,2,2,2,2,2)
# nreps <- c(rmin:rmax)
# power <- Fpower2(alpha, nlev, nreps, Delta, sigma)
# options(digits=5)
# # Results of the statistical power:
# power
# # Conclusion: we have to do it in triplicate

# # Randozing the DoE
# PBd=rbind(doe,doe,doe)
# PBd=PBd[,1:8]
# names(doe)=c('A','B','C','D','E','F','G','H')
# NoHelico=1:12
# NoHelico=rep(NoHelico,3)
# PBd=cbind(PBd,NoHelico)
# Designer=c('ME','TM','CE','EJ','EG','MC','BS','AA','BD','FT','QJ','SG','MD','MO','ED')
# Designer=rep(Designer,3)
# Designer=Designer[1:36]
# Designer=sample(Designer)
# PBd=cbind(PBd,Designer)

write.csv(doe,file="PBdesign4Helico_New.csv",row.names=TRUE)
#kable(PBd)

