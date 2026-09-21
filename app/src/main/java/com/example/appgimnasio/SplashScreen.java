package com.example.appgimnasio;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SplashScreen extends Fragment {

    public SplashScreen() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (isAdded() && getActivity() instanceof MainActivity) {
                // Llamamos a MainActivity pasándole las animaciones de Fade
                ((MainActivity) getActivity()).loadFragment(
                        new Registro(),
                        R.anim.fade_in,
                        R.anim.fade_out
                );
            }
        }, 3000);
    }
}