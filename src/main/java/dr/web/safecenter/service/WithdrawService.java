package dr.web.safecenter.service;

import java.util.Map;

public interface WithdrawService {

	String withdraw(Map<String, String> param);

	Map<String, Object> exchange(Map<String, String> param, Map<String, Object> user);

}
