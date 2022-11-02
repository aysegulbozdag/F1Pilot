package com.example.android.f1pilot.ui.detail

import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.android.f1pilot.R
import com.example.android.f1pilot.databinding.FragmentDetailF1PilotBinding
import com.example.android.f1pilot.util.base.BaseFragment


class DetailF1PilotFragment : BaseFragment<FragmentDetailF1PilotBinding, F1PilotDetailViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_detail_f1_pilot
    override val viewModel: F1PilotDetailViewModel by viewModels()
    private val args: DetailF1PilotFragmentArgs by navArgs()

    override fun onFragmentStarted() {
       /* val window: Window = requireActivity().window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.navy)*/
    }




}