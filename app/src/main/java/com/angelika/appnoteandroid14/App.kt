package com.angelika.appnoteandroid14

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.angelika.appnoteandroid14.data.dp.AppDatabase
import com.angelika.appnoteandroid14.utils.PreferenceHelper

class App : Application() {

    companion object {
        private var appDatabase: AppDatabase? = null
        private var context: Context? = null

        fun getInstance(): AppDatabase? {
            if (appDatabase == null) {
                appDatabase = context?.let {
                    Room.databaseBuilder(
                        it,
                        AppDatabase::class.java,
                        "note.database"
                    ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
                }
            }
            return appDatabase
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        getInstance()
        initPreference()
    }

    private fun initPreference() {
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.prefUnit(this)
    }
}