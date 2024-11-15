nombre = int(input("entrer un nombre : "))
count = 0

while nombre != 0:
    count += 1
    nombre = nombre // 10
print(count)    