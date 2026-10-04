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
import androidx.navigation.fragment.NavHostFragment;

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
            // Verificamos que el fragmento siga adjunto a la pantalla para evitar crashes
            if (isAdded()) {
                NavHostFragment.findNavController(SplashScreen.this)
                        .navigate(R.id.action_splash_to_registro);
                // NOTA: Asegúrate de que R.id.action_splash_to_registro existe en tu nav_graph.xml
            }
        }, 3000);
    }
}