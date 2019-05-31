package com.dongkesoft.testeleroute

import android.app.Application
import com.scwang.smartrefresh.header.MaterialHeader
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.footer.ClassicsFooter

class App : Application() {

    init {

        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater { context, layout ->
            layout.setPrimaryColors(R.color.colorPrimary, android.R.color.white)
            MaterialHeader(context)
        }

        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater { context, layout ->
            ClassicsFooter(context).setSpinnerStyle(
                SpinnerStyle.Translate
            )
        }


    }

}