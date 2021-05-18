package com.tutorial.greentreeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.content_contact.*

class ContactActivity : AppCompatActivity(), OnMapReadyCallback,
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mMap: GoogleMap

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        //Button CV
        btnCV.setOnClickListener {
            Intent(this, PdfActivity::class.java).also {
                startActivity(it)
            }
        }

        //Floating button
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Intent(this, MessageActivity::class.java).also {
                startActivity(it)
            }
        }

        //MAP
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val wroclaw = LatLng(51.125611, 16.984347)
        mMap.addMarker(MarkerOptions().position(wroclaw).title("GreenTree Company"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wroclaw))
//        mMap.setMinZoomPreference(9f)
        mMap.setMaxZoomPreference(21f)
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13f))
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_plants -> {
                val intent = Intent(this, PlantsGalleryActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_projects -> {
                val intent = Intent(this, ProjectsActivity::class.java)
                startActivity(intent)
            }
//            R.id.nav_adviser -> {
//                val intent = Intent(this, AdviserActivity::class.java)
//                startActivity(intent)
//            }
            R.id.nav_contact -> {
                val intent = Intent(this, ContactActivity::class.java)
                startActivity(intent)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}