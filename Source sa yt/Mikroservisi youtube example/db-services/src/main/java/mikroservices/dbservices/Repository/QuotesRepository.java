package mikroservices.dbservices.Repository;

import mikroservices.dbservices.Model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotesRepository extends JpaRepository<Quote, Integer> {


    List<Quote> findByUserName(String username);
}
