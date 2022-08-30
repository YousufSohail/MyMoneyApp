package com.yousufsohail.android.common.resources

import java.io.InputStream

interface CSVParser<T> {
   suspend fun parse(stream: InputStream): List<T>
}
