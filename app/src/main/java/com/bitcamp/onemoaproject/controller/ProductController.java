package com.bitcamp.onemoaproject.controller;

import javax.servlet.ServletContext;

import com.bitcamp.onemoaproject.service.ProductReviewService;
import com.bitcamp.onemoaproject.vo.product.Product;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bitcamp.onemoaproject.service.ProductCategoryService;
import com.bitcamp.onemoaproject.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// CRUD 요청을 처리하는 페이지 컨트롤러들을 한 개의 클래스로 합친다.
@Controller // 페이지 컨트롤러에 붙이는 애노테이션
@RequestMapping("/product/")
public class ProductController {

  @Autowired
  ServletContext sc;
  @Autowired
  ProductService productService;
  @Autowired
  ProductCategoryService productCategoryService;
  @Autowired
  ProductReviewService productReviewService;

  /*
  @GetMapping("form")
  public void form() throws Exception {
  }
  
  @PostMapping("add")
  public String add(
      Product product,
      @RequestParam("files") MultipartFile[] files,
      HttpSession session) throws Exception {
  
    product.setAttachedFiles(saveAttachedFiles(files));
    product.setWriter((Member) session.getAttribute("loginMember"));
  
    productService.add(product);
    return "redirect:list";
  }
  
  private List<AttachedFile> saveAttachedFiles(Part[] files)
      throws IOException, ServletException {
    List<AttachedFile> attachedFiles = new ArrayList<>();
    String dirPath = sc.getRealPath("/board/files");
  
    for (Part part : files) {
      if (part.getSize() == 0) {
        continue;
      }
  
      String filename = UUID.randomUUID().toString();
      part.write(dirPath + "/" + filename);
      attachedFiles.add(new AttachedFile(filename));
  
    }
    return attachedFiles;
  }
  private List<AttachedFile> saveAttachedFiles(MultipartFile[] files)
      throws IOException, ServletException {
    List<AttachedFile> attachedFiles = new ArrayList<>();
    String dirPath = sc.getRealPath("/board/files");
  
    for (MultipartFile part : files) {
      if (part.isEmpty()) {
        continue;
      }
  
      String filename = UUID.randomUUID().toString();
      part.transferTo(new File(dirPath + "/" + filename)); // 파일경로를 파일 객체에 담아서 넘겨야 함
      attachedFiles.add(new AttachedFile(filename));
  
    }
    return attachedFiles;
  }
  */

  @GetMapping("list")
  public void list(Model model) throws Exception {
    model.addAttribute("products", productService.list());
    model.addAttribute("productCategories", productCategoryService.list());
    System.out.println(productCategoryService.list());

  }

  @GetMapping("detail")
  public Map detail(int no) throws Exception {

    Product product = productService.get(no);
    double average = Math.round((productReviewService.get(no)*100)/100.0);

    Map map = new HashMap();
    map.put("product", product);
    map.put("average", average);
    System.out.println(average);
    return map;
  }




  //  @PostMapping("update")
  //  public String update(
  //      Board board,
  //      Part[] files,
  //      HttpSession session) throws Exception {
  //
  //    board.setAttachedFiles(saveAttachedFiles(files));
  //
  //    checkOwner(board.getNo(), session);
  //
  //    if (!boardService.update(board)) {
  //      throw new Exception("게시글을 변경할 수 없습니다.");
  //    }
  //
  //    return "redirect:list";
  //  }
  //
  //  private void checkOwner(int boardNo, HttpSession session) throws Exception {
  //    Member loginMember = (Member) session.getAttribute("loginMember");
  //    if (boardService.get(boardNo).getWriter().getNo() != loginMember.getNo()) {
  //      throw new Exception("게시글 작성자가 아닙니다.");
  //    }
  //  }
  //
  //  @GetMapping("delete")
  //  public String delete(
  //      @RequestParam("no") int no,
  //      HttpSession session)
  //          throws Exception {
  //
  //    checkOwner(no, session);
  //    if (!boardService.delete(no)) {
  //      throw new Exception("게시글을 삭제할 수 없습니다!");
  //    }
  //
  //    return "redirect:list";
  //  }
  //
  //  @GetMapping("fileDelete")
  //  public String fileDelete(
  //      @RequestParam("no") int no,
  //      HttpSession session)
  //          throws Exception {
  //
  //    AttachedFile attachedFile = boardService.getAttachedFile(no);
  //
  //    // 게시글의 작성자가 로그인 사용자인지 검사한다. (남의 것 삭제할 수 있으면 안되니까)
  //    Member loginMember = (Member) session.getAttribute("loginMember");
  //    Board board = boardService.get(attachedFile.getBoardNo());
  //
  //    if (board.getWriter().getNo() != loginMember.getNo()) {
  //      throw new Exception("게시글 작성자가 아닙니다.");
  //    }
  //
  //    // 첨부파일을 삭제한다.
  //    if (!boardService.deleteAttachedFile(no)) {
  //      throw new Exception("게시글 첨부파일 삭제 실패!");
  //    }
  //
  //    return "redirect:detail?no=" + board.getNo();
  //  }
}


