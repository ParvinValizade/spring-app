package paputu.company.az.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_hash_code",unique = true, nullable = false, length = 9)
    private String productHashCode;
    @Column(name = "product_name",nullable = false)
    private String productName;
    @Column(name = "product_type",nullable = false)
    private String productType;
    @Column(name = "product_volume",nullable = false)
    private Long productVolume;
}
