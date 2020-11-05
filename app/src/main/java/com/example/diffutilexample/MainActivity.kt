package com.example.diffutilexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.diffutilexample.view.SimpleDiffUtilExampleFragment
import com.example.diffutilexample.view_life_cycle_aware.SimpleDiffUtilWithLifeCycleAwareFragment

class MainActivity : AppCompatActivity() {

    private fun getCurrentFragment(): BaseFragment? = supportFragmentManager.findFragmentById(R.id.container) as? BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, SimpleDiffUtilWithLifeCycleAwareFragment(), SimpleDiffUtilWithLifeCycleAwareFragment::class.java.canonicalName)
            .addToBackStack(SimpleDiffUtilWithLifeCycleAwareFragment::class.java.canonicalName)
            .commit();

        supportFragmentManager.addOnBackStackChangedListener {
            manageToolBar(getCurrentFragment())
        }
    }

    private fun manageToolBar(fragment: BaseFragment?){
        fragment?.let {
            supportActionBar?.title = it.provideScreenTitle()
        }
    }
}