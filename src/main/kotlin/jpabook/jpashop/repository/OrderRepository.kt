package jpabook.jpashop.repository

import jpabook.jpashop.domain.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class OrderRepository (
    @PersistenceContext
    val em: EntityManager
) {
    fun save(order: Order) {
        em.persist(order)
    }

    fun findOne(id: Long): Order {
        return em.find(Order::class.java, id)
    }

    // fun findAll(orderSearch: OrderSearch) : List<Order> {}
}