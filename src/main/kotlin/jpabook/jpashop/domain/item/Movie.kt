package jpabook.jpashop.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("M")
class Movie (name: String, price: Int, stockQuantity: Int, id: Long, director: String, actor: String): Item(name, price, stockQuantity, id)