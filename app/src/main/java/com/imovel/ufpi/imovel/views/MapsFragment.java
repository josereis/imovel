package com.imovel.ufpi.imovel.views;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //permite o zoom no mapa
        mMap.getUiSettings().setZoomControlsEnabled(true);


        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        LatLng imovel = new LatLng(-5.0620277,-42.7989373);
        //LatLng imovel2 = new LatLng(-5.0619693,-42.8012447);
        //LatLng sydney;
        MarkerOptions marker = new MarkerOptions();
        //MarkerOptions marker2 = new MarkerOptions();
        //marker.position(sydney);
        marker.position(imovel);
        //marker.position(imovel2);
        marker.title("Imovel");
        //marker2.title("Imovel2 lindo");
        //define o titulo do marcador quando ele eh selecionado
        mMap.addMarker(marker);
        // mMap.addMarker(marker2);
        //move a camera ate a posiçao marcada
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(imovel));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(imovel2));

    }
}

