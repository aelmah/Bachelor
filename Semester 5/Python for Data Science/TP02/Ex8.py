liste = input("Entrer element de liste : ")
L = [int(x) for x in liste.split(' ')]
L.sort()
print(L)

val = int(input("Entrer un valeur : "))

index = 0
while index < len(L) and L[index] < val:
    index+=1
    print(index)
L.insert(index,val)
print(L)