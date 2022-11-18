package com.bitcamp.onemoaproject.controller;

import com.bitcamp.onemoaproject.service.NoticeService;
import com.bitcamp.onemoaproject.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("review/")
public class ReviewController {

//  @Autowired
//  ServletContext sc;
//  @Autowired
//  ReviewService reviewService;

  @GetMapping("reviewForm")
  public void form() throws Exception {
    System.out.println("form 호출");
  }

//    @PostMapping("reviewAdd")
//    public String reviewadd(
//            Qna qna,
//            @RequestParam("files") Part[] files,
//            HttpSession session
//  ) throws Exception {
//      qna.setQnaAttachedFiles(saveAttachedFiles(files));
//      qna.setWriter((Member) session.getAttribute("loginMember"));
//
//      qnaService.add(qna);
//      return "redirect:list";
//    }
//
//  @PostMapping("add")
//  public String add(
//          Qna qna,
//          @RequestParam("files") Part[] files,
//          HttpSession session
//  ) throws Exception {
//    qna.setQnaAttachedFiles(saveAttachedFiles(files));
//    qna.setWriter((Member) session.getAttribute("loginMember"));
//
//    qnaService.add(qna);
//    return "redirect:list";
//  }
//
//  private List<QnaAttachedFile> saveAttachedFiles(Part[] files)
//          throws IOException, ServletException {
//    List<QnaAttachedFile> attachedFiles = new ArrayList<>();
//    String dirPath = sc.getRealPath("/qna/files");
//
//    for (Part part : files) {
//      if (part.getSize() == 0) {
//        continue;
//      }
//      String originname = part.getSubmittedFileName();
//      System.out.println(originname);
//      String filename = UUID.randomUUID().toString();
//      part.write(dirPath + "/" + filename);
//      attachedFiles.add(new QnaAttachedFile(originname, filename));
//      }
//
//    return attachedFiles;
//  }
//
//  @GetMapping("list")
//  public void list(Model model, HttpSession session) throws Exception {
//    Member member = (Member) session.getAttribute("loginMember");
//    if(member != null) {
//      model.addAttribute("qnas", qnaService.list(member.getNo()));
//    } else {
//      model.addAttribute("qnas", qnaService.list());
//    }
//  }
//
//  @GetMapping("detail")
//  public Map detail(int no) throws Exception {
//    Qna qna = qnaService.get(no);
//    if (qna == null) {
//      throw new Exception("해당 번호의 게시글이 없습니다!");
//    }
//    Map map = new HashMap();
//    map.put("qna", qna);
//    return map;
//  }
//
//  @PostMapping("update")
//  public String update(
//          Qna qna,
//          Part[] files,
//          HttpSession session)
//          throws Exception {
//    qna.setWriter((Member) session.getAttribute("loginMember"));
//    qna.setQnaAttachedFiles(saveAttachedFiles(files));
//
//    checkOwner(qna.getNo(), session);
//
//    if (!qnaService.update(qna)) {
//      throw new Exception("게시글을 변경할 수 없습니다!");
//    }
//
//    return "redirect:list";
//  }
//
//  private void checkOwner(int qnaNo, HttpSession session) throws Exception {
//    Member loginMember = (Member) session.getAttribute("loginMember");
//    if (qnaService.get(qnaNo).getWriter().getNo() != loginMember.getNo()) {
//      throw new Exception("게시글 작성자가 아닙니다.");
//    }
//  }
//
//  @GetMapping("updateform")
//  public Map updateform(int no) throws Exception {
//    Qna qna = qnaService.get(no);
//    if (qna == null) {
//      throw new Exception("해당 번호의 게시글이 없습니다!");
//    }
//
//    Map map = new HashMap();
//    map.put("qna", qna);
//    return map;
//  }
//
//  @GetMapping("delete")
//  public String delete(
//      int no,
//      HttpSession session)
//          throws Exception {
//
////    checkOwner(no, session);
//    if (!qnaService.delete(no)) {
//      throw new Exception("게시글을 삭제할 수 없습니다.");
//    }
//
//    return "redirect:list";
//  }
//
//  @GetMapping("fileDelete")
//  public String fileDelete(
//      int no,
//      HttpSession session)
//          throws Exception {
//
//    QnaAttachedFile attachedFile = qnaService.getAttachedFile(no);
//
//    Member loginMember = (Member) session.getAttribute("loginMember");
//    Qna qna = qnaService.get(attachedFile.getQnaNo());
//
//    if (qna.getWriter().getNo() != loginMember.getNo()) {
//      throw new Exception("게시글 작성자가 아닙니다.");
//    }
//
//    if (!qnaService.deleteAttachedFile(no)) {
//      throw new Exception("게시글 첨부파일을 삭제할 수 없습니다.");
//    }
//
//    return "redirect:updateform?no=" + qna.getNo();
//  }
}





