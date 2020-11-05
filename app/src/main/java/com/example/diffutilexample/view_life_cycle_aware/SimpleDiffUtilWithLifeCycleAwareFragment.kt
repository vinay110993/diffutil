package com.example.diffutilexample.view_life_cycle_aware

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutilexample.BaseFragment
import com.example.diffutilexample.DiffUtilViewModel
import com.example.diffutilexample.R
import com.example.diffutilexample.databinding.SimpleDiffUtilExampleLayoutBinding

class SimpleDiffUtilWithLifeCycleAwareFragment: BaseFragment() {

    private val viewModel= DiffUtilViewModel()

    private val adapter: SimpleDiffUtilWithLifeCycleAwareAdapter by lazy {
        SimpleDiffUtilWithLifeCycleAwareAdapter(object: SimpleDiffUtilWithLifeCycleAwareAdapter.ViewClick{
            override fun onFavButtonClick(): LiveData<Boolean> {
                return viewModel.favButtonClickedObserver()
            }
        } )
    }

    private var binding: SimpleDiffUtilExampleLayoutBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_simple_diff_example_layout, container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(context)
        binding?.recyclerView?.adapter = adapter

        viewModel.getList()
        viewModel.listLiveDataObserver().observe(viewLifecycleOwner, Observer {
            adapter.updateItems(it)
        })

        binding?.fab?.setOnClickListener {
            viewModel.addItem()
        }
    }

    override fun provideScreenTitle() = "Simple Diff CallBack LCA Example"
}