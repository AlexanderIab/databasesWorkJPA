package base;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Iablonski
 * */
@ToString(callSuper = true)
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class GroupAlpinist extends BaseId {
    private boolean closed;
    @OneToMany(mappedBy = "groupAlpinist", cascade = CascadeType.PERSIST)
    private final List<Alpinist> alpinists = new ArrayList<>();
    @JoinColumn(unique = true, nullable = false)
    @NonNull
    @OneToOne
    private Mount mount;

    public GroupAlpinist(){}

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
