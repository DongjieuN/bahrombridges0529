package com.example.o_ttae.ui.gift.question

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.example.o_ttae.ui.MainActivity
import com.example.o_ttae.R

class QuestionFragment : Fragment() {

    lateinit var questionProgressSb: SeekBar
    lateinit var questionProgressTv: TextView
    lateinit var questionContentTv: TextView
    lateinit var questionAnswerTopBtn: Button
    lateinit var questionAnswerBottomBtn: Button

    var resultS: String = ""  // 사용자의 답변 저장

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_question, container, false)

        questionProgressSb = view.findViewById(R.id.question_progress_sb)
        questionProgressTv = view.findViewById(R.id.question_progress_tv)
        questionContentTv = view.findViewById(R.id.question_content_tv)
        questionAnswerTopBtn = view.findViewById(R.id.question_answer_top_btn)
        questionAnswerBottomBtn = view.findViewById(R.id.question_answer_bottom_btn)

        //초기화
        resultS = ""

        val transaction = (context as MainActivity).supportFragmentManager.beginTransaction()

        // 상단 답 버튼 클릭 시
        questionAnswerTopBtn.setOnClickListener {
            questionProgressSb.progress += 25  // 진행률 증가

            // 진행률에 따른 질문, 답, 진행된 질문 개수 설정
            when (questionProgressSb.progress) {
                25 -> {
                    //위에 답 클릭
                    resultS += "0"
                    questionProgressTv.text = "2/5"
                    questionContentTv.text = "당신이 휴일을\n보내는 방법은?"
                    questionAnswerTopBtn.text = "집이 좋아!\n 집콕하면서 영화 시청"
                    questionAnswerBottomBtn.text = "밖이 좋아!\n 친구들과 함께 외출"
                }
                50 -> {
                    //위에 답 클릭
                    resultS += "0"
                    questionProgressTv.text = "3/5"
                    questionContentTv.text = "건강에 얼마나\n관심이 있나요?"
                    questionAnswerTopBtn.text = "관심 多\n 아무리 바빠도 운동은 꼭!"
                    questionAnswerBottomBtn.text = "관심 少\n 숨쉬는 것도 운동이야.."
                }
                75 -> {
                    //위에 답 클릭
                    resultS += "0"
                    questionProgressTv.text = "4/5"
                    questionContentTv.text = "what's in\nmy bag?"
                    questionAnswerTopBtn.text = "바리바리스타\n 일단 필요할 수 있으니 다 챙겨"
                    questionAnswerBottomBtn.text = "가방이 필요해?\n 핸드폰만 있으면 충분"
                }
                100 -> {
                    //위에 답 클릭
                    resultS += "0"
                    questionProgressTv.text = "5/5"
                    questionContentTv.text = "나의 음식 취향은?"
                    questionAnswerTopBtn.text = "한국인은 밥심\n 한식파"
                    questionAnswerBottomBtn.text = "밥보다는 빵\n 양식파"

                    questionAnswerTopBtn.setOnClickListener {
                        //위에 답 클릭
                        resultS += "0"

                        // 결과지로 이동
                        sendAnswers()
                    }

                    questionAnswerBottomBtn.setOnClickListener {
                        //아래 답 클릭
                        resultS += "1"

                        // 결과지로 이동
                        sendAnswers()
                    }
                }
                else -> {
                    // 결과지로 이동
                    sendAnswers()
                }
            }
        }

        // 하단 답 버튼 클릭 시
        questionAnswerBottomBtn.setOnClickListener {
            questionProgressSb.progress += 25  // 진행률 증가

            // 진행률에 따른 질문, 답, 진행된 질문 개수 설정
            when (questionProgressSb.progress) {
                25 -> {
                    //아래 답 클릭
                    resultS += "1"
                    questionProgressTv.text = "2/5"
                    questionContentTv.text = "당신이 휴일을\n보내는 방법은?"
                    questionAnswerTopBtn.text = "집이 좋아!\n 집콕하면서 영화 시청"
                    questionAnswerBottomBtn.text = "밖이 좋아!\n 친구들과 함께 외출"
                }
                50 -> {
                    //아래 답 클릭
                    resultS += "1"
                    questionProgressTv.text = "3/5"
                    questionContentTv.text = "건강에 얼마나\n관심이 있나요?"
                    questionAnswerTopBtn.text = "관심 多\n 아무리 바빠도\n운동은 꼭!"
                    questionAnswerBottomBtn.text = "관심 少\n 숨쉬는 것도 운동이야.."

                }
                75 -> {
                    //아래 답 클릭
                    resultS += "1"
                    questionProgressTv.text = "4/5"
                    questionContentTv.text = "what's in\nyour bag?"
                    questionAnswerTopBtn.text = "바리바리스타\n 일단 필요할 수 있으니 다 챙겨"
                    questionAnswerBottomBtn.text = "가방이 필요해?\n 핸드폰만 있으면 충분"
                }
                100 -> {
                    //아래 답 클릭
                    resultS += "1"
                    questionProgressTv.text = "5/5"
                    questionContentTv.text = "나의 음식 취향은?"
                    questionAnswerTopBtn.text = "한국인은 밥심\n 한식파"
                    questionAnswerBottomBtn.text = "밥보다는 빵\n 양식파"

                    questionAnswerBottomBtn.setOnClickListener {
                        //아래 답 클릭
                        resultS += "1"

                        // 결과지로 이동
                        sendAnswers()
                    }

                    questionAnswerTopBtn.setOnClickListener {
                        //위에 답 클릭
                        resultS += "0"

                        // 결과지로 이동
                        sendAnswers()
                    }
                }
                else -> {
                    // 결과지로 이동
                    sendAnswers()
                }
            }
        }

        return view
    }

    fun sendAnswers() {
        val mActivity = activity as MainActivity
        mActivity.setDataAtFragment(ResultFragment(), resultS)
    }
}