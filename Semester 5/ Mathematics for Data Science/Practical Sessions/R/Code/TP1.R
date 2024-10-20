library(questionr)

data(hdv2003)
d<-hdv2003

View(d)

#TP1

table(d$sexe)
table(d$occup)
sort(table(d$occup))
sort(table(d$occup),decreasing = TRUE)
table(d$trav.satisf, useNA = "ifany")

summary(d$qualif)
prop.table(table(d$qualif))
prop.table(table(d$qualif, useNA = "ifany"))
freq(d$qualif)

table(d$freres.soeurs)
prop.table(table(d$freres.soeurs))
freq(d$freres.soeurs, cum = TRUE, total = TRUE, digits = 2, exclude = NA)
summary(d$freres.soeurs)

d$age.class<-cut(d$age, breaks = 5)
d$age.class<-cut(d$age, c(18, 20, 40, 60, 80, 97),include.lowest = TRUE, labels = c("<20ans","21-40ans","41-60ans","61-80ans","80ans"))
icut() 
## Cutting d$age into d$age_rec
d$age_rec <- cut(d$age, include.lowest = TRUE, right = FALSE, dig.lab = 4, breaks = 5)
freq(d$age.class, cum = TRUE, total = TRUE, digits = 2, exclude = NA)

pie(table(d$sexe))
pie(table(d$sexe), col = c("brown", "blue"))
pie(table(d$sexe), col = c("brown"),density = c(NA, 50, 30))
pie(table(d$occup), main = "Occupation", ylab="Effectif")
?pie

plot(table(d$freres.soeurs))
plot(table(d$freres.soeurs), main = "Nombre de FS")
plot(table(d$freres.soeurs), main = "Nombre de FS", ylab = "Effectif")
plot(table(d$freres.soeurs), type = "l") #p,n,h,o ...
plot(table(d$freres.soeurs), col = "Blue")
?plot

hist(d$heures.tv, main = "Nombre d'heures passées devant la télé", xlab = "Heures", ylab = "Effectif")


