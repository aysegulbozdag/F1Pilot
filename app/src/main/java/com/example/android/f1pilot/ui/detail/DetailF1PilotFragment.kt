package com.example.android.f1pilot.ui.detail

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.android.f1pilot.R
import com.example.android.f1pilot.databinding.FragmentDetailF1PilotBinding
import com.example.android.f1pilot.util.Result
import com.example.android.f1pilot.util.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailF1PilotFragment : BaseFragment<FragmentDetailF1PilotBinding, F1PilotDetailViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_detail_f1_pilot
    override val viewModel: F1PilotDetailViewModel by viewModels()
    private val args: DetailF1PilotFragmentArgs by navArgs()

    override fun onFragmentStarted() {

        viewModel.getDetail(args.id)
        initObserve()

    }

    private fun initObserve(){
        viewModel.f1PilotDetail.observe(this) { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    getDataBinding().model = result.data
                    hideProgress()
                }
                Result.Status.ERROR -> {
                    result.message?.let {
                        Log.e("ERROR : ", it)
                    }
                    hideProgress()
                }
                Result.Status.LOADING -> showProgress()
            }
        }
    }
}