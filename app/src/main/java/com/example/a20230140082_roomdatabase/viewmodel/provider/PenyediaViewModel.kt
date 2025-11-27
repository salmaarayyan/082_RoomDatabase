package com.example.a20230140082_roomdatabase.viewmodel.provider

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a20230140082_roomdatabase.viewmodel.EntryViewModel
import com.example.a20230140082_roomdatabase.viewmodel.HomeViewModel

object PenyediaViewModel{
    val Factory = viewModelFactory{
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
    }
}