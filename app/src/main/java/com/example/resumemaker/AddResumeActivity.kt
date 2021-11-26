package com.example.resumemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.resumemaker.profile.BasicInfo
import com.example.resumemaker.profile.BasicInfoFragment

class AddResumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_resume)
        supportActionBar?.hide()
        var basicInfo=intent.getParcelableExtra<BasicInfo>("obj")
        var code=intent.getStringExtra("code")
        var fragment:Fragment= BasicInfoFragment.newInstance(code!!,basicInfo!!)
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.add_new_resume_host, fragment).commit()
    }
}