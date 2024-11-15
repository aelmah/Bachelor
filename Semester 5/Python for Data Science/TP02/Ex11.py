liste = input("Entrer element de liste : ").split()
L = [int(x) for x in liste]
print(L)
L2=[]
num = int(input("entrer le nombre que vous cherchez : "))
count = L.count(num)

if(count>=1):
    print(f"{num} occure {count} fois.")
    print("L'indice de chaque occurence : ")
    itr = 1
    for indice in range(len(L)):
        if L[indice] == num:
            print(f"Position {itr} est : {indice}",end="\n")
            L2.append(indice)
            itr+=1
    #for indice ,nombre in enumerate(L):
    #    if(num == nombre):
    #        print(f"L[{indice}]")
else:
    print(f"{num} n'existe pas dans la liste.")
print(f"liste des indice d'occurence de {num} : {L2}")