package base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;


/**
 * @author Alexander Iablonski
 * */
@ToString(callSuper = true)
@Getter
@Setter
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
