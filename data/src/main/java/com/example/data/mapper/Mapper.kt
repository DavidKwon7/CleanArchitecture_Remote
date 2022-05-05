package com.example.data.mapper

interface Mapper<in I, out O> {
    fun mapToModel(from: I) : O
}