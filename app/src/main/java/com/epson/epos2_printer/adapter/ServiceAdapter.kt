package com.epson.epos2_printer.adapter

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Typeface
import android.provider.SyncStateContract
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import com.epson.epos2_printer.R
import com.epson.epos2_printer.models.Services
import com.epson.epos2_printer.utils.Constants.DISPLAY_LNG_ARABIC
import com.epson.epos2_printer.utils.Constants.TYPEFACE_BOLD
import com.epson.epos2_printer.utils.Constants.TYPEFACE_BOLD_ITALIC
import com.epson.epos2_printer.utils.Constants.TYPEFACE_ITALIC
import kotlinx.android.synthetic.main.item_services.view.*
import kotlinx.coroutines.*
import java.io.IOException
import java.util.*


class ServiceAdapter : RecyclerView.Adapter<ServiceAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : ItemCallback<Services>() {
        override fun areItemsTheSame(oldItem: Services, newItem: Services): Boolean {
            return oldItem.Services_PK_ID == newItem.Services_PK_ID
        }

        override fun areContentsTheSame(oldItem: Services, newItem: Services): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ServiceAdapter.ListViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_services, parent, false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ServiceAdapter.ListViewHolder, position: Int) {
        val services = differ.currentList[position]

        holder.itemView.apply {
            if (Locale.getDefault().displayLanguage == DISPLAY_LNG_ARABIC)
                mServiceBtn.text = services.Services_Name_AR
            else
                mServiceBtn.text = services.Services_Name_EN

            mServiceBtn.text = services.Services_Name_AR + "\n\n" + services.Services_Name_EN
            try {
                mServiceBtn.setBackgroundColor(Color.parseColor("#${services.Services_Color}"))
            } catch (e: Exception) {
                e.stackTrace
            }
            try {
                mServiceBtn.setTextColor(Color.parseColor("#${services.Services_FontColor}"))
            } catch (e: Exception) {
                e.stackTrace
            }
            when (services.Services_FontStyle) {
                TYPEFACE_BOLD -> {
                    //  mServiceBtn.setTypeface(null,Typeface.BOLD)
                    mServiceBtn.typeface = Typeface.create(services.Services_FontName, Typeface.BOLD)
                }
                TYPEFACE_BOLD_ITALIC -> {
                    //   mServiceBtn.setTypeface(null,Typeface.BOLD_ITALIC)
                    mServiceBtn.typeface = Typeface.create(services.Services_FontName, Typeface.BOLD_ITALIC)
                }
                TYPEFACE_ITALIC -> {
                    //    mServiceBtn.setTypeface(null,Typeface.ITALIC)
                    mServiceBtn.typeface = Typeface.create(services.Services_FontName, Typeface.ITALIC)
                }
                else -> {
                    //     mServiceBtn.setTypeface(null,Typeface.NORMAL)
                    mServiceBtn.typeface = Typeface.create(services.Services_FontName, Typeface.NORMAL)
                }
            }
            if (services.Services_Logo != null && services.Services_Logo!!.isNotEmpty()) {
                //  UniversalImageLoader.setImage(Uri.parse(services.Services_Logo), mIconService, null, "", context)
                CoroutineScope(Dispatchers.IO).launch {
                    var bitmap = convertBase64ToBitmap(services.Services_Logo!!)
                    withContext(Dispatchers.Main) {
                        try {
                            mIconService.setImageBitmap(bitmap)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
            }

            mServiceBtn.textSize = services.Services_FontSize?.toFloat() ?: 18f

            mServiceBtn.setOnClickListener { view ->
                onItemClickListener?.let { it(services, view) }
            }
            mIconService.setOnClickListener { view ->
                mServiceBtn.performClick()
            }
        }
    }

    private var onItemClickListener: ((Services, View) -> Unit)? = null

    fun setOnItemClickListener(listener: ((Services, View) -> Unit)) {
        onItemClickListener = listener
    }

    suspend fun convertBase64ToBitmap(b64: String): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val job = CoroutineScope(Dispatchers.Default).async {
                val imageAsBytes: ByteArray = Base64.decode(b64.toByteArray(), Base64.DEFAULT)
                bitmap = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.size)
            }
            job.await()
        } catch (e: IOException) {
            println(e)
        }
        return bitmap
    }


}
