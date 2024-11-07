package com.softagape.mustacheajax.stomp;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/stomp")
public class StompRoomController {
    @Autowired
    private StompRoomService stompRoomService;

    @GetMapping("/list")
    public String stompRoomList(Model model) {
        List<StompRoomDto> list = this.stompRoomService.findAll();
        model.addAttribute("stompRoomList", list);
        return "stomp/stomproomlist";
    }

    @PostMapping("/create")
    public String createStompRoom(Model model, String roomName, String writer) {
        if (roomName != null && !roomName.isEmpty() && writer != null && !writer.isEmpty()) {
            StompRoomDto newRoom = this.stompRoomService.insert(roomName);
            String url = "redirect:/stomp/enter?roomId=" + newRoom.getRoomId() + "&writer=" + URLEncoder.encode(writer, StandardCharsets.UTF_8);
            return url;
//        } else if (roomName != null && !roomName.isEmpty()) {
//            this.stompRoomService.insert(roomName);
        }
        return "redirect:/stomp/list";
    }

    @PostMapping("/enter")   // GET ? 와 &
//    @GetMapping("/enter/{roomId}/{writer}") // GET 주소로 데이터 전달
    public String enterStompRoom(Model model
            , HttpServletRequest request
            , @RequestBody StompRoomDto stompRoomDto
    ) {
        model.addAttribute("stompRoomDto", this.stompRoomService.findByRoomId(stompRoomDto.getRoomId()));
        model.addAttribute("writer",stompRoomDto.getWriter());
        String url = String.format("%s:%d", request.getServerName(), request.getServerPort());
        model.addAttribute("hostUrl", url);
        return "stomp/stomproomdetail";
    }
}
