# -*- coding: utf-8 -*-
"""
Created on Sun Feb 18 22:21:36 2024

@author: user
"""
# Importer les packages necessaires
import streamlit as st
import pandas as pd
import numpy as np
from sklearn import preprocessing
from sklearn import impute
from sklearn import compose
from sklearn.decomposition import PCA

# Titre de l'application
st.title("Préparation de données avec Streamlit")

# Chargement du fichier depuis l'ordinateur
uploaded_file = st.file_uploader("Uploader le fichier CSV", type=["csv"])

# Si un fichier est chargé
if uploaded_file is not None:
    # Lecture du fichier CSV
    df = pd.read_csv(uploaded_file)
    st.write(df)
    # Affichage du nombre d'instances et d'attributs
    st.markdown("***Le nombre d'instances de la base de donnees achat est :***")
    st.write(df.shape[0])
    st.markdown("***Le nombre d'attributs de la base de donnees achat est :***")
    st.write(df.shape[1])
    
    # Affichage des premières lignes de la base de données
    st.markdown("***Les premières lignes de la base de données :***")
    st.write(df.head())
    
    # Séparation des variables indépendantes (X) et dépendantes (Y)
    X = df.iloc[: , :-1].values 
    Y = df.iloc[: , -1].values
    # Bouton pour nettoyer les données X
    st.markdown('***Nettoyage les données X :***')
    if st.button("Nettoyer"):
        # Remplacer les valeurs manquantes
        imputer = impute.SimpleImputer(missing_values=np.nan,strategy='mean')
        X[:,1:3]= imputer.fit_transform(X[:,1:3])
        st.markdown("***Les premières lignes de X après la phase de nettoyage :***")
        Xn = pd.DataFrame(X,columns=["Country","Age","Salary"])
        st.write(Xn[:5])
   
    # Bouton pour normaliser X (les attributs Age et Salary)
    st.markdown('***Normalisation X (les attributs Age et Salary) :***')
    if st.button("Normaliser"):
        imputer = impute.SimpleImputer(missing_values=np.nan,strategy='mean')
        X[:,1:3]= imputer.fit_transform(X[:,1:3])
        scaler = preprocessing.MinMaxScaler()
        X[:,1:3] = scaler.fit_transform(X[:,1:3])
        st.markdown("***Les premières lignes de X après la phase de normalisation :***")
        X_scaled = pd.DataFrame(X,columns=["Country","Age","Salary"])
        st.write(X_scaled[:5])
        

    # Bouton pour encoder la colonne catégoriale Country
    st.markdown('***Encodage la colonne catégoriale country :***')
    if st.button("Encoder"):
        imputer = impute.SimpleImputer(missing_values=np.nan,strategy='mean')
        X[:,1:3]= imputer.fit_transform(X[:,1:3])
        encoder = compose.ColumnTransformer(transformers=[('encoder',preprocessing.OneHotEncoder(),[0])],remainder='passthrough')
        X_encoded =np.array(encoder.fit_transform(X),dtype=np.int32)
        st.markdown("***Les premières lignes de X après la phase d'encodage :***")
        X_encoded = pd.DataFrame(X_encoded,columns=["France","Germany","Spain","Age","Salary"])
        st.write(X_encoded[:5])
        
        
    # Bouton pour réduire les attributs Age et Salary en un seul attribut
    st.markdown('***Réduire les attributs Age et Salary en seul attribut :***')
    if st.button("Réduire"):
        imputer = impute.SimpleImputer(missing_values=np.nan,strategy='mean')
        X[:,1:3]= imputer.fit_transform(X[:,1:3])
        scaler = preprocessing.MinMaxScaler()
        X[:,1:3] = scaler.fit_transform(X[:,1:3])
        pca = PCA(n_components=1)
        X[:,1:3] = pca.fit_transform(X[:,1:3])
        st.markdown("***Les premières lignes de X après la phase de réduction :***")
        X_reduced = pd.DataFrame(X[:,0:2],columns=["Country","Age+Salary"])
        st.write(X_reduced[:5])


