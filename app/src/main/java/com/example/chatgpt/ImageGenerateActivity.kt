package com.example.chatgpt

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatgpt.adapter.MessageAdapter
import com.example.chatgpt.api.ApiUtilities
import com.example.chatgpt.databinding.ActivityImageGenerateBinding
import com.example.chatgpt.models.imageresponse.MessageModel
import com.example.chatgpt.models.imageresponse.request.ImageGenerateRequest
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.RequestBody

class ImageGenerateActivity : AppCompatActivity() {

    private var list = ArrayList<MessageModel>()
    private lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var adapter: MessageAdapter

    private lateinit var binding: ActivityImageGenerateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageGenerateBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backBtn.setOnClickListener{ finish()   }

        mLayoutManager = LinearLayoutManager(this)
        mLayoutManager.stackFromEnd = true
        adapter = MessageAdapter(list)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = mLayoutManager


        binding.sendbtn.setOnClickListener{
            if (binding.userMsg.text!!.isEmpty()){
                Toast.makeText(this,"Please ask your question?", Toast.LENGTH_SHORT).show()
            }else{
                callApi()
            }
        }

    }

    private fun callApi() {
        list.add(MessageModel(isUser = true, isImage = false,binding.userMsg.text.toString()))

        adapter.notifyItemInserted(list.size - 1)

        binding.recyclerView.recycledViewPool.clear()
        binding.recyclerView.smoothScrollToPosition(list.size-1)

        val apiInterface= ApiUtilities.getApiInterface()


        val requestBody= RequestBody.create(
            MediaType.parse("application/json"),
            Gson().toJson(
                ImageGenerateRequest(
                    2,
                    binding.userMsg.text.toString(),
                    "1024x1024"
                )
            )
        )
        val contentType = "application/json"
        val authorization = "Bearer ${Utils.API_KEY}"

        lifecycleScope.launch(Dispatchers.IO){


            try {
                val response =apiInterface.generateImage(
                    contentType,authorization,requestBody
                )

                val textResponse = response.data.first().url

                list.add(MessageModel(false,true, textResponse))
                withContext(Dispatchers.Main) {
                    adapter.notifyItemInserted(list.size - 1)

                    binding.recyclerView.recycledViewPool.clear()
                    binding.recyclerView.smoothScrollToPosition(list.size - 1)
                }
                binding.userMsg.text!!.clear()

            } catch (e: Exception) {
                withContext(Dispatchers.Main){
                    Toast.makeText(this@ImageGenerateActivity,e.message, Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}