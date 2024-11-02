package com.veen.mvvmbase.utils

import android.Manifest
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.veen.mvvmbase.utils.CommonUtils.REQUEST_ID_MULTIPLE_PERMISSIONS
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

object CommonMethod {
    private var deviceId = ""

    /*This is used application permission access request in application*/
    fun checkAndRequestPermissions(context: Context, activity: Activity): Boolean {
        val camera = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CAMERA
        )
        val write = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        val read = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        val listPermissionsNeeded: MutableList<String> = ArrayList()
        if (write != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (camera != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA)
        }
        if (read != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        if (listPermissionsNeeded.isNotEmpty()) {
            ActivityCompat.requestPermissions(
                activity,
                listPermissionsNeeded.toTypedArray(),
                REQUEST_ID_MULTIPLE_PERMISSIONS
            )
            return false
        }
        deviceId = "qwerty"
        return true
    }

    /*This is for splash screen animation on Image view in application*/
    fun startLoaderAnimate(loaderImage: ImageView) {
        val objectAnimator = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                val startHeight = 170
                val newHeight = (startHeight + (startHeight + 40) * interpolatedTime).toInt()
                loaderImage.layoutParams.height = newHeight
                loaderImage.requestLayout()
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        objectAnimator.repeatCount = -1
        objectAnimator.repeatMode = ValueAnimator.REVERSE
        objectAnimator.duration = 1000
        loaderImage.startAnimation(objectAnimator)
    }

    /*Custom toast functions here*/
    fun showToast(context: Context, message: Int) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    /*This is used for while internet connection disable*/
    fun indefiniteSnack(context: Context, msg: Int): Snackbar {
        val snackbar = Snackbar.make(
            (context as Activity).findViewById(android.R.id.content),
            msg, Snackbar.LENGTH_INDEFINITE
        )
        snackbar.show()

        return snackbar
    }

    /*This is used for get current date & time in application*/
    @SuppressLint("SimpleDateFormat")
    fun getCurrentDateTime(): Any {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        return sdf.format(Date())
    }

    /*Hide Keyboard when don't need in application*/
    fun hideKeyboardFrom(context: Context, view: View) {
        val imm: InputMethodManager =
            context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}