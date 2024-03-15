package pojo;

import lombok.Getter;
import lombok.Setter;

public class UserAuth {
    @Getter @Setter private boolean success;
    @Getter @Setter private String accessToken;
    @Getter @Setter private String refreshToken;
    @Getter @Setter private User user;
}
