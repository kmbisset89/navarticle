package com.example.navarticle

import com.example.navarticle.bl.INavigationArea
import com.example.navarticle.bl.INavigationItem
import com.example.navarticle.ui.main.HomeNavigationArea
import com.example.navarticle.ui.main.HomeNavigationItem
import com.example.navarticle.ui.main.MainViewModel
import com.example.navarticle.ui.test.TestNavigationItem
import com.example.navarticle.ui.test.main.TestMainNavigationArea
import com.example.navarticle.ui.test.main.TestViewModel
import com.example.navarticle.ui.test.second.TestSecondArea
import com.example.navarticle.ui.test.second.TestSecondScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val module =
    module {

        viewModel { p -> MainViewModel(p[0], getAll<INavigationItem<Any>>().sortedBy { it.order }, getAll()) }

        single { HomeNavigationItem() } bind INavigationItem::class

        single { TestNavigationItem() } bind INavigationItem::class

        single { HomeNavigationArea() } bind INavigationArea::class

        single { TestMainNavigationArea() } bind INavigationArea::class

        factory { TestViewModel(get()) }

        single { TestSecondArea() } bind INavigationArea::class

        factory { p -> TestSecondScreenViewModel(get(), p[0]) }
    }
