package ir.hajkarami.frenchlanguageteacher

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ir.hajkarami.frenchlanguageteacher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnRed.setOnClickListener ( this )
        binding.btnBlack.setOnClickListener ( this )
        binding.btnGreen.setOnClickListener ( this )
        binding.btnYellow.setOnClickListener ( this )
        binding.btnPurple.setOnClickListener ( this )

    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btn_red -> PlaySounds(R.raw.red)
            R.id.btn_black -> PlaySounds(R.raw.black)
            R.id.btn_green -> PlaySounds(R.raw.green)
            R.id.btn_purple -> PlaySounds(R.raw.purple)
            R.id.btn_yellow -> PlaySounds(R.raw.yellow)
        }

    }

    private fun PlaySounds(Id: Int) {
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, Id)
        mediaPlayer?.start()
        mediaPlayer?.setOnCompletionListener { it.release() }
    }
}