package com.example.playlistmaker

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class TracksViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val albumImage = itemView.findViewById<ImageView>(R.id.albumImage)
    val subTitle = itemView.findViewById<TextView>(R.id.subtitle)
    val trackName = itemView.findViewById<TextView>(R.id.trackName)

    fun bind(model: Track) {
        Glide
            .with(itemView)
            .load(model.artworkUrl100)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .centerCrop()
            .transform(RoundedCorners(2))
            .into(albumImage)
        trackName.text = model.trackName
        subTitle.text = "${model.artistName} • ${model.trackTime}"
    }
}