package com.mugh.creditsocibar.entities.Menu

import com.mugh.creditsocibar.R

class Menu {
    val types = getTypes()
}

fun getTypes(): Map<Type,MenuType> {
    var types = HashMap<Type,MenuType>()
    types[Type.DRINK] = MenuType(Type.DRINK,"Beguda")
    types[Type.FOOD] = MenuType(Type.FOOD,"Menjar")
    types[Type.OTHERS] = MenuType(Type.OTHERS,"Altres")
    return types
}

class MenuType(val type:Type, val description:String){
    var subTypes = getSubTypes(type)
}

fun getSubTypes(type:Type): Map<SubType,MenuSubType> {
    var subTypes = HashMap<SubType,MenuSubType>()

    when(type) {
        Type.FOOD -> {
            subTypes[SubType.SANDWICH] = MenuSubType(type,SubType.SANDWICH,"Bikini")
            subTypes[SubType.APPETIZER] = MenuSubType(type,SubType.APPETIZER,"Tapas")
        }
        Type.DRINK -> {
            subTypes[SubType.REFRESHMENT] = MenuSubType(type,SubType.REFRESHMENT,"Refrescos")
            subTypes[SubType.COFFEE] = MenuSubType(type,SubType.COFFEE,"Cafes i infusions")
            subTypes[SubType.ALCHOL] = MenuSubType(type,SubType.ALCHOL,"Alchol")
        }
        Type.OTHERS -> {
            subTypes[SubType.OTHERS] = MenuSubType(type,SubType.OTHERS,"Altres")
        }
    }
    return subTypes
}

class MenuSubType(type:Type,subType:SubType,description:String){
    var articles = getMenuArticles(type,subType)
}

fun getMenuArticles(type:Type,subType:SubType):Map<String,MenuArticle>?{
    var articles = HashMap<String,MenuArticle>()

    when(subType){
        SubType.APPETIZER -> {
            articles["CHIPS"] =
                MenuArticle("CHIPS",1,"Patates chips",0.8,null,type,subType,null)
            articles["OLIVES"] =
                MenuArticle("OLIVES",2,"Olives",1.0,null,type,subType,null)
        }
        SubType.SANDWICH -> {
            articles["BIKINI_TRAD"] =
                MenuArticle("BIKINI_TRAD",1,"Bikini Tradicional",2.0,R.drawable.bikini,type,subType,null)
            articles["BIKINI_SALAT"] =
                MenuArticle("BIKINI_SALAT",2,"Bikini Salat",2.5,R.drawable.bikini,type,subType,null)
            articles["BIKINI_IBERIC"] =
                MenuArticle("BIKINI_IBERIC",3,"Bikini Ibèric",2.5,R.drawable.bikini,type,subType,null)
            articles["BIKINI_ANGLES"] =
                MenuArticle("BIKINI_ANGLES",4,"Bikini Anglés",3.0,R.drawable.bikini,type,subType,null)
            articles["BIKINI_AMERICA"] =
                MenuArticle("BIKINI_AMERICA",5,"Bikini Americà",3.0,R.drawable.bikini,type,subType,null)
            articles["BIKINI_NORUEG"] =
                MenuArticle("BIKINI_NORUEG",6,"Bikini Nórueg",3.0,R.drawable.bikini,type,subType,null)
            articles["BIKINI_FORMATGE"] =
                MenuArticle("BIKINI_FORMATGE",7,"Bikini Formatge",2.0,R.drawable.bikini,type,subType,null)
            articles["BIKINI_DOLÇ"] =
                MenuArticle("BIKINI_DOLÇ",8,"Bikini Dolç",2.0,R.drawable.bikini,type,subType,null)
        }
        SubType.REFRESHMENT -> {
            articles["COCACOLA"] =
                MenuArticle("COCACOLA",1,"Coca-Cola",1.2,R.drawable.cocacola,type,subType,null)
        }
        SubType.COFFEE -> {
            articles["CAFE"] =
                MenuArticle("CAFE",1,"Cafè sol",1.0,R.drawable.cafe,type,subType,null)
        }
        SubType.ALCHOL -> {
            articles["MITJANA"] =
                MenuArticle("MITJANA",1,"Cerveza mitjana",1.5,null,type,subType,null)
        }
        SubType.OTHERS -> {
            articles["COMMENT"] =
                MenuArticle("COMMENT",1,"Comentario",0.0,null,type,subType,null)
        }
    }

    return articles
}

public enum class Type {
    FOOD,
    DRINK,
    OTHERS
}

enum class SubType {
    APPETIZER,
    SANDWICH,
    REFRESHMENT,
    COFFEE,
    ALCHOL,
    OTHERS
}