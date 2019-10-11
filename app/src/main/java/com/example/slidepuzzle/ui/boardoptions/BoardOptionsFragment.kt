package com.example.slidepuzzle.ui.boardoptions

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.slidepuzzle.R
import android.content.Context
import android.graphics.BitmapFactory
import android.view.*
import android.widget.*

class ImageCardsAdapterGridView(
    private val parentContext: Context,
    private val cards: Array<TitledCardInfo>
) : BaseAdapter() {
    override fun getCount(): Int {
        return cards.size
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getItem(position: Int): Any {
        return cards[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var newView: View? = convertView
        if (newView == null) {
            val vi = parentContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            newView = vi.inflate(R.layout.titled_image_card_fragment, null)
            newView.tag = cards[position]
        }

        val tag: TitledCardInfo = newView?.tag as TitledCardInfo
        newView.findViewById<TextView>(R.id.title).text = tag.title
        newView.findViewById<ImageView>(R.id.image).setImageBitmap(tag.image)

        return newView
    }
}

class BoardOptionsFragment : Fragment() {

    companion object {
        fun newInstance() = BoardOptionsFragment()
    }

    private val viewModel: BoardOptionsViewModel by lazy {
        ViewModelProviders.of(this).get(BoardOptionsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.board_options_fragment, container, false)
        activity!!.setActionBar(
            view.findViewById(R.id.board_options_toolbar)
        )
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val context = this.context
        val board = view?.findViewById<GridView>(R.id.images_grid)

        if (context != null && board != null) {
            board.adapter = ImageCardsAdapterGridView(
                context,
                BoardOptionsViewModel.PREDEFINED_IMAGES.map { (id, name) -> TitledCardInfo(
                    BitmapFactory.decodeResource(resources, id),
                    name
                )}.toTypedArray()
            )
        }
    }
}
