package net.farid.ict602project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Vector;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    MarkerOptions marker;
    LatLng center;

    Vector<MarkerOptions> markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        center = new LatLng(3.0, 101);

        markerOptions = new Vector<>();

        markerOptions.add(new MarkerOptions().title("Hospital Kuala Kubu Bharu")
                .position(new LatLng(3.5643738024874527,101.6530844255112))
                .snippet("Operation Hours: 24Hours")
        );
        markerOptions.add(new MarkerOptions().title("Hospital Selayang")
                .position(new LatLng(3.243407753979876,101.64678039667591))
                .snippet("Operation Hours: 24Hours")
        );
        markerOptions.add(new MarkerOptions().title("Hospital UiTM Puncak Alam")
                .position(new LatLng(3.2119201761172747,101.45023897521304))
                .snippet("Operation Hours: 24Hours")
        );
        markerOptions.add(new MarkerOptions().title("Hospital Sungai Buloh")
                .position(new LatLng(3.2198621594647974,101.58320982551139))
                .snippet("Operation Hours: 24hours")
        );
        markerOptions.add(new MarkerOptions().title("Klinik Medivron Jeram")
                .position(new LatLng(3.2641280642253485,101.30822312722964))
                .snippet("Operation Hours: 16hours")
        );
        markerOptions.add(new MarkerOptions().title("Columbia Asia Hospital- Klang")
                .position(new LatLng(3.1389104143921527,101.45021813813892))
                .snippet("Operation Hours: 24Hours")
        );
        markerOptions.add(new MarkerOptions().title("USIM Hospital")
                .position(new LatLng(2.8349735262668894,101.7849255491584))
                .snippet("Operation Hours: 24Hours")
        );
        markerOptions.add(new MarkerOptions().title("Hospital Kepala Batas")
                .position(new LatLng(5.512902797119672,100.43651925250076))
                .snippet("Operation Hours: 24Hours")
        );
        markerOptions.add(new MarkerOptions().title("Penang General Hospital")
                .position(new LatLng(5.417254333523842,100.31147035434802))
                .snippet("Operation Hours: 24Hours")
        );
        markerOptions.add(new MarkerOptions().title("Tapah Hospital")
                .position(new LatLng(4.260105992530227,101.24586921869923))
                .snippet("Operation Hours: 24Hours")
        );
        markerOptions.add(new MarkerOptions().title("Hospital Kuala Lumpur")
                .position(new LatLng(3.175392350787756,101.69131809707922))
                .snippet("Operation Hours: 24Hours")
        );
        markerOptions.add(new MarkerOptions().title("Hospital Kajang")
                .position(new LatLng(2.993057139248723,101.79275996599324)) 
                .snippet("Operation Hours: 24Hours")
        );
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

        // Add a marker in Sydney and move the camera
        // LatLng sydney = new LatLng(-34, 151);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        for (MarkerOptions mark : markerOptions){
            mMap.addMarker(mark);
        }
        enableMyLocation();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center,8));
    }
    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            String perms[] = {"android.permission.ACCESS_FINE_LOCATION"};
            // Permission to access the location is missing. Show rationale and request permission
            ActivityCompat.requestPermissions(this,perms,200);
        }
    }
}