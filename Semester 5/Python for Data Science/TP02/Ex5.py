while True:
    majuscule = False
    miniscule = False
    chiffre = False
    cspecial = False


    mot_de_passe = input("Entrer votre mot de pase : ")
    password = list(mot_de_passe)
    taille_password = len(password)

    for i in password:
        if i.isupper():
            majuscule = True
        if i.islower():
            miniscule = True
        if i.isdigit():
            chiffre = True
        if i in ["&", "$", "!"]:
            cspecial = True

    if majuscule and miniscule and chiffre and cspecial and taille_password >= 8 :
        print("Mot de passe valide")
        break
    else:
        print("mot de passe invalide")