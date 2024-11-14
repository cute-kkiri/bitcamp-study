package bitcamp.myapp.security09;

import bitcamp.myapp.vo.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class CustomUserDetails implements UserDetails {

  private final User user;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(() -> "ROLE_USER");
    if (user.getEmail().equals("admin@test.com")) {
      authorities.add(() -> "ROLE_ADMIN");
    }
    return authorities;
  }

  @Override
  public String getUsername() {
    return this.user.getEmail();
  }

  @Override
  public String getPassword() {
    return this.user.getPassword();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
