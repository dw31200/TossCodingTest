package com.example.tosscodingtest.menulist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tosscodingtest.databinding.FragmentMenuListBinding
import com.example.tosscodingtest.menulist.adapter.MenuListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuListFragment : Fragment(), MenuNavigation {
    private var _binding: FragmentMenuListBinding? = null
    private val binding
        get() = _binding!!
    private val viewModel: MenuListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentMenuListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = this@MenuListFragment
        binding.navigation = this@MenuListFragment
        binding.menuList.adapter = MenuListAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun navigateToDetail(menuItem: Int) {
        val action = MenuListFragmentDirections.actionMenuListFragmentToMenuDetailFragment(menuItem)
        findNavController().navigate(action)
    }
}
