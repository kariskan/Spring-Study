package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity //jpa를 사용하는 클래스라고 인식
public class Member {

    @Id
    private Long id;
    @Column(name = "name")
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;

    public Member() {
    }
}
