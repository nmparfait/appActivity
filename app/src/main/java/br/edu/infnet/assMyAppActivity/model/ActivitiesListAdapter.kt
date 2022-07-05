package br.edu.infnet.assMyAppActivity.model


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.assMyAppActivity.R

class ActivitiesListAdapter :
    ListAdapter<ListEntity, ActivitiesListAdapter.ActivitiesViewHolder>(ACTIVITIES_COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        return ActivitiesViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.atividades)
    }

    class ActivitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvActivity: TextView = itemView.findViewById(R.id.tvThought)

        fun bind(text: String?) {
            tvActivity.text = text
        }

        companion object {
            fun create(parent: ViewGroup): ActivitiesViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return ActivitiesViewHolder(view)
            }
        }
    }

    companion object {
        private val ACTIVITIES_COMPARATOR = object : DiffUtil.ItemCallback<ListEntity>() {
            override fun areItemsTheSame(oldItem: ListEntity, newItem: ListEntity): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: ListEntity, newItem: ListEntity): Boolean {
                return oldItem.atividades == newItem.atividades
            }
        }
    }
}
