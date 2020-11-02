package com.example.diffutilexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.diffutilexample.view.SimpleDiffUtilExampleFragment

class MainActivity : AppCompatActivity() {

    private val currentFragment: BaseFragment? = supportFragmentManager.findFragmentById(R.id.container) as? BaseFragment //supportFragmentManager.findFragmentById(R.id.container) as? BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, SimpleDiffUtilExampleFragment(), SimpleDiffUtilExampleFragment::class.java.canonicalName)
            .addToBackStack(SimpleDiffUtilExampleFragment::class.java.canonicalName)
            .commit();
        supportActionBar?.title = "Transaction"
        supportFragmentManager.addOnBackStackChangedListener {
            //manageToolBar(currentFragment)
        }
    }

    private fun manageToolBar(fragment: BaseFragment?){
        fragment?.let {
            supportActionBar?.title = it.provideScreenTitle()
        }
    }
}