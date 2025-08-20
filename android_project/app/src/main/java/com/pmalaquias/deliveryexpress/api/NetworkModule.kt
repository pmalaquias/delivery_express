package com.pmalaquias.deliveryexpress.api

import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import com.pmalaquias.deliveryexpress.api.interfaces.DeliveryExpressApi

@Module
class NetworkModule {

    @Provides
    fun provideDeliveryExpressApi(baseUrl: String): DeliveryExpressApi {
        return DeliveryExpressApiImpl(baseUrl)
    }
}