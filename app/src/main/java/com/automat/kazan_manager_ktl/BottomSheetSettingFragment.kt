package com.automat.kazan_manager_ktl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.automat.kazan_manager_ktl.Global.Companion.APP_SETTING_PREF
import com.automat.kazan_manager_ktl.Global.Companion.IP_ADDRESS
import com.automat.kazan_manager_ktl.Global.Companion.getSP
import com.automat.kazan_manager_ktl.Global.Companion.saveSP
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.bottomsheet_setting_fragment.*

class BottomSheetSettingFragment: BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottomsheet_setting_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences = view.context.getSharedPreferences(APP_SETTING_PREF, 0)
        et_ip_address.setText(getSP(sharedPreferences, IP_ADDRESS))
        btn_save_setting.setOnClickListener {
            val ipAddress: String = et_ip_address.text.toString()
            saveSP(sharedPreferences, IP_ADDRESS, ipAddress)
            this.context?.let { it1 -> Global.createToast(it1, "Успешно") }
            this.dismiss()
        }
    }
}