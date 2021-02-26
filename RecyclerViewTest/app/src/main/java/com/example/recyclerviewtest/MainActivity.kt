package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val fruitList = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init_fruit()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList)
        recyclerView.adapter = adapter
    }
  private  fun init_fruit() {
        repeat(2){
            fruitList.add(Fruit("Apple", R.drawable.apple_pic))
            fruitList.add(Fruit("Banana", R.drawable.banana_pic))
            fruitList.add(Fruit("cherry", R.drawable.cherry_pic))
            fruitList.add(Fruit("grape", R.drawable.grape_pic))
            fruitList.add(Fruit("mango", R.drawable.mango_pic))
            fruitList.add(Fruit("orange", R.drawable.orange_pic))
            fruitList.add(Fruit("pear", R.drawable.pear_pic))
            fruitList.add(Fruit("pineapple", R.drawable.pineapple_pic))
            fruitList.add(Fruit("strawberry", R.drawable.strawberry_pic))
            fruitList.add(Fruit("watermelon", R.drawable.watermelon_pic))
        }
    }
}