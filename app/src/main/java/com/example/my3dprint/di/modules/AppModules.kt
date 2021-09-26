package com.example.my3dprint.di.modules

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.my3dprint.database.dao.AppDatabase
import com.example.my3dprint.database.dao.PrintDAO
import com.example.my3dprint.model.Print
import com.example.my3dprint.repository.PrintRepository
import com.example.my3dprint.ui.fragment.ListPrintFragment
import com.example.my3dprint.ui.recyclerview.adapter.PrintListAdapter
import com.example.my3dprint.ui.viewmodel.PrintListViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val DATA_BASE_NAME = "print.db"
private const val DATA_BASE_NAME_TEST = "print-test.db"

val testDataBaseModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            DATA_BASE_NAME_TEST
        ).fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    CoroutineScope(IO).launch {
                        val dao: PrintDAO by inject()
                        dao.salva(
                            Print(
                                1, "Description1"
                            ),
                            Print(
                                2, "Description2"
                            ),
                            Print(
                                3, "Description3"
                            )
                        )
                    }
                }
            }).build()
    }
}

val databaseModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            DATA_BASE_NAME
        ).build()
    }
}

val daoModule = module {
    single<PrintDAO> { get<AppDatabase>().printDao() }
    single<PrintRepository> { get() }
}

val uiModule = module {
    factory<ListPrintFragment> { ListPrintFragment() }
}

val viewModelModule = module {
    viewModel<PrintListViewModel> { get() }
}

val adapter = module{
    single<PrintListAdapter>{get()}
}