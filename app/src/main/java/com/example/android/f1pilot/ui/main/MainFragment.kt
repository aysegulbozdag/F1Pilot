package com.example.android.f1pilot.ui.main

import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.android.f1pilot.R
import com.example.android.f1pilot.data.model.F1Pilot
import com.example.android.f1pilot.databinding.FragmentMainBinding
import com.example.android.f1pilot.util.Result
import com.example.android.f1pilot.util.base.BaseDiffUtilItemCallback
import com.example.android.f1pilot.util.base.BaseFragment
import com.example.android.f1pilot.util.custom.GenericAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, F1PilotListViewModel>() {

    private val adapter by lazy {
        GenericAdapter(
           viewModel,
            R.layout.item_f1_pilot_list,
            BaseDiffUtilItemCallback<F1Pilot>()
        ) {
            onClick { it ->
                view?.findNavController()?.navigate(R.id.detailF1PilotFragment, bundleOf("id" to it.id))
            }
        }
    }


    override fun onFragmentStarted() {
        getDataBinding().rvBank.adapter =adapter
       viewModel.f1PilotList.observe(this, Observer {
            when(it.status){
                Result.Status.SUCCESS ->{
                    hideProgress()
                    adapter.submitList(it?.data?.items)
                }
                Result.Status.ERROR -> {
                    it.message?.let {
                        Log.e("ERROR : " , it)
                    }
                    hideProgress()
                }
                Result.Status.LOADING -> showProgress()
            }

        })
    }

    override fun getLayoutId(): Int = R.layout.fragment_main
    fun getViewModel(): Class<F1PilotListViewModel> = F1PilotListViewModel::class.java
    override val viewModel: F1PilotListViewModel by viewModels()


}