package com.example.navtestapp

import com.example.navtestapp.data.Datasource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Binds
    @Singleton
    fun ProvideDataSource(): Datasource {
        return Datasource()
    }

}