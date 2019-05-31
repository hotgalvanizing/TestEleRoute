package com.dongkesoft.testeleroute

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val titles = mutableListOf("全部", "卤味", "麻辣小吃", "精品蛋糕", "水果", "咖啡", "奶茶果汁", "面包", "牛奶")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "下午茶"
        toolbar.setNavigationIcon(R.mipmap.ic_back)
        setSupportActionBar(toolbar)

        viewPager.adapter = MyViewPagerAdapter(titles, supportFragmentManager)
        tabLayout.setViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home_serach, menu)
        return true
    }
}

class MyViewPagerAdapter(
    private val titles: MutableList<String>,
    fm: FragmentManager
) : FragmentPagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment {
        val fragment = TestFragment()
        val arguments = Bundle()
        arguments.putInt("position", p0)
        fragment.arguments = arguments
        return fragment
    }

    override fun getCount(): Int {
        return titles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

}
