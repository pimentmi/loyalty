package com.hotels.loyalty.daos

import com.hotels.loyalty.LoyaltyPoint
import org.springframework.stereotype.Component

@Component
class PointDao {

    /** Map of point id to point **/
    val allPoints = mutableListOf(
            LoyaltyPoint(accountId = 50, usdValue = 100.0),
            LoyaltyPoint(accountId = 50, usdValue = 100.0),
            LoyaltyPoint(accountId = 50, usdValue = 200.0),
            LoyaltyPoint(accountId = 10, usdValue = 400.0),
            LoyaltyPoint(accountId = 10, usdValue = 500.0),
            LoyaltyPoint(accountId = 2, usdValue = 1000.0)
    ).map { it.id to it }.toMap().toMutableMap()

    fun getPointsFor(vararg accountIds: Int): List<LoyaltyPoint> {
        return allPoints.values.filter { accountIds.contains(it.accountId) }
    }

    fun upsertPoints(points: List<LoyaltyPoint>) {
        points.forEach { allPoints[it.id] =  it }
    }
}