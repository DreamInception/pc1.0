package dr.web.product.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import dr.web.common.base.InterfaceServiceImpl;
import dr.web.common.page.Page;
import dr.web.common.page.PageImpl;
import dr.web.common.page.Pageable;
import dr.web.product.service.ProductDetailService;

@Service
public class ProductDetailServiceImpl extends InterfaceServiceImpl<Map<String, Object>> implements ProductDetailService{
	private static final String nameSpace = "product_detail";
	@Override
	public String getNamespace() {
		return nameSpace;
	}
	@Override
	public Map<String, Object> findProductDetail(Map<String, Object> map) {
		 List<Map<String, Object>> findAllList = dao.findAllList(nameSpace, "findProductDetail", map);
		 if(findAllList != null && findAllList.size() > 0){
			 return findAllList.get(0);
		 }
		 return null;
	}
	@Override
	public Page<Map<String, Object>> investList(Pageable pageable, Map<String, Object> map) {
		if(Integer.valueOf(map.get("source").toString())==1){
		Integer count = dao.count(nameSpace, "investListCount", map);
		if(count == 0){
			return new PageImpl<>(Arrays.asList(),pageable,count);
		}
		List<Map<String, Object>> list = dao.findPageList(nameSpace, "investList", map);
		return new PageImpl<>(list, pageable, count); 
		}else{
			Integer count = dao.count(nameSpace, "v3investListCount", map);
			if(count == 0){
				return new PageImpl<>(Arrays.asList(),pageable,count);
			}
			List<Map<String, Object>> list = dao.findPageList(nameSpace, "v3investList", map);
			return new PageImpl<>(list, pageable, count); 
		}
	}
	@Override
	public Map<String, Object> v3ProductDetail(Map<String, Object> map) {
		List<Map<String, Object>> findAllList = dao.findAllList(nameSpace, "v3ProductDetail", map);
		 if(findAllList != null && findAllList.size() > 0){
			 return findAllList.get(0);
		 }
		 return null;
	}
	@Override
	public Map<String, Object> orderinfo(Map<String, Object> map) {
		Map<String, Object> order = dao.findById(nameSpace, "orderinfo", map);
		return order;
	}
	@Override
	public Map<String, Object> v3orderinfo(Map<String, Object> map) {
		Map<String, Object> order = dao.findById(nameSpace, "v3orderinfo", map);
		return order;
	}

}
