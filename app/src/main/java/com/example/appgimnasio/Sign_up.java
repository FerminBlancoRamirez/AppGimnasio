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

public class Sign_up extends Fragment {

    public Sign_up() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Cambia 'btnRegistrarse' por el ID real de tu botón en fragment_sign_up.xml
        Button btnRegistrarse = view.findViewById(R.id.mBRegistro);

        if (btnRegistrarse != null) {
            btnRegistrarse.setOnClickListener(v ->
                    NavHostFragment.findNavController(Sign_up.this)
                            .navigate(R.id.action_registrarse_to_inicio)
            );
        }
    }
}