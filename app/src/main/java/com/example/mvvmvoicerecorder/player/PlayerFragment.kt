package com.example.mvvmvoicerecorder.player

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.example.mvvmvoicerecorder.R
import com.example.mvvmvoicerecorder.databinding.PlayerFragmentBinding

class PlayerFragment : DialogFragment() {
    private var _binding: PlayerFragmentBinding? = null
    private val mBinding get() = _binding!!


    private lateinit var viewModel: PlayerViewModel
    private var itemPath: String? = null

    companion object {
        private const val ARG_ITEM_PATH = "recording_item_path"

    }

    fun newInstance(itemPath: String?):PlayerFragment{
        val f = PlayerFragment()
        val b = Bundle()
        b.putString(ARG_ITEM_PATH, itemPath)

        f.arguments = b
        return f
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PlayerFragmentBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        itemPath = arguments?.getString(PlayerFragment.ARG_ITEM_PATH)

        mBinding.playerView.showTimeoutMs = 0

        val application = requireNotNull(this.activity).application
        val viewModelFactory = itemPath?.let { PlayerViewModelFactory(it, application) }

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PlayerViewModel::class.java)

        viewModel.itemPath = itemPath
        viewModel.player.observe(viewLifecycleOwner, Observer {
            mBinding.playerView.player = it
        })
    }

}









