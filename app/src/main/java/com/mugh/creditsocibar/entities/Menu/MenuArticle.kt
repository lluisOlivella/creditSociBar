package com.mugh.creditsocibar.entities.Menu

class MenuArticle(
    var idArticle:String,
    var order:Int,
    var description:String,
    var import:Double,
    var logo:Int?,
    var type:Type,
    var subType:SubType,
    var complements:MutableList<MenuComplement>?) {



}

