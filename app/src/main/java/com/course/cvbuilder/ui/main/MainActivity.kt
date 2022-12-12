package com.course.cvbuilder.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.course.cvbuilder.R
import com.course.cvbuilder.databinding.ActivityMainBinding
import com.course.cvbuilder.ui.main.SectionsPagerAdapter
 import com.course.cvbuilder.ui.main.work.AddworkListner
import edu.miu.CVBuilderApp.data.Work

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_linkedin -> {
                browseWebsite("https://www.linkedin.com/in/mahmoud-anwar-fadel/")
            }
            R.id.menu_twitter -> {
                browseWebsite("https://github.com/MahmoudAnwar613725")
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun browseWebsite(website: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(website));
        startActivity(browserIntent);
    }

}