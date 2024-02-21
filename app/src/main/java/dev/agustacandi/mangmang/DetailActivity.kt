package dev.agustacandi.mangmang

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import dev.agustacandi.mangmang.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataManga = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_manga", Manga::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_manga")
        }

        Glide.with(binding.root.context).load(dataManga!!.image).placeholder(ColorDrawable(Color.GRAY)).into(binding.ivDetailImage)
        Glide.with(binding.root.context).load(dataManga!!.charaImage).placeholder(ColorDrawable(Color.GRAY)).into(binding.ivMainChara)
        Glide.with(binding.root.context).load(dataManga!!.charaImage2).placeholder(ColorDrawable(Color.GRAY)).into(binding.ivMainChara2)
        Glide.with(binding.root.context).load(dataManga!!.charaImage3).placeholder(ColorDrawable(Color.GRAY)).into(binding.ivMainChara3)
        binding.tvDetailTitle.text = dataManga.title
        val authorName = "By ${dataManga.author} | Published Date: ${dataManga.publishedDate}"
        val score = "Score: ${dataManga.score}"
        val genres = "Genres: ${dataManga.genres}"
        binding.tvDetailBy.text = authorName
        binding.tvScore.text = score
        binding.tvGenres.text = genres
        binding.tvSynopsis.text = dataManga.synopsis
        binding.tvMainChara.text = dataManga.charaName
        binding.tvMainChara2.text = dataManga.charaName2
        binding.tvMainChara3.text = dataManga.charaName3

        binding.ibBack.setOnClickListener {
            finish()
        }

        binding.actionShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "MangMang\nManga Title: ${dataManga.title}\nAuthor: ${dataManga.author}\n${dataManga.synopsis}")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}