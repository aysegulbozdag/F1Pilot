package com.example.android.f1pilot.ui.splash

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.android.f1pilot.R
import com.example.android.f1pilot.databinding.FragmentSplashBinding
import com.example.android.f1pilot.util.base.BaseFragment
import com.example.android.f1pilot.util.orTrue
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_splash

    override val viewModel: SplashViewModel by viewModels()

    override fun onFragmentStarted() {}

    override fun onResume() {
        super.onResume()
        viewModel.isNavigation.observe(this) {
            if (it.orTrue())
                Navigation.findNavController(requireView()).navigate(R.id.f1PilotListFragment)
        }
    }
}