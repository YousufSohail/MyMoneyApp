package com.yousufsohail.android.home.domain

import com.yousufsohail.android.app.common.BaseUseCase
import com.yousufsohail.android.home.models.DataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface UseCase : BaseUseCase<Pair<Double, Double>, Flow<DataModel>>

class DefaultUseCase @Inject constructor() : UseCase {
    override suspend fun execute(input: Pair<Double, Double>): Flow<DataModel> {
      return flow {

      }
    }
}
