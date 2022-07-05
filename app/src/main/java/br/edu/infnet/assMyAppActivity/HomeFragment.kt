package br.edu.infnet.assMyAppActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val btStart = view.findViewById<Button>(R.id.btStart)

        val etNameHome = view.findViewById<EditText>(R.id.etNameHome)

        btStart.setOnClickListener {

            if (validated(etNameHome)) {
                val navController = this.findNavController()
                val bundle = bundleOf("name" to etNameHome.text.toString())

                navController.navigate(R.id.action_homeFragment_to_seconFragment, bundle)
            } else {
                Toast.makeText(activity, "Insira o seu nome aqui", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        return view
    }

    private fun validated(name: EditText): Boolean {
        return name.text.isNotBlank()
    }

}