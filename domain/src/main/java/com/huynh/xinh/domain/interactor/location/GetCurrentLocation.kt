package com.huynh.xinh.domain.interactor.location

import com.huynh.xinh.domain.executor.PostExecutionThread
import com.huynh.xinh.domain.executor.ThreadExecutor
import com.huynh.xinh.domain.interactor.UseCase
import com.huynh.xinh.domain.models.GeoAddress
import com.huynh.xinh.domain.repositories.location.LocationRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Create by Mr.X on 1/29/19
 */
class GetCurrentLocation
@Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val repository: LocationRepository
) : UseCase<GeoAddress, Void>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(param: Void?): Observable<GeoAddress> {
        return repository.getCurrentLocation()
            .flatMap { repository.reverseGeocodeLocation(it).map { it[0] }.toObservable() }
    }
}