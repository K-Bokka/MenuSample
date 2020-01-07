package com.kbokka.android.menusample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  private fun createTeishokuList(): MutableList<MutableMap<String, Any>> {
    val menuList: MutableList<MutableMap<String, Any>> = mutableListOf()

    menuList.add(
      mutableMapOf("name" to "から揚げ定食", "price" to 800, "desc" to "若鶏のから揚げにサラダ、ご飯とお味噌汁が付きます。")
    )
    menuList.add(
      mutableMapOf("name" to "ハンバーグ定食", "price" to 810, "desc" to "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。")
    )
    Array(8) { it + 1 }.forEach {
      menuList.add(
        mutableMapOf(
          "name" to "ハンバーグ定食${it}",
          "price" to (820 + (it * 10)),
          "desc" to "手ごねハンバーグ${it}にサラダ、ご飯とお味噌汁が付きます。"
        )
      )
    }
    return menuList
  }
}
