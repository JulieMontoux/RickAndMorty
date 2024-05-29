package fr.epsi.montoux.rickandmorty

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
            holder.characterName.text = characterList[position].name
        }

        override fun getItemCount() = characterList.size

        fun updateCharacters(newCharacters: List<Character>) {
            characterList = newCharacters
            notifyDataSetChanged()
        }


}

