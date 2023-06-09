package com.example.o_ttae.ui.my

import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.o_ttae.*
import com.example.o_ttae.data.adapter.MyGiftListAdapter
import com.example.o_ttae.data.db.DBManager
import com.example.o_ttae.data.model.MyGiftList
import com.example.o_ttae.ui.MainActivity
import com.example.o_ttae.ui.login.LoginPageActivity
import kotlinx.android.synthetic.main.fragment_my.*
import java.util.*



class MyFragment : Fragment() {

    lateinit var mainActivity: MainActivity
    private var giftData = ArrayList<MyGiftList>()
    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase
    private var userId: String? = null
    lateinit var myTitleTv: TextView
    lateinit var myLogOutBtn: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            userId = it.getString("userId")  // 데이터 수신
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_my, container, false)

        // 사용자 이름 설정
        myTitleTv = view.findViewById(R.id.my_title_tv)
        myLogOutBtn = view.findViewById(R.id.my_log_out_btn)
        myLogOutBtn.setOnClickListener {
            startActivity(Intent(mainActivity, LoginPageActivity::class.java))
        }

        // db 읽어서 배열에 저장
        dbManager = DBManager(mainActivity, "my", null, 1)
        sqlitedb = dbManager.readableDatabase

        // 현재 로그인 한 user의 아이디를 가져오기
        loadUserName()
        // 가져온 user의 아이디를 사용하여 my 테이블에서 user의 선물추천 받은 기록을 불러오기

        return view
    }


    // 로그인한 사용자 이름 가져와서 my페이지에 문구 세팅
    private fun loadUserName() {
        var pref = this.activity?.getSharedPreferences("name", 0)
        userId = pref?.getString("name", "0")

        myTitleTv.text = userId + "님의 MY PAGE"
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        my_user_info_edit_tv.setOnClickListener {
            val url = "https://easylaw.go.kr/CSP/CnpClsMain.laf?csmSeq=652&ccfNo=1&cciNo=1&cnpClsNo=1"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        user_notice_tv.setOnClickListener {
            val url = "https://www.socialenterprise.or.kr/social/ente/company.do?m_cd=D003"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }




    }
}
