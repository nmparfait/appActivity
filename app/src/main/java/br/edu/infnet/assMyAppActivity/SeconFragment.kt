package br.edu.infnet.assMyAppActivity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.edu.infnet.assMyAppActivity.viewmodel.RandomActivitiesViewModel

import br.edu.infnet.assMyAppActivity.databinding.FragmentSeconBinding


class SeconFragment : Fragment() {

    private lateinit var viewModel: RandomActivitiesViewModel
    private lateinit var binding: FragmentSeconBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_secon,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(RandomActivitiesViewModel::class.java)

        val name = arguments?.getString("name")

        binding.tvName.text = " Olá, $name!!"
        binding.randomActivitiesViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        var takeActivity = ""

        viewModel.activities.observe(viewLifecycleOwner) { newThought ->
            binding.tvRandom.text = newThought
            takeActivity = newThought
        }


        binding.btShare.setOnClickListener {
            if (takeActivity.isNotBlank()) {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"

                val thoughtShareText =
                    "Ativivade gerada pelo BD: ${takeActivity}"
                shareIntent.putExtra(Intent.EXTRA_TEXT, thoughtShareText)

                val chooser =
                    Intent.createChooser(shareIntent, "Selecione uma Opção de Compartilhamento")
                this.startActivity(chooser)
            } else {
                Toast.makeText(activity, "Insira mais uma ativivade", Toast.LENGTH_LONG).show()
            }
        }

        binding.btMyList.setOnClickListener {
            val navController = this.findNavController()
            navController.navigate(R.id.action_seconFragment_to_mainActivity)
        }

        return binding.root
    }

}