package com.midnight.android.movies.framwork.repo.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.midnight.android.movies.framwork.repo.local.models.*

class Converters {
    @TypeConverter
    fun fromCollectionsList(collectionList: CollectionsModelDb?): String? {
        val type = object : TypeToken<CollectionsModelDb?>() {}.type
        return Gson().toJson(collectionList, type)
    }

    @TypeConverter
    fun toCollectionsList(collectionsString: String?): CollectionsModelDb? {
        val type = object : TypeToken<CollectionsModelDb?>() {}.type
        return Gson().fromJson<CollectionsModelDb?>(collectionsString, type)
    }

    ///

    @TypeConverter
    fun fromGeneresList(generesList: List<GenresModelDb?>?): String? {
        val type = object : TypeToken<List<GenresModelDb?>?>() {}.type
        return Gson().toJson(generesList, type)
    }

    @TypeConverter
    fun toGeneresList(generesListString: String?): List<GenresModelDb>? {
        val type = object : TypeToken<List<GenresModelDb?>?>() {}.type
        return Gson().fromJson<List<GenresModelDb>>(generesListString, type)
    }

    ///

    @TypeConverter
    fun fromProductionCompaniesList(pcList: List<ProductionCompaniesModelDb?>?): String? {
        val type = object : TypeToken<List<ProductionCompaniesModelDb?>?>() {}.type
        return Gson().toJson(pcList, type)
    }

    @TypeConverter
    fun toProductionCompaniesList(pcString: String?): List<ProductionCompaniesModelDb>? {
        val type = object : TypeToken<List<ProductionCompaniesModelDb?>?>() {}.type
        return Gson().fromJson<List<ProductionCompaniesModelDb>>(pcString, type)
    }
    ///

    @TypeConverter
    fun fromProductionCountriesList(pCountriesList: List<ProductionCountriesModelDb?>?): String? {
        val type = object : TypeToken<List<ProductionCountriesModelDb?>?>() {}.type
        return Gson().toJson(pCountriesList, type)
    }

    @TypeConverter
    fun toProductionCountriesList(pCountriesString: String?): List<ProductionCountriesModelDb>? {
        val type = object : TypeToken<List<ProductionCountriesModelDb?>?>() {}.type
        return Gson().fromJson<List<ProductionCountriesModelDb>>(pCountriesString, type)
    }

    ///

    @TypeConverter
    fun fromSpokenLangList(spokenLangList: List<SpokenLanguagesModelDb?>?): String? {
        val type = object : TypeToken<List<SpokenLanguagesModelDb?>?>() {}.type
        return Gson().toJson(spokenLangList, type)
    }

    @TypeConverter
    fun toSpokenLangList(spokenLangString: String?): List<SpokenLanguagesModelDb>? {
        val type = object : TypeToken<List<SpokenLanguagesModelDb?>?>() {}.type
        return Gson().fromJson<List<SpokenLanguagesModelDb>>(spokenLangString, type)
    }



}