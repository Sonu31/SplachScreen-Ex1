package com.example.splaceex1

import android.R.attr.button
import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.skyfishjy.library.RippleBackground


class SplaceScreen : AppCompatActivity() {


    var rippleBackground: RippleBackground? = null
    private var foundDevice: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace_screen)

        rippleBackground = findViewById(R.id.content)

        var handler = Handler()



        rippleBackground?.startRippleAnimation()

        Handler(Looper.getMainLooper()).postDelayed({
            foundDevice()
            startActivity(Intent(this, MainActivity::class.java))
            finish();

        }, 17000)



    }

    @SuppressLint("ObjectAnimatorBinding")
    private fun foundDevice() {
        val animatorSet = AnimatorSet()
        animatorSet.duration = 400
        animatorSet.interpolator = AccelerateDecelerateInterpolator()
        val animatorList = ArrayList<Animator>()
        val scaleXAnimator = ObjectAnimator.ofFloat(foundDevice, "ScaleX", 0f, 1.2f, 1f)
        animatorList.add(scaleXAnimator)
        val scaleYAnimator = ObjectAnimator.ofFloat(foundDevice, "ScaleY", 0f, 1.2f, 1f)
        animatorList.add(scaleYAnimator)
        animatorSet.playTogether(animatorList)
//        foundDevice!!.visibility = View.VISIBLE
        animatorSet.start()
    }
}