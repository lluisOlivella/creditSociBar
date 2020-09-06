package com.mugh.creditsocibar.backend

import com.mugh.creditsocibar.entities.OrderView

interface RefreshTable {

    fun onRefresh(order: OrderView)

}