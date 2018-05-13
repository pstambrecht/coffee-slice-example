/*
 *  Copyright (C) 2018 Bc. Pavel Stambrecht - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Pavel Stambrecht
 * /
 */

package cz.stambrecht.slicesexample

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO Use Kotlin Extensions
        findViewById<View>(R.id.button_open).setOnClickListener {
            try {
                startActivity(Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("slice-content://cz.stambrecht.slicesexample/coffee")
                })
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "You need to have installed Slice Viewer App", Toast.LENGTH_LONG).show()
            }
        }
    }
}
