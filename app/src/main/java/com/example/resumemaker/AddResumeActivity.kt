package com.example.resumemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.resumemaker.profile.BasicInfoFragment

class AddResumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_resume)
        var fragment:Fragment= BasicInfoFragment.newInstance()
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.add_new_resume_host, fragment).commit()

    }
}