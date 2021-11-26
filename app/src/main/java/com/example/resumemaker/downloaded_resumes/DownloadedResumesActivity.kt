package com.example.resumemaker.downloaded_resumes

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resumemaker.R
import com.example.resumemaker.utils.ImagesGallery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import android.widget.Toast

import android.content.ActivityNotFoundException

import android.content.Intent
import android.os.Build
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import android.widget.Button
import java.lang.reflect.Method
import androidx.core.content.FileProvider
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK

import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP








class DownloadedResumesActivity : AppCompatActivity() {

    lateinit var butn:Button

    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter: DownloadedResumeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_downloaded_resumes)
        /////

        val builder = VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())
        /////////////



        findIds()
        val uri=ImagesGallery.getAllDoc(applicationContext)[1]
        Toast.makeText(this, uri.toString(), Toast.LENGTH_LONG)
            .show()
      butn.setOnClickListener {

          val intent = Intent(Intent.ACTION_VIEW)

          intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
          intent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY)

          intent.setDataAndType(
              uri, "application/pdf"
          )
          try {
              this.startActivity(
                  Intent.createChooser(
                      intent,
                      "Open File"
                  )
              )
          } catch (unused: ActivityNotFoundException) {
              Toast.makeText(this, "No app to read File", Toast.LENGTH_SHORT).show()
          }
      }

        //////////////
        //launching a seprate thread
        /////////////////////


               // Log.i("ghgh ","this "+ImagesGallery.getAllDoc(applicationContext).size)






            //Log.i("ghgh ","this "+ImagesGallery.getAllDoc(this@DownloadedResumesActivity).size)

            //adapter= DownloadedResumeAdapter(ImagesGallery.getAllDoc(this@DownloadedResumesActivity))
            //recyclerView.adapter=adapter

    }
    private fun findIds() {
        recyclerView=findViewById(R.id.downloaded_file_recycler_view)
        recyclerView.layoutManager=LinearLayoutManager(this)

        butn=findViewById(R.id.aa)
    }
}