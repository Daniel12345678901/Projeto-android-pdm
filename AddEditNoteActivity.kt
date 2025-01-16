
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.UUID

class AddEditNoteActivity : AppCompatActivity() {

    private lateinit var editTextTitle: EditText
    private lateinit var editTextContent: EditText
    private lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)

        editTextTitle = findViewById(R.id.editTextTitle)
        editTextContent = findViewById(R.id.editTextContent)
        buttonSave = findViewById(R.id.buttonSave)

        buttonSave.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() {
        val title = editTextTitle.text.toString()
        val content = editTextContent.text.toString()
        if (title.isNotEmpty() && content.isNotEmpty()) {
            val note = Note(
                id = UUID.randomUUID().toString(),
                title = title,
                content = content
            )
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_NOTE, note)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

    companion object {
        const val EXTRA_NOTE = "com.example.notesapp.EXTRA_NOTE"
    }
}
