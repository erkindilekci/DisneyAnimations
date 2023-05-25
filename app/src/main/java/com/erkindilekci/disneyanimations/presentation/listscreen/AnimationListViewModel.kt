package com.erkindilekci.disneyanimations.presentation.listscreen

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
class AnimationListViewModel @Inject constructor(
    private val repository: DisneyRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AnimationListScreenState())
    val state: StateFlow<AnimationListScreenState> = _state.asStateFlow()

    init {
        getAllAnimations()
    }

    fun getAllAnimations() {
        repository.getAllAnimations().onEach { resource ->
            when (resource) {
                is Resource.Error -> {
                    _state.value = AnimationListScreenState(
                        error = resource.message ?: "An unexpected error occurred!"
                    )
                }

                is Resource.Loading -> {
                    _state.value = AnimationListScreenState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value =
                        AnimationListScreenState(animations = resource.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}
