package com.voss.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.voss.imageslider.data.ImageModel
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {
    private val imageModel: ImageModel = ImageModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager.adapter = ViewPagerAdapter(imageModel.images, imageModel.names)
        viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator: CircleIndicator3 = findViewById(R.id.indicator)
        indicator.setViewPager(viewpager)

        fake_swipe_but.setOnClickListener {
            viewpager.apply {
                beginFakeDrag()
                fakeDragBy(-100f)
                endFakeDrag()
            }

        }

    }
}