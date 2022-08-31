package com.yousufsohail.android.common

interface BaseUseCase<Input, Output> {

    suspend fun execute(input: Input): Output

}
