package com.example.donapps.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.donapps.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    private val dataListWithDesc = listOf(
        mapOf("title" to "Kotlin",       "desc" to "Bahasa untuk Android modern"),
        mapOf("title" to "Java",         "desc" to "Bahasa OOP yang populer"),
        mapOf("title" to "Python",       "desc" to "Bahasa yang mudah dipahami"),
        mapOf("title" to "C++",          "desc" to "Bahasa performa tinggi"),
        mapOf("title" to "JavaScript",   "desc" to "Bahasa untuk web frontend"),
        mapOf("title" to "Dart",         "desc" to "Bahasa untuk Flutter"),
        mapOf("title" to "Swift",        "desc" to "Bahasa untuk iOS"),
        mapOf("title" to "Go",           "desc" to "Bahasa buatan Google"),
        mapOf("title" to "Ruby",         "desc" to "Bahasa scripting elegan"),
        mapOf("title" to "R",            "desc" to "Bahasa untuk statistik"),
        mapOf("title" to "PHP",          "desc" to "Bahasa untuk web backend"),
        mapOf("title" to "C#",           "desc" to "Bahasa ekosistem Microsoft"),
        mapOf("title" to "TypeScript",   "desc" to "JavaScript dengan tipe data"),
        mapOf("title" to "Shell",        "desc" to "Bahasa scripting sistem"),
        mapOf("title" to "SQL",          "desc" to "Bahasa untuk database"),
        mapOf("title" to "Perl",         "desc" to "Bahasa scripting tua"),
        mapOf("title" to "Rust",         "desc" to "Bahasa system yang aman"),
        mapOf("title" to "Scala",        "desc" to "Bahasa JVM fungsional"),
        mapOf("title" to "Haskell",      "desc" to "Bahasa fungsional murni"),
        mapOf("title" to "Lua",          "desc" to "Bahasa scripting ringan"),
        mapOf("title" to "Erlang",       "desc" to "Bahasa concurrent"),
        mapOf("title" to "Prolog",       "desc" to "Bahasa logika"),
        mapOf("title" to "Assembly",     "desc" to "Bahasa tingkat rendah"),
        mapOf("title" to "Objective-C",  "desc" to "Bahasa iOS lama"),
        mapOf("title" to "VBA",          "desc" to "Bahasa untuk Microsoft Office")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "More"
        }

        /* Definisikan adapter sebagai penghubung dataList dengan layout simple_list_item_2 */
        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        // Hubungkan listViewItems dengan adapter
        binding.listViewItems.adapter = adapter

        // Tambahkan aksi saat item di-list diklik
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(requireContext(), "Kamu memilih: $title ($desc)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
