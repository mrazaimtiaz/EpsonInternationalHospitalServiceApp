package com.epson.epos2_printer.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.epson.epos2_printer.repository.QRepository

class QViewModelProviderFactory(
    val app: Application,
    val qRepository: QRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QViewModel(
            app,
            qRepository
        ) as T
    }
}