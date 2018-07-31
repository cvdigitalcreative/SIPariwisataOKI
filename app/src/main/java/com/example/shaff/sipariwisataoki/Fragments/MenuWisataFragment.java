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
public class MenuWisataFragment extends Fragment {
    Button btnWKeluarga, btnWBudaya, btnWAlam;

    public MenuWisataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;

        view = inflater.inflate(R.layout.fragment_menu_wisata, container, false);

        btnWKeluarga = view.findViewById(R.id.btn_w_keluarga);
        btnWBudaya = view.findViewById(R.id.btn_w_budaya);
        btnWAlam = view.findViewById(R.id.btn_w_alam);

        btnWKeluarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaftarWisataFragment daftarWisata = new DaftarWisataFragment();

                Bundle sendedData = new Bundle();
                sendedData.putString("wisata", "Keluarga");

                daftarWisata.setArguments(sendedData);
                getFragmentManager().beginTransaction().replace(R.id.container_fragment, daftarWisata).addToBackStack(null).commit();
            }
        });

        btnWBudaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaftarWisataFragment daftarWisata = new DaftarWisataFragment();

                Bundle sendedData = new Bundle();
                sendedData.putString("wisata", "Budaya");

                daftarWisata.setArguments(sendedData);
                getFragmentManager().beginTransaction().replace(R.id.container_fragment, daftarWisata).addToBackStack(null).commit();
            }
        });

        btnWAlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaftarWisataFragment daftarWisata = new DaftarWisataFragment();

                Bundle sendedData = new Bundle();
                sendedData.putString("wisata", "Alam");

                daftarWisata.setArguments(sendedData);
                getFragmentManager().beginTransaction().replace(R.id.container_fragment, daftarWisata).addToBackStack(null).commit();
            }
        });

        return view;
    }

}
