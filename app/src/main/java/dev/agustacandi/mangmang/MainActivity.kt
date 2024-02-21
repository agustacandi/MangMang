package dev.agustacandi.mangmang

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dev.agustacandi.mangmang.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val listManga = ArrayList<Manga>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibAbout.setOnClickListener {
            Intent(this, AboutActivity::class.java).apply {
                binding.root.context.startActivity(this)
            }
        }

        binding.rvManga.setHasFixedSize(true)

        listManga.addAll(getListManga())
        showRecyclerList()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val orientation: Int = newConfig.orientation
        showRecyclerList(orientation)
    }

    private fun getListManga(): ArrayList<Manga> {
        val dataMangaTitles = resources.getStringArray(R.array.manga_title)
        val dataMangaAuthors = resources.getStringArray(R.array.manga_author)
        val dataMangaScores = resources.getStringArray(R.array.manga_score)
        val dataMangaSynopsis = resources.getStringArray(R.array.manga_synopsis)
        val dataMangaGenres = resources.getStringArray(R.array.manga_genres)
        val dataMangaPublishedDate = resources.getStringArray(R.array.manga_published_date)
        val dataMangaImages = resources.getStringArray(R.array.manga_image)
        val dataMangaCharaImages = resources.getStringArray(R.array.manga_chara_image)
        val dataMangaCharaNames = resources.getStringArray(R.array.manga_chara_name)
        val dataMangaCharaImages2 = resources.getStringArray(R.array.manga_chara_image2)
        val dataMangaCharaNames2 = resources.getStringArray(R.array.manga_chara_name2)
        val dataMangaCharaImages3 = resources.getStringArray(R.array.manga_chara_image3)
        val dataMangaCharaNames3 = resources.getStringArray(R.array.manga_chara_name3)
        val mangas = ArrayList<Manga>()
        for (i in dataMangaTitles.indices) {
            val manga = Manga(dataMangaTitles[i], dataMangaAuthors[i], dataMangaScores[i], dataMangaSynopsis[i], dataMangaGenres[i], dataMangaPublishedDate[i], dataMangaImages[i], dataMangaCharaImages[i], dataMangaCharaNames[i], dataMangaCharaImages2[i], dataMangaCharaNames2[i], dataMangaCharaImages3[i], dataMangaCharaNames3[i])
            mangas.add(manga)
        }
        return mangas
    }

    private fun showRecyclerList(orientation: Int = Configuration.ORIENTATION_PORTRAIT) {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.rvManga.layoutManager = LinearLayoutManager(this)
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvManga.layoutManager = GridLayoutManager(this, 2)
        }
        val listMangaAdapter = ListMangaAdapter(listManga)
        binding.rvManga.adapter = listMangaAdapter
    }
}