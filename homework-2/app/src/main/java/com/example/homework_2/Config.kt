package com.example.homework_2

enum class StatusLoad {
    LOADING,
    SUCCESS,
    ERROR
}

enum class ResponseParameters(val value: String) {
    API_KEY("9FF4Dz6pMk2JDlphgZOMSOU4l4fBWNII"),
    Q("cat"),
    LIMIT("10"),
    RATING("g"),
    LANG("en"),
}