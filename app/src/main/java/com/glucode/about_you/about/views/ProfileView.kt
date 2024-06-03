package com.glucode.about_you.about.views

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.glucode.about_you.R
import com.glucode.about_you.about.AboutFragment
import com.glucode.about_you.databinding.ViewProfileBinding

class ProfileView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: ViewProfileBinding =
        ViewProfileBinding.inflate(LayoutInflater.from(context), this, true)

    private var aboutFragment: AboutFragment? = null

    var name: String? = null
        set(value) {
            field = value
            binding.nameTextView.text = value
        }

    var title: String? = null
        set(value) {
            field = value
            binding.titleTextView.text = value
        }

    var years: String? = null
        set(value) {
            field = value
            binding.yearsTextView.text = value
        }

    var coffee: String? = null
        set(value) {
            field = value
            binding.coffeeTextView.text = value
        }

    var bugs: String? = null
        set(value) {
            field = value
            binding.bugsTextView.text = value
        }

    var imageView: Uri? = null
        set(value) {
            field = value
            binding.imageView.setImageURI(value)
        }

    init {
        elevation = resources.getDimension(R.dimen.elevation_normal)
        setUpView()
    }

    fun setAboutFragment(fragment: AboutFragment) {
        this.aboutFragment = fragment
    }

    private fun setUpView() {
        binding.imageView.setOnClickListener {
            aboutFragment?.onImageClick()
        }
    }
}
