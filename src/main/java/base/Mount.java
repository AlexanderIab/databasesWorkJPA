package base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Mount extends BaseId {
    @Column(unique = true, nullable = false)
    @NonNull
    private String mountTitle;
    @Column(unique = true, nullable = false)
    @NonNull
    private String country;
    @Column(unique = true, nullable = false)
    private final int height;
    private GroupAlpinist groupAlpinist;

}
