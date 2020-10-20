package com.example.guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //猜拳
        btn_mora.setOnClickListener {
            //判斷字串是否空白來要求輸入姓名
            if (ed_name.length() < 1){
                tv_game_status.text = R.string.inputNameStartGame.toString()
            } else {
                //顯示玩家姓名與我方出拳
                tv_name.text = String.format("名字\n%s", ed_name.text)
                tv_me_mora.text = String.format("我方出拳\n${
                    when {
                        btn_scissor.isChecked -> "剪刀"
                        btn_stone.isChecked -> "石頭"
                        else -> "布"
                    }
                }")

                //Random()產生0~1之間不含1的亂數，乘3產生 0~2當作電腦的出拳
                val computer = (Math.random() * 3).toInt()
                tv_pc_mora.text = String.format("電腦出拳\n${
                    when (computer) {
                        0 -> "剪刀"
                        1 -> "石頭"
                        else -> "布"
                    }
                }")

                //用三個判斷式判斷並顯示猜拳結果
                when {
                        btn_scissor.isChecked && computer == 2 ||
                            btn_stone.isChecked && computer == 0 ||
                            btn_paper.isChecked && computer == 1 ->{
                                tv_winner.text = String.format("勝利者\n${ed_name.text}")
                                tv_game_status.text = "恭喜你獲勝了!"
                    }

                        btn_scissor.isChecked && computer == 1 ||
                        btn_stone.isChecked && computer == 2   ||
                        btn_paper.isChecked && computer == 0 ->{
                            tv_winner.text = String.format("勝利者 \n電腦")
                            tv_game_status.text = " 可惜，電腦獲勝了！ "
                        }
                        else -> {
                            tv_winner.text = String.format("勝利者\n平手")
                            tv_game_status.text = "平局，再試一次!"
                        }
                    }

            }
        }

    }
}