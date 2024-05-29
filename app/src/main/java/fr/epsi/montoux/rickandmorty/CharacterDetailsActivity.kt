package fr.epsi.montoux.rickandmorty

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CharacterDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        // Récupérer les données du personnage depuis l'intent
        val characterName = intent.getStringExtra("character_name")

        // Afficher les détails du personnage
        displayCharacterDetails(characterName)
    }

    private fun displayCharacterDetails(characterName: String?) {
        // Afficher le nom du personnage dans un TextView par exemple
        val nameTextView: TextView = findViewById(R.id.character_name_text_view)
        nameTextView.text = characterName
    }
}