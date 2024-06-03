package com.glucode.about_you.about

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.glucode.about_you.MainActivity
import com.glucode.about_you.about.views.QuestionCardView
import com.glucode.about_you.databinding.FragmentAboutBinding
import com.glucode.about_you.mockdata.MockData
import com.glucode.about_you.viewmodels.AboutYouViewModel

class AboutFragment: Fragment() {
    private val viewModel: AboutYouViewModel by activityViewModels()
    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profileView.setAboutFragment(this)
        setUpProfile()
        setUpQuestions()
    }

    private fun setUpQuestions() {
        val engineerName = arguments?.getString("name")
        val engineer = MockData.engineers.first { it.name == engineerName }

        engineer.questions.forEach { question ->
            val questionView = QuestionCardView(requireContext())
            questionView.title = question.questionText
            questionView.answers = question.answerOptions
            questionView.selection = question.answer.index

            binding.container.addView(questionView)
        }
    }

    private fun setUpProfile() {
        val engineerName = arguments?.getString("name")
        val engineer = MockData.engineers.first { it.name == engineerName }

        with(binding.profileView) {
            name = engineer.name
            title = engineer.role
            coffee = engineer.quickStats.coffees.toString()
            bugs = engineer.quickStats.bugs.toString()
            years = engineer.quickStats.years.toString()
        }

    }

    fun onImageClick() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, MainActivity.IMAGE_REQUESTED_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val engineerName = arguments?.getString("name")

        if (requestCode == MainActivity.IMAGE_REQUESTED_CODE && resultCode == AppCompatActivity.RESULT_OK) {
            viewModel.setProfileImage(engineerName, data?.data)

            binding.profileView.imageView = data?.data
        }
    }
}