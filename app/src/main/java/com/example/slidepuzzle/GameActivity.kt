package com.example.slidepuzzle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import com.example.slidepuzzle.ui.game.GameBoard

class GameActivity : AppCompatActivity() {
    private fun mountBoard() {
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

        setContentView(R.layout.game_activity)
        setActionBar(findViewById(R.id.board_options_toolbar))

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
