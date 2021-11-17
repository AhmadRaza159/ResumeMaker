package com.example.resumemaker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.print.PrintAttributes
import android.print.PrintManager
import android.view.View
import android.webkit.WebView
import android.widget.Button
import com.example.resumemaker.profile.BasicInfo

class ViewResumeActivity : AppCompatActivity() {
    lateinit var webView: WebView
    lateinit var genratePdfButton: Button
    var param1:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_resume2)
        param1 = intent.getStringExtra("html")!!
        findIds()
        factory()
    }


    private fun factory() {
        webView.loadDataWithBaseURL(null, param1, "text/HTML", "UTF-8", null)
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        genratePdfButton.setOnClickListener{
            (getSystemService(Context.PRINT_SERVICE) as? PrintManager)?.let { printManager ->

                val jobName = "${getString(R.string.app_name)} Document"

                // Get a print adapter instance
                val printAdapter = webView.createPrintDocumentAdapter(jobName)

                // Create a print job with name and adapter instance
                printManager.print(
                    jobName,
                    printAdapter,
                    PrintAttributes.Builder().build()
                ).also { printJob ->

                    // Save the job object for later status checking
                    //printJobs += printJob
                }
            }
        }
    }

    private fun findIds() {
        genratePdfButton=findViewById(R.id.genrate_resume_pdf_button)
        webView=findViewById(R.id.web_view_of_resume)
    }
}