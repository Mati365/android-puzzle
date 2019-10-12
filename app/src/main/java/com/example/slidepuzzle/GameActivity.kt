package com.example.slidepuzzle

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Size
import android.view.MenuItem
import android.widget.Button
import com.example.slidepuzzle.ui.boardoptions.BoardOptionsViewModel
import com.example.slidepuzzle.ui.boardoptions.BoardTitledSize
import com.example.slidepuzzle.ui.game.GameBoard

data class BoardActivityParams(val bitmap: Bitmap, val size: BoardTitledSize)

class GameActivity : AppCompatActivity() {
    companion object {
        lateinit var initialConfig: BoardActivityParams
    }

    private val viewModel: BoardOptionsViewModel by lazy {
        ViewModelProviders.of(this).get(BoardOptionsViewModel::class.java)
    }

    private fun mountBoard() {
        val board = findViewById<GameBoard>(R.id.boardView)

        viewModel.boardSize.observe(this, Observer {
            it?.let {
                board.resize(
                    Size(it.width, it.height),
                    viewModel.boardImage.value
                )
            }
        })

        findViewById<Button>(R.id.shuffle).setOnClickListener {
            board.shuffle()
        }

        findViewById<Button>(R.id.reset).setOnClickListener {
            board.shuffle(true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel.apply {
            boardSize.value = initialConfig.size
            boardImage.value = initialConfig.bitmap
        }

        super.onCreate(savedInstanceState)

        setContentView(R.layout.game_activity)
        setSupportActionBar(findViewById(R.id.board_options_toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mountBoard()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
