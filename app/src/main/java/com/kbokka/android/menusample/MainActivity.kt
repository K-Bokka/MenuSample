package com.kbokka.android.menusample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {

  private var _menuList: MutableList<MutableMap<String, Any>>? = null
  private val FROM = arrayOf("name", "price")
  private val TO = intArrayOf(R.id.tvMenuName, R.id.tvMenuPrice)


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    _menuList = createTeishokuList()
    val lvMenu = findViewById<ListView>(R.id.lvMenu)
    val adapter = SimpleAdapter(applicationContext, _menuList, R.layout.row, FROM, TO)

    lvMenu.adapter = adapter
    lvMenu.onItemClickListener = ListItemClickListener()
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.menu_options_menu_list, menu)
    return super.onCreateOptionsMenu(menu)
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

  private fun createCurryList(): MutableList<MutableMap<String, Any>> {
    val menuList: MutableList<MutableMap<String, Any>> = mutableListOf()

    menuList.add(
      mutableMapOf("name" to "ビーフカレー", "price" to 700, "desc" to "特選スパイスをきかせた国産ビーフ100%のカレーです。")
    )
    menuList.add(
      mutableMapOf("name" to "ポークカレー", "price" to 710, "desc" to "特選スパイスをきかせた国産ポーク100%のカレーです。")
    )
    Array(8) { it + 1 }.forEach {
      menuList.add(
        mutableMapOf(
          "name" to "ポークカレー${it}",
          "price" to (710 + it * 10),
          "desc" to "特選スパイス${it}をきかせた国産ポーク100%のカレーです。"
        )
      )
    }
    return menuList
  }

  private inner class ListItemClickListener : AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
      val item = parent.getItemAtPosition(position) as MutableMap<String, Any>
      val menuName = item["name"] as String
      val menuPrice = item["price"] as Int

      val intent = Intent(applicationContext, MenuThanksActivity::class.java)
      intent.putExtra("menuName", menuName)
      intent.putExtra("menuPrice", "${menuPrice}円")
      startActivity(intent)
    }
  }

}
