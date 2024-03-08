package me.dongku.jpa.mention;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.dongku.jpa.user.User;
import me.dongku.jpa.thread.Thread;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Mention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    Thread thread;

    @Builder
    public Mention(User user, Thread thread) {
        this.user = user;
        this.thread = thread;
    }
}
