package com.example.hashgeneratorapp

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.hashgeneratorapp.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private val homeViewModel : HomeViewModel by viewModels()
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onResume() {
        super.onResume()
        val hashAlogrithms = resources.getStringArray(R.array.hash_algorithms)
        var adapter = ArrayAdapter(requireContext(),R.layout.drop_down_item,hashAlogrithms)
        binding.autoCompleteTextView.setAdapter(adapter)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)


        binding.generateBtn.setOnClickListener {
            onGenerateClicked()
        }
        return binding.root
    }

    private fun getHashData() : String{
        val algorithm = binding.autoCompleteTextView.text.toString()
        val plainText = binding.plainText.text.toString()
        return homeViewModel.getHash(plainText, algorithm)

    }

    fun onGenerateClicked(){
        if (binding.plainText.text.isEmpty()){
            showSnackBar("Filed Empty!")
        }else{
            lifecycleScope.launch {
                applyAnimation()
                navigateToSuccess(getHashData())
            }
        }

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.clear_menu){
            binding.plainText.text.clear()
            showSnackBar("Clear...")
            return true
        }
        return true
    }
    private suspend fun applyAnimation(){
        binding.generateBtn.isClickable = false // do anima chỉ ẩn btn đi chứ vẫn ấn được, nếu k để = false sẽ bị crash app
        binding.titleTextView.animate().alpha(0f).duration = 400L
        binding.generateBtn.animate().alpha(0f).duration = 400L
        binding.textInputLayout.animate()
            .alpha(0f)
            .translationXBy(1200f) // trượt theo chiều rộng X về bên phải
            .duration = 400L

        binding.plainText.animate()
            .alpha(0f)
            .translationXBy(-1200f) // trượt về bên trái
            .duration = 400L

        delay(300)

        binding.successBackground.animate().alpha(1f).duration = 600L // hiện lên
        binding.successBackground.animate().rotationBy(720f).duration = 600L // quay
        binding.successBackground.animate().scaleXBy(900f).duration = 800L // phóng to theo chiều X
        binding.successBackground.animate().scaleYBy(900f).duration = 800L // phóng to theo chiều Y

        delay(500)
        binding.successImageView.animate().alpha(1f).duration = 1000L

        // delay trước khi bật frgment success
        delay(1500)

    }

    private fun navigateToSuccess(hash : String){
        val directions = HomeFragmentDirections.actionHomeFragmentToSuccessFragment(hash)
        findNavController().navigate(directions)
    }

    private fun showSnackBar(message : String){
        var snackBar = Snackbar.make(binding.rootLayout, message, Snackbar.LENGTH_SHORT)
        snackBar.setAction("OK"){

        }
        snackBar.setActionTextColor(ContextCompat.getColor(requireContext(),R.color.blue))
        snackBar.show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}