package com.example.mvvmvoicerecorder.recordsList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmvoicerecorder.R
import com.example.mvvmvoicerecorder.database.RecordDatabase
import com.example.mvvmvoicerecorder.databinding.FragmentListRecordBinding

class ListRecordFragment : Fragment() {

    private var _binding: FragmentListRecordBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListRecordBinding.inflate(layoutInflater, container, false)
        val binding: FragmentListRecordBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list_record, container, false
        )
        val application = requireNotNull(this.activity).application

        val dataSource = RecordDatabase.getInstance(application).recordDao
        val viewModelFactory = ListRecordViewModelFactory(dataSource)

        val listRecordViewModel = ViewModelProviders.of(
            this, viewModelFactory).get(ListRecordViewModel::class.java)

        mBinding.listRecordViewModel = listRecordViewModel

        val adapter = ListRecordAdapter()
        mBinding.recyclerView.adapter = adapter

        listRecordViewModel.records.observe(viewLifecycleOwner, Observer {
            it?.let { adapter.data = it }
        })

        binding.lifecycleOwner = this

        return mBinding.root
    }

}