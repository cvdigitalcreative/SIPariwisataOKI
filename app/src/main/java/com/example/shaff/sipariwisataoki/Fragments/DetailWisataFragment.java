package com.example.shaff.sipariwisataoki.Fragments;


import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaff.sipariwisataoki.R;
import com.google.android.gms.maps.model.LatLng;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailWisataFragment extends Fragment {
    TextView tvNamaWisata, tvSejarahWisata;
    ImageView ivFotoWisata;
    Button btnMap;
    private LatLng latLng;

    public DetailWisataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;

        view = inflater.inflate(R.layout.fragment_detail_wisata, container, false);

        tvNamaWisata = view.findViewById(R.id.tv_nama_wisata_detail);
        tvSejarahWisata = view.findViewById(R.id.tv_sejarah_wisata_detail);
        ivFotoWisata = view.findViewById(R.id.iv_gambar_wisata_detail);
        btnMap = view.findViewById(R.id.btn_wisata_detail);

        Bundle receivedData = getArguments();
        final String nama_wisata = receivedData.getString("nama_wisata");
        String sejarah_wisata = receivedData.getString("sejarah_wisata");
        int foto = receivedData.getInt("foto");
        final double longitude_wisata = receivedData.getDouble("longitude_wisata");
        final double latitude_wisata = receivedData.getDouble("latitude_wisata");

        tvNamaWisata.setText(nama_wisata);
        tvSejarahWisata.setText(sejarah_wisata);
        ivFotoWisata.setImageResource(foto);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle sendedData = new Bundle();
                sendedData.putString("nama_wisata",nama_wisata);
                sendedData.putDouble("longitude_target",longitude_wisata);
                sendedData.putDouble("latitude_target",latitude_wisata);
                sendedData.putDouble("longitude",latLng.longitude);
                sendedData.putDouble("latitude",latLng.latitude);

                MapFragment map= new MapFragment();
                map.setArguments(sendedData);

                getFragmentManager().beginTransaction().replace(R.id.container_fragment, map).addToBackStack(null).commit();
            }
        });

        if (GPSPremissionCheck(getContext())) {
            latLng = getCurrentLocation(getContext());
        }else{
            Toast.makeText(getContext(), "GPS Denied",Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    public LatLng getCurrentLocation(Context context) {
        try {
            LocationManager locMgr = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            String locProvider = locMgr.getBestProvider(criteria, false);
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            }
            Location location = locMgr.getLastKnownLocation(locProvider);

            // getting GPS status
            boolean isGPSEnabled = locMgr.isProviderEnabled(LocationManager.GPS_PROVIDER);
            // getting network status
            boolean isNWEnabled = locMgr.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNWEnabled)
            {
                // no network provider is enabled
                return null;
            }
            else
            {
                // First get location from Network Provider
                if (isNWEnabled)
                    if (locMgr != null)
                        location = locMgr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled)
                    if (location == null)
                        if (locMgr != null)
                            location = locMgr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }

            return new LatLng(location.getLatitude(), location.getLongitude());
        }
        catch (NullPointerException ne)
        {
            Log.e("Current Location", "Current Lat Lng is Null");
            return new LatLng(0, 0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new LatLng(0, 0);
        }
    }

    public static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 123;

    public boolean GPSPremissionCheck(final Context context) {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context,
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        (Activity) context,
                        Manifest.permission.ACCESS_FINE_LOCATION)) {
                    showDialog("External storage", context,
                            Manifest.permission.ACCESS_FINE_LOCATION);

                } else {
                    ActivityCompat
                            .requestPermissions(
                                    (Activity) context,
                                    new String[] { Manifest.permission.ACCESS_FINE_LOCATION },
                                    MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
                }
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public void showDialog(final String msg, final Context context,
                           final String permission) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
        alertBuilder.setCancelable(true);
        alertBuilder.setTitle("Permission necessary");
        alertBuilder.setMessage(msg + " permission is necessary");
        alertBuilder.setPositiveButton(android.R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions((Activity) context,
                                new String[] { permission },
                                MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
                    }
                });
        AlertDialog alert = alertBuilder.create();
        alert.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // do your stuff
                } else {
                    Toast.makeText(getContext(), "GPS Denied",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions,
                        grantResults);
        }
    }
}
