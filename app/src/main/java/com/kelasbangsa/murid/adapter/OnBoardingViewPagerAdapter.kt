package com.kelasbangsa.murid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.OnBoardingData

class OnBoardingViewPagerAdapter(
    private var context: Context,
    private var onBoardingDataList: List<OnBoardingData>) : PagerAdapter(){


    override fun getCount(): Int {
        return onBoardingDataList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view : View = LayoutInflater.from(context).inflate(R.layout.onboarding_screen_layout,null)
        val imageView : ImageView
        val title : TextView
        val desc : TextView

        //INIT VIEW
        imageView = view.findViewById(R.id.im_ilustrasi_onboarding)
        title = view.findViewById(R.id.tv_title_onboarding)
        desc = view.findViewById(R.id.tv_desc_onboarding)

        imageView.setImageResource(onBoardingDataList[position].image)
        title.text = onBoardingDataList[position].title
        desc.text = onBoardingDataList[position].desc

        container.addView(view)

        return view
    }

}