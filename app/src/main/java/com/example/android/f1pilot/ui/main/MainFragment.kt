package com.example.android.f1pilot.ui.main

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.navigation.Navigation
import com.example.android.f1pilot.R
import com.example.android.f1pilot.R.id.action_f1PilotListFragment_to_detailF1PilotFragment
import com.example.android.f1pilot.data.model.F1Pilot
import com.example.android.f1pilot.databinding.FragmentMainBinding
import com.example.android.f1pilot.ui.detail.DetailF1PilotFragment
import com.example.android.f1pilot.ui.detail.DetailF1PilotFragmentArgs
import com.example.android.f1pilot.util.custom.GenericAdapter
import com.example.android.f1pilot.util.base.BaseDiffUtilItemCallback
import com.example.android.f1pilot.util.base.BaseFragment
import com.example.android.f1pilot.util.Result
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
               /* Navigation.findNavController(requireView()).navigate(
                    action_f1PilotListFragment_to_detailF1PilotFragment, DetailF1PilotFragmentArgs(it.id).toBundle())*/
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