package xyz.pistis.squidplayer

import android.app.DownloadManager
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.exoplayer2.offline.Download
import kotlinx.android.synthetic.main.activity_main.*
import xyz.pistis.squidplayer.handlers.DataBaseHandler
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    private val STORAGE_PERMISSION_CODE: Int = 1000;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //==============================================================


        //=========================side menu=============================
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_View.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_Item1 -> Toast.makeText(applicationContext, "Clicked Item 1", Toast.LENGTH_SHORT).show()
                R.id.menu_Item2 -> Toast.makeText(applicationContext, "Clicked Item 2", Toast.LENGTH_SHORT).show()
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