package com.example.Lesson9Tasks.task1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Full name bo'sh bo'lmasligi kerak")
    private String full_name;
    @Positive(message = "Yoshi 0 dan katta bo'lishi kerak")
    private Integer age;
    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime created_at;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Groups groups;
}
