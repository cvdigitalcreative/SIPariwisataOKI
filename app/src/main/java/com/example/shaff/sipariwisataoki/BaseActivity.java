package com.example.shaff.sipariwisataoki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shaff.sipariwisataoki.Fragments.HalamanMasukFragment;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        HalamanMasukFragment halamanMasuk = new HalamanMasukFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container_fragment, halamanMasuk).commit();
    }
}
