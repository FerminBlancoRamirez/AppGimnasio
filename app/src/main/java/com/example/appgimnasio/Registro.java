package com.example.appgimnasio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class Registro extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        Button loginButton= view.findViewById(R.id.btnInicioSesion);
        Button singUpButton = view.findViewById(R.id.btnRegistro);

        loginButton.setOnClickListener(v->{
            Fragment loginFragment =new Login();

            getParentFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_right,
                            R.anim.slide_out_left,
                            R.anim.slide_in_left,
                            R.anim.slide_out_right
                    )
                    .replace(R.id.fragment_container, loginFragment)
                    .addToBackStack(null)
                    .commit();
        });

        singUpButton.setOnClickListener(v->{
            Fragment singUpFragment= new Sign_up();

            getParentFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_right,
                            R.anim.slide_out_left,
                            R.anim.slide_in_left,
                            R.anim.slide_out_right
                    )
                    .replace(R.id.fragment_container, singUpFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}