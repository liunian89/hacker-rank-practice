package com.liunian.hacker_rank_practice.utils

import org.apache.commons.io.FileUtils
import java.io.File

fun read(path: String): List<String> {
    return FileUtils.readLines(File(path), Charsets.UTF_8)
}