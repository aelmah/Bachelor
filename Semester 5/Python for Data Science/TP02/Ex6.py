#ma_liste = [12,75,150,180,145,525,50]
liste = input("Entrer element de liste : ").split(',')
ma_liste = [int(x) for x in liste]

for itr in ma_liste:
    if itr > 500:
        break
    if itr > 150:
        continue
    if itr % 5 == 0:
        print(itr,end="\n\n") 