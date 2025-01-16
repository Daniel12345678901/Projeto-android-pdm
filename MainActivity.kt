Implemente as atividades principais:

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var notesAdapter: NotesAdapter
    private val notesList = mutableListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        fab = findViewById(R.id.fab)

        recyclerView.layoutManager = LinearLayoutManager(this)
        notesAdapter = NotesAdapter(notesList)
        recyclerView.adapter = notesAdapter

        fab.setOnClickListener {
            val intent = Intent(this, AddEditNoteActivity::class.java)
            startActivityForResult(intent, ADD_NOTE_REQUEST)
        }

        loadNotes()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {
            val note = data?.getParcelableExtra<Note>(AddEditNoteActivity.EXTRA_NOTE)
            if (note != null) {
                notesList.add(note)
                notesAdapter.notifyDataSetChanged()
                saveNotes()
            }
        }
    }

    private fun loadNotes() {
        val sharedPreferences = getSharedPreferences("notes", MODE_PRIVATE)
        val notesJson = sharedPreferences.getString("notes_list", null)
        if (notesJson != null) {
            val type = object : TypeToken<List<Note>>() {}.type
            val savedNotes: List<Note> = Gson().fromJson(notesJson, type)
            notesList.addAll(savedNotes)
            notesAdapter.notifyDataSetChanged()
        }
    }

    private fun saveNotes() {
        val sharedPreferences = getSharedPreferences("notes", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val notesJson = Gson().toJson(notesList)
        editor.putString("notes_list", notesJson)
        editor.apply()
    }

    companion object {
        const val ADD_NOTE_REQUEST = 1
    }
}
