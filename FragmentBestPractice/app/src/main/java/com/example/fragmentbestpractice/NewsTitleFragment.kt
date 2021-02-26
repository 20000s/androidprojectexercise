package com.example.fragmentbestpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.news_title_frag.*

class NewsTitleFragment : Fragment(){
    private var isTwoPane = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_title_frag,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isTwoPane = activity?.findViewById<View>(R.id.newsContentLayout) != null
        val layoutManager = LinearLayoutManager(activity)
        newsTitleRecyclerView.layoutManager = layoutManager
        val adapter = NewsAdapter(getnews())
        newsTitleRecyclerView.adapter = adapter
    }
    private fun getnews(): List<News>{
        val newsList = ArrayList<News>()
        for(i in 1..50){
            val news = News("this is news title $i", "this is sb")
            newsList.add(news)
        }
        return newsList
    }
    inner class NewsAdapter(val newsList: List<News>):
            RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
        inner class ViewHolder(view :View): RecyclerView.ViewHolder(view){
            val newsTitle : TextView = view.findViewById(R.id.newsTitle)
        }

        override fun getItemCount() = newsList.size
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
            val holder =ViewHolder(view)
            holder.itemView.setOnClickListener{
                val news = newsList[holder.adapterPosition]
                if(isTwoPane){
                    val fragment = newsContentFrag as NewsContentFragment
                    fragment.refresh(news.title,news.content)
                }else{
                    NewsContentActivity.actionStart(parent.context,news.title,news.content)
                }
            }
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text= news.title
        }
    }
}