package com.erkindilekci.disneyanimations.presentation.detailscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erkindilekci.disneyanimations.domain.repository.DisneyRepository
import com.erkindilekci.disneyanimations.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AnimationDetailViewModel @Inject constructor(
    private val repository: DisneyRepository
) : ViewModel() {
    private val _state = MutableStateFlow(AnimationDetailScreenState())
    val state: StateFlow<AnimationDetailScreenState> = _state.asStateFlow()

    fun getSelectedAnimation(id: Int) {
        repository.getSelectedAnimation(id).onEach { resource ->
            when (resource) {
                is Resource.Error -> {
                    _state.value = AnimationDetailScreenState(
                        error = resource.message ?: "An unexpected error occurred!"
                    )
                }

                is Resource.Loading -> {
                    _state.value = AnimationDetailScreenState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = AnimationDetailScreenState(animation = resource.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}
