package fr.epsi.montoux.rickandmorty

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import fr.epsi.montoux.rickandmorty.model.Character

class CharacterDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        // Récupérer l'objet Character depuis l'intent
        val character = intent.getParcelableExtra<Character>("character")

        // Afficher les détails du personnage
        character?.let {
            displayCharacterDetails(it)
        }
    }

    private fun displayCharacterDetails(character: Character) {
        // Afficher le nom du personnage dans un TextView par exemple
        val nameTextView: TextView = findViewById(R.id.character_name_text_view)
        val statusTextView: TextView = findViewById(R.id.status_text_view)
        val speciesTextView: TextView = findViewById(R.id.species_text_view)
        val genderTextView: TextView = findViewById(R.id.gender_text_view)
        val originTextView: TextView = findViewById(R.id.origin_text_view)
        val locationTextView: TextView = findViewById(R.id.location_text_view)

        nameTextView.text = character.name
        statusTextView.text = character.status
        speciesTextView.text = character.species
        genderTextView.text = character.gender
        originTextView.text = character.origin.name
        locationTextView.text = character.location.name
    }
}
