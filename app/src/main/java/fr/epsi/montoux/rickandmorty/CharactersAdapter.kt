package fr.epsi.montoux.rickandmorty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import fr.epsi.montoux.rickandmorty.databinding.CharacterItemBinding
import fr.epsi.montoux.rickandmorty.databinding.ItemSketetonBinding
import fr.epsi.montoux.rickandmorty.model.Character

class CharactersAdapter(
    private var characters: List<Character>,
    private val onItemClickListener: (Character) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isLoadingAdded = false

    companion object {
        private const val ITEM = 0
        private const val LOADING = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM) {
            val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            CharacterViewHolder(binding)
        } else {
            val binding = ItemSketetonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            LoadingViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == ITEM) {
            val character = characters[position]
            (holder as CharacterViewHolder).bind(character, onItemClickListener)
        } else {
            (holder as LoadingViewHolder).binding.shimmerViewContainer.startShimmer()
        }
    }

    override fun getItemCount() = characters.size + if (isLoadingAdded) 1 else 0

    override fun getItemViewType(position: Int): Int {
        return if (position == characters.size && isLoadingAdded) LOADING else ITEM
    }

    fun updateCharacters(newCharacters: List<Character>) {
        characters = newCharacters
        notifyDataSetChanged()
    }

    fun addLoadingFooter() {
        isLoadingAdded = true
        notifyItemInserted(characters.size)
    }

    fun removeLoadingFooter() {
        isLoadingAdded = false
        notifyItemRemoved(characters.size)
    }

    class CharacterViewHolder(private val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character, clickListener: (Character) -> Unit) {
            binding.characterNameTextView.text = character.name
            binding.characterImageView.load(character.image) {
                placeholder(R.drawable.ic_placeholder)
                error(R.drawable.ic_error)
            }
            binding.root.setOnClickListener { clickListener(character) }
        }
    }

    class LoadingViewHolder(val binding: ItemSketetonBinding) : RecyclerView.ViewHolder(binding.root)
}
