package com.app.parking

import java.time.LocalDate
import java.util.Date

data class Task (
    var id: Int = 0,
    var name: String = "",
    var dueDate : LocalDate = LocalDate.now() ){
}