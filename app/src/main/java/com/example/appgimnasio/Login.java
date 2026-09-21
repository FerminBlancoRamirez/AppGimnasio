package com.example.appgimnasio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

public class Login extends Fragment {

    public Login(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        MaterialButton iniciarSesion = view.findViewById(R.id.mBIniciarSesion);

        iniciarSesion.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                // Pasamos el nuevo fragmento junto con las 4 animaciones
                ((MainActivity) getActivity()).loadFragment(
                        new inicio(),
                        R.anim.slide_in_right,
                        R.anim.slide_out_left,
                        R.anim.slide_in_left,
                        R.anim.slide_out_right
                );
            }
        });
    }
}