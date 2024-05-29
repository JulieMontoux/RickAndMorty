package fr.epsi.montoux.rickandmorty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CharactersListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters_list)

        val recyclerView: RecyclerView = findViewById(R.id.characters_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val characters = listOf("Character 1", "Character 2", "Character 3")

        val adapter = CharactersAdapter(characters)
        recyclerView.adapter = adapter
    }
}