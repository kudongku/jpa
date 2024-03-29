package me.dongku.jpa.userChannel;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class UserChannelId implements Serializable {

    @Column(name = "user_id")
    private Long userId;   // UserChannel 의 user 필드명과 동일해야함
    @Column(name = "channel_id")
    private Long channelId; // UserChannel 의 channel 필드명과 동일해야함

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserChannelId userChannelId = (UserChannelId) o;
        return Objects.equals(getUserId(), userChannelId.getUserId()) && Objects.equals(getChannelId(), userChannelId.getChannelId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getChannelId());
    }
}
