package com.example.modul

import com.google.firebase.database.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class Module(val id: UUID = UUID.randomUUID(),
                  var number:Int = 0,
                  var dateOFDelivery: Date = Date(),
                  var module_station: String = "",
                  var is_military: Boolean = false,
                  var input_control: String = "" ,
                  var comments: String = "")
