package com.cointest.coindiscophilie.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cointest.coindiscophilie.R


class MainActivity : AppCompatActivity() {

    //region - AppCompatActivity Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //endregion

}