package com.yousufsohail.android.app.common

interface BaseUseCase<Input, Output> {
    suspend fun execute(input: Input): Output
}
