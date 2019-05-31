package com.dongkesoft.testeleroute

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jay.widget.StickyHeadersLinearLayoutManager
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import kotlinx.android.synthetic.main.fragment_test.*

class TestFragment : Fragment() {

    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        position = arguments?.getInt("position") ?: 0
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = StickyHeadersLinearLayoutManager<TestAdapter>(activity)

        recycler_view.layoutManager = layoutManager
        val adapter = TestAdapter(position == 0)
        recycler_view.adapter = adapter

        refreshLayout.setOnRefreshListener { refreshlayout -> refreshlayout.finishRefresh(1500) }

        refreshLayout.setOnLoadmoreListener { refreshlayout -> refreshlayout.finishLoadmore(1500) }
    }




}