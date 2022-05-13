package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.util

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import androidx.core.content.FileProvider
import com.mohamedfathidev.skindiseasesdiagnosissystem.BuildConfig
import java.io.File
import java.io.IOException

public fun createFile(): File {
    return File.createTempFile("tmp_image_file", ".png", null).apply {
        createNewFile()
        deleteOnExit()
    }
}


public fun getTmpFileUri(context: Context): Uri {
    val tmpFile = createFile()
    return FileProvider.getUriForFile(context, "${BuildConfig.APPLICATION_ID}.provider", tmpFile)
}

@Throws(IOException::class)
fun Uri.readBytes(context: Context): ByteArray? =
    context.contentResolver.openInputStream(this)?.buffered()?.use { it.readBytes() }

fun Context.getFileName(uri: Uri): String? = when(uri.scheme) {
    ContentResolver.SCHEME_CONTENT -> getContentFileName(uri)
    else -> uri.path?.let(::File)?.name
}

fun Context.getContentFileName(uri: Uri): String? = runCatching {
    contentResolver.query(uri, null, null, null, null)?.use { cursor ->
        cursor.moveToFirst()
        return@use cursor.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME).let(cursor::getString)
    }
}.getOrNull()

fun Uri.getName(context: Context): String? {
    val returnCursor = context.contentResolver.query(this, null, null, null, null)
    val nameIndex = returnCursor?.getColumnIndex(OpenableColumns.DISPLAY_NAME)
    returnCursor?.moveToFirst()
    val fileName = nameIndex?.let { returnCursor.getString(it) }
    returnCursor?.close()
    return fileName
}