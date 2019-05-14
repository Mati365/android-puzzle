package com.example.slidepuzzle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button

class GameActivity : AppCompatActivity() {
    fun mountBoard() {
        val board = findViewById<GameBoard>(R.id.boardView)

        findViewById<Button>(R.id.shuffle).setOnClickListener {
            board.onShuffle()
        }

        findViewById<Button>(R.id.reset).setOnClickListener {
            board.onShuffle(true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fullscreen)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mountBoard()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
