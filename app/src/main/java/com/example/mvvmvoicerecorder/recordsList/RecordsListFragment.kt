package com.example.mvvmvoicerecorder.recordsList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvmvoicerecorder.R
import com.example.mvvmvoicerecorder.databinding.FragmentRecordsListBinding

class RecordsListFragment : Fragment() {

    private var _binding: FragmentRecordsListBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecordsListBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

}