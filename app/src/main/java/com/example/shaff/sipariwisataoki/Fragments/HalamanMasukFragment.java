package com.example.shaff.sipariwisataoki.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shaff.sipariwisataoki.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HalamanMasukFragment extends Fragment {
    Button btnMasuk;

    public HalamanMasukFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;

        view = inflater.inflate(R.layout.fragment_halaman_masuk, container, false);

        btnMasuk = view.findViewById(R.id.btn_masuk);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuWisataFragment menuWisata = new MenuWisataFragment();

                getFragmentManager().beginTransaction().replace(R.id.container_fragment, menuWisata).addToBackStack(null).commit();
            }
        });

        return view;
    }

}
