package com.e444er.note

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.e444er.note.database.room.AppRoomDatabase
import com.e444er.note.database.room.RoomRepository
import com.e444er.note.utils.REPOSITORY
import com.e444er.note.utils.TYPE_ROOM

class MainViewModel(app: Application) : AndroidViewModel(app) {

    val context = app

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        Log.d("checkData", "MainViewModel initDatabase with type: $type")
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }
    }
}

class MainViewModelFactory(private val app: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(app) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel")
    }
}