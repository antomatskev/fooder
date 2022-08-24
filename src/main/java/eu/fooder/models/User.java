package eu.fooder.models;

import eu.fooder.security.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor @AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private Long id;
    @Getter @Setter private UserRole userRole;
    @Getter @Setter private String password;
    @Getter @Setter private String username;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private boolean isAccountNonExpired;
    @Getter @Setter private boolean isAccountNonLocked;
    @Getter @Setter private boolean isCredentialsNonExpired;
    @Getter @Setter private boolean isEnabled;
//    @OneToOne
//    @Getter @Setter private Order currentOrder;
//    @OneToMany
//    @Getter @Setter private List<Order> orderList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRole.getGrantedAuthority();
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public void enableAll() {
        isEnabled = true;
        isAccountNonExpired = true;
        isAccountNonLocked = true;
        isCredentialsNonExpired = true;
    }

}
