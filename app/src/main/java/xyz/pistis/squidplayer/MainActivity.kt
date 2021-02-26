package xyz.pistis.squidplayer

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import xyz.pistis.squidplayer.fragments.Fragment_home
import xyz.pistis.squidplayer.fragments.Fragment_main


class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    private val STORAGE_PERMISSION_CODE: Int = 1000;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = Fragment_main()
        val fragmentB = Fragment_home()

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentA).commit()

        //==============================================================


        //=========================side menu=============================
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_View.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_Item1 -> {
                    drawerLayout.closeDrawer(GravityCompat.START)// drawer close
//                    Toast.makeText(applicationContext, "Clicked Item 1", Toast.LENGTH_SHORT).show()

                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentB).commit()
                }
                R.id.menu_Item2 -> {
                    drawerLayout.closeDrawer(GravityCompat.START)// drawer close
//                    Toast.makeText(applicationContext, "Clicked Item 1", Toast.LENGTH_SHORT).show()

                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentA).commit()
                }
                R.id.menu_Item3 -> Toast.makeText(applicationContext, "Clicked Item 3", Toast.LENGTH_SHORT).show()
            }
            true
        }
        //===============================================================
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {//side menu
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}