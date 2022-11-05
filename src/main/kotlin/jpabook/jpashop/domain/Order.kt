package jpabook.jpashop.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order (
    @ManyToOne
    @JoinColumn(name = "member_id")
    val member: Member,

    @OneToMany(mappedBy = "order")
    val orderItems: List<OrderItem>,

    val orderDate: LocalDateTime,

    @OneToOne
    @JoinColumn(name = "delivery_id")
    val delivery: Delivery,

    @Enumerated(EnumType.STRING)
    val status: OrderStatus, // 주문상태 [ORDER, CANCEL]

    @Id @GeneratedValue
    @Column(name = "order_id")
    val id: Long?
)
