package com.example.resumemaker

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.print.PrintAttributes
import android.print.PrintManager
import android.view.Display
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import com.example.resumemaker.profile.BasicInfo
import android.view.WindowManager




class ViewResumeActivity : AppCompatActivity() {
    lateinit var webView: WebView
    lateinit var genratePdfButton: Button
    var pdfName:String=""
    var param1:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_resume2)
        param1 = intent.getStringExtra("html")!!
        pdfName = intent.getStringExtra("name")!!
        findIds()
        factory()
    }


    private fun factory() {
        webView.loadDataWithBaseURL(null, param1, "text/HTML", "UTF-8", null)
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.setInitialScale(1)
        webView.settings.allowFileAccess = true;
        genratePdfButton.setOnClickListener{
            ////
            pdfName += "_Resume_Generator"

                (getSystemService(Context.PRINT_SERVICE) as? PrintManager)?.let { printManager ->

                    val jobName = pdfName

                    // Get a print adapter instance

                    val printAdapter = webView.createPrintDocumentAdapter(jobName)



                    // Create a print job with name and adapter instance
                    printManager.print(
                        jobName,
                        printAdapter,
                        PrintAttributes.Builder().build()
                    )


                    //printManager.printJobs
                }



            /////

        }
    }


    private fun getScale(): Int {
        val display: Display = (getSystemService(WINDOW_SERVICE) as WindowManager).defaultDisplay
        val width: Int = display.getWidth()
        var `val`: Double = width?.toDouble()

        return `val`.toInt()
    }

    private fun findIds() {
        genratePdfButton=findViewById(R.id.genrate_resume_pdf_button)
        webView=findViewById(R.id.web_view_of_resume)
    }
}