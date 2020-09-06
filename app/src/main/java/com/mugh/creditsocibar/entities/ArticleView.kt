package com.mugh.creditsocibar.entities

import com.mugh.creditsocibar.entities.Menu.MenuComplement
import java.util.*

class ArticleView (
    var articleId:String,
    var order:Int?=0,
    var description:String?="",
    var import:Double?=0.0,
    var logo:Int?=null,
    var complements:MutableList<MenuComplement>?=null,
    var state: ArticleState?=null,
    var date: Date?=null
) {
}