package com.example.testkoinmvvm.fragments.home

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testkoinmvvm.R
import com.example.testkoinmvvm.activities.main.MainActivity
import com.example.testkoinmvvm.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.activity_main.*


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainActivity.main_bottom_navigation.visibility = View.VISIBLE
        binding.homeBtNavigate.setOnClickListener {
            val args = Bundle()
            args.putString("passed_string", binding.homeTvString.text.toString())
            mainActivity.navController.navigate(R.id.action_homeFragment_to_detailsFragment, args)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}
