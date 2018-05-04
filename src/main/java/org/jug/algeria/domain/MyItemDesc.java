package org.jug.algeria.domain;


import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@Table(name = "my_item_descr")
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = "myItem")
@NoArgsConstructor
public class MyItemDesc {

  private static final String GENERATOR_NAME = "my_item_descr_id_seq";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR_NAME)
  @SequenceGenerator(name = GENERATOR_NAME, sequenceName = GENERATOR_NAME, allocationSize = 1)
  private Long id;

  @NotNull
  private String descr;

}
