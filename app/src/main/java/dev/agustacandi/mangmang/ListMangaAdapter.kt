package dev.agustacandi.mangmang

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.agustacandi.mangmang.databinding.ItemRowMangaBinding

class ListMangaAdapter(private val listManga: ArrayList<Manga>) : RecyclerView.Adapter<ListMangaAdapter.ListViewHolder>() {
    class ListViewHolder(val binding: ItemRowMangaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listManga.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val manga = listManga[position]
        val authorName = "By ${manga.author}"
        Glide.with(holder.binding.root.context).load(manga.image).placeholder(ColorDrawable(Color.GRAY)).into(holder.binding.ivManga)
        holder.binding.tvTitle.text = manga.title
        holder.binding.tvBy.text = authorName
        holder.binding.tvSynopsis.text = manga.synopsis
        holder.binding.bDetail.setOnClickListener {
            Intent(it.context, DetailActivity::class.java).apply {
                this.putExtra("key_manga", listManga[position])
                it.context.startActivity(this)
            }
        }
    }
}