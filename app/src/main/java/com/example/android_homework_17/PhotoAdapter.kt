package com.example.android_homework_17

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_homework_17.databinding.ActivityMainBinding
import com.example.android_homework_17.databinding.PhotoesItemBinding

class PhotoAdapter: RecyclerView.Adapter<PhotoViewHolder>() {

    private var data:List<Photo> = emptyList()
    fun setData(data:List<Photo>) {
        Log.e("******", "setData")
        this.data = data
        notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            PhotoesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = data.getOrNull(position)
        with(holder.binding) {
            id.text = item?.id.toString() ?: ""
            item?.let {
                Glide
                    .with(photo.context)
                    .load(it.img_src)
                    .into(photo)
            }
        }
    }

}

class PhotoViewHolder(val binding: PhotoesItemBinding) : RecyclerView.ViewHolder(binding.root)