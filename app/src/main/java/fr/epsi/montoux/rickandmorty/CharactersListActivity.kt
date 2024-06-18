package fr.epsi.montoux.rickandmorty

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.montoux.rickandmorty.model.Character
import fr.epsi.montoux.rickandmorty.viewmodel.CharactersListViewModel

class CharactersListActivity : AppCompatActivity() {
    private val viewModel: CharactersListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters_list)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Rick and Morty Characters"

        val recyclerView: RecyclerView = findViewById(R.id.characters_recycler_view)
        val errorTextView: TextView = findViewById(R.id.error_text_view)

        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns in grid
        val adapter = CharactersAdapter(emptyList())
        recyclerView.adapter = adapter

        viewModel.characters.observe(this, Observer { characters ->
            if (characters.isNotEmpty()) {
                recyclerView.visibility = View.VISIBLE
                errorTextView.visibility = View.GONE
                adapter.updateCharacters(characters)
            }
        })

        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) {
                recyclerView.visibility = View.GONE
                errorTextView.visibility = View.VISIBLE
                errorTextView.text = errorMessage
            }
        })

        adapter.setOnItemClickListener(object : CharactersAdapter.OnItemClickListener {
            override fun onItemClick(character: Character) {
                val intent = Intent(this@CharactersListActivity, CharacterDetailsActivity::class.java)
                intent.putExtra("character", character)
                startActivity(intent)
            }
        })
    }
}
