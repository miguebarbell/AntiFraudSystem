package antifraud;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Transaction {
	long amount;

	@JsonCreator
	public Transaction(@JsonProperty("amount") long amount) {
		this.amount = amount;
	}
	public EvaluatedTransaction evaluate() {
		return new EvaluatedTransaction(this.amount);
	}
	static class EvaluatedTransaction {
		public TrasactionEval result;
		public EvaluatedTransaction(long amount) {
			if (amount <= 0){
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			else if (amount <= 200) {
				result = TrasactionEval.ALLOWED;
			} else if (amount > 1500) {
				result = TrasactionEval.PROHIBITED;
			} else {
				result = TrasactionEval.MANUAL_PROCESSING;
			}
		}
	}
}
