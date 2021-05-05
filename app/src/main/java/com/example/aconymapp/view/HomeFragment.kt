package com.example.aconymapp.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.aconymapp.R
import com.example.aconymapp.databinding.FragmentHomeBinding
import com.example.aconymapp.util.ApiState
import com.example.aconymapp.viewModel.SharedViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private  val sharedVM by viewModels<SharedViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentHomeBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
            sharedViewModel  = sharedVM
        }
        sharedVM.apiState.observe(viewLifecycleOwner){ response ->
            if (response is ApiState.Success){
                val action = response.acronyms.let {
                    HomeFragmentDirections.actionHomeFragmentToAcronymListFragment()
                }
                if (action != null){
                    findNavController().navigate(action)
                }
            }else{
                Log.d("tate", "onViewCreated: else statement r something ")
            }
        }
    }

}