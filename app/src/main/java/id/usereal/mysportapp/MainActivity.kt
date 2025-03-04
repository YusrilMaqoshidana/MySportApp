package id.usereal.mysportapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import dagger.hilt.android.AndroidEntryPoint
import id.usereal.mysportapp.databinding.ActivityMainBinding
import id.usereal.mysportapp.view.home.HomeFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var splitInstallManager: SplitInstallManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        splitInstallManager = SplitInstallManagerFactory.create(this)

        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_favorite -> loadFavoriteFeature()  // Load Modul Favorite Secara Dinamis
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun loadFavoriteFeature() {
        val moduleName = "favorite"
        if (splitInstallManager.installedModules.contains(moduleName)) {
            try {
                val fragmentClass =
                    Class.forName("id.usereal.mysportapp.favorite.ui.FavoriteFragment")
                val fragment = fragmentClass.getDeclaredConstructor().newInstance() as Fragment
                loadFragment(fragment)
            } catch (e: Exception) {
                Toast.makeText(this, "Gagal memuat modul Favorite", Toast.LENGTH_SHORT).show()
            }
        } else {
            val request = SplitInstallRequest.newBuilder()
                .addModule(moduleName)
                .build()

            splitInstallManager.startInstall(request)
                .addOnSuccessListener {
                    Toast.makeText(this, "Module Favorite Terinstall", Toast.LENGTH_SHORT).show()
                    loadFavoriteFeature()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Gagal Menginstall Modul Favorite", Toast.LENGTH_SHORT)
                        .show()
                }
        }
    }
}
