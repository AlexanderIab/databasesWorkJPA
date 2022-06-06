package base;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true)
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class GroupAlpinist extends BaseId {
    @Setter
    private boolean closed;
    @OneToMany(mappedBy = "groupAlpinist", cascade = CascadeType.PERSIST)
    private final List<Alpinist> alpinists = new ArrayList<>();
    @Column(unique = true, nullable = false)
    @NonNull
    private Mount mount;

    public void addAlpinist(Alpinist... alps) {
        if (closed) {
            System.out.println("Набор закрыт");
            return;
        }
        for (Alpinist alpinist : alps) {
            if (alpinists.size() < 3) {
                alpinist.setGroupAlpinist(this);
                alpinists.add(alpinist);
            }
            if (alpinists.size() == 3){
                setClosed(true);
                System.out.println("Группа заполнена");
            }
        }
    }
}
