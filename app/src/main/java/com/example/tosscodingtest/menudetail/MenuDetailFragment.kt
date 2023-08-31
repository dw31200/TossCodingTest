package com.example.tosscodingtest.menudetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.tosscodingtest.R
import com.example.tosscodingtest.data.model.Caffeine
import com.example.tosscodingtest.data.model.IceSize
import com.example.tosscodingtest.data.model.Temp
import com.example.tosscodingtest.databinding.FragmentMenuDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuDetailFragment : Fragment() {
    private var _binding: FragmentMenuDetailBinding? = null
    private val binding
        get() = _binding!!
    private val viewModel: MenuDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentMenuDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = this@MenuDetailFragment
        binding.menuDetailTempCheckGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.hot_button -> viewModel.checkTemp(Temp.HOT)
                R.id.ice_button -> viewModel.checkTemp(Temp.ICE)
            }
        }
        binding.menuDetailCaffeineCheckGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.caffeine_button -> viewModel.checkCaffeine(Caffeine.CAFFEINE)
                R.id.decaffeine_button -> viewModel.checkCaffeine(Caffeine.DECAFFEINE)
            }
        }
        binding.menuDetailIceCheckGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.ice_small_button -> viewModel.checkIceSize(IceSize.SMALL)
                R.id.ice_medium_button -> viewModel.checkIceSize(IceSize.MEDIUM)
                R.id.ice_large_button -> viewModel.checkIceSize(IceSize.LARGE)
            }
        }
        binding.selectButton.setOnClickListener {
            lifecycleScope.launch {
                viewModel.setMenuItem()
            }
            navigateToCheck(viewModel.id)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun navigateToCheck(menuItem: Int) {
        val action = MenuDetailFragmentDirections.actionMenuDetailFragmentToMenuCheckFragment(menuItem)
        findNavController().navigate(action)
    }
}
