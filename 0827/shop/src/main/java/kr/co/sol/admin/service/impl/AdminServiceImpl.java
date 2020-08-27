package kr.co.sol.admin.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sol.admin.dao.AdminDAO;
import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.admin.dto.ItemDTO;
import kr.co.sol.admin.dto.MemberDTO;
import kr.co.sol.admin.dto.OrderCancelDTO;
import kr.co.sol.admin.dto.OrderDTO;
import kr.co.sol.admin.dto.PageDTO;
import kr.co.sol.admin.dto.ItemInquiryDTO;
import kr.co.sol.admin.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO adminDao;
	
	@Override
	public String logon(AdminDTO adto) {
		return adminDao.logon(adto);
	}

	@Override
	public HashMap<String, Object> getItemInquirys(PageDTO pdto) {
		 // TODO Auto-generated method stub
	      HashMap<String, Object> hash = new HashMap<String, Object>();
	      // 페이징 처리
	      // 한 페이지에 출력 할 article 개수
	      pdto.setLinePerPage(9);
	      if (pdto.getPresentPage() == 0) {
	         pdto.setPresentPage(1);
	      }
	      int presentPage = pdto.getPresentPage();

	      // 전체 레코드 수
	      int allCount = adminDao.getItemInquiryscnt();
	      pdto.setAllCount(allCount);
	      System.out.println("allCount ; " + allCount);
	      // 전체 페이지 개수
	      int allPage = allCount / pdto.getLinePerPage() + 1;
	      pdto.setAllPage(allPage);

	      int crb = 1;
	      if (presentPage == 1) {
	         pdto.setPresentPageBlock(crb);
	      } else {
	         crb = presentPage % pdto.getPageBlockPerNumber() == 0 ? presentPage / pdto.getPageBlockPerNumber()
	               : presentPage / pdto.getPageBlockPerNumber() + 1;
	         pdto.setPresentPageBlock(crb);
	      }
	      // 페이지 블럭 하나에 포함 될 페이지 수
	      int linePerPageNumber = 7;
	      if (presentPage - linePerPageNumber / 2 <= 1) {
	         pdto.setStartPage(1);
	         if (linePerPageNumber >= allPage)
	            pdto.setEndPage(allPage);
	         else
	            pdto.setEndPage(linePerPageNumber);
	      } else if (presentPage + linePerPageNumber / 2 >= allPage) {
	         pdto.setEndPage(allPage);
	         if (allPage - linePerPageNumber + 1 <= 0)
	            pdto.setStartPage(1);
	         else
	            pdto.setStartPage(allPage - linePerPageNumber + 1);
	      } else {
	         pdto.setStartPage(presentPage - linePerPageNumber / 2);
	         pdto.setEndPage(presentPage + linePerPageNumber / 2);
	      }

	      int start = (presentPage - 1) * pdto.getLinePerPage() + 1;
	      int end = presentPage * pdto.getLinePerPage();
	      System.out.println("start ; " + start);
	      System.out.println("end ; " + end);
	      List<ItemInquiryDTO> list = adminDao.getItemInquirys(start, end);
	      // 페이징 처리 끝
	      hash.put("pdto", pdto);
	      hash.put("list", list);
	      return hash;
	}

	@Override
	public HashMap<String, Object> getMember(PageDTO pdto) {
		 // TODO Auto-generated method stub
	      HashMap<String, Object> hash = new HashMap<String, Object>();
	      // 페이징 처리
	      // 한 페이지에 출력 할 article 개수
	      pdto.setLinePerPage(9);
	      if (pdto.getPresentPage() == 0) {
	         pdto.setPresentPage(1);
	      }
	      int presentPage = pdto.getPresentPage();

	      // 전체 레코드 수
	      int allCount = adminDao.getMemberCount();
	      pdto.setAllCount(allCount);
	      System.out.println("allCount ; " + allCount);
	      // 전체 페이지 개수
	      int allPage = allCount / pdto.getLinePerPage() + 1;
	      pdto.setAllPage(allPage);

	      int crb = 1;
	      if (presentPage == 1) {
	         pdto.setPresentPageBlock(crb);
	      } else {
	         crb = presentPage % pdto.getPageBlockPerNumber() == 0 ? presentPage / pdto.getPageBlockPerNumber()
	               : presentPage / pdto.getPageBlockPerNumber() + 1;
	         pdto.setPresentPageBlock(crb);
	      }
	      // 페이지 블럭 하나에 포함 될 페이지 수
	      int linePerPageNumber = 7;
	      if (presentPage - linePerPageNumber / 2 <= 1) {
	         pdto.setStartPage(1);
	         if (linePerPageNumber >= allPage)
	            pdto.setEndPage(allPage);
	         else
	            pdto.setEndPage(linePerPageNumber);
	      } else if (presentPage + linePerPageNumber / 2 >= allPage) {
	         pdto.setEndPage(allPage);
	         if (allPage - linePerPageNumber + 1 <= 0)
	            pdto.setStartPage(1);
	         else
	            pdto.setStartPage(allPage - linePerPageNumber + 1);
	      } else {
	         pdto.setStartPage(presentPage - linePerPageNumber / 2);
	         pdto.setEndPage(presentPage + linePerPageNumber / 2);
	      }

	      int start1 = (presentPage - 1) * pdto.getLinePerPage() + 1;
	      int end1 = presentPage * pdto.getLinePerPage();
	      System.out.println("start ; " + start1);
	      System.out.println("end ; " + end1);
	      List<MemberDTO> list = adminDao.getMember(start1, end1);
	      // 페이징 처리 끝
	      hash.put("pdto", pdto);
	      hash.put("list", list);
	      return hash;
	}

//	@Override
//	public List<OrderDTO> getOrder(OrderDTO odto) {
//		return adminDao.getOrder(odto);
//	}
	
	@Override
	public HashMap<String, Object> getOrder(PageDTO pdto, int order_no) {
		 // TODO Auto-generated method stub
	      HashMap<String, Object> hash = new HashMap<String, Object>();
	      // 페이징 처리
	      // 한 페이지에 출력 할 article 개수
	      pdto.setLinePerPage(9);
	      if (pdto.getPresentPage() == 0) {
	         pdto.setPresentPage(1);
	      }
	      int presentPage = pdto.getPresentPage();

	      // 전체 레코드 수
	      int allCount = adminDao.getOrderCount();
	      pdto.setAllCount(allCount);
	      System.out.println("allCount ; " + allCount);
	      // 전체 페이지 개수
	      int allPage = allCount / pdto.getLinePerPage() + 1;
	      pdto.setAllPage(allPage);

	      int crb = 1;
	      if (presentPage == 1) {
	         pdto.setPresentPageBlock(crb);
	      } else {
	         crb = presentPage % pdto.getPageBlockPerNumber() == 0 ? presentPage / pdto.getPageBlockPerNumber()
	               : presentPage / pdto.getPageBlockPerNumber() + 1;
	         pdto.setPresentPageBlock(crb);
	      }
	      // 페이지 블럭 하나에 포함 될 페이지 수
	      int linePerPageNumber = 7;
	      if (presentPage - linePerPageNumber / 2 <= 1) {
	         pdto.setStartPage(1);
	         if (linePerPageNumber >= allPage)
	            pdto.setEndPage(allPage);
	         else
	            pdto.setEndPage(linePerPageNumber);
	      } else if (presentPage + linePerPageNumber / 2 >= allPage) {
	         pdto.setEndPage(allPage);
	         if (allPage - linePerPageNumber + 1 <= 0)
	            pdto.setStartPage(1);
	         else
	            pdto.setStartPage(allPage - linePerPageNumber + 1);
	      } else {
	         pdto.setStartPage(presentPage - linePerPageNumber / 2);
	         pdto.setEndPage(presentPage + linePerPageNumber / 2);
	      }

	      int start = (presentPage - 1) * pdto.getLinePerPage() + 1;
	      int end = presentPage * pdto.getLinePerPage();
	      System.out.println("start ; " + start);
	      System.out.println("end ; " + end);
	      List<OrderDTO> list = adminDao.getOrder(start, end, order_no);
	      // 페이징 처리 끝
	      hash.put("pdto", pdto);
	      hash.put("list", list);
	      return hash;
	}
	
	
	
	

	@Override
	public List<OrderCancelDTO> getOrderCancel(OrderCancelDTO ocdto) {
		return adminDao.getOrderCancel(ocdto);
	}

	@Override
	public HashMap<String, Object> getItem(PageDTO pdto) {
	      // TODO Auto-generated method stub
	      HashMap<String, Object> hash = new HashMap<String, Object>();
	      // 페이징 처리
	      // 한 페이지에 출력 할 article 개수
	      pdto.setLinePerPage(9);
	      if (pdto.getPresentPage() == 0) {
	         pdto.setPresentPage(1);
	      }
	      int presentPage = pdto.getPresentPage();

	      // 전체 레코드 수
	      int allCount = adminDao.getItemCount();
	      pdto.setAllCount(allCount);
	      System.out.println("allCount ; " + allCount);
	      // 전체 페이지 개수
	      int allPage = allCount / pdto.getLinePerPage() + 1;
	      pdto.setAllPage(allPage);

	      int crb = 1;
	      if (presentPage == 1) {
	         pdto.setPresentPageBlock(crb);
	      } else {
	         crb = presentPage % pdto.getPageBlockPerNumber() == 0 ? presentPage / pdto.getPageBlockPerNumber()
	               : presentPage / pdto.getPageBlockPerNumber() + 1;
	         pdto.setPresentPageBlock(crb);
	      }
	      // 페이지 블럭 하나에 포함 될 페이지 수
	      int linePerPageNumber = 7;
	      if (presentPage - linePerPageNumber / 2 <= 1) {
	         pdto.setStartPage(1);
	         if (linePerPageNumber >= allPage)
	            pdto.setEndPage(allPage);
	         else
	            pdto.setEndPage(linePerPageNumber);
	      } else if (presentPage + linePerPageNumber / 2 >= allPage) {
	         pdto.setEndPage(allPage);
	         if (allPage - linePerPageNumber + 1 <= 0)
	            pdto.setStartPage(1);
	         else
	            pdto.setStartPage(allPage - linePerPageNumber + 1);
	      } else {
	         pdto.setStartPage(presentPage - linePerPageNumber / 2);
	         pdto.setEndPage(presentPage + linePerPageNumber / 2);
	      }

	      int start = (presentPage - 1) * pdto.getLinePerPage() + 1;
	      int end = presentPage * pdto.getLinePerPage();
	      System.out.println("start ; " + start);
	      System.out.println("end ; " + end);
	      List<ItemDTO> list = adminDao.getItem(start, end);
	      // 페이징 처리 끝
	      hash.put("pdto", pdto);
	      hash.put("list", list);
	      return hash;
	}

	@Override
	public ItemInquiryDTO getItemInquiry(ItemInquiryDTO iqdto) {
		// TODO Auto-generated method stub
		return adminDao.getItemInquiry(iqdto);
	}

	@Override
	public void ItemInquiryWriteProc(ItemInquiryDTO iqdto) {
		// TODO Auto-generated method stub
		 adminDao.ItemInquiryWriteProc(iqdto);
		
	}

	@Override
	public int ItemInquiryDelete(ItemInquiryDTO iqdto) {
		// TODO Auto-generated method stub
		return adminDao.ItemInquiryDelete(iqdto);
	}

	@Override
	public void OrderCancelUpdate(OrderCancelDTO ocdto) {
	adminDao.OrderCancelUpdate(ocdto);
	}

	@Override
	public void OrderCancelDelete(OrderCancelDTO ocdto) {
		adminDao.OrderCancelDelete(ocdto);
	}


}

