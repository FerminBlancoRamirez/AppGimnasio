package com.example.appgimnasio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class Registro extends Fragment {

    public Registro() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button loginButton = view.findViewById(R.id.btnInicioSesion);
        Button signUpButton = view.findViewById(R.id.btnRegistro);

        // Navegar hacia la pantalla de Login
        loginButton.setOnClickListener(v ->
                NavHostFragment.findNavController(Registro.this)
                        .navigate(R.id.action_registro_to_login)
        );

        // Navegar hacia la pantalla de Formulario de Registro
        signUpButton.setOnClickListener(v ->
                NavHostFragment.findNavController(Registro.this)
                        .navigate(R.id.action_registro_to_sign_up)
        );
    }
}