package com.example.tugas8.repositori

import android.app.Application
import android.content.Context
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData
import com.example.tugas8.room.DatabaseSiswa

interface ContainerApp {
    val repositoriSiswa : RepositoriSiswa
}

class ContainerDataApp(private val context: Context):
        ContainerApp{
            override val repositoriSiswa: RepositoriSiswa by lazy {
                OfflineRepositoriSiswa(
                    siswaDao = DatabaseSiswa.getDatabase(context).siswaDao()
                )
            }
        }
class AplikasiSiswa : Application() {
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(context = this)
    }
}