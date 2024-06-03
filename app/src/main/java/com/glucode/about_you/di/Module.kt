package com.glucode.about_you.di

import com.glucode.about_you.viewmodels.AboutYouViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val viewModels = module {
    viewModel { AboutYouViewModel() }
}

val allModules = listOf(
    viewModels
)