#L = [1,-30,0,-2,500,4,2,100]
liste = input("Entrer element de liste : ")
L = [int(x) for x in liste.split(' ')]

#methode classic
#M = []
#for num in L:
#    if num < 0:
#        M.append(num)
#for num in L:
#    if num >= 0:
#        M.append(num)
        
#methode simple
M = [num for num in L if num < 0 ]+[num for num in L if num >= 0]    

print(M)