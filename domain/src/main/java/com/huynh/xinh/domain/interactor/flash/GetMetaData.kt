package com.huynh.xinh.domain.interactor.flash

import com.huynh.xinh.domain.executor.PostExecutionThread
import com.huynh.xinh.domain.executor.ThreadExecutor
import com.huynh.xinh.domain.interactor.UseCase
import com.huynh.xinh.domain.models.MetaData
import com.huynh.xinh.domain.repositories.FlashRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Create by Mr.X on 12/25/18
 */
class GetMetaData
@Inject constructor(
    threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread,
    private val repository: FlashRepository
) : UseCase<MetaData, Void>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Void?): Observable<MetaData> {
        return repository.getMetaData
    }
}