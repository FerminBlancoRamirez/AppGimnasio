package com.example.appgimnasio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.ArrayList;

public class Calendario extends Fragment {
    CalendarView calendarView;
    TextView myDate;

    private ArrayList<Days> daysArrayList;
    private String[] daysDiasDeLaSemana;
    private String[] daysEntrenamiento;
    private RecyclerView recyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_celendario, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recyclerview = view.findViewById(R.id.rVCalendario);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        MyAdapter myAdapter= new MyAdapter(getContext(), daysArrayList);
        recyclerview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {
        daysArrayList = new ArrayList<>();

        daysDiasDeLaSemana = new String[]{
                getString(R.string.Lunes),
                getString(R.string.Martes),
                getString(R.string.Miercoles),
                getString(R.string.Jueves),
                getString(R.string.Viernes),
                getString(R.string.Sabado),
                getString(R.string.Domingo)
        };

        daysEntrenamiento = new String[]{
                getString(R.string.DiaDePierna),
                getString(R.string.DiaDePecho),
                getString(R.string.DiaDeEspalda),
                getString(R.string.DiaDeFullBody),
                getString(R.string.DiaDePierna),
                getString(R.string.DiaDeDescanso),
                getString(R.string.DiaDeDescanso)
        };

        for (int i = 0; i < daysDiasDeLaSemana.length; i++) {
            String entrenamiento = (i < daysEntrenamiento.length) ? daysEntrenamiento[i] : getString(R.string.DiaDeDescanso);
            Days days = new Days(daysDiasDeLaSemana[i], entrenamiento);
            daysArrayList.add(days);
        }
    }
}