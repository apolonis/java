package mikroservices.dbservices.Resource;

import mikroservices.dbservices.Repository.QuotesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResourse {

    QuotesRepository quotesRepository;

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable ("username") String username){


        return quotesRepository.findByUserName(username)
                    .stream().map(quote -> {
                      return quote.getQuote(); })
                    .collect(Collectors.toList());


    }

}
