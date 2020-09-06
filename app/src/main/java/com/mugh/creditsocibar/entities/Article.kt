package com.mugh.creditsocibar.entities

import com.mugh.creditsocibar.entities.Menu.Menu
import com.mugh.creditsocibar.entities.Menu.MenuArticle
import com.mugh.creditsocibar.entities.Menu.SubType
import com.mugh.creditsocibar.entities.Menu.Type
import java.util.*

class Article(
    var menuArticleId: String?=null,
    var type: Type,
    var subType: SubType,
    var state: ArticleState?=null,
    var user: String?=null,
    var date: Date?=null
){

    fun convertToArticleView(articleId:String):ArticleView{
        var articleView = ArticleView(articleId)
        val menuArticle = Menu().types.get(key = this.type)?.subTypes?.get(key = this.subType)?.articles?.get(key = this.menuArticleId)
        articleView.articleId=articleId
        articleView.description=menuArticle?.description
        articleView.import=menuArticle?.import
        articleView.date = this.date
        articleView.logo=menuArticle?.logo
        articleView.state=this.state
        articleView.order=0
        return articleView
    }

}

