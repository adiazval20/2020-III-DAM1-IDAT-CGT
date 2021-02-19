package edu.idat.semana6;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PerfilFragment extends Fragment {
    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        LinearLayout lytDatosPerfil = view.findViewById(R.id.lytDatosPerfil);
        ImageView imgUser = view.findViewById(R.id.imgUser);

        ObjectAnimator desplazamientoEnY = ObjectAnimator.ofFloat(lytDatosPerfil, "translationY", 500f, 0f);
        desplazamientoEnY.setDuration(1000);
//        desplazamientoEnY.start();

        ObjectAnimator transparencia = ObjectAnimator.ofFloat(lytDatosPerfil, "alpha", 0f, 1f);
        transparencia.setDuration(1000);

        ObjectAnimator rotacion = ObjectAnimator.ofFloat(imgUser, "rotation", 270f, 360f);
        rotacion.setDuration(1000);

        AnimatorSet set = new AnimatorSet();
        set.play(desplazamientoEnY);
        set.play(transparencia);
        set.play(rotacion);
        set.start();
    }
}