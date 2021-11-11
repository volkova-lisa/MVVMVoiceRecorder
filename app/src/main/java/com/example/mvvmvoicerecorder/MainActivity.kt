package com.example.mvvmvoicerecorder

import android.app.ActivityManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.mvvmvoicerecorder.R
import com.example.mvvmvoicerecorder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        NavigationUI.setupWithNavController(mBinding.bottomNavigation,
            Navigation.findNavController(this, R.id.nav_host_fragment))
    }

    fun isServiceRunning(): Boolean {
        val  manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Int.MAX_VALUE)) {
            if ("com.example.mvvmvoicerecorder.record.RecordService" == service.service.className) {
                return true
            }
        }
        return false
    }
}
