package com.mugh.creditsocibar.backend

import com.mugh.creditsocibar.entities.Order

interface OrdersService {

    fun newOrder(order: Order)

    fun getOrders(table: String,myCallback: RefreshTable)

}