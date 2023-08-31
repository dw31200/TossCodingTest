package com.example.tosscodingtest.menucheck

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tosscodingtest.databinding.FragmentMenuCheckBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuCheckFragment : Fragment() {
    private var _binding: FragmentMenuCheckBinding? = null
    private val binding
        get() = _binding!!
    private val viewModel: MenuCheckViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentMenuCheckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = this@MenuCheckFragment
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
