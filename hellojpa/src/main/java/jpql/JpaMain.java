package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            em.flush();
            em.clear();
//            typedQuery(em);
//            JPQLType(em);
//            caseQuery(em);
//            coalesce(em);
//            nullif(em);
//            jpqlBasicFunction(em);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void jpqlBasicFunction(EntityManager em) {
        String concatQuery = "select concat('a', 'b') From Member m";
        String substringQuery = "select substring(m.username, 2, 3) From Member m";
        String locateQuery = "select locate('de', 'abcdegf') From Member m";
        String sizeQuery = "select size(t.members) From Team t";
        em.createQuery(concatQuery, String.class)
                .getResultList();
        em.createQuery(substringQuery, String.class)
                .getResultList();
        em.createQuery(locateQuery, Integer.class)
                .getResultList();
        em.createQuery(sizeQuery, Integer.class)
                .getResultList();
    }

    private static void nullif(EntityManager em) {
        String query = "select nullif(m.username, '관리자') from Member m ";
        List<String> resultList = em.createQuery(query, String.class)
                .getResultList();
    }

    private static void coalesce(EntityManager em) {
        String query = "select coalesce(m.username, '이름 없는 회원') from Member m ";
        List<String> resultList = em.createQuery(query, String.class)
                .getResultList();
    }

    private static void caseQuery(EntityManager em) {
        String query = "select " +
                " case when m.age <= 10 then '학생요금'" +
                "      when m.age >= 60 then '경로요금'" +
                "      else '일반요금' " +
                " end " +
                "from Member m";
        List<String> resultList = em.createQuery(query, String.class)
                .getResultList();
    }

    private static void JPQLType(EntityManager em) {
        String query = "select m.username, 'HELLO', TRUE from Member as m where m.type = :userType";
        List resultList = em.createQuery(query)
                .setParameter("userType", MemberType.ADMIN)
                .getResultList();
    }

    private static void typedQuery(EntityManager em) {
        TypedQuery<Member> typedQuery = em.createQuery("select m from Member m", Member.class);
        List<Member> resultList = typedQuery.getResultList();
        for (Member member1 : resultList) {
            System.out.println("member1 = " + member1);
        }
        Query query = em.createQuery("select m.username, m.age from Member m where m.id = 10");
        Object singleResult = query.getSingleResult();
    }
}
