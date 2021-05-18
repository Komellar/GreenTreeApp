package com.tutorial.greentreeapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.tutorial.greentreeapp.adapter.DesignerAdapter
import com.tutorial.greentreeapp.adapter.PlantAdapter
import com.tutorial.greentreeapp.data.DesignersDatasource
import com.tutorial.greentreeapp.model.Plant
import kotlinx.android.synthetic.main.content_plants.*

class PlantsGalleryActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var arrayList: ArrayList<Plant>? = null
    private var plantAdapter: PlantAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plants_gallery)

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

        //Grid
        recyclerView = findViewById(R.id.plantRecyclerView)
        gridLayoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
//        arrayList = ArrayList()
        arrayList =  setDataInList()
        plantAdapter = PlantAdapter(applicationContext, arrayList!!)
        recyclerView?.adapter = plantAdapter


    }

    private fun setDataInList(): ArrayList<Plant> {
        var items: ArrayList<Plant> = ArrayList()

        items.add(Plant(R.drawable.plant1))
        items.add(Plant(R.drawable.plant10))
        items.add(Plant(R.drawable.plant3))
        items.add(Plant(R.drawable.plant4))
        items.add(Plant(R.drawable.plant5))
        items.add(Plant(R.drawable.plant6))
        items.add(Plant(R.drawable.plant7))
        items.add(Plant(R.drawable.plant8))
        items.add(Plant(R.drawable.plant9))
        items.add(Plant(R.drawable.plant2))

        return items
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