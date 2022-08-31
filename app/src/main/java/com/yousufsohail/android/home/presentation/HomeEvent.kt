package com.yousufsohail.android.home.presentation

sealed class HomeEvent {
    object FetchEvent : HomeEvent()
    object RefreshFetchEvent : HomeEvent()
}
