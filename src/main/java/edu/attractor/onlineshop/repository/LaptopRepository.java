package edu.attractor.onlineshop.repository;

import edu.attractor.onlineshop.entity.Laptop;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

    @Query("select l from Laptop l")
    Optional<Slice<Laptop>> getAllLaptops(Pageable pageable);
/*
@NamedQuery(
    name="findAllCustomersWithName",
    query="SELECT c FROM Customer c WHERE c.name LIKE :custName"
)
Here’s an example of createNamedQuery, which uses the @NamedQuery:

@PersistenceContext
public EntityManager em;
...
customers = em.createNamedQuery("findAllCustomersWithName")
    .setParameter("custName", "Smith")
    .getResultList();
 */

   /*
   public List findWithName(String name) {
return em.createQuery(
    "SELECT c FROM Customer c WHERE c.name LIKE :custName")
    .setParameter("custName", name)
    .setMaxResults(10)
    .getResultList();
}
    */




    Optional<Laptop> findById(Integer commentId);
}
