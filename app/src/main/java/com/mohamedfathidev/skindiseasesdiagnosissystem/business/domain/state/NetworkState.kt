package com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.state

sealed class NetworkState {
    object Available : NetworkState()
    object Unavailable : NetworkState()
}