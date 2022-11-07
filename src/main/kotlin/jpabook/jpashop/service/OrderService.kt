package jpabook.jpashop.service

import jpabook.jpashop.domain.Delivery
import jpabook.jpashop.domain.Member
import jpabook.jpashop.domain.Order
import jpabook.jpashop.domain.OrderItem
import jpabook.jpashop.domain.item.Item
import jpabook.jpashop.repository.ItemRepository
import jpabook.jpashop.repository.MemberRepository
import jpabook.jpashop.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OrderService (
    val orderRepository: OrderRepository,
    val memberRepository: MemberRepository,
    val itemRepository: ItemRepository
) {

    /**
     * 주문
     */
    @Transactional
    fun order (memberId: Long, itemId: Long, count: Int): Long {
        // 엔티티 조회
        val member: Member = memberRepository.findOne(memberId)
        val item: Item = itemRepository.findOne(itemId)

        // 배송정보 생성
        val delivery: Delivery = Delivery(
            order = null,
            address = member.address,
            status = null,
        )

//        val delivery1 = Delivery::class.java.getConstructor().newInstance()
//        delivery1.address = member.address


        // 주문상품 생성, companion object 사용
        val orderItem: OrderItem = OrderItem.createOrderItem(item, item.price!!, count)

        // 주문 생성
        val order: Order = Order.createOrder(member, delivery, mutableListOf<OrderItem>(orderItem))

        // 주문 저장
        orderRepository.save(order)

        return order.id!!
    }
    /**
     * 주문취소
     */
    @Transactional
    fun cancelOrder(orderId: Long) {
        // 주문 엔티티 조회
        val order: Order = orderRepository.findOne(orderId)
        // 도메인 모델 패턴: 엔티티가 비즈니스 로직을 가짐
        // 주문 취소
        order.cancel()
    }
    
    // 검색
//    fun findOrders(orderSearch: OrderSearch) {
//        return orderRepository.findOne(orderSearch)
//    }
}