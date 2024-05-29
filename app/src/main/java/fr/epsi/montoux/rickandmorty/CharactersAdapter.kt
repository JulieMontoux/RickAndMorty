package fr.epsi.montoux.rickandmorty

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.montoux.rickandmorty.model.Character

class CharactersAdapter(private var characterList: List<Character>) : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

        class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val characterName: TextView = view.findViewById(R.id.character_name)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
            return CharacterViewHolder(view)
        }

        override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
            val character = characterList[position]
            holder.characterName.text = character.name
            holder.itemView.setOnClickListener {
                itemClickListener?.onItemClick(character)
            }
        }

        override fun getItemCount() = characterList.size

        @SuppressLint("NotifyDataSetChanged")
        fun updateCharacters(newCharacters: List<Character>) {
            characterList = newCharacters
            notifyDataSetChanged()
        }

    interface OnItemClickListener {
        fun onItemClick(character: Character)
    }

    private var itemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.itemClickListener = listener
    }

}

