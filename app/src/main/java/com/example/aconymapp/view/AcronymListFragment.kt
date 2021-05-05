package com.example.aconymapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.aconymapp.R
import com.example.aconymapp.adapters.AcronymAdapter
import com.example.aconymapp.databinding.AcronymListFragmentBinding

class AcronymListFragment: Fragment(R.layout.acronym_list_fragment) {
    private val args: AcronymListFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AcronymListFragmentBinding.bind(view).apply {
            acronymRv.adapter = AcronymAdapter(args.acronyms)
        }
    }



}