package fr.epsi.montoux.rickandmorty

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load
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
        // Afficher les détails du personnage dans les TextView et ImageView
        val nameTextView: TextView = findViewById(R.id.character_name_text_view)
        val statusTextView: TextView = findViewById(R.id.status_text_view)
        val speciesTextView: TextView = findViewById(R.id.species_text_view)
        val genderTextView: TextView = findViewById(R.id.gender_text_view)
        val originTextView: TextView = findViewById(R.id.origin_text_view)
        val locationTextView: TextView = findViewById(R.id.location_text_view)
        val imageView: ImageView = findViewById(R.id.character_image_view)

        nameTextView.text = character.name
        statusTextView.text = "Status: ${character.status}"
        speciesTextView.text = "Species: ${character.species}"
        genderTextView.text = "Gender: ${character.gender}"
        originTextView.text = "Origin: ${character.origin.name}"
        locationTextView.text = "Location: ${character.location.name}"

        imageView.load(character.image) {
            placeholder(R.drawable.ic_placeholder)
            error(R.drawable.ic_error)
        }
    }
}
