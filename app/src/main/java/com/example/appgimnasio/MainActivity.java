package com.example.appgimnasio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });

        navigationView = findViewById(R.id.bNVNavigation);

        // FIX 1: Ocultamos la barra explícitamente desde el inicio por seguridad
        navigationView.setVisibility(View.GONE);

        // FIX 2: Cargar el SplashScreen llamando a loadFragment
        if (savedInstanceState == null) {
            loadFragment(new SplashScreen());
        }

        navigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.inicio) {
                loadFragment(new inicio());
                return true;
            } else if (itemId == R.id.calendario) {
                loadFragment(new Calendario());
                return true;
            } else if (itemId == R.id.Progreso) {
                loadFragment(new Progreso());
                return true;
            } else if (itemId == R.id.Perfil) {
                loadFragment(new Perfil());
                return true;
            }
            return false;
        });
    }


    // 1. Sobrecarga para 4 animaciones (Entrar, Salir, Volver a Entrar, Volver a Salir)
    public void loadFragment(Fragment fragment, int enterAnim, int exitAnim, int popEnterAnim, int popExitAnim) {
        if (fragment instanceof SplashScreen || fragment instanceof Login || fragment instanceof Registro || fragment instanceof Sign_up) {
            navigationView.setVisibility(View.GONE);
        } else {
            navigationView.setVisibility(View.VISIBLE);
        }

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim)
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    // 2. Sobrecarga para 2 animaciones (Entrar y Salir)
    public void loadFragment(Fragment fragment, int enterAnim, int exitAnim) {
        if (fragment instanceof SplashScreen || fragment instanceof Login || fragment instanceof Registro || fragment instanceof Sign_up) {
            navigationView.setVisibility(View.GONE);
        } else {
            navigationView.setVisibility(View.VISIBLE);
        }

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(enterAnim, exitAnim)
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    // 3. Método por defecto (llama a la versión de 2 animaciones)
    public void loadFragment(Fragment fragment) {
        loadFragment(
                fragment,
                R.anim.slide_in_right,
                R.anim.slide_out_left
        );
    }
}