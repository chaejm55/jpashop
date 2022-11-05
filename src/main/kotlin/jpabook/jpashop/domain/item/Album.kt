package jpabook.jpashop.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("A")
class Album (name: String, price: Int, stockQuantity: Int, id: Long, artist: String, etc: String): Item(name, price, stockQuantity, id)