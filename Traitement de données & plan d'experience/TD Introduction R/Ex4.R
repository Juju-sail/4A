#Matrices

mat1<- matrix(1:12,ncol=3)
mat1
mat2<- matrix(1:12, ncol=3, byrow=TRUE)
mat2

length(mat1)
dim(mat1)

mat1[2,3]
mat1[2,]
mat1[,3]
mat1[,3,drop=F]

nrow(mat2)
ncol(mat2)
rbind(mat2,c(13:15))
mat1 <- cbind(mat1,c(13:16))

mat3<-matrix(1:4,ncol=2)
solve(mat3)
mat3
v=eigen(mat3)
v$values
v$vectors
v


