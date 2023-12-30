package local.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="books")
public class BookEntity {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private @Getter @Setter int id;

  @Column(name="name")
  private @Getter @Setter String name;

  @Column(name="prize")
  private @Getter @Setter String prize;
  
  @Column(name="npages")
  private @Getter @Setter int number_pages;
}
