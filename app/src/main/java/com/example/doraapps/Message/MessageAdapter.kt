package com.example.doraapps.Message

    import android.content.Context
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.ArrayAdapter
    import com.bumptech.glide.Glide
    import com.example.doraapps.databinding.ItemMessageBinding

    class MessageAdapter(
        context: Context,
        private val Messages: List<MessageModel>
    ) : ArrayAdapter<MessageModel>(context, 0, Messages) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            // Inisialisasi View Binding untuk item list
            val binding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
            val view = binding.root

            // Ambil data berdasarkan posisi
            val data = Messages[position]

            // Load gambar menggunakan library Glide
            Glide.with(context)
                .load(data.avatarUrl)
                .into(binding.avatarImg)

            // Set teks untuk nama pengirim dan isi pesan
            binding.textSender.text = data.senderName
            binding.textMessage.text = data.messageText

            return view
        }
    }