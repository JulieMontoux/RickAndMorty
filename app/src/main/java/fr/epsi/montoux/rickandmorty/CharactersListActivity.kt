package fr.epsi.montoux.rickandmorty

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.montoux.rickandmorty.databinding.ActivityCharactersListBinding
import fr.epsi.montoux.rickandmorty.viewmodel.CharactersListViewModel

class CharactersListActivity : AppCompatActivity() {
    private val viewModel: CharactersListViewModel by viewModels()
    private lateinit var binding: ActivityCharactersListBinding
    private lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configure the toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Rick and Morty Characters"

        val layoutManager = GridLayoutManager(this, 2)
        binding.charactersRecyclerView.layoutManager = layoutManager
        adapter = CharactersAdapter(emptyList()) { character ->
            val intent = Intent(this, CharacterDetailsActivity::class.java)
            intent.putExtra("character", character)
            startActivity(intent)
        }
        binding.charactersRecyclerView.adapter = adapter

        viewModel.characters.observe(this, Observer { characters ->
            if (characters.isNotEmpty()) {
                binding.charactersRecyclerView.visibility = View.VISIBLE
                binding.errorTextView.visibility = View.GONE
                adapter.updateCharacters(characters)
            }
        })

        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) {
                binding.charactersRecyclerView.visibility = View.GONE
                binding.errorTextView.visibility = View.VISIBLE
                binding.errorTextView.text = errorMessage
            }
        })

        viewModel.isLoading.observe(this, Observer { isLoading ->
            if (isLoading) {
                adapter.addLoadingFooter()
            } else {
                adapter.removeLoadingFooter()
            }
        })

        binding.charactersRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                if (!viewModel.isLoading.value!! && (visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0) {
                    viewModel.fetchNextPage()
                }
            }
        })
    }
}
