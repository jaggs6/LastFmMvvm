package uk.co.mgntech.last_fm_mvvm.requests

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query
import uk.co.mgntech.last_fm_mvvm.models.SearchResponse
import uk.co.mgntech.last_fm_mvvm.utils.Constants

interface LastFMApi {

    companion object {
        const val START_PAGE = 1

        private const val BASE_PATH = "2.0/"
        private const val API_KEY = "api_key"
        private const val FORMAT = "format"
        private const val FORMAT_JSON = "json"
        private const val METHOD = "method"
        private const val PAGE = "page"

        private const val ARTIST = "artist"
        private const val SEARCH_ARTIST = "artist.search"
        private const val ALBUM = "album"
        private const val SEARCH_ALBUM = "album.search"
        private const val TRACK = "track"
        private const val SEARCH_TRACK = "track.search"
    }

    @GET(BASE_PATH)
    fun searchArtist(
        @Query(ARTIST) artist: String,
        @Query(PAGE) page: Int = START_PAGE,
        @Query(API_KEY) key: String = Constants.API_KEY,
        @Query(FORMAT) format: String = FORMAT_JSON,
        @Query(METHOD) method: String = SEARCH_ARTIST
    ): Flowable<SearchResponse>

    @GET(BASE_PATH)
    fun searchAlbum(
        @Query(ALBUM) album: String,
        @Query(PAGE) page: Int = START_PAGE,
        @Query(API_KEY) key: String = Constants.API_KEY,
        @Query(FORMAT) format: String = FORMAT_JSON,
        @Query(METHOD) method: String = SEARCH_ALBUM
    ): Flowable<SearchResponse>

    @GET(BASE_PATH)
    fun searchSong(
        @Query(TRACK) song: String,
        @Query(PAGE) page: Int = START_PAGE,
        @Query(API_KEY) key: String = Constants.API_KEY,
        @Query(FORMAT) format: String = FORMAT_JSON,
        @Query(METHOD) method: String = SEARCH_TRACK
    ): Flowable<SearchResponse>
}
