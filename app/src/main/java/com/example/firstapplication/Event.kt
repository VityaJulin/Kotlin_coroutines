package com.example.firstapplication

enum class Event(val geoLocation: GeoLocation?) {
    POST_A_EVENT(GeoLocation()), POST_NOT_A_EVENT(null)
}