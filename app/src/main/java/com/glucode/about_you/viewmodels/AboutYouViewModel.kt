package com.glucode.about_you.viewmodels

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glucode.about_you.mockdata.MockData
import kotlinx.coroutines.launch

class AboutYouViewModel : ViewModel() {

    fun setProfileImage(engineerName: String?, imageUri: Uri?) {
        viewModelScope.launch {
            val engineer = MockData.engineers.first { it.name == engineerName }

            engineer.defaultImageName = imageUri
        }
    }
}