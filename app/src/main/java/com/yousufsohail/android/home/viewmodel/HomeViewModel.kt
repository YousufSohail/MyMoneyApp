package com.yousufsohail.android.home.viewmodel

import androidx.lifecycle.ViewModel
import com.yousufsohail.android.home.domain.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {

}
