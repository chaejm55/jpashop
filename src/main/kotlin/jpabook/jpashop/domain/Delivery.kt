package jpabook.jpashop.domain

import javax.persistence.*

@Entity
class Delivery (
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    val order: Order?,

    @Embedded
    val address: Address?,

    @Enumerated(EnumType.STRING)
    val status: DeliveryStatus?, // READY, COMP
) {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    val id: Long? = null
}