package com.bitcamp.onemoaproject.service;

import com.bitcamp.onemoaproject.dao.MemberDao;
import com.bitcamp.onemoaproject.dao.MessageDao;
import com.bitcamp.onemoaproject.vo.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class DefaultMessageService implements MessageService {

  @Autowired
  MemberDao memberDao;

  @Autowired
  MessageDao messageDao;
  
  // 메시지 미리보기 조회 (사이드바)
  @Override
  public List<Message> list(int sender) throws Exception {
    return messageDao.findAll(sender);
  }
  
  // 메시지 상세보기
  @Override
  public List<Message> listNo(int sender, int no) throws Exception {
    return messageDao.findByNo(sender, no);
  }
  
  // 메시지 저장
  @Override
  public int addMessage(int sender, int receiver, String content) throws Exception {
    return messageDao.insertMessage(sender, receiver, content);
  }
  
  // 메시지 카운터
  @Override
  public int getCount(int sender, int receiver) {
    // 상대방한테 메시지를 발송할때 상대방이 나한테 보낸 메시지가 없다면
    if (messageDao.messageCount(sender, receiver) == 0) {
      // 발신자 수신자위치 바꿔서 null 값으로 채워 넣음.
      messageDao.insertMessage2(sender, receiver);
    }
    return messageDao.messageCount(sender, receiver);
  }
}








