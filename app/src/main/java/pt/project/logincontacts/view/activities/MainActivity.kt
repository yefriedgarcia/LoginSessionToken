package pt.project.logincontacts.view.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.navigation.NavController
import dagger.hilt.android.AndroidEntryPoint
import pt.project.logincontacts.R
import pt.project.logincontacts.database.preferences.LoginPreferences
import pt.project.logincontacts.view.fragments.login.Login

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userPreferences = LoginPreferences(this)

        userPreferences.token.asLiveData().observe(this, Observer {
            Toast.makeText(this, it ?: "Token is null", Toast.LENGTH_SHORT).show()
            openFragment()
        })
    }

    private fun openFragment(){
        val loginFragment = Login()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, loginFragment)
        transaction.commit()
    }
}