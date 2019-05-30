package com.ynov.kotlin.rickmorty.presentation.liste.viewmodel

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ynov.kotlin.rickmorty.R
import com.ynov.kotlin.rickmorty.data.entity.RMCharacterModel
import com.ynov.kotlin.rickmorty.presentation.DetailActivity
import com.ynov.kotlin.rickmorty.presentation.MainActivity
import kotlinx.android.synthetic.main.view_character_list_item.view.*
import kotlin.math.log

class CharacterListAdapter: RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {

    private var characterList: MutableList<RMCharacterModel> = mutableListOf()

    override fun getItemCount(): Int {
        return this.characterList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.view_character_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList.get(position))
    }

    fun updateList(characterList: List<RMCharacterModel>){
        this.characterList.clear()
        this.characterList.addAll(characterList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(rmCharacter: RMCharacterModel){
            itemView.view_character_list_item_name.text = rmCharacter.name
            itemView.view_character_list_item_name.setOnClickListener{
                Log.i("nom", rmCharacter.name)
                val intent = MainActivity.newIntent(itemView.context, rmCharacter.id)
                itemView.context.startActivity(intent)
            }
        }
    }

}