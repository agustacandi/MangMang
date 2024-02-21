package dev.agustacandi.mangmang

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import dev.agustacandi.mangmang.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =   ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val avatarUrl = "https://media.licdn.com/dms/image/D5603AQEzQ_nXA50Vtw/profile-displayphoto-shrink_200_200/0/1708238953879?e=1714003200&v=beta&t=lHnrU5AldB6J_u7WP1vzAuZTAJ-ai9VqPg4kJsII4IU"
        Glide.with(binding.root.context).load(avatarUrl).placeholder(ColorDrawable(Color.GRAY)).into(binding.ivProfile)

        binding.ibBack.setOnClickListener {
            finish()
        }

        binding.tvInstagram.setOnClickListener {
            val instagramUrl = "https://instagram.com/agustacandi"
            Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse(instagramUrl)
                startActivity(this)
            }
        }

        binding.tvGithub.setOnClickListener {
            val githubUrl = "https://github.com/agustacandi"
            Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse(githubUrl)
                startActivity(this)
            }
        }

        binding.tvLinkedin.setOnClickListener {
            val linkedinUrl = "https://linkedin.com/in/candiagusta"
            Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse(linkedinUrl)
                startActivity(this)
            }
        }
    }
}