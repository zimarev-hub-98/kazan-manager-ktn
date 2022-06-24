package com.automat.kazan_manager_ktl

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.automat.kazan_manager_ktl.Global.Companion.APP_SETTING_PREF
import com.automat.kazan_manager_ktl.Global.Companion.createSnackBar
import com.automat.kazan_manager_ktl.Global.Companion.createToast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
    }

    private fun init() {
        val bottomSheetSettingFragment = BottomSheetSettingFragment()

        val appSettingPref = getSharedPreferences(APP_SETTING_PREF, 0)
        val sharedPrefsEdit = appSettingPref.edit()


        btn_login.setOnClickListener {
            if (et_login.text.toString().isEmpty() || et_password.text.toString().isEmpty())
            createSnackBar(activity_login, "Заполните имя и пароль")
        }

        btn_setting.setOnClickListener {
            bottomSheetSettingFragment.show(supportFragmentManager, "BottomSheetDialog")
        }

        tv_forgot_psw.setOnClickListener { createToast(this, "Обратитесь в службу поддержки") }
        tv_create_acc.setOnClickListener { createToast(this, "Обратитесь в службу поддержки") }
    }
}