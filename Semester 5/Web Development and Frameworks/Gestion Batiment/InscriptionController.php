<?php


class InscriptionController extends Controller
{
    public function register(Request $request)
    {
        // Validation des données
        $request->validate([
            'name' => 'required',
            'email' => 'required|email|unique:users',
            'password' => 'required|min:6|confirmed',
        ]);

        // Création d'un nouvel utilisateur
        $user = User::create([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password),
        ]);

        // Connexion automatique après l'inscription
        Auth::login($user);

        // Redirection après l'inscription
        return redirect()->route('dashboard');
    }


}