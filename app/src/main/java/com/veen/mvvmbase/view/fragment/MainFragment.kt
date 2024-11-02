package com.veen.mvvmbase.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.veen.mvvmbase.base.BaseFragment
import com.veen.mvvmbase.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMainBinding
        get() = FragmentMainBinding::inflate

}