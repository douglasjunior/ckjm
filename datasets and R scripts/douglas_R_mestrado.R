#d1 <- read.csv('CSipSimple-class.csv', sep=';')
#d1 <- read.csv('CSipSimple-pkg.csv', sep=';')

setwd("C:/Users/Douglas/OneDrive/Mestrado Douglas/Topicos Engenharia de Software/Projeto Android/arquivos") 

#install.packages("vioplot")
library("vioplot")

#"C:\Temp\osmand-ckjm-results-pkg.csv"
#"C:\Temp\mytracks-ckjm-results-pkg.csv"
#"C:\Temp\softkeyboard-ckjm-results-pkg.csv"
#"C:\Temp\sipdroid-ckjm-results-pkg.csv"
#"C:\Temp\zxing-ckjm-results-pkg.csv"
#"C:\Temp\WiFiTether-ckjm-results-pkg.csv"
#"C:\Temp\CSipSimple-results-pkg.csv"
#"C:\Temp\k9-ckjm-results-pkg.csv"

osmand <- read.csv('osmand-ckjm-results-pkg.csv', sep=';')
mytracks <- read.csv('mytracks-ckjm-results-pkg.csv', sep=';')
softkeyboard <- read.csv('softkeyboard-ckjm-results-pkg.csv', sep=';')
sipdroid <- read.csv('sipdroid-ckjm-results-pkg.csv', sep=';')
WiFiTether <- read.csv('WiFiTether-ckjm-results-pkg.csv', sep=';')
zxing <- read.csv('zxing-ckjm-results-pkg.csv', sep=';')
CSipSimple <- read.csv('CSipSimple-results-pkg.csv', sep=';')
k9 <- read.csv('k9-ckjm-results-pkg.csv', sep=';')

#Vioplot WMC
vioplot(osmand$WMC, mytracks$WMC, softkeyboard$WMC, sipdroid$WMC, WiFiTether$WMC, zxing$WMC, CSipSimple$WMC, k9$WMC, 
        names=c("osmand", "mytracks", "softkeyboard", "sipdroid", "WiFiTether", "zxing", "CSipSimple", "k9"), 
        col="gold")
title("WMC per project")

boxplot(osmand$WMC, mytracks$WMC, softkeyboard$WMC, sipdroid$WMC, WiFiTether$WMC, zxing$WMC, CSipSimple$WMC, k9$WMC, 
        names=c("osmand", "mytracks", "softkeyboard", "sipdroid", "WiFiTether", "zxing", "CSipSimple", "k9"), 
        col="gold")
title("WMC per project")

#Vioplot DIT
vioplot(osmand$DIT, mytracks$DIT, softkeyboard$DIT, sipdroid$DIT, WiFiTether$DIT, zxing$DIT, CSipSimple$DIT, k9$DIT, 
        names=c("osmand", "mytracks", "softkeyboard", "sipdroid", "WiFiTether", "zxing", "CSipSimple", "k9"), 
        col="gold")
title("DIT per project")

boxplot(osmand$DIT, mytracks$DIT, softkeyboard$DIT, sipdroid$DIT, WiFiTether$DIT, zxing$DIT, CSipSimple$DIT, k9$DIT, 
        names=c("osmand", "mytracks", "softkeyboard", "sipdroid", "WiFiTether", "zxing", "CSipSimple", "k9"), 
        col="gold")
title("DIT per project")

#Vioplot CBO
vioplot(osmand$CBO, mytracks$CBO, softkeyboard$CBO, sipdroid$CBO, WiFiTether$CBO, zxing$CBO, CSipSimple$CBO, k9$CBO, 
        names=c("osmand", "mytracks", "softkeyboard", "sipdroid", "WiFiTether", "zxing", "CSipSimple", "k9"), 
        col="gold")
title("CBO per project")

boxplot(osmand$CBO, mytracks$CBO, softkeyboard$CBO, sipdroid$CBO, WiFiTether$CBO, zxing$CBO, CSipSimple$CBO, k9$CBO,  
        names=c("osmand", "mytracks", "softkeyboard", "sipdroid", "WiFiTether", "zxing", "CSipSimple", "k9"), 
        col="gold")
title("CBO per project")

#Vioplot RFC
vioplot(osmand$RFC, mytracks$RFC, softkeyboard$RFC, sipdroid$RFC, WiFiTether$RFC, zxing$RFC, CSipSimple$RFC, k9$RFC, 
        names=c("osmand", "mytracks", "softkeyboard", "sipdroid", "WiFiTether", "zxing", "CSipSimple", "k9"), 
        col="gold")
title("RFC per project")

boxplot(osmand$RFC, mytracks$RFC, softkeyboard$RFC, sipdroid$RFC, WiFiTether$RFC, zxing$RFC, CSipSimple$RFC, k9$RFC, 
        names=c("osmand", "mytracks", "softkeyboard", "sipdroid", "WiFiTether", "zxing", "CSipSimple", "k9"), 
        col="gold")
title("RFC per project")

#Vioplot LCOM
vioplot(osmand$LCOM, mytracks$LCOM, softkeyboard$LCOM, sipdroid$LCOM, WiFiTether$LCOM, zxing$LCOM, CSipSimple$LCOM, k9$LCOM, 
        names=c("osmand", "mytracks", "softkeyboard", "sipdroid", "WiFiTether", "zxing", "CSipSimple", "k9"), 
        col="gold")
title("LCOM per project")

boxplot(osmand$LCOM, mytracks$LCOM, softkeyboard$LCOM, sipdroid$LCOM, WiFiTether$LCOM, zxing$LCOM, CSipSimple$LCOM, k9$LCOM, 
        names=c("osmand", "mytracks", "softkeyboard", "sipdroid", "WiFiTether", "zxing", "CSipSimple", "k9"), 
        col="gold")
title("LCOM per project")

#Vioplot Ca
#vioplot(osmand$Ca, mytracks$Ca, softkeyboard$Ca, sipdroid$Ca, WiFiTether$Ca, zxing$Ca, CSipSimple$Ca, k9$Ca, 
#        names=c("osmand", "mytracks", "softkeyboard", "sipdroid", "WiFiTether", "zxing", "CSipSimple", "k9"), 
#        col="gold")
#title("Ca per project")

#boxplot(osmand$Ca, mytracks$Ca, softkeyboard$Ca, sipdroid$Ca, WiFiTether$Ca, zxing$Ca, CSipSimple$Ca, k9$Ca, 
#        names=c("osmand", "mytracks", "softkeyboard", "sipdroid", "WiFiTether", "zxing", "CSipSimple", "k9"), 
#        col="gold")
#title("Ca per project")

#Vioplot NPM
vioplot(osmand$NPM, mytracks$NPM, softkeyboard$NPM, sipdroid$NPM, WiFiTether$NPM, zxing$NPM, CSipSimple$NPM, k9$NPM, 
        names=c("osmand", "mytracks", "softkeyboard", "sipdroid", "WiFiTether", "zxing", "CSipSimple", "k9"), 
        col="gold")
title("NPM per project")

boxplot(osmand$NPM, mytracks$NPM, softkeyboard$NPM, sipdroid$NPM, WiFiTether$NPM, zxing$NPM, CSipSimple$NPM, k9$NPM,
        names=c("osmand", "mytracks", "softkeyboard", "sipdroid", "WiFiTether", "zxing", "CSipSimple", "k9"), 
        col="gold")
title("NPM per project")


#mann-u-tes
#http://www.r-tutor.com/elementary-statistics/non-parametric-methods/mann-whitney-wilcoxon-test

#p<.5 cannot 
#The null hypothesis is that the WMC package A and WMC package B are identical populations.
#To test the hypothesis, we apply the wilcox.test function to compare the independent samples. 
#As the p-value turns out to be 0.001817, and is less than the .05 significance level, we reject the null hypothesis.
#less or greater alternative hypotesys (o primeiro parametro que é menor ou maior)

#Interpratation
#At .05 significance level, we conclude that the 
#WMC package A and WMC package B to XXX project are nonidentical populations.

#CSipSimple<- read.csv('CSipSimple-results-pkg.csv', sep=';')
#WiFiTether<- read.csv('WiFiTether-ckjm-results-pkg.csv', sep=';')
#k9<- read.csv('k9-ckjm-results-pkg.csv', sep=';')
#osmand<- read.csv('osmand-ckjm-results-pkg.csv', sep=';')
#sipdroid<- read.csv('sipdroid-ckjm-results-pkg.csv', sep=';')
#zxing<- read.csv('zxing-ckjm-results-pkg.csv', sep=';')
#softkeyboard<- read.csv('softkeyboard-ckjm-results-pkg.csv', sep=';')
#mytracks<- read.csv('mytracks-ckjm-results-pkg.csv', sep=';')

wilcox.test(softkeyboard$CBO, CSipSimple$CBO, correct=TRUE, alternative="two.sided")


#kruskall wallis
#http://www.r-tutor.com/elementary-statistics/non-parametric-methods/kruskal-wallis-test

#A collection of data samples are independent if they come from unrelated populations and the samples do not affect each other

#The null hypothesis is that the WMC de todos os pacotes are identical populations. Ou WMC de todos os projetos (somar todos os pacotes de um projeto) são iguais
#To test the hypothesis, we apply the kruskal.test function to compare the independent WMC data. 
#The p-value turns out to be nearly zero (6.901e-06). Hence we reject the null hypothesis.

#At .05 significance level, we conclude that the WMC in em um projeto are nonidentical populations.

kruskal.test(list(A,P,S,AP,SA,SP,ALL))

##### DataSet para Radar Plot ####

#classesData <- read.csv('CSipSimple-class.csv', sep=';')
#pkgData <- read.csv('CSipSimple-pkg.csv', sep=';')
#data <- pkgData[,-1]
#rownames(data) <- pkgData[,1]

source("radar.r")
#par(mfcol = c(3, 4))

#for (cont in 1:12)
#{
  #radar plot no site abaixo
  #http://statisticstoproveanything.blogspot.com.br/2013/11/spider-web-plots-in-r.html
 # webplot(data, cont, col=cont, lty=cont)
} 

#"C:\Temp\mytracks-ckjm-results-pkg.csv"
#"C:\Temp\softkeyboard-ckjm-results-pkg.csv"
#"C:\Temp\sipdroid-ckjm-results-pkg.csv"
#"C:\Temp\zxing-ckjm-results-pkg.csv"
#"C:\Temp\WiFiTether-ckjm-results-pkg.csv"
#"C:\Temp\CSipSimple-results-pkg.csv"
#"C:\Temp\k9-ckjm-results-pkg.csv"

#computing Median by Metrics, by Projects
softkeyboard.WMC <- median(softkeyboard$WMC)
softkeyboard.DIT <- median(softkeyboard$DIT)
#softkeyboard.NOC <- median(softkeyboard$NOC)
softkeyboard.CBO <- median(softkeyboard$CBO)
softkeyboard.RFC <- median(softkeyboard$RFC)
softkeyboard.LCOM <- median(softkeyboard$LCOM)
#softkeyboard.Ca <- median(softkeyboard$Ca)
softkeyboard.NPM <- median(softkeyboard$NPM)
#softkeyboard <- c(softkeyboard.WMC,softkeyboard.DIT,softkeyboard.NOC,softkeyboard.CBO,softkeyboard.RFC,softkeyboard.LCOM,softkeyboard.Ca,softkeyboard.NPM)
softkeyboard <- c(softkeyboard.WMC,softkeyboard.DIT,softkeyboard.CBO,softkeyboard.RFC,softkeyboard.LCOM,softkeyboard.NPM)

mytracks.WMC <- median(mytracks$WMC)
mytracks.DIT <- median(mytracks$DIT)
#mytracks.NOC <- median(mytracks$NOC)
mytracks.CBO <- median(mytracks$CBO)
mytracks.RFC <- median(mytracks$RFC)
mytracks.LCOM <- median(mytracks$LCOM)
#mytracks.Ca <- median(mytracks$Ca)
mytracks.NPM <- median(mytracks$NPM)
#mytracks <- c(mytracks.WMC,mytracks.DIT,mytracks.NOC,mytracks.CBO,mytracks.RFC,mytracks.LCOM,mytracks.Ca,mytracks.NPM)
mytracks <- c(mytracks.WMC,mytracks.DIT,mytracks.CBO,mytracks.RFC,mytracks.LCOM,mytracks.NPM)

CSipSimple.WMC <- median(CSipSimple$WMC)
CSipSimple.DIT <- median(CSipSimple$DIT)
#CSipSimple.NOC <- median(CSipSimple$NOC)
CSipSimple.CBO <- median(CSipSimple$CBO)
CSipSimple.RFC <- median(CSipSimple$RFC)
CSipSimple.LCOM <- median(CSipSimple$LCOM)
#CSipSimple.Ca <- median(CSipSimple$Ca)
CSipSimple.NPM <- median(CSipSimple$NPM)
#CSipSimple <- c(CSipSimple.WMC,CSipSimple.DIT,CSipSimple.NOC,CSipSimple.CBO,CSipSimple.RFC,CSipSimple.LCOM,CSipSimple.Ca,CSipSimple.NPM)
CSipSimple <- c(CSipSimple.WMC,CSipSimple.DIT,CSipSimple.CBO,CSipSimple.RFC,CSipSimple.LCOM,CSipSimple.NPM)

WiFiTether.WMC <- median(WiFiTether$WMC)
WiFiTether.DIT <- median(WiFiTether$DIT)
#WiFiTether.NOC <- median(WiFiTether$NOC)
WiFiTether.CBO <- median(WiFiTether$CBO)
WiFiTether.RFC <- median(WiFiTether$RFC)
WiFiTether.LCOM <- median(WiFiTether$LCOM)
#WiFiTether.Ca <- median(WiFiTether$Ca)
WiFiTether.NPM <- median(WiFiTether$NPM)
#WiFiTether <- c(WiFiTether.WMC,WiFiTether.DIT,WiFiTether.NOC,WiFiTether.CBO,WiFiTether.RFC,WiFiTether.LCOM,WiFiTether.Ca,WiFiTether.NPM)
WiFiTether <- c(WiFiTether.WMC,WiFiTether.DIT,WiFiTether.CBO,WiFiTether.RFC,WiFiTether.LCOM,WiFiTether.NPM)

k9.WMC <- median(k9$WMC)
k9.DIT <- median(k9$DIT)
#k9.NOC <- median(k9$NOC)
k9.CBO <- median(k9$CBO)
k9.RFC <- median(k9$RFC)
k9.LCOM <- median(k9$LCOM)
#k9.Ca <- median(k9$Ca)
k9.NPM <- median(k9$NPM)
#k9 <- c(k9.WMC,k9.DIT,k9.NOC,k9.CBO,k9.RFC,k9.LCOM,k9.Ca,k9.NPM)
k9 <- c(k9.WMC,k9.DIT,k9.CBO,k9.RFC,k9.LCOM,k9.NPM)

osmand.WMC <- median(osmand$WMC)
osmand.DIT <- median(osmand$DIT)
#osmand.NOC <- median(osmand$NOC)
osmand.CBO <- median(osmand$CBO)
osmand.RFC <- median(osmand$RFC)
osmand.LCOM <- median(osmand$LCOM)
#osmand.Ca <- median(osmand$Ca)
osmand.NPM <- median(osmand$NPM)
#osmand <- c(osmand.WMC,osmand.DIT,osmand.NOC,osmand.CBO,osmand.RFC,osmand.LCOM,osmand.Ca,osmand.NPM)
osmand <- c(osmand.WMC,osmand.DIT,osmand.CBO,osmand.RFC,osmand.LCOM,osmand.NPM)

sipdroid.WMC <- median(sipdroid$WMC)
sipdroid.DIT <- median(sipdroid$DIT)
#sipdroid.NOC <- median(sipdroid$NOC)
sipdroid.CBO <- median(sipdroid$CBO)
sipdroid.RFC <- median(sipdroid$RFC)
sipdroid.LCOM <- median(sipdroid$LCOM)
#sipdroid.Ca <- median(sipdroid$Ca)
sipdroid.NPM <- median(sipdroid$NPM)
#sipdroid <- c(sipdroid.WMC,sipdroid.DIT,sipdroid.NOC,sipdroid.CBO,sipdroid.RFC,sipdroid.LCOM,sipdroid.Ca,sipdroid.NPM)
sipdroid <- c(sipdroid.WMC,sipdroid.DIT,sipdroid.CBO,sipdroid.RFC,sipdroid.LCOM,sipdroid.NPM)

zxing.WMC <- median(zxing$WMC)
zxing.DIT <- median(zxing$DIT)
#zxing.NOC <- median(zxing$NOC)
zxing.CBO <- median(zxing$CBO)
zxing.RFC <- median(zxing$RFC)
zxing.LCOM <- median(zxing$LCOM)
#zxing.Ca <- median(zxing$Ca)
zxing.NPM <- median(zxing$NPM)
#zxing <- c(zxing.WMC,zxing.DIT,zxing.NOC,zxing.CBO,zxing.RFC,zxing.LCOM,zxing.Ca,zxing.NPM)
zxing <- c(zxing.WMC,zxing.DIT,zxing.CBO,zxing.RFC,zxing.LCOM,zxing.NPM)


#transforma vetores em uma matriz
dados<-rbind(zxing,CSipSimple,WiFiTether,k9,osmand,sipdroid,mytracks,softkeyboard)

#dados<-data.frame(zxing,CSipSimple,WiFiTether,k9,osmand,sipdroid)
#ordem das colunas para o edit WMC DIT  NOC CBO RFC LCOM Ca NPM

#transformar os vetores em um dataframe
dados<-data.frame(dados)

#renomear as colunas 1,2...8 com os nomes das colunas
#names(dados)[c(1,2,3,4,5,6,7,8)] <- c("WMC","DIT","NOC","CBO","RFC","LCOM","Ca","NPM")

names(dados)[c(1,2,3,4,5,6)] <- c("WMC","DIT","CBO","RFC","LCOM","NPM")

par(mar = c(1, 1, 2, 1))
webplot(dados, "zxing", col="1", main = "Radar plot")
webplot(dados, "CSipSimple", add = T, col = "2", lty = 2)
webplot(dados, "WiFiTether", add = T, col = "3", lty = 3)
webplot(dados, "k9", add = T, col = "4", lty = 4)
webplot(dados, "osmand", add = T, col = "5", lty = 5)
webplot(dados, "sipdroid", add = T, col = "6", lty = 6)
webplot(dados, "mytracks", add = T, col = "7", lty = 7)
webplot(dados, "softkeyboard", add = T, col = "8", lty = 8)
par(new = T)
par(mar = c(0, 0, 0, 0))
plot(0, type = "n", axes = F)
legend("topright", lty = c(1,2,3,4,5,6,7,8), 
       lwd = 2,
       cex=0.8,
       col = c("1","2","3","4","5","6","7","8"), 
       c("zxing","CSipSimple","WiFiTether","k9","osmand","sipdroid","mytracks","softkeyboard"), 
       bty = "n")


