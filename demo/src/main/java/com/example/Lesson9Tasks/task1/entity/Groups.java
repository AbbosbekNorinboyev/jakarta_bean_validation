package com.example.Lesson9Tasks.task1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Group name bo'sh bo'lmasligi kerak")
    private String group_name;
    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime created_at;
    @Min(value = 24, message = "O'quvchilar soni {value} ta dan kam bo'lmasligi kerak")
    private Integer count;
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "groups"
    )
    private List<Student> student;
}
