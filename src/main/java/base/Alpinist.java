package base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;


@ToString(callSuper = true)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Entity
public class Alpinist extends BaseId {
    @NonNull
    @Column(unique = true, nullable = false)
    private String name;
    @NonNull
    @Column(nullable = false)
    private String address;
    @ManyToOne
    private GroupAlpinist groupAlpinist;

    public Alpinist(){}
}