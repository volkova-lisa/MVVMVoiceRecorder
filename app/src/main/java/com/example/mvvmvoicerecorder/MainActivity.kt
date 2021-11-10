package com.example.mvvmvoicerecorder

import android.app.ActivityManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.mvvmvoicerecorder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    val mBinding get() = _binding!!
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)
        mBinding.bottomNavigationView.setupWithNavController(navController)
        mBinding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.list_menu -> navController.navigate(R.id.action_recordFragment_to_listRecordFragment)
                R.id.record_menu -> navController.navigate(R.id.action_listRecordFragment_to_recordFragment)
            }
            true
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_container, fragment)
            transaction.commit()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun isServiceRunning(): Boolean {
        val manager = getSystemService(Context.ACTIVITY_SERVICE) as
                ActivityManager
        for (service in manager.getRunningServices(Int.MAX_VALUE)) {
            if ("info.fandroid.voicerecorder.record.RecordService" ==
                service.service.className
            ) {
                return true
            }
        }
        return false
    }
}