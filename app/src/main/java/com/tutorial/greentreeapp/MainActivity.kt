package com.tutorial.greentreeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator
import com.tutorial.greentreeapp.adapter.DesignerAdapter
import com.tutorial.greentreeapp.data.DesignersDatasource
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_main.designersViewPager
import kotlinx.android.synthetic.main.content_main.toolbar


class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        //Carousel with designers
        val myDataset = DesignersDatasource().loadDesigners()
        val adapter = DesignerAdapter(this, myDataset)
        designersViewPager.adapter = adapter

//        TabLayoutMediator(designersTabLayout, designersViewPager) { tab, position ->
//            tab.text = "Tab ${position + 1}"
//        }.attach()

        TabLayoutMediator(designersTabLayout, designersViewPager) { tab, position ->
            tab.text = DesignersDatasource().designerName[position]
        }.attach()

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