L1=[1,3,6,78,35,35,88,55]
L2=[12,24,35,24,88,120,155,88,55]
#liste1 = input('Entrer element de liste1 : ').split()
#L1 = [int(x) for x in liste1]
#liste2 = input('Entrer element de liste2 : ').split()
#L2 = [int(x) for x in liste2]

L3=[]

for num in L1:
    if num in L2 and num not in L3:
        L3.append(num)

print("L3 =",L3)