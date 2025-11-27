package com.example.a20230140082_roomdatabase.viewmodel

import android.app.PictureInPictureUiState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.a20230140082_roomdatabase.repositori.RepositoriSiswa
import com.example.a20230140082_roomdatabase.room.Siswa

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())

    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean{
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa){
        uiStateSiswa =
            UIStateSiswa(detailSiswa = detailSiswa,
                isEntryValid = validasiInput(detailSiswa))
    }

    suspend fun saveSiswa(){
        if (validasiInput()){
            repositoriSiswa.insertSiswa(uiStateSiswa.detailSiswa.toSiswa())
        }
    }
}

data class uiStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)

data class DetailSiswa(
    val id: Int = 0,
    val nama: String ="",
    val alamat: String = "",
    val telpon: String = "",
)

fun DetailSiswa.toSiswa(): Siswa = Siswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)

fun Siswa.toUiStateSiswa(isEntryValid: Boolean = false): UIStateSsiswa = uiStateSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid
)

