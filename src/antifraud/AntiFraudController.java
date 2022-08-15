package antifraud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AntiFraudController {
	ObjectMapper mapper = new ObjectMapper();
	@PostMapping("/api/antifraud/transaction")
	public String transaction(@RequestBody Transaction transaction) throws JsonProcessingException {
		System.out.println("evaluating " + transaction.amount);
		return mapper.writeValueAsString(transaction.evaluate());
//		return "ok";
	}
}
