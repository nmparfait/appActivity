package br.edu.infnet.assMyAppActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.assMyAppActivity.model.ListEntity
import br.edu.infnet.assMyAppActivity.model.ActivitiesListAdapter
import br.edu.infnet.assMyAppActivity.viewmodel.ListViewModel

class MainActivity : AppCompatActivity() {


    private val listViewModel: ListViewModel by viewModels {
        ListViewModel.ListViewModelFactory((application as ListApplication).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        val etNewThought = findViewById<EditText>(R.id.etNewThought)

        val adapter = ActivitiesListAdapter()
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)

        val btAdd = findViewById<Button>(R.id.btAdd)
        val btDelete = findViewById<Button>(R.id.btDelete)

        btAdd.setOnClickListener {

            if (etNewThought.text.isNotBlank()) {
                val thought = etNewThought.text.toString()
                val newThought = ListEntity(atividades = thought)
                listViewModel.insert(newThought)

                etNewThought.setText("")
            } else {
                Toast.makeText(this, "Insira uma atividades", Toast.LENGTH_LONG).show()
            }
        }

        btDelete.setOnClickListener {
            listViewModel.deleteAll()
        }

        listViewModel.allActivities.observe(this) { thoughts ->
            thoughts.let { adapter.submitList(it) }
        }
    }
}


