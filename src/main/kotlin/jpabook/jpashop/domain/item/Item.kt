package jpabook.jpashop.domain.item

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
class Item (
    val name: String,
    val price: Int,
    val stockQuantity: Int,

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    val id: Long
)
