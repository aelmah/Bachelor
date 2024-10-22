import streamlit as st
import pandas as pd
import numpy as np
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split, GridSearchCV
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_absolute_error, mean_squared_error, r2_score
import matplotlib.pyplot as plt

# Titre de l'application
st.title("Prédiction de Salaire")

# Sidebar
uploaded_file = st.sidebar.file_uploader("Uploader le fichier CSV", type=["csv"])

# Charger les données du fichier CSV
if uploaded_file is not None:
    df = pd.read_csv(uploaded_file)

    # Afficher le nombre d'instances et d'attributs
    st.sidebar.write(f"Nombre d'instances : {df.shape[0]} \n , Nombre d'attributs : {df.shape[1]}")

    # Afficher les premières lignes du jeu de données
    st.sidebar.subheader("Premières lignes du jeu de données")
    st.sidebar.write(df.head())

    # Visualisation de X et Y dans une figure
    st.sidebar.subheader("Visualisation de X et Y")
    fig, ax = plt.subplots()
    ax.scatter(df['AnneesExpérience'], df['Salaire'])
    ax.set_xlabel('AnneesExpérience')
    ax.set_ylabel('Salaire')
    st.sidebar.pyplot(fig)

    # Bouton pour normaliser X
    if st.sidebar.button("Normaliser X"):
        scaler = StandardScaler()
        df['AnneesExpérience'] = scaler.fit_transform(df[['AnneesExpérience']])
        st.sidebar.success("La normalisation de X est effectuée.")

    

    # Buttons pour calculer les métriques d'erreurs
    st.sidebar.subheader("Calcul des métriques d'erreurs")
    X = df[['AnneesExpérience']]
    y = df['Salaire']
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

    if st.sidebar.button("Calculer MAE"):
        y_pred = LinearRegression().fit(X_train, y_train).predict(X_test)
        mae = mean_absolute_error(y_test, y_pred)
        st.sidebar.write(f"Mean Absolute Error : {mae}")

    if st.sidebar.button("Calculer MSE"):
        y_pred = LinearRegression().fit(X_train, y_train).predict(X_test)
        mse = mean_squared_error(y_test, y_pred)
        st.sidebar.write(f"Mean Squared Error : {mse}")

    if st.sidebar.button("Calculer R2 Score"):
        y_pred = LinearRegression().fit(X_train, y_train).predict(X_test)
        r2 = r2_score(y_test, y_pred)
        st.sidebar.write(f"R2 Score : {r2}")

    # Visualisation de X, Y et les prédictions sur X dans une seule figure
    st.subheader("Visualisation de X, Y et les prédictions")
    fig, ax = plt.subplots()
    ax.scatter(df['AnneesExpérience'], df['Salaire'], label='Données réelles')
    ax.plot(df['AnneesExpérience'], LinearRegression().fit(X, y).predict(X), color='red', label='Prédictions')
    ax.set_xlabel('AnneesExpérience')
    ax.set_ylabel('Salaire')
    ax.legend()
    st.pyplot(fig)

    # Champs pour saisir les années et afficher les salaires prédictifs
    st.subheader("Prédictions pour les années saisies")
    years_to_predict = st.text_input("Saisir les années (séparées par des virgules)", "1.0,2.0,3.0")
    years_to_predict = [float(year) for year in years_to_predict.split(',')]
    predictions = LinearRegression().fit(X, y).predict(np.array(years_to_predict).reshape(-1, 1))
    st.write("Années:", years_to_predict)
    st.write("Salaires prédits:", predictions)
