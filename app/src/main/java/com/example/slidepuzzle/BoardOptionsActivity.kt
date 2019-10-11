package com.example.slidepuzzle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.slidepuzzle.ui.boardoptions.BoardOptionsFragment

class BoardOptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.board_options_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BoardOptionsFragment.newInstance())
                .commitNow()
        }
    }

}
