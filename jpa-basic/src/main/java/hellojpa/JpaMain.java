package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /**
             * 생성
             */
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            /**
             * 수정
             */
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//            findMember.setName("HelloJPA");

            /**
             * jpql
             */
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//            for (Member member : result) {
//                System.out.println("member = " + member.getName());
//            }

/*            //비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            //영속(이 때 DB에 저장되는것은 아니다)
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");

            Member findMember = em.find(Member.class, 101L);

            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());*/
//            Member memberA = new Member(1L,"A");
//            Member memberB = new Member(2L, "B");
//            System.out.println("persist");
//
//            System.out.println("find");
//            Member findA = em.find(Member.class, 1L);
//            System.out.println("findA.getName() = " + findA.getName());
//            System.out.println("findA.getId() = " + findA.getId());
//
            System.out.println("commit");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        //code
        emf.close();
    }
}