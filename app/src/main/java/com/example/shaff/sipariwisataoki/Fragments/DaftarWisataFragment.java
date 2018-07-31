package com.example.shaff.sipariwisataoki.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shaff.sipariwisataoki.ModelData.WisataModel;
import com.example.shaff.sipariwisataoki.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaftarWisataFragment extends Fragment {
    ArrayList<WisataModel> wisataList;
    RecyclerView myRecyclerView;
    String jenis_wisata;
    TextView tvJenisWisata;

    int[] foto_wisata_keluarga = {R.drawable.taman_kayuagung_emas, R.drawable.yahya, R.drawable.azza_indor, R.drawable.wahana};
    int[] nama_wisata_keluarga = {R.string.wisata_keluarga_1, R.string.wisata_keluarga_2, R.string.wisata_keluarga_3, R.string.wisata_keluarga_4};
    int[] sejarah_wisata_keluarga = {R.string.sejarah_wisata_keluarga_1, R.string.sejarah_wisata_keluarga_2, R.string.sejarah_wisata_keluarga_3, R.string.sejarah_wisata_keluarga_4};
    int[] longitude_wisata_keluarga = {R.string.long_wisata_keluarga_1, R.string.long_wisata_keluarga_2, R.string.long_wisata_keluarga_3, R.string.long_wisata_keluarga_4};
    int[] latitude_wisata_keluarga = {R.string.lat_wisata_keluarga_1, R.string.lat_wisata_keluarga_2, R.string.lat_wisata_keluarga_3, R.string.lat_wisata_keluarga_4};

    int[] foto_wisata_budaya = {R.drawable.makam_seriang_kuning, R.drawable.rumah_linmas, R.drawable.makam_batu_jimat, R.drawable.makam_puyang_buncit, R.drawable.rumah_haji_bahri,
            R.drawable.rumah_adat_pangeran_ajaya_pati, R.drawable.masjid_jamik, R.drawable.rumah_adat_tokeh_jahri, R.drawable.rumah_pangeran_haji_toyut, R.drawable.rumah_depati_amir,
            R.drawable.rumah_adat_pangeran_ajaya_pati, R.drawable.rumah_100_tiang_sugiwaras, R.drawable.makam_rejet, R.drawable.rumah_depati_ahmad, R.drawable.rumah_depati_mnur,
            R.drawable.rumah_adat_joegronegoro, R.drawable.rumah_linmas_depati, R.drawable.makam_buyut, R.drawable.batu_gajah, R.drawable.batu_pengantin,
            R.drawable.batu_paso, R.drawable.makam_serunting_sakti, R.drawable.rumah_depati_baradum, R.drawable.makam_ratu_api};
    int[] nama_wisata_budaya = {R.string.wisata_budaya_1, R.string.wisata_budaya_2, R.string.wisata_budaya_3, R.string.wisata_budaya_4, R.string.wisata_budaya_5,
            R.string.wisata_budaya_6, R.string.wisata_budaya_7, R.string.wisata_budaya_8, R.string.wisata_budaya_9, R.string.wisata_budaya_10,
            R.string.wisata_budaya_11, R.string.wisata_budaya_12, R.string.wisata_budaya_13, R.string.wisata_budaya_14, R.string.wisata_budaya_15,
            R.string.wisata_budaya_16, R.string.wisata_budaya_17, R.string.wisata_budaya_18, R.string.wisata_budaya_19, R.string.wisata_budaya_20,
            R.string.wisata_budaya_21, R.string.wisata_budaya_22, R.string.wisata_budaya_23, R.string.wisata_budaya_24};
    int[] sejarah_wisata_budaya = {R.string.sejarah_wisata_budaya_1, R.string.sejarah_wisata_budaya_2, R.string.sejarah_wisata_budaya_3, R.string.sejarah_wisata_budaya_4, R.string.sejarah_wisata_budaya_5,
            R.string.sejarah_wisata_budaya_6, R.string.sejarah_wisata_budaya_7,R.string.sejarah_wisata_budaya_8, R.string.sejarah_wisata_budaya_9, R.string.sejarah_wisata_budaya_10,
            R.string.sejarah_wisata_budaya_11, R.string.sejarah_wisata_budaya_12, R.string.sejarah_wisata_budaya_13, R.string.sejarah_wisata_budaya_14, R.string.sejarah_wisata_budaya_15,
            R.string.sejarah_wisata_budaya_16, R.string.sejarah_wisata_budaya_17, R.string.sejarah_wisata_budaya_18, R.string.sejarah_wisata_budaya_19, R.string.sejarah_wisata_budaya_20,
            R.string.sejarah_wisata_budaya_21, R.string.sejarah_wisata_budaya_22, R.string.sejarah_wisata_budaya_23, R.string.sejarah_wisata_budaya_24};
    int[] longitude_wisata_budaya = {R.string.long_wisata_budaya_1, R.string.long_wisata_budaya_2, R.string.long_wisata_budaya_3, R.string.long_wisata_budaya_4, R.string.long_wisata_budaya_5,
            R.string.long_wisata_budaya_6, R.string.long_wisata_budaya_7, R.string.long_wisata_budaya_8, R.string.long_wisata_budaya_9, R.string.long_wisata_budaya_10,
            R.string.long_wisata_budaya_11, R.string.long_wisata_budaya_12, R.string.long_wisata_budaya_13, R.string.long_wisata_budaya_14, R.string.long_wisata_budaya_15,
            R.string.long_wisata_budaya_16, R.string.long_wisata_budaya_17, R.string.long_wisata_budaya_18, R.string.long_wisata_budaya_19, R.string.long_wisata_budaya_20,
            R.string.long_wisata_budaya_21, R.string.long_wisata_budaya_22, R.string.long_wisata_budaya_23, R.string.long_wisata_budaya_24};
    int[] latitude_wisata_budaya = {R.string.lat_wisata_budaya_1, R.string.lat_wisata_budaya_2, R.string.lat_wisata_budaya_3, R.string.lat_wisata_budaya_4, R.string.lat_wisata_budaya_5,
            R.string.lat_wisata_budaya_6, R.string.lat_wisata_budaya_7, R.string.lat_wisata_budaya_8, R.string.lat_wisata_budaya_9, R.string.lat_wisata_budaya_10,
            R.string.lat_wisata_budaya_11, R.string.lat_wisata_budaya_12, R.string.lat_wisata_budaya_13, R.string.lat_wisata_budaya_14, R.string.lat_wisata_budaya_15,
            R.string.lat_wisata_budaya_16, R.string.lat_wisata_budaya_17, R.string.lat_wisata_budaya_18, R.string.lat_wisata_budaya_19, R.string.lat_wisata_budaya_20,
            R.string.lat_wisata_budaya_21, R.string.lat_wisata_budaya_22, R.string.lat_wisata_budaya_23, R.string.lat_wisata_budaya_24};

    int[] foto_wisata_alam = {R.drawable.sungai_kembar, R.drawable.hutan_kota, R.drawable.teluk_gelam};
    int[] nama_wisata_alam = {R.string.wisata_alam_1, R.string.wisata_alam_2, R.string.wisata_alam_3};
    int[] sejarah_wisata_alam = {R.string.sejarah_wisata_alam_1, R.string.sejarah_wisata_alam_2, R.string.sejarah_wisata_alam_3};
    int[] longitude_wisata_alam = {R.string.long_wisata_alam_1, R.string.long_wisata_alam_2, R.string.long_wisata_alam_3};
    int[] latitude_wisata_alam = {R.string.lat_wisata_alam_1, R.string.lat_wisata_alam_2, R.string.lat_wisata_alam_3};


    public DaftarWisataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;

        view = inflater.inflate(R.layout.fragment_daftar_wisata, container, false);

//        String contoh = getResources().getString(R.string.Tema);
        Bundle wisata = getArguments();
        jenis_wisata = "";

        if(wisata != null){
            jenis_wisata = wisata.getString("wisata");
        }
        else{
            jenis_wisata = "Jenis Wisata";
        }

        tvJenisWisata= view.findViewById(R.id.tv_jenis_wisata);
        tvJenisWisata.setText("Wisata "+jenis_wisata);

        myRecyclerView = view.findViewById(R.id.rv_wisata);
        myRecyclerView.setHasFixedSize(true);

        inisialisasi_list_wisata();
        LinearLayoutManager MyLinearLayoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(MyLinearLayoutManager);

        return view;
    }

    public class DaftarWisataAdapter extends RecyclerView.Adapter<DaftarWisataAdapter.DaftarWisataViewHolder>{
        private ArrayList<WisataModel> wisata_list;

        public DaftarWisataAdapter(ArrayList<WisataModel> list){
            wisata_list = list;
        }

        @NonNull
        @Override
        public DaftarWisataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daftar_wisata_item_recycle, parent, false);

            DaftarWisataViewHolder holder = new DaftarWisataViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull DaftarWisataViewHolder holder, final int position) {
            holder.ivWisata.setImageResource(wisata_list.get(position).getFoto());
            holder.tvNamaWisata.setText(wisata_list.get(position).getNama_wisata());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle sendedData = new Bundle();
                    sendedData.putString("nama_wisata",wisata_list.get(position).getNama_wisata());
                    sendedData.putString("sejarah_wisata",wisata_list.get(position).getSejarah_wisata());
                    sendedData.putDouble("longitude_wisata",wisata_list.get(position).getLongitude());
                    sendedData.putDouble("latitude_wisata",wisata_list.get(position).getLatitude());
                    sendedData.putInt("foto",wisata_list.get(position).getFoto());

                    DetailWisataFragment detailWisata = new DetailWisataFragment();
                    detailWisata.setArguments(sendedData);

                    getFragmentManager().beginTransaction().replace(R.id.container_fragment, detailWisata).addToBackStack(null).commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return wisata_list.size();
        }

        public class DaftarWisataViewHolder extends RecyclerView.ViewHolder{
            ImageView ivWisata;
            TextView tvNamaWisata;

            public DaftarWisataViewHolder(View itemView) {
                super(itemView);

                ivWisata = itemView.findViewById(R.id.iv_gambar_wisata);
                tvNamaWisata = itemView.findViewById(R.id.tv_nama_wisata);
            }
        }
    }

    private void inisialisasi_list_wisata() {
        int i;
        wisataList = new ArrayList<>();

        if(jenis_wisata.equals("Keluarga")){
            for(i=0; i<nama_wisata_keluarga.length; i++){
                WisataModel wisataModel = new WisataModel();
                wisataModel.setNama_wisata(getResources().getString(nama_wisata_keluarga[i]));
                wisataModel.setSejarah_wisata(getResources().getString(sejarah_wisata_keluarga[i]));
                wisataModel.setLongitude(Double.parseDouble(getResources().getString(longitude_wisata_keluarga[i])));
                wisataModel.setLatitude(Double.parseDouble(getResources().getString(latitude_wisata_keluarga[i])));
                wisataModel.setFoto(foto_wisata_keluarga[i]);

                wisataList.add(wisataModel);
            }

            myRecyclerView.setAdapter(new DaftarWisataAdapter(wisataList));
        }
        else if(jenis_wisata.equals("Budaya")){
            for(i=0; i<nama_wisata_budaya.length; i++){
                WisataModel wisataModel = new WisataModel();
                wisataModel.setNama_wisata(getResources().getString(nama_wisata_budaya[i]));
                wisataModel.setSejarah_wisata(getResources().getString(sejarah_wisata_budaya[i]));
                wisataModel.setLongitude(Double.parseDouble(getResources().getString(longitude_wisata_budaya[i])));
                wisataModel.setLatitude(Double.parseDouble(getResources().getString(latitude_wisata_budaya[i])));
                wisataModel.setFoto(foto_wisata_budaya[i]);

                wisataList.add(wisataModel);
            }

            myRecyclerView.setAdapter(new DaftarWisataAdapter(wisataList));
        }
        else{
            for(i=0; i<nama_wisata_alam.length; i++){
                WisataModel wisataModel = new WisataModel();
                wisataModel.setNama_wisata(getResources().getString(nama_wisata_alam[i]));
                wisataModel.setSejarah_wisata(getResources().getString(sejarah_wisata_alam[i]));
                wisataModel.setLongitude(Double.parseDouble(getResources().getString(longitude_wisata_alam[i])));
                wisataModel.setLatitude(Double.parseDouble(getResources().getString(latitude_wisata_alam[i])));
                wisataModel.setFoto(foto_wisata_alam[i]);

                wisataList.add(wisataModel);
            }

            myRecyclerView.setAdapter(new DaftarWisataAdapter(wisataList));
        }
    }
}
