package com.automat.kazan_manager_ktl

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class Global {

    companion object {
        const val APP_SETTING_PREF = "AppSettingPref"
        const val IP_ADDRESS = "IpAddress"

        // <SharedPreferences>

        fun <T> saveSP(sharedPref: SharedPreferences, KEY_NAME: String, value: T) {
            val editor: SharedPreferences.Editor = sharedPref.edit()
            editor.putString(KEY_NAME, "$value")
            editor.apply()
        }

        fun getSP(sharedPref: SharedPreferences, KEY_NAME: String) : String? {
            return sharedPref.getString(KEY_NAME, "")
        }

        fun deleteAllSP(sharedPref: SharedPreferences, KEY_NAME: String) {
            val editor: SharedPreferences.Editor = sharedPref.edit()

            editor.remove(KEY_NAME)
            editor.apply()
        }
        // </SharedPreferences>

        // SnackBar
        fun createSnackBar(view: View, text: String) {
            Snackbar.make(view, text, Snackbar.LENGTH_SHORT).setAction("Ok") {}.show()
        }

        fun createToast(context: Context, text: String) {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }
    }
}