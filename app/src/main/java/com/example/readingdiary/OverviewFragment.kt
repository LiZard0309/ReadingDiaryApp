package com.example.readingdiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class OverviewFragment : Fragment() {
    private lateinit var tabLayout: TabLayout
    private lateinit var childNavController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_overview, container, false)

        tabLayout = view.findViewById(R.id.tabLayout)

        val childFragment = childFragmentManager.findFragmentById(R.id.childNavHostFragment)
        childNavController = NavHostFragment.findNavController(childFragment!!)

        setupTabNavigation()

        return view
    }

    private fun setupTabNavigation() {
        tabLayout.addTab(tabLayout.newTab().setText("Search Books"))
        tabLayout.addTab(tabLayout.newTab().setText("Already Read"))
        tabLayout.addTab(tabLayout.newTab().setText("Wishlist"))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> childNavController.navigate(R.id.bookSearchListFragment)
                    1 -> childNavController.navigate(R.id.readListFragment)
                    2 -> childNavController.navigate(R.id.wishListFragment)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }
}