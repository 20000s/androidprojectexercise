package com.example.listviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init_fruit()
        val adapter = FruitAdapter(this,R.layout.friut_item,fruitList)
        ListView.adapter = adapter
        ListView.setOnItemClickListener{ parent, view, position, id ->
            val fruit = fruitList[position]
            Toast.makeText(this,fruit.name,Toast.LENGTH_SHORT).show()
        }

    }
    fun init_fruit() {
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