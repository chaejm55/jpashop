package jpabook.jpashop.domain.item

import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("B")
class Book(name: String, price: Int, stockQuantity: Int, id: Long, author: String, isbn: String): Item(name, price, stockQuantity, id)