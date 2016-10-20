package dr.web.product.service;

import java.util.Map;

import dr.web.common.base.InterfaceService;
import dr.web.common.page.Page;
import dr.web.common.page.Pageable;

public interface ProductDetailService extends InterfaceService{
	public Map<String, Object> findProductDetail(Map<String, Object> map);
	
	public Page<Map<String, Object>> investList(Pageable pageable, Map<String, Object> map);
	
	public Map<String, Object> v3ProductDetail(Map<String, Object> map);
	
	public Map<String, Object> orderinfo(Map<String, Object> map);
	
	public Map<String, Object> v3orderinfo(Map<String, Object> map);
}
