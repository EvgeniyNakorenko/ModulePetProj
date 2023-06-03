package com.example.modul

import com.google.firebase.database.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class Module(
                  var dateOFDelivery: Date = Date(),
                  var module_station: String = "",
                  var is_military: Boolean = false,
                  var input_control: String = "" ,
                  var comments: String = ""){
    override fun equals(obj: Any?): Boolean {
        return this.dateOFDelivery == (obj as Module).dateOFDelivery
                && this.module_station == obj.module_station
                && this.is_military == obj.is_military
                && this.input_control == obj.input_control
                && this.comments == obj.comments
    }
}

data class ListModul(var param :MutableList<Module>? =null)

