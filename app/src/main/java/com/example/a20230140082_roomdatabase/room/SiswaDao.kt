package com.example.a20230140082_roomdatabase.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface SiswaDao {
    @Query("SELECT * from tblSiswa ORDER BY nama ASC")
    fun getAllSiswa(): Flow<List<Siswa>>
}