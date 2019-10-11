package com.example.slidepuzzle.ui.boardoptions

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Size
import com.example.slidepuzzle.R

typealias TitledResourcePair = Pair<Int, String>

class BoardOptionsViewModel : ViewModel() {
    companion object {
        val PREDEFINED_IMAGES: Array<TitledResourcePair> = arrayOf(
            TitledResourcePair(R.drawable.cat, "kotek"),
            TitledResourcePair(R.drawable.doge, "piesek"),
            TitledResourcePair(R.drawable.spiderman, "spajdemen"),
            TitledResourcePair(R.drawable.spiderman_office, "smuteczek"),
            TitledResourcePair(R.drawable.yeti, "yeti"),
            TitledResourcePair(R.drawable.pigeon, "szczur"),
            TitledResourcePair(R.drawable.spiderman_ok, "spajdermen okej"),
            TitledResourcePair(R.drawable.pepe, "żabka"),
            TitledResourcePair(R.drawable.dolan, "kaczka")
        )
    }

    val boardSize: MutableLiveData<Size> by lazy {
        MutableLiveData<Size>().apply { setValue(Size(4, 4))}
    }
}
