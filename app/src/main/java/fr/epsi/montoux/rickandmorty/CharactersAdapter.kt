package fr.epsi.montoux.rickandmorty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import fr.epsi.montoux.rickandmorty.model.Character

class CharactersAdapter(
    private var characters: List<Character>
) : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(character: Character)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character, onItemClickListener)
    }

    override fun getItemCount() = characters.size

    fun updateCharacters(newCharacters: List<Character>) {
        characters = newCharacters
        notifyDataSetChanged()
    }

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.character_name_text_view)
        private val imageView: ImageView = itemView.findViewById(R.id.character_image_view)

        fun bind(character: Character, clickListener: OnItemClickListener?) {
            nameTextView.text = character.name
            imageView.load(character.image) {
                placeholder(R.drawable.ic_placeholder)
                error(R.drawable.ic_error)
            }
            itemView.setOnClickListener {
                clickListener?.onItemClick(character)
            }
        }
    }
}
