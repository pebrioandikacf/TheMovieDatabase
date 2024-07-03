package com.pebrioandikacf.themoviedb

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pebrioandikacf.themoviedb.R

class ProfileFragment : Fragment() {

    lateinit var image: ImageView
    lateinit var title: TextView
    lateinit var subtitle: TextView
    lateinit var list: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        title = root.findViewById(R.id.title)
        subtitle = root.findViewById(R.id.subtitle)
        image = root.findViewById(R.id.image)
        list = root.findViewById(R.id.list)

        title.text = "Pebrio Andhika Cahya Fahmi"
        subtitle.text = "2210031802023"
        list.adapter = linkAdapter

        return root
    }


    private val linkAdapter by lazy {
        val items = listOf<LinkModel>(
            LinkModel("WhatsApp", R.drawable.wa, "https://api.whatsapp.com/send/?phone=%2B6281275798898&text&type=phone_number&app_absent=0"),
            LinkModel("Instagram", R.drawable.ig, "https://www.instagram.com/pebrioandikacf?igsh=MTdja2gzYXFneXN5Yw=="),
            LinkModel("Tiktok", R.drawable.tt, "https://www.tiktok.com/@pebrioandikacf?_t=8ni2CJQZxjN&_r=1"),

            )

        LinkAdapter(items, object : LinkAdapter.AdapterListener {
            override fun onClick(linktree: LinkModel) {1
                Log.e("onClick", linktree.url)
                openUrl(linktree.url)
            }

        })
    }

    private fun openUrl(url: String) {
        val openUrl = Intent(Intent.ACTION_VIEW)
        openUrl.data = Uri.parse(url)
        startActivity(openUrl)
    }
}