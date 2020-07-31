package kr.co.sol.admin.service.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sol.admin.dao.OrderMgrDAO;
import kr.co.sol.admin.service.OrderMgrService;
import kr.co.sol.shop.dto.OrderDTO;

	
@Service
public class OrderMgrServiceImpl implements OrderMgrService {
	@Autowired  
	OrderMgrDAO orderMgrDao;


	@Override
	public List<OrderDTO> getOrders(OrderDTO odto) {
		return orderMgrDao.getOrders(odto);
	}


	@Override
	public int insertOrders(Hashtable<Integer, OrderDTO> hCartList) {
		Set<Integer> keys = hCartList.keySet();
		List<OrderDTO> list = new ArrayList<OrderDTO>(keys.size());
		Iterator<Integer> iterKeys = keys.iterator();
		while(iterKeys.hasNext()) {
			list.add(hCartList.get(iterKeys.next()));
		}
		return orderMgrDao.insertOrders(list);
	}


}

