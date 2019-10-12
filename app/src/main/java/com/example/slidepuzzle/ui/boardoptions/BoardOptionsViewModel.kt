package com.example.slidepuzzle.ui.boardoptions

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.graphics.Bitmap
import com.example.slidepuzzle.R
import java.io.Serializable

typealias TitledResourcePair = Pair<Int, String>

data class BoardTitledSize(val width: Int, val height: Int): Serializable {
    override fun toString(): String {
        return "$width x $height"
    }
}

class BoardOptionsViewModel : ViewModel() {
    companion object {
        val PREDEFINED_BOARD_SIZE = arrayOf(
            BoardTitledSize(3, 3),
            BoardTitledSize(4, 4),
            BoardTitledSize(5, 5),
            BoardTitledSize(6, 6),
            BoardTitledSize(7, 7),
            BoardTitledSize(8, 8)
        )

        val PREDEFINED_IMAGES: Array<TitledResourcePair> = arrayOf(
            TitledResourcePair(R.drawable.cat, "kotek"),
            TitledResourcePair(R.drawable.doge, "piesek"),
            TitledResourcePair(R.drawable.spiderman, "spajdemen"),
            TitledResourcePair(R.drawable.spiderman_office, "smuteczek"),
            TitledResourcePair(R.drawable.yeti, "yeti"),
            TitledResourcePair(R.drawable.pigeon, "szczur"),
            TitledResourcePair(R.drawable.spiderman_ok, "spajdermen okej"),
            TitledResourcePair(R.drawable.pepe, "żabka"),
            TitledResourcePair(R.drawable.dolan, "kaczka"),
            TitledResourcePair(R.drawable.original_pepe, "pepe"),
            TitledResourcePair(R.drawable.alien, "alien"),
            TitledResourcePair(R.drawable.wat, "wat")
        )
    }

    val boardSize = MutableLiveData<BoardTitledSize>()
    val boardImage = MutableLiveData<Bitmap>()
}
