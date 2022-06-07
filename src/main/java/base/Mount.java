package base;

import jakarta.persistence.*;
import lombok.*;

@ToString(callSuper = true)
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
    @NonNull
    private int height;
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "mount")
    private GroupAlpinist groupAlpinist;

    public Mount(){}

}
