package me.noman.recipes.data.preferences

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class RecipeSharedPreferences constructor(val context: Context) {

    private val TAG = "RecipeSharedPreferences"
    private val PREFERENCE_NAME = "Recipe_Pref"

    private fun getPreference(): SharedPreferences {
        return context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun save(key: String?, value: Any?) {
        if (value == null) {
            Log.e(TAG, "saveSharedPreference: Value = null; unable to save_image")
            return
        }
        val editor = getPreference().edit()
        if (value is Int) {
            editor.putInt(key, (value as Int?)!!)
        } else if (value is Float) {
            editor.putFloat(key, (value as Float?)!!)
        } else if (value is Boolean) {
            editor.putBoolean(key, (value as Boolean?)!!)
        } else if (value is Long) {
            editor.putLong(key, (value as Long?)!!)
        } else {
            editor.putString(key, value.toString())
        }
        editor.apply()
        editor.commit()
    }

    fun getString(Key: String?): String? {
        return getPreference().getString(Key, null)
    }

    fun getString(Key: String?, defaultValue: String?): String? {
        return getPreference().getString(Key, defaultValue)
    }

    fun getBoolean(key: String?): Boolean {
        return getPreference().getBoolean(key, false)
    }

    fun remove(key: String?) {
        val editor = getPreference().edit()
        editor.remove(key)
        editor.apply()
        editor.commit()
    }

}