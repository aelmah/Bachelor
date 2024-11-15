liste = input("Entrer element de liste : ")
L = [int(x) for x in liste.split(' ')]

print("La liste :\n",L)
nombre = int(input("entrer un nombre a supprimer : "))

#methode1
#for num in L[::-1]:
#    if num == nombre:
#        L.remove(num)
#methode2 simple
while L.count(nombre) != 0:
    L.remove(nombre)
print(L)