package com.example.amazonbeginner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonbeginner.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var phoneProducts:ArrayList<Product>
    private lateinit var tvProduct: ArrayList<Product>
    private lateinit var laptopProducts: ArrayList<Product>

    private lateinit var allProduct: ArrayList<ArrayList<Product>>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        allProduct = ArrayList()

        binding.tabLayoutMain.addTab(binding.tabLayoutMain.newTab().setText("Phone"))
        binding.tabLayoutMain.addTab(binding.tabLayoutMain.newTab().setText("TV"))
        binding.tabLayoutMain.addTab(binding.tabLayoutMain.newTab().setText("Laptop"))

        phoneProducts = addPhones()
        tvProduct = addTVs()
        laptopProducts = addLaptops()

        allProduct.add(phoneProducts)
        allProduct.add(tvProduct)
        allProduct.add(laptopProducts)

        binding.rvMain.adapter = setAdapter(phoneProducts)
        binding.rvMain.layoutManager= GridLayoutManager(this,2)

        binding.tabLayoutMain.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null){
                    binding.rvMain.adapter = setAdapter(allProduct[tab.position])
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                if (tab != null){
                    binding.rvMain.adapter = setAdapter(allProduct[tab.position])
                }
            }
        })

    }

    private fun setAdapter(products: ArrayList<Product>):ProductAdapter{
        return ProductAdapter(products)
    }

    private fun addLaptops(): ArrayList<Product> {
        return ArrayList<Product>().apply {
            for (i in 0..11){
                this.add(Product("MacBook Pro", "Laptop","https://cdn.mos.cms.futurecdn.net/GfinEMFXnT42BFxAcDc2rA.jpg"))

            }
        }
    }


    private fun addPhones(): ArrayList<Product> {
        return ArrayList<Product>().apply {
            for (i in 0..11){
                this.add(Product("iPhone 8 Plus", "Telephone",
                    "https://www.apple.com/newsroom/images/r8-landing-page-tiles/iPhone8-iPhone8PLUS-Special-Edition_LP_hero.jpg.og.jpg"))

            }
        }
    }

    private fun addTVs(): ArrayList<Product> {
        return ArrayList<Product>().apply {
            for (i in 0..11){
                this.add(Product("Apple_Tv", "Tv",
                    "https://cdn.pocket-lint.com/r/s/1200x/assets/images/156947-tv-review-apple-tv-4k-review-web-story-image6-kfj67p3b0x.jpg"))

            }
        }
    }


}