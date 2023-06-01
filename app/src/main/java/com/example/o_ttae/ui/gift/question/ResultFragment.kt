package com.example.o_ttae.ui.gift.question

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.o_ttae.data.db.DBManager
import com.example.o_ttae.ui.MainActivity
import com.example.o_ttae.R

class ResultFragment : Fragment() {

    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase
    lateinit var mainActivity: MainActivity
    lateinit var friendItem: TextView
    lateinit var productName: TextView
    lateinit var giftImg: ImageView
    lateinit var price: TextView
    lateinit var saveResultBtn: ImageButton
    lateinit var againButton: ImageButton
    lateinit var resultItemBg: ImageView
    lateinit var resultItemIntro: TextView

    lateinit var resultImg: ImageView
    private var result: String? = null
    private var myId: String? = null
    private var friendName: String? = null
    private var imgTemp: Int? = null

    private var friendItemComment: String = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            // QuestionFragment에서 검사한 결과를 받아오기
            result = it.getString("result")  // 데이터 수신
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_result, container, false)

        // 결과지에 세팅할 것들
        friendItem = view.findViewById(R.id.friend_item)
        productName = view.findViewById(R.id.product_name)
        price = view.findViewById(R.id.gift_price)
        giftImg = view.findViewById(R.id.cover_img)
        resultImg = view.findViewById(R.id.result_img)
        resultItemBg = view.findViewById(R.id.result_item_bg)
        resultItemIntro = view.findViewById(R.id.result_item_intro)
        saveResultBtn = view.findViewById(R.id.save_result_btn)

        val transaction = (context as MainActivity).supportFragmentManager.beginTransaction()

        // 다시 검사하기 버튼
        againButton = view.findViewById(R.id.again_btn)
        againButton.setOnClickListener {
            transaction.replace(R.id.main_frm, TakerInfoFirstFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        // result로 조건문 작성 -> 결과지 세팅
        when (result) {
            // 1. 어색, 집좋아, 허약, 보부상, 한식
            // 10100
            "10100" -> {
                loadData()

                // 보드게임
                friendItem.text = "집콕이 좋은 " + friendName + "님을 위한\n" + "멸종위기동물 보드게임 BRIDGES!"
                productName.text = "스프링샤인 / 멸종위기동물 보드게임"
                price.text = "34,000"
                imgTemp = R.drawable.result_board_game1_img
                resultImg.setImageResource(R.drawable.result_board_game2_img)
                giftImg.setImageResource(R.drawable.result_board_game1_img)
                friendItemComment = friendName + " 님을 위한 보드게임"
                resultItemBg.setImageResource(R.drawable.result_board_game3_img)
                resultItemIntro.text = getString(R.string.result_item_board_game_intro)
            }

            // 2. E, 밖, 운동, 보부상, 양식
            // 01001
            "01001" -> {
                loadData()

                // 대형가방
                friendItem.text = "보부상 프로 외출러 " + friendName + "님을 위한\n" + "자연미감 고급 자수 가방 BRIDGES!"
                productName.text = "자연미감 / 자연미감 고급 자수 가방"
                price.text = "24,000"
                imgTemp = R.drawable.result_sports_bag1_img
                resultImg.setImageResource(R.drawable.result_sports_bag2_img)
                giftImg.setImageResource(R.drawable.result_sports_bag1_img)
                friendItemComment = friendName + " 님을 위한 고급 자수 대형 가방"
                resultItemBg.setImageResource(R.drawable.result_sports_bag3_img)
                resultItemIntro.text = getString(R.string.result_item_sports_bag_intro)
            }

            // 3. I, 집, 운동, 미니멀, 양식
            // 10011
            "10011" -> {
                loadData()

                // 복분자원
                friendItem.text = "건강이 중요한 내향인 " + friendName + "님을 위한\n" + "해다미 복분자원 BRIDGES!"
                productName.text = "사회복지법인 다운회 아름다운 / 해다미 복분자원 "
                price.text = "26,000"
                imgTemp = R.drawable.result_chicken1_img
                resultImg.setImageResource(R.drawable.result_chicken2_img)
                giftImg.setImageResource(R.drawable.result_chicken1_img)
                friendItemComment = friendName + " 님을 위한 건강에 좋은 복분자원"
                resultItemBg.setImageResource(R.drawable.result_chicken3_img)
                resultItemIntro.text = getString(R.string.result_item_chicken_intro)
            }

            // 4. E, 밖, 허약, 미니멀, 한식 ->
            // 01110
            "01110" -> {
                loadData()

                // 에너지바
                friendItem.text = "외출이 좋지만 운동은 싫은 " + friendName + "님을 위한\n" + "13가지 견과류 수제간식 에너지바 BRIDGES!"
                productName.text = "사단법인 한국복지나눔 / 13가지 견과류 수제간식 에너지바 35g 20개입 1박스"
                price.text = "27,500"
                imgTemp = R.drawable.result_vitamin1_img
                resultImg.setImageResource(R.drawable.result_vitamin2_img)
                giftImg.setImageResource(R.drawable.result_vitamin1_img)
                friendItemComment = friendName + " 님을 위한 견과류 에너지바"
                resultItemBg.setImageResource(R.drawable.result_vitamin3_img)
                resultItemIntro.text = getString(R.string.result_item_vitamin_intro)
            }

            // 5. E, 밖, 허약, 보부상, 양식 -> 밖을 잘 돌아다니는 친구를 위한 보조배터리
            // 01101
            "01101" -> {
                loadData()

                // 보조배터리
                friendItem.text = "친구도 많고 외출도 자주! " + friendName + "님을 위한\n" + "일체형 보조배터리 BRIDGES!"
                productName.text = "오피스배재 / 플레오맥스 일체형 보조배터리 C타입 5000mAH"
                price.text = "14,200"
                imgTemp = R.drawable.result_battery1_img
                resultImg.setImageResource(R.drawable.result_battery2_img)
                giftImg.setImageResource(R.drawable.result_battery1_img)
                friendItemComment = friendName + " 님을 위한 보조배터리"
                resultItemBg.setImageResource(R.drawable.result_battery3_img)
                resultItemIntro.text = getString(R.string.result_item_battery_intro)
            }

            // 6. E, 밖, 운동인, 보부상, 한식 -> 외출을 자주하는 친구를 위한 계절밥상 기프티콘
            // 01000
            "01000" -> {
                loadData()

                // 계절밥상
                friendItem.text = "건강을 생각하는 한식파 " + friendName + "님을 위한\n" + "한식 도시락 6종류 BRIDGES!"
                productName.text = "아삭-아주 건강한 속삭임 / 한식 도시락 6종류"
                price.text = "8,000"
                imgTemp = R.drawable.result_food1_img
                resultImg.setImageResource(R.drawable.result_food2_img)
                giftImg.setImageResource(R.drawable.result_food1_img)
                friendItemComment = friendName + " 님을 위한 한식 도시락 6종류"
                resultItemBg.setImageResource(R.drawable.result_food3_img)
                resultItemIntro.text = getString(R.string.result_item_food_intro)
            }

            // 7. I, 집, 운동, 미니멀, 한식 -> I이지만 운동을 좋아하는 친구를 위한 운동기구 (덤벨)
            // 10010
            "10010" -> {
                loadData()

                // 찻잔세트
                friendItem.text = "미니멀리스트 내향인 " + friendName + "님을 위한\n" + "한글 패턴 후식잔(찻잔) 세트 BRIDGES!"
                productName.text = "소로시 / 한글 패턴 후식잔(찻잔) 세트"
                price.text = "20,000"
                imgTemp = R.drawable.result_teaset1_img
                resultImg.setImageResource(R.drawable.result_teaset2_img)
                giftImg.setImageResource(R.drawable.result_teaset1_img)
                friendItemComment = friendName + " 님을 위한 찻잔세트"
                resultItemBg.setImageResource(R.drawable.result_teaset3_img)
                resultItemIntro.text = getString(R.string.result_item_teaset_intro)

            }

            // 8. I, 집, 허약, 미니멀, 양식
            // 10111
            "10111" -> {
                loadData()

                // 카스테라
                friendItem.text = "집도 좋고 빵도 좋은" + friendName + "님을 위한\n" + "우리쌀 카스테라 BRIDGES!"
                productName.text = "경주제과 / [100% 국산쌀] 우리쌀 카스테라 2개입"
                imgTemp = R.drawable.result_fitness1_img
                price.text = "10,000"
                resultImg.setImageResource(R.drawable.result_fitness2_img)
                giftImg.setImageResource(R.drawable.result_fitness1_img)
                friendItemComment = friendName + " 님을 위한 우리쌀 카스테라"
                resultItemBg.setImageResource(R.drawable.result_fitness3_img)
                resultItemIntro.text = getString(R.string.result_item_fitness_intro)
            }

            else -> {
                loadData()

                // 아무거나 넣기
                friendItem.text = "미니멀리스트 내향인 " + friendName + "님을 위한\n" + "한글 패턴 후식잔(찻잔) 세트 BRIDGES!"
                productName.text = "소로시 / 한글 패턴 후식잔(찻잔) 세트"
                price.text = "20,000"
                imgTemp = R.drawable.result_teaset1_img
                resultImg.setImageResource(R.drawable.result_teaset2_img)
                giftImg.setImageResource(R.drawable.result_teaset1_img)
                friendItemComment = friendName + " 님을 위한 찻잔세트"
                resultItemBg.setImageResource(R.drawable.result_teaset3_img)
                resultItemIntro.text = getString(R.string.result_item_teaset_intro)
            }
        }


        //결과 저장하기 버튼
        saveResultBtn.setOnClickListener {
            dbManager = DBManager(mainActivity, "my", null, 1)
            sqlitedb = dbManager.writableDatabase
            saveResult()
            sqlitedb.close()
        }

        return view
    }

    // 저장 버튼 누르면 호출되는 함수
    private fun saveResult() {
        var productNameTemp: String = productName.text.toString()
        var priceTemp: String = price.text.toString()

        loadUserName()
        // 테이블에 검사 결과 저장
        sqlitedb.execSQL("INSERT INTO my VALUES('" + myId.toString() + "','" + friendItemComment + "','" + productNameTemp + "','" + priceTemp + "'," + imgTemp + ");")
    }

    // 추천받을 친구 이름 가져오는 함수
    private fun loadData() {
        var pref = this.activity?.getPreferences(0)
        var name = pref?.getString("friendName", "")

        friendName = name
    }

    // 현재 검사를 진행하고 이름 user아이디 가져오는 함수
    private fun loadUserName() {
        var pref = this.activity?.getSharedPreferences("name", 0)
        myId = pref?.getString("name", "0")
    }
}