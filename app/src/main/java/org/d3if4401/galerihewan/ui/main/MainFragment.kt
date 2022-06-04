package org.d3if4401.galerihewan.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if4401.galerihewan.model.Hewan
import org.d3if4401.galerihewan.R
import org.d3if4401.galerihewan.databinding.FragmentMainBinding
import org.d3if4401.galerihewan.network.ApiStatus
import kotlin.reflect.KProperty

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private lateinit var binding: FragmentMainBinding
    private lateinit var myAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        myAdapter = MainAdapter();
        with(binding.recyclerView) {
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    RecyclerView.VERTICAL
                )
            )
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return binding.root
        Log.i("MainFragment", "onCreateView dijalankan")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getData().observe(viewLifecycleOwner, {
            myAdapter.updateData(it)
        })
        viewModel.getStatus().observe(viewLifecycleOwner, {
            updateProgress(it)
        })
        Log.i("MainFragment", "onViewCreated dijalankan")
    }

    private fun updateProgress(status: ApiStatus) {
        when (status) {
            ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }ApiStatus.SUCCESS -> {
            binding.progressBar.visibility = View.GONE
        }
            ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("MainFragment", "onAttach dijalankan")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainFragment", "onResume dijalankan")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainFragment", "onPause dijalankan")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainFragment", "onStop dijalankan")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("MainFragment", "onDestroyView dijalankan")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainFragment", "onDestroy dijalankan")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("MainFragment", "onDetach dijalankan")
    }
}