package com.tutorial.greentreeapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.tutorial.greentreeapp.data.ProjectsDatasource
import kotlinx.android.synthetic.main.content_project.*
import kotlinx.android.synthetic.main.content_project.projectRating
import kotlinx.android.synthetic.main.item_project.*

class ProjectActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)

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

        // Change layout content
        val mProjectsList = ProjectsDatasource().getProjects()
        val position = intent.getIntExtra(Constants.EXTRA_PROJECT, 0)
        val myDesigner = intent.getStringExtra(Constants.EXTRA_DESIGNER)
        val project = mProjectsList[position]
        projectImage.setImageResource(project.imageResourceId)
        projectNum.text = "Projekt numer ${project.id}"
        projectDesc.text = project.description
        projectRating.text = "Ocena klienta: ${project.rating}"
        projectDesigner.text = "Projektował: ${myDesigner}"
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
//
//
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_person)
//
//    val bundle:Bundle? = intent.extras
//    val extraUser = bundle?.get("EXTRA_USER")
//    val extraImg = bundle?.get("EXTRA_IMAGE")
//    val extraDesc = bundle?.get("EXTRA_DESC")
//
//    val name = findViewById<TextView>(R.id.personName)
//    val image = findViewById<ImageView>(R.id.personImage)
//    val description = findViewById<TextView>(R.id.personDescription)
//
//    name.text = extraUser.toString()
//    image.setImageResource(extraImg.toString().toInt())
//    description.text = extraDesc.toString()
//
//}