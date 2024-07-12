package com.smartlab411.personaltailor.android.http

import android.content.Context
import android.content.SharedPreferences
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import java.net.URL
import java.util.concurrent.ConcurrentHashMap

/**
 * TODO Cookie持久化Jar
 *
 * @constructor
 * TODO
 *
 * @param context
 */
class PersistentCookieJar(context: Context?) : CookieJar {

    private var sharedPreferences: SharedPreferences? = null
    private val cookies: MutableMap<String, MutableList<Cookie>> = ConcurrentHashMap()

    init {
        context?.let {
            sharedPreferences = it.getSharedPreferences("CookiePrefs", Context.MODE_PRIVATE)
        }
        // Load cookies from SharedPreferences
        sharedPreferences?.all?.forEach { (host, cookieSet) ->
            val cookiesString = cookieSet as? String
            cookiesString?.let {
                val cookieList = mutableListOf<Cookie>()
                it.split(";").forEach { cookieString ->
                    Cookie.parse(HttpUrl.get(URL("https://"+host)), cookieString)?.let { cookie ->
                        cookieList.add(cookie)
                    }
                }
                cookies[host] = cookieList
            }
        }
    }

    /**
     * 从响应中保存 Cookies 到本地 SharedPreferences 中。
     *
     * @param url 请求的 URL
     * @param cookies 从响应中获取的 Cookies 列表
     */
    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        val host = url.host()
        val cookiesString = cookies.joinToString("; ") { it.toString() }
        val editor = sharedPreferences?.edit()
        editor?.putString(host, cookiesString)
        editor?.apply()
        this.cookies[host] = cookies.toMutableList()
    }

    /**
     * 加载指定 URL 的请求所需的 Cookies。
     *
     * @param url 请求的 URL
     * @return 返回该 URL 对应的 Cookies 列表，如果没有则返回空列表
     */
    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        val host = url.host()
        return cookies[host] ?: emptyList()
    }

    companion object {
        private const val TAG = "PersistentCookieJar"
    }
}
