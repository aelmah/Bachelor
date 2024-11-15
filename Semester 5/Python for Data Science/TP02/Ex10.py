liste = input("Entrer element de liste : ")
L = [int(x) for x in liste.split(' ')]
print(L)
'''
methode 1
for num in L[::-1]: #iterartion inverse
    if L.count(num) > 1:
        #print(L)
        L.remove(num)

#autre methode
for num in L:
    while(L.count(num) > 1):
        L.remove(num)
'''
#methode primitive
i = 0
while(i < len(L)):
    j=i+1
    while(j < len(L)):
        if(L[i]==L[j]):
            del L[j]
        else:
            j+=1
    i+=1        
L.sort()
print("La liste apres suppression des occurences : \n",L)