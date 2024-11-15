nombre = int(input("Entrer nombre des lignes : "))

for i in range(1,nombre+1):
    for j in range(1,i+1):
        print(j,end=" ")
    print()