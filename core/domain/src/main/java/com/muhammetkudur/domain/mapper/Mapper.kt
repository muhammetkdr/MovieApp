package com.muhammetkudur.domain.mapper

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

interface Mapper<I, O> {
    fun map(input: I): O
}
