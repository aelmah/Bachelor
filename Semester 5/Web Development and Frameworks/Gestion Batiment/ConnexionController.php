<?php

class ConnexionController extends Controller
{
    public function login(Request $request)
    {
        // Validation des données
        $request->validate([
            'email' => 'required|email',
            'password' => 'required',
        ]);

        // Tentative de connexion
        if (Auth::attempt(['email' => $request->email, 'password' => $request->password])) {
            // Connexion réussie
            return redirect()->route('dashboard');
        } else {
            // Connexion échouée
            return redirect()->back()->withErrors(['message' => 'Adresse e-mail ou mot de passe incorrect']);
        }
    }
}
