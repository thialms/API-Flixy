package br.com.flixy.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "streaming")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Streaming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;
}
