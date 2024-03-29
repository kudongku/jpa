package me.dongku.jpa.userChannel;

import jakarta.persistence.*;
import lombok.*;
import me.dongku.jpa.channel.Channel;
import me.dongku.jpa.user.User;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class UserChannel {
    /**
     * 컬럼 - 연관관계 컬럼을 제외한 컬럼을 정의합니다.
     */
    @EmbeddedId
    private UserChannelId userChannelId;
    /**
     * 생성자 - 약속된 형태로만 생성가능하도록 합니다.
     */
    @Builder
    public UserChannel(User user, Channel channel){
        this.user = user;
        this.channel = channel;
    }


    /**
     * 연관관계 - Foreign Key 값을 따로 컬럼으로 정의하지 않고 연관 관계로 정의합니다.
     */
    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("channelId")
    private Channel channel;

    /**
     * 연관관계 편의 메소드 - 반대쪽에는 연관관계 편의 메소드가 없도록 주의합니다.
     */

    /**
     * 서비스 메소드 - 외부에서 엔티티를 수정할 메소드를 정의합니다. (단일 책임을 가지도록 주의합니다.)
     */
}
