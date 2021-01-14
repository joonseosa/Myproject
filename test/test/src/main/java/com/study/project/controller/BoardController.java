package com.study.project.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.study.project.service.BoardService;
import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.PlatformResponse;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

@Controller
public class BoardController {

	// resource는 호출 ,bean id 호출한다
	@Resource(name = "service")
	private BoardService boardService;

	@RequestMapping("list")
	// @ResponseBody
	public String list(@RequestParam Map<String, Object> map, Model model) {
		// 페이징 처리 페이지1번에 10개씩 리스트가 들어감
	
		//isEmpty() 는  비어있는지 확인한다는 의미 
		if (map.isEmpty()) {
			map.put("pageNo", 1);
			map.put("listSize", 10);
		}

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = boardService.list(map);

		// 페이징 처리 설정
		int pageCnt = boardService.pageCnt(map);
		map.put("pageCnt", pageCnt);
		Map<String, Object> pageMap = boardService.page(map);
	
		
		
		//뷰 코드에서는 name으로 지정한 이름을 통해서 value를 사용한다.
		//예를들어 ${list.seq}
		//view 에  데이터를 전달할수있다. 
		model.addAttribute("list", list);

		// 페이징 처리
		model.addAttribute("pageMap", pageMap);

		model.addAttribute("map", map);

		return "board/list";

	}

 
	
		

	// 등록 버튼 --> 작성페이지
	@RequestMapping("wtr")
	public String wtr() {
		return "board/writeView";
	}

	// form action=write을 통한 submit --> db 전달
	@RequestMapping("write")
	public String write(@RequestParam Map<String, Object> map, Model model) {
		boardService.insert(map);

		return "redirect:/list";
	}

	@RequestMapping("detail")
	public String detail(@RequestParam int seq, Model detailMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boardService.viewCnt(seq);

		map = boardService.detail(seq);
		detailMap.addAttribute("map", map);
		return "board/writeView";

	}

	@RequestMapping("update")
	public String update(@RequestParam Map<String, Object> map) {
		System.out.println("this is map" + map);
		boardService.update(map);
		return "redirect:/list";
	}

	@RequestMapping("delete")
	public String delete(Integer[] chk) {
		System.out.println("this delete" + chk);
		List<Integer> list = Arrays.asList(chk);
		boardService.delete(list);
		return "redirect:/list";
	}

	@RequestMapping("searchList")
	public String searchList(@RequestParam Map<String, Object> map, Model model) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = boardService.list(map);

		// 페이징 처리 설정
		int pageCnt = boardService.pageCnt(map);

		map.put("pageCnt", pageCnt);
		Map<String, Object> pageMap = boardService.page(map);

		// 리스트 출력
		model.addAttribute("list", list);

		// 페이징 처리
		model.addAttribute("pageMap", pageMap);

		return "board/searchList";
	}

	@RequestMapping("fileFrm")
	public String fileFrm() {
		return "board/file";
	}

	/*
	 * @RequestMapping("requestupload1") public String
	 * requestupload1(MultipartHttpServletRequest mtfRequest) { String src =
	 * mtfRequest.getParameter("src"); System.out.println("src value : " + src);
	 * MultipartFile mf = mtfRequest.getFile("file");
	 * 
	 * String path = "C:\\image\\";
	 * 
	 * String originFileName = mf.getOriginalFilename(); // 원본 파일 명 long fileSize =
	 * mf.getSize(); // 파일 사이즈
	 * 
	 * System.out.println("originFileName : " + originFileName);
	 * System.out.println("fileSize : " + fileSize);
	 * 
	 * String safeFile = path + System.currentTimeMillis() + originFileName;
	 * 
	 * try { mf.transferTo(new File(safeFile)); } catch (IllegalStateException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } catch (IOException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * return "redirect:list"; }
	 * 
	 * @RequestMapping("requestupload2") public String
	 * requestupload2(MultipartHttpServletRequest mtfRequest) { List<MultipartFile>
	 * fileList = mtfRequest.getFiles("file"); String src =
	 * mtfRequest.getParameter("src"); System.out.println("src value : " + src);
	 * 
	 * String path = "C:\\image\\";
	 * 
	 * for (MultipartFile mf : fileList) { String originFileName =
	 * mf.getOriginalFilename(); // 원본 파일 명 long fileSize = mf.getSize(); // 파일 사이즈
	 * 
	 * System.out.println("originFileName : " + originFileName);
	 * System.out.println("fileSize : " + fileSize);
	 * 
	 * String safeFile = path + System.currentTimeMillis() + originFileName; try {
	 * mf.transferTo(new File(safeFile)); } catch (IllegalStateException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } catch (IOException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * return "redirect:list"; }
	 */

	@RequestMapping("file")
	public String file() {
		return "file";
	}

	// 파일경로 고정값 final 로 선언 ,고정된 값
	private final static String filePath = "C:/Users/myeon/OneDrive/바탕 화면/imgages/";

	// 파일이 없을때 예외처리 가능해야함
	@RequestMapping("fileUp")
	public String fileUp(MultipartHttpServletRequest mRequest) throws IllegalStateException, IOException {
		// 단건으로 하나씩 받을때
		// mRequest.getFile(name);

		// 인풋 여러개 한번에 받고싶을때
		// mRequest.getFileNames();

		// 다중파일 업로드 할때! 인풋하나에 여러개 받을때
		// mRequest.getFileNames();

		// 리스트처럼 출력됨 . 인픗이 담긴다, while과 함께 사용
		Iterator<String> itr = mRequest.getFileNames();

		// hasnext 불린형 이터레이터에서 값체크 , 자료가 있는지 없는지 따진다 .
		while (itr.hasNext()) {

			// 파일을 생성시킴
			// . next 로 name을 하나씩 빼온다
			MultipartFile mFile = mRequest.getFile(itr.next());

			if (mFile.getSize() > 0) {

				// 내가 첨부하는 파일명을 가져옴
				String fileName = System.currentTimeMillis() + mFile.getOriginalFilename();
				mFile.transferTo(new File(filePath + fileName));
			}

		}

		return "board/file";
	}

	@RequestMapping("fileDown")
	public void fileDown(@RequestParam String saveFile, @RequestParam String realFile, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		File file = new File(filePath + saveFile);
		if (file != null) {
			String fileName = realFile;
			String userAgent = request.getHeader("User-Agent");

			if (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1) {
				fileName = URLEncoder.encode(file.getName(), "utf-8").replaceAll("\\+", "%20");
				;
			} else if (userAgent.indexOf("Chrome") > -1) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < file.getName().length(); i++) {
					char c = file.getName().charAt(i);
					if (c > '~') {
						sb.append(URLEncoder.encode("" + c, "UTF-8"));
					} else {
						sb.append(c);
					}
				}
				fileName = sb.toString();
			} else {
				fileName = new String(file.getName().getBytes("utf-8"));
			}
			response.setContentType("application/octer-stream");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");

			OutputStream out = response.getOutputStream();
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
				FileCopyUtils.copy(fis, out);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (out != null) {
					out.flush();
				}
			}
		}
	}
	
	@RequestMapping("excelDown")
	public String excelDown(@RequestParam Map<String, Object> map , Model model) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		list = boardService.list(map);
		model.addAttribute("modelList", list);
		return "board/excelDown";
	}
	
	@RequestMapping("milist")
	public void aa(@RequestParam Map<String,Object>map,HttpServletResponse response,HttpServletRequest request) throws IOException {
		
		PlatformRequest pReq = new PlatformRequest(request,"UTF-8");
		pReq.receiveData();
		
		DatasetList searchDsl = pReq.getDatasetList();
		VariableList searchVl = pReq.getVariableList();
		
		
		//spring = miplatform (마이플랫폼을 스프링으로)  java_search=ds_search
		Dataset searchDs = searchDsl.getDataset("java_search");
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		
		
		//  map 과 miPlatform 의 값이 정확히 입력해야함 
		//             map의  key값                                                      //ds_search의 id     
		searchMap.put("searchOp",searchDs.getColumnAsString(0, "type"));
		searchMap.put("searchTy",searchDs.getColumnAsString(0, "txt"));
		searchMap.put("stDate",searchDs.getColumnAsString(0, "sDate"));
		searchMap.put("edDate",searchDs.getColumnAsString(0, "eDate"));
	
	
		
		
		
		// boardservice.milist로 이동을하는데  searchMap 을 담아서  -->  service -> dao -> > mapper 로 이동을하게됨 
		List<Map<String, Object>>list=boardService.milist(searchMap); // 데이터를 담아 서비스 로 이동  
			
			 
			Dataset ds = new Dataset("java_list");// "java_list" 를 쓴 이유, spring  data를 마이플랫폼으로
			//컬럼추가  이름,아이디,제목,내용    (컬럼명,타입,크기)
			ds.addColumn("mem_name", ColumnInfo.COLTYPE_STRING, 1000);
			ds.addColumn("mem_id", ColumnInfo.COLTYPE_STRING, 1000);
			ds.addColumn("board_subject", ColumnInfo.COLTYPE_STRING, 1000);
			ds.addColumn("board_content", ColumnInfo.COLTYPE_STRING, 1000);
			
	
			
			
			
			//dataset 출력
			System.out.println("DS::" + ds);
			
			//반복문을 통해서 리스트 출력 
			for(int i=0;i<list.size();i++) {
				//db에서 가져온 내용 row 추가 
				int row = ds.appendRow();
				//column 가져오기                                                       //mapper에 지정된 property 이름 
				ds.setColumn(row, "mem_name",list.get(i).get("memName").toString());
				ds.setColumn(row, "mem_id",list.get(i).get("memId").toString());
				ds.setColumn(row, "board_subject",list.get(i).get("boardSubject").toString());
				
				
				
				
				//만약 boardContent 내용이 없다면??? row 추가시 " " 로 출력 
				if (list.get(i).get("boardContent") == null) {
		    		ds.setColumn(row, "board_content", "");
				
				// 아니면 boardContent가 있다면, db에 있는 boardContent 내용을 출력 
				}else {
					ds.setColumn(row, "board_content", list.get(i).get("boardContent").toString());
				}	
				
			}
			//ds의 내용을 list 형태로 담기위해 , DatasetList객체생성 
			DatasetList dsl= new DatasetList();
			//dsl (데이터셋 리스트) 에 ds 내용을 담는다
			
			dsl.add(ds);
			
			VariableList vl = new VariableList();
			
			/*
			 * VariableList에서 key를 통해 Variable 객체로 변환된 value를 저장하고 있게 된다. 
			 * 어찌보면 VariableList는 개념적인것만 놓고 보면 Java의 Map과 같은 구조이다. 
			 * 이러한 VariableList 객체에 있는 값들을 Controller의 메소드에서 Java 클래스 객체로 받아야 하는데 이때 사용하는 것이 
			 * @RequestVariable 어노테이션이 된다.
			 */
			
			
			//예외처리  
		    //xml 형식으로 만들어서 utf-8로 인코딩   , 마이플랫폼은 xml 형식임 
			//플랫폼 리스폰스 때문에 예외처리 를 함  , 외부의 요청이기 때문에 ,exception 필요 
			
			PlatformResponse pRes= new PlatformResponse(response,PlatformRequest.XML,"UTF-8");
		   
			
			
			//데이터 전송 
			pRes.sendData(vl, dsl);  	
			//jsp 안보내니까 리턴 필요없음 , void 
			
		
	}
		
	
	
	
		


}
