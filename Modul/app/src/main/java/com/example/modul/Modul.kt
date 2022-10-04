package com.example.modul

import java.util.*

data class Module(val id: UUID = UUID.randomUUID(),
                  var number:Int = 0,
                  var dateIn: Date = Date(),
                  var station: String = "",
                  var military: Boolean = false,
                  var inputControl: String = "" ,
                  var comments: String = "")
